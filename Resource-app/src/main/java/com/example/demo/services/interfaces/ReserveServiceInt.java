package com.example.demo.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Reserve;

@RequestMapping("/reserve")
public interface ReserveServiceInt {
	@PostMapping("/")
	 public ResponseEntity<Reserve> createReserve(@RequestBody Reserve reserve);
	 
	 @GetMapping("/")
	 ResponseEntity<List<Reserve>> getReserves() ;
}
