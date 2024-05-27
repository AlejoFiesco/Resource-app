package com.example.demo.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.interfaces.ClassroomBusinessInt;
import com.example.demo.database.factory.Factory;
import com.example.demo.model.Classroom;

@Service
public class ClassroomBusinessImp implements ClassroomBusinessInt {

	@Autowired
	Factory factory;

	@Override
	public Classroom createClassroom(Classroom classroom) throws Exception {
		Classroom createdClassroom = null;
		if (classroom != null) {
			try {
				createdClassroom = (Classroom) factory.create(classroom, classroom.getId());
			} catch (Exception e) {
				throw e;
			}
		}
		return createdClassroom;
	}

	@Override
	public List<Classroom> getClassroomList() throws Exception {
		List<Classroom> classroomList = null;

		try {
			classroomList = factory.getList(Classroom.class, null);
		} catch (Exception e) {
			throw e;
		}
		return classroomList;
	}

	@Override
	public Classroom getClassroomById(String classroomId) throws Exception {
		Classroom returnedClassroom = null;
		
		try {
			returnedClassroom = (Classroom) factory.getById(Classroom.class, classroomId);
		}catch(Exception e) {
			throw e;
		}
		
		return returnedClassroom;
	}
}
