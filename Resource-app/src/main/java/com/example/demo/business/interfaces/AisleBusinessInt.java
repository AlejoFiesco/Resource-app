package com.example.demo.business.interfaces;

import java.util.List;

import com.example.demo.model.Aisle;

public interface AisleBusinessInt {

	public Aisle createAisle(Aisle aisle) throws Exception;

	public List<Aisle> getAisleList() throws Exception;
	
	public Aisle getAisleById(String aisleId) throws Exception;
}
