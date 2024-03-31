package com.example.demo.database.interfaces;

import com.example.demo.model.Reserve;

public interface ReserveDBInt {
	public Reserve createReserve(Reserve reserve) throws Exception;

	Reserve registerDevolution(String id) throws Exception;
}
