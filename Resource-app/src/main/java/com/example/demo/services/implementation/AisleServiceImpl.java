package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.implementation.AisleBusinessImpl;
import com.example.demo.config.AuthenticatorAnnotation;
import com.example.demo.model.Aisle;
import com.example.demo.services.interfaces.AisleServiceInt;
import com.example.demo.utilities.responses.CustomResponse;

@RestController
public class AisleServiceImpl implements AisleServiceInt{

	@Autowired
	AisleBusinessImpl aisleBusiness;
	
	@Override
	@AuthenticatorAnnotation
	public ResponseEntity<Aisle> createAisle(Aisle aisle) throws Exception {
		Aisle createdAisle = null;
		try {
			createdAisle = aisleBusiness.createAisle(aisle);
		}catch(Exception e) {
			System.out.println(e);
		}
		return CustomResponse.buildResponse(createdAisle);
	}

	@Override
	public ResponseEntity<List<Aisle>> getAisleList() throws Exception {
		List<Aisle> aisleList = null;
		try {
			aisleList = aisleBusiness.getAisleList();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return CustomResponse.buildResponse(aisleList);
	}

	@Override
	public ResponseEntity<Aisle> getAisleById(String aisleId) throws Exception {
		Aisle returnedAisle = null;
		try {
			returnedAisle = aisleBusiness.getAisleById(aisleId);
		}catch(Exception e) {
			System.out.println(e);
		}
		return CustomResponse.buildResponse(returnedAisle);
	}

	
}
