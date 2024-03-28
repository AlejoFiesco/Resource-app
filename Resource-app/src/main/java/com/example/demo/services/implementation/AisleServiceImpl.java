package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.business.implementation.AisleBusinessImpl;
import com.example.demo.model.Aisle;
import com.example.demo.services.interfaces.AisleServiceInt;

public class AisleServiceImpl implements AisleServiceInt{

	@Autowired
	AisleBusinessImpl aisleBusiness;
	
	@Override
	public ResponseEntity<Aisle> createAisle(Aisle aisle) throws Exception {
		Aisle createdAisle = null;
		try {
			createdAisle = aisleBusiness.createAisle(aisle);
		}catch(Exception e) {
			System.out.println(e);
		}
		return createdAisle == null ? ResponseEntity.internalServerError().build() : ResponseEntity.ok(createdAisle);
	}

	@Override
	public ResponseEntity<List<Aisle>> getAisleList() throws Exception {
		List<Aisle> aisleList = null;
		try {
			aisleList = aisleBusiness.getAisleList();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return ResponseEntity.ok(aisleList);
	}

}
