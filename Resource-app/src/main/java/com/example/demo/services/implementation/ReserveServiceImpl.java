package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.implementation.ReserveBusinessImpl;
import com.example.demo.model.Reserve;
import com.example.demo.services.interfaces.ReserveServiceInt;
import com.example.demo.utilities.responses.CustomResponse;

@RestController
public class ReserveServiceImpl implements ReserveServiceInt{

	@Autowired
	ReserveBusinessImpl reserveBusiness;
	
	@Override
	public ResponseEntity<Reserve> createReserve(Reserve reserve) {
		Reserve createdReserve = null;
		if(reserve != null) {
			try {
				createdReserve = reserveBusiness.createReserve(reserve);
			}catch(Exception e) {
				System.out.println(e);
				return CustomResponse.buildResponse(e.getMessage());
			}			
		}
		return CustomResponse.buildResponse(createdReserve);
	}

	@Override
	public ResponseEntity<List<Reserve>> getReserves() {
		List<Reserve> reserveList = null;
		try {
			reserveList = reserveBusiness.getReserveList();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return CustomResponse.buildResponse(reserveList);
	}

	@Override
	public ResponseEntity<Reserve> getReserveById(String id) {
		Reserve returnedReserve = null;
		if(id != null) {
			try {
				returnedReserve = reserveBusiness.getReserveById(id);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		return CustomResponse.buildResponse(returnedReserve);
	}

}
