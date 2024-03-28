package com.example.demo.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.AisleBusinessInt;
import com.example.demo.database.factory.Factory;
import com.example.demo.model.Aisle;

@Service
public class AisleBusinessImpl implements AisleBusinessInt{

	@Autowired
	Factory factory;
	
	@Override
	public Aisle createAisle(Aisle aisle) throws Exception {
		Aisle createdAisle = null;
		if (aisle != null) {
			try {
				createdAisle = (Aisle) factory.create(aisle);
			} catch (Exception e) {
				throw e;
			}
		}
		return createdAisle;
	}

	@Override
	public List<Aisle> getAisleList() throws Exception {
		List<Aisle> aisleList;

		try {
			aisleList = factory.getList(Aisle.class);
		} catch (Exception e) {
			throw e;
		}
		return aisleList;
	}

}
