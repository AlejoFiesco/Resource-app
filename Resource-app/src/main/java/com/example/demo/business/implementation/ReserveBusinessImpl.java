package com.example.demo.business.implementation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.ReserveBusinessInt;
import com.example.demo.database.factory.Factory;
import com.example.demo.database.implementation.ReserveDBImpl;
import com.example.demo.database.implementation.ResourceDBImpl;
import com.example.demo.database.implementation.exceptions.AlreadyReservedException;
import com.example.demo.database.implementation.exceptions.OutOfDisponibilityException;
import com.example.demo.model.Reserve;
import com.example.demo.model.Resource;
import com.example.demo.utilities.filters.ReserveFilter;
import com.example.demo.utilities.filters.ResourceFilter;
import com.example.demo.utilities.reserve.ReserveUtils;

@Service
public class ReserveBusinessImpl implements ReserveBusinessInt {

	@Autowired
	Factory factory;

	@Autowired
	ReserveDBImpl reserveDb;
	
	@Autowired
	ResourceDBImpl resourceDb;

	@Override
	public Reserve createReserve(Reserve reserve) throws Exception {
		Reserve createdReserve = null;
		if (reserve != null) {
			reserve.setResourceList(resourceDb.getResourceList(new ResourceFilter(reserve.getResourceIdList())));
			List<Resource> outOfDisponibilityResources = ReserveUtils.areResourcesAvalaible(reserve);
			if (!outOfDisponibilityResources.isEmpty())
				throw new OutOfDisponibilityException("La reserva está fuera de la disponibilidad del recurso "
						+ outOfDisponibilityResources.stream().map(Resource::getName).collect(Collectors.joining(", ")));

			if (!reserveDb.checkForCross(reserve))
				throw new AlreadyReservedException("La reserva se cruza");

			createdReserve = reserveDb.createReserve(reserve);

		}
		return createdReserve;
	}

	@Override
	public List<Reserve> getReserveList(ReserveFilter filter) throws Exception {
		List<Reserve> reserveList;

		reserveList = reserveDb.filterReserves(filter);
		reserveList.stream().forEach(reserve -> {
			reserve.setResourceList(reserve.getResourceIdList().stream()
					.map(id -> {
						try {
							return (Resource) factory.getById(Resource.class, id);
						} catch (Exception e) {
							return  null;
						}
					})
					.filter(Objects::nonNull)
					.collect(Collectors.toList()));
		});

		return reserveList;
	}

	@Override
	public Reserve getReserveById(String id) throws Exception {
		Reserve returnedReserve = null;

		returnedReserve = factory.getById(Reserve.class, id);

		return returnedReserve;
	}

	@Override
	public Reserve registerDevolution(String id) throws Exception {
		Reserve reserve = null;

		reserve = reserveDb.registerDevolution(id);

		return reserve;
	}

}
