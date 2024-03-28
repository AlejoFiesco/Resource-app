package com.example.demo.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.ReserveBusinessInt;
import com.example.demo.database.factory.Factory;
import com.example.demo.model.Reserve;
import com.example.demo.model.Resource;

@Service
public class ReserveBusinessImpl implements ReserveBusinessInt {
	
	@Autowired
	Factory factory;

	@Override
	public Reserve createReserve(Reserve reserve) throws Exception {
		Reserve createdReserve = null;
		if (reserve != null) {
			try {
				createdReserve = (Reserve) factory.create(reserve);
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
			reserveList = factory.getList(Resource.class);
		} catch (Exception e) {
			throw e;
		}
		return reserveList;
	}

}
