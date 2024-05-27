package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Reserve;

@RequestMapping("/reserve")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public interface ReserveServiceInt {
	@PostMapping("/")
	 public ResponseEntity<Reserve> createReserve(@RequestBody Reserve reserve);
	 
	 @GetMapping("/")
	 public ResponseEntity<List<Reserve>> getReserves(
			 @RequestParam(value="classroomId", required=false) String classroomId, 
			 @RequestParam(value="resourceId", required=false) String resourceId, 
			 @RequestParam(value="reservedById", required=false) String reservedById,
			 @RequestParam(value="startDate", required=false) String startDate,
			 @RequestParam(value="endDate", required=false) String endDate
			 ) ;
	 
	 @GetMapping("/{reserveId}")
	 public ResponseEntity<Reserve> getReserveById(@PathVariable(value="reserveId") String id);
	 
	 @PutMapping("/{reserveId}")
	 public ResponseEntity<Reserve> registerDevolution(@PathVariable(value="reserveId") String id);
}
