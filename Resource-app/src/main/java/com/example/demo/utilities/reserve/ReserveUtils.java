package com.example.demo.utilities.reserve;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.factory.Collections;
import com.example.demo.model.Reserve;
import com.example.demo.model.Resource;
import com.example.demo.utilities.date.DateUtils;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;

@Service
public class ReserveUtils {
	@Autowired
	Firestore firestore;

	public boolean checkForCross(Reserve reserve) throws InterruptedException, ExecutionException {
		CollectionReference reserveCollRef = firestore.collection(Collections.RESERVES.getCollectionName());
		Query query1 = reserveCollRef.whereGreaterThan("from", reserve.getFrom()).whereLessThan("from", reserve.getTo())
				.whereArrayContainsAny("resourceIdList",
						Objects.isNull(reserve.getResourceIdList()) ? new ArrayList<Object>()
								: reserve.getResourceIdList())
				.whereEqualTo("classroom.id", reserve.getClassroom().getId())
				.whereEqualTo("devolutionDate", reserveCollRef);

		Query query2 = firestore.collection(Collections.RESERVES.getCollectionName())
				.whereGreaterThan("to", reserve.getFrom()).whereLessThan("to", reserve.getTo())
				.whereArrayContainsAny("resourceIdList",
						Objects.isNull(reserve.getResourceIdList()) ? new ArrayList<Object>()
								: reserve.getResourceIdList())
				.whereEqualTo("classroom.id", reserve.getClassroom().getId());

		List<Reserve> reserves1 = query1.get().get().toObjects(Reserve.class);
		List<Reserve> reserves2 = query2.get().get().toObjects(Reserve.class);
		return reserves1.isEmpty() && reserves2.isEmpty();
	}

	public static List<Resource> areResourcesAvalaible(Reserve reserve) {
		// Se busca recursos que no estén disponibles
		return (List<Resource>) reserve.getResourceList().stream()
				.filter(resource -> !DateUtils.isTimeGreaterThanTime2(DateUtils.getHoursMinutes(reserve.getFrom()),
						resource.getDisponibility().get(0).getStart())
						|| !DateUtils.isTimeGreaterThanTime2(DateUtils.getHoursMinutes(reserve.getFrom()),
								resource.getDisponibility().get(0).getStart()))
				.toList();

	}
}
