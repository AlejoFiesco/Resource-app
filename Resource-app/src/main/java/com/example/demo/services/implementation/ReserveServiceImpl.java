package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.implementation.ReserveBusinessImpl;
import com.example.demo.model.Reserve;
import com.example.demo.services.interfaces.ReserveServiceInt;

@RestController
public class ReserveServiceImpl implements ReserveServiceInt{

	@Autowired
	ReserveBusinessImpl reserveBusiness;
	
	@Override
	public ResponseEntity<Reserve> createReserve(Reserve reserve) {
		Reserve createdReserve = null;
		try {
			createdReserve = reserveBusiness.createReserve(reserve);
		}catch(Exception e) {
			System.out.println(e);
		}
		return createdReserve == null ? ResponseEntity.internalServerError().build() : ResponseEntity.ok(createdReserve);
	}

	@Override
	public ResponseEntity<List<Reserve>> getReserves() {
		List<Reserve> reserveList = null;
		try {
			reserveList = reserveBusiness.getReserveList();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return reserveList == null ? ResponseEntity.internalServerError().build() : ResponseEntity.ok(reserveList);
	}

}
