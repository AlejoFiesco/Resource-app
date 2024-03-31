package com.example.demo.database.factory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class Factory implements FactoryInterface {
	
	
	@Autowired
	Firestore firestore;
	
	HashMap<Class<?>, String> collections;
	
	Factory(){
		collections = new HashMap<>();
		Arrays.asList(Collections.values()).forEach(coll -> collections.put(coll.getClass1(), coll.getCollectionName()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T create(T object, String id) throws Exception {
		T createdObject = null;

		try {
			String collection = collections.get(object.getClass());
			DocumentReference docRef = id == null ? firestore.collection(collection).document() : firestore.collection(collection).document(id);
			if(id == null) {
				Method setIdMethod = object.getClass().getMethod("setId", String.class);
				setIdMethod.invoke(object, docRef.getId());
			}
			ApiFuture<WriteResult> future = docRef.set(object);
			System.out.println("Updated at: " + future.get().getUpdateTime());
			ApiFuture<DocumentSnapshot> newDocRef = docRef.get();
			createdObject = (T) newDocRef.get().toObject(object.getClass());
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}

		return createdObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getList(Class<?> class1) throws Exception {
		List<T> objectList = null;
		
		try {
			CollectionReference collectionRef = firestore.collection(collections.get(class1));
			List<QueryDocumentSnapshot> docSnapList = collectionRef.get().get().getDocuments();
			objectList =  (List<T>) docSnapList.stream().map(doc -> doc.toObject(class1)).collect(Collectors.toList());
		}catch(Exception e) {
			throw e;
		}
		
		return objectList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getById(Class<?> class1, String id) throws Exception {
		T returnedObject = null;
		
		try {
			DocumentReference docRef = firestore.collection(collections.get(class1)).document(id);
			returnedObject = (T) docRef.get().get().toObject(class1);
		}catch(Exception e) {
			System.out.println(e);
			throw e;
		}
		
		return returnedObject;
	}	
}
