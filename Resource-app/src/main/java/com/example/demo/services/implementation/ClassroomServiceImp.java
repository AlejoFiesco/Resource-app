package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.implementation.ClassroomBusinessImp;
import com.example.demo.model.Classroom;
import com.example.demo.services.interfaces.ClassroomServiceInt;

@RestController
public class ClassroomServiceImp implements ClassroomServiceInt{

	@Autowired
	ClassroomBusinessImp classroomBusiness;
	
	@Override
	public ResponseEntity<Classroom> createClassroom(Classroom classroom) {
		Classroom createdClassroom = null;
		try {
			createdClassroom = classroomBusiness.createClassroom(classroom);
		}catch(Exception e) {
			System.out.println(e);
		}
		return createdClassroom == null ? ResponseEntity.internalServerError().build() : ResponseEntity.ok(createdClassroom);
	}

	@Override
	public ResponseEntity<List<Classroom>> getClassroom() {
		List<Classroom> classroomList = null;
		try {
			classroomList = classroomBusiness.getClassroomList();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return classroomList == null ? ResponseEntity.internalServerError().build() : ResponseEntity.ok(classroomList);
	}

}
