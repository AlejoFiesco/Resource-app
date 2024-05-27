package com.example.demo.business.interfaces;

import java.util.List;

import com.example.demo.model.Reserve;
import com.example.demo.utilities.filters.ReserveFilter;

public interface ReserveBusinessInt {
	public Reserve createReserve(Reserve reserve) throws Exception;

	public List<Reserve> getReserveList(ReserveFilter filter) throws Exception;

	Reserve getReserveById(String id) throws Exception;

	Reserve registerDevolution(String id) throws Exception;
}
