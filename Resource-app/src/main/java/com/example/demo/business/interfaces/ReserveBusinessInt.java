package com.example.demo.business.interfaces;

import java.util.List;

import com.example.demo.model.Reserve;

public interface ReserveBusinessInt {
	public Reserve createReserve(Reserve reserve) throws Exception;

	public List<Reserve> getReserveList() throws Exception;
}
