package com.example.demo.database.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.interfaces.ResourceDBInt;
import com.example.demo.model.Resource;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

@Service
public class ResourceDBImpl implements ResourceDBInt{

	@Autowired
	Firestore firestore;
	
	@Override
	public Resource createResource(Resource resource) throws Exception {
		Resource createdResource = null;
		
		try {
			DocumentReference docRef = firestore.collection("resources").document();
			ApiFuture<WriteResult> future = docRef.set(resource);
			ApiFuture<DocumentSnapshot> docFuture = docRef.get();
			System.out.println("Updated at: " + future.get().getUpdateTime());
			createdResource = docFuture.get().toObject(Resource.class);
		}catch(Exception e) {
			System.out.println(e);
			throw e;
		}
		
		
		return createdResource;
	}

}
