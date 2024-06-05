package com.example.demo.database.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.factory.Collections;
import com.example.demo.database.interfaces.ResourceDBInt;
import com.example.demo.model.Reserve;
import com.example.demo.model.Resource;
import com.example.demo.utilities.filters.ResourceFilter;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class ResourceDBImpl implements ResourceDBInt{

	@Autowired
	Firestore firestore;
	
	private static String resourcesCollection = "resources";
	
	@Override
	public Resource createResource(Resource resource) throws Exception {
		Resource createdResource = null;
		
		try {
			DocumentReference docRef = firestore.collection(resourcesCollection).document();
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

	@Override
	public List<Resource> getResourceList(ResourceFilter filter) throws Exception {
		List<Resource> resourceList;
		
		try {
			Query query = firestore.collection(resourcesCollection);
			if(Objects.nonNull(filter.getResourcesId())) query = query.whereIn(FieldPath.documentId(), filter.getResourcesId());
			List<QueryDocumentSnapshot> docSnapList = query.get().get().getDocuments();
			resourceList = docSnapList.stream().map(doc -> doc.toObject(Resource.class)).collect(Collectors.toList());
		}catch(Exception e) {
			throw e;
		}
		return resourceList;
	}
	

}
