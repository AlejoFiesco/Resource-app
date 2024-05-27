package com.example.demo.database.interfaces;

import java.util.List;

import com.example.demo.model.Reserve;
import com.example.demo.utilities.filters.ReserveFilter;

public interface ReserveDBInt {
	public Reserve createReserve(Reserve reserve) throws Exception;

	Reserve registerDevolution(String id) throws Exception;

	List<Reserve> filterReserves(ReserveFilter filter) throws Exception;
}
