package com.example.demo.database.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.factory.Collections;
import com.example.demo.database.interfaces.ReserveDBInt;
import com.example.demo.model.Reserve;
import com.example.demo.utilities.date.DateUtils;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;

@Service
public class ReserveDBImpl implements ReserveDBInt{
	
	@Autowired
	Firestore firestore;

	@Override
	public Reserve createReserve(Reserve reserve) throws Exception {
		Reserve createdReserve = null;
		CollectionReference collRef = firestore.collection(Collections.RESERVES.getCollectionName());
		
		try {
			Query query1 = collRef
					.whereGreaterThan("from", reserve.getFrom())
					.whereLessThan("from", reserve.getTo())
					.whereArrayContainsAny("resourceList", reserve.getResourceList())
					.whereEqualTo("classroom.id", reserve.getClassroom().getId())
					;
			
			Query query2 = firestore.collection(Collections.RESERVES.getCollectionName())
					.whereGreaterThan("to", reserve.getFrom())
					.whereLessThan("to", reserve.getTo())
					.whereArrayContainsAny("resourceList", reserve.getResourceList())
					.whereEqualTo("classroom.id", reserve.getClassroom().getId())
					;
			
		List<Reserve> reserves1 = query1.get().get().toObjects(Reserve.class); 
		List<Reserve> reserves2 = query2.get().get().toObjects(Reserve.class); 
		if(!(reserves1.isEmpty() && reserves2.isEmpty())) throw new Exception("Se cruza con otra reserva");
		DocumentReference docRef = collRef.document();
		reserve.setId(docRef.getId());
		reserve.setCreatedDate(DateUtils.getCurrentDate());
		docRef.set(reserve);
		createdReserve = docRef.get().get().toObject(Reserve.class);
			
		}catch(Exception e) {
			throw e;
		}
		
		
		return createdReserve;
	}

	@Override
	public Reserve registerDevolution(String id) throws Exception{
		Reserve reserve = null;
		
		try {
			DocumentReference docRef = firestore.collection(Collections.RESERVES.getCollectionName()).document(id); 
			reserve = docRef.get().get().toObject(Reserve.class);
			if(reserve == null) throw new Exception("No se ha encontrado la reserva");
			reserve.setDevolutionDate(DateUtils.getCurrentDate());
			docRef.set(reserve);
		}catch(Exception e) {
			throw e;
		}
		
		return reserve;
	}

}
