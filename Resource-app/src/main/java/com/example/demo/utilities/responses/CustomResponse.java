package com.example.demo.utilities.responses;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class CustomResponse extends ResponseEntity<Object>{

	public CustomResponse(Object body, HttpStatusCode status) {
		super(body, status);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> ResponseEntity<T> buildResponse(Object object){
		return object == null ? ResponseEntity.internalServerError().build() : (ResponseEntity<T>) ResponseEntity.ok(object);
	}

}
