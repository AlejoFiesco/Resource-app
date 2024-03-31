package com.example.demo.business.interfaces;

import java.util.List;

import com.example.demo.model.Reserve;

public interface ReserveBusinessInt {
	public Reserve createReserve(Reserve reserve) throws Exception;

	public List<Reserve> getReserveList() throws Exception;

	Reserve getReserveById(String id) throws Exception;

	Reserve registerDevolution(String id) throws Exception;
}