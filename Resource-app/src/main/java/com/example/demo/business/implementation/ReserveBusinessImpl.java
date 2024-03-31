package com.example.demo.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.ReserveBusinessInt;
import com.example.demo.database.factory.Factory;
import com.example.demo.database.implementation.ReserveDBImpl;
import com.example.demo.model.Reserve;

@Service
public class ReserveBusinessImpl implements ReserveBusinessInt {
	
	@Autowired
	Factory factory;
	
	@Autowired
	ReserveDBImpl reserveDb;

	@Override
	public Reserve createReserve(Reserve reserve) throws Exception {
		Reserve createdReserve = null;
		if (reserve != null) {
			try {
				createdReserve = reserveDb.createReserve(reserve);
			} catch (Exception e) {
				throw e;
			}
		}
		return createdReserve;
	}

	@Override
	public List<Reserve> getReserveList() throws Exception {
		List<Reserve> reserveList;

		try {
			reserveList = factory.getList(Reserve.class);
		} catch (Exception e) {
			throw e;
		}
		return reserveList;
	}

	@Override
	public Reserve getReserveById(String id) throws Exception{
		Reserve returnedReserve = null;
		
		try {
			returnedReserve = factory.getById(Reserve.class, id);
		}catch(Exception e) {
			throw e;
		}
		
		return returnedReserve;
	}

	@Override
	public Reserve registerDevolution(String id) throws Exception {
		Reserve reserve = null;
		
		try {
			reserve = reserveDb.registerDevolution(id);
		}catch(Exception e) {
			throw e;
		}
		return reserve;
	}

}
