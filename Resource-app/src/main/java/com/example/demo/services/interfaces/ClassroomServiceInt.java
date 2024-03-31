package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Classroom;


@RequestMapping("/classroom")
public interface ClassroomServiceInt {
	
	 @PostMapping("/")
	 public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom);
	 
	 @GetMapping("/")
	 public ResponseEntity<List<Classroom>> getClassroom() ;
	 
	 @GetMapping("/{classroomId}")
	 public ResponseEntity<Classroom> getClassroomById(@PathVariable(value = "classroomId") String classroomId );
}
