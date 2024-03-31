package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Reserve;

@RequestMapping("/reserve")
public interface ReserveServiceInt {
	@PostMapping("/")
	 public ResponseEntity<Reserve> createReserve(@RequestBody Reserve reserve);
	 
	 @GetMapping("/")
	 public ResponseEntity<List<Reserve>> getReserves() ;
	 
	 @GetMapping("/{reserveId}")
	 public ResponseEntity<Reserve> getReserveById(@PathVariable(value="reserveId") String id);
	 
	 @PutMapping("/{reserveId}")
	 public ResponseEntity<Reserve> registerDevolution(@PathVariable(value="reserveId") String id);
}
