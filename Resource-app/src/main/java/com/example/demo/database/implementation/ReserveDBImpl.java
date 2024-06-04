package com.example.demo.database.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.factory.Collections;
import com.example.demo.database.implementation.exceptions.AlreadyReservedException;
import com.example.demo.database.implementation.exceptions.OutOfDisponibilityException;
import com.example.demo.database.interfaces.ReserveDBInt;
import com.example.demo.model.Reserve;
import com.example.demo.model.Resource;
import com.example.demo.utilities.date.DateUtils;
import com.example.demo.utilities.filters.Operators;
import com.example.demo.utilities.filters.ReserveFilter;
import com.example.demo.utilities.structures.FilterUtils;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;

@Service
public class ReserveDBImpl implements ReserveDBInt {

	@Autowired
	Firestore firestore;

	@Override
	public Reserve createReserve(Reserve reserve) throws Exception {
		Reserve createdReserve = null;

		//Se busca recursos que no estén disponibles
		List<Resource> outOfDisponibilityResources = (List<Resource>) reserve.getResourceList().stream()
				.filter(resource -> !DateUtils.isTimeGreaterThanTime2(DateUtils.getHoursMinutes(reserve.getFrom()),
						resource.getDisponibility().get(0).getStart())
						|| !DateUtils.isTimeGreaterThanTime2(DateUtils.getHoursMinutes(reserve.getFrom()),
								resource.getDisponibility().get(0).getStart()))
				.toList();

		//Se imprimen los nombres de los recursos no disponibles
		if (!outOfDisponibilityResources.isEmpty())
			throw new OutOfDisponibilityException("La reserva está fuera de la disponibilidad del recurso "
					+ outOfDisponibilityResources.stream().map(Resource::getName).collect(Collectors.joining(", ")));
		
		CollectionReference reserveCollRef = firestore.collection(Collections.RESERVES.getCollectionName());
		try {
			Query query1 = reserveCollRef.whereGreaterThan("from", reserve.getFrom())
					.whereLessThan("from", reserve.getTo())
					.whereArrayContainsAny("resourceIdList",
							Objects.isNull(reserve.getResourceIdList()) ? new ArrayList<Object>()
									: reserve.getResourceIdList())
					.whereEqualTo("classroom.id", reserve.getClassroom().getId());

			Query query2 = firestore.collection(Collections.RESERVES.getCollectionName())
					.whereGreaterThan("to", reserve.getFrom()).whereLessThan("to", reserve.getTo())
					.whereArrayContainsAny("resourceIdList",
							Objects.isNull(reserve.getResourceIdList()) ? new ArrayList<Object>()
									: reserve.getResourceIdList())
					.whereEqualTo("classroom.id", reserve.getClassroom().getId());

			List<Reserve> reserves1 = query1.get().get().toObjects(Reserve.class);
			List<Reserve> reserves2 = query2.get().get().toObjects(Reserve.class);
			if (!(reserves1.isEmpty() && reserves2.isEmpty()))
				throw new AlreadyReservedException("Se cruza con otra reserva");
			DocumentReference docRef = reserveCollRef.document();
			reserve.setId(docRef.getId());
			reserve.setCreatedDate(DateUtils.getCurrentDate());
			docRef.set(reserve);
			createdReserve = docRef.get().get().toObject(Reserve.class);

		} catch (Exception e) {
			throw e;
		}

		return createdReserve;
	}

	@Override
	public Reserve registerDevolution(String id) throws Exception {
		Reserve reserve = null;

		DocumentReference docRef = firestore.collection(Collections.RESERVES.getCollectionName()).document(id);
		reserve = docRef.get().get().toObject(Reserve.class);
		if (reserve == null)
			throw new Exception("No se ha encontrado la reserva");
		reserve.setDevolutionDate(DateUtils.getCurrentDate());
		docRef.set(reserve);

		return reserve;
	}

	@Override
	public List<Reserve> filterReserves(ReserveFilter filter) throws Exception {
		CollectionReference collRef = firestore.collection(Collections.RESERVES.getCollectionName());
		Query query = collRef;
		if (!Objects.isNull(filter.getStartDate()))
			query = FilterUtils.filterByRange(query, "from", filter.getStartDate(), Operators.GREATER);
		if (!Objects.isNull(filter.getEndDate()))
			query = FilterUtils.filterByRange(query, "to", filter.getEndDate(), Operators.LESS);
		if (!Objects.isNull(filter.getClassroomId()))
			query = FilterUtils.filterEqualTo(query, "classroom.id", filter.getClassroomId());
		if (!Objects.isNull(filter.getReservedById()))
			query = FilterUtils.filterEqualTo(query, "reservedBy.id", filter.getReservedById());
		if (!Objects.isNull(filter.getResourceId()))
			query = query.whereArrayContains("resourceIdList", filter.getResourceId());

		return query.get().get().getDocuments().stream().map(doc -> doc.toObject(Reserve.class)).toList();
	}

}
