package com.example.demo.database.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.factory.Collections;
import com.example.demo.database.interfaces.ReserveDBInt;
import com.example.demo.model.Reserve;
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
					.whereGreaterThanOrEqualTo("from", reserve.getFrom())
					.whereLessThanOrEqualTo("from", reserve.getTo())
					.whereArrayContainsAny("resourceList", reserve.getResourceList())
					.whereEqualTo("classroom.id", reserve.getClassroom().getId())
					;
			
			Query query2 = firestore.collection(Collections.RESERVES.getCollectionName())
					.whereGreaterThanOrEqualTo("to", reserve.getFrom())
					.whereLessThanOrEqualTo("to", reserve.getTo())
					.whereArrayContainsAny("resourceList", reserve.getResourceList())
					.whereEqualTo("classroom.id", reserve.getClassroom().getId())
					;
			
		if(!(query1.get().get().isEmpty() && query2.get().get().isEmpty())) throw new Exception("Se cruza con otra reserva");
		DocumentReference docRef = collRef.document();
		docRef.set(reserve);
		createdReserve = docRef.get().get().toObject(Reserve.class);
			
		}catch(Exception e) {
			throw e;
		}
		
		
		return createdReserve;
	}

}
