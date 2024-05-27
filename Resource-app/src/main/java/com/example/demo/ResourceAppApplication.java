package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ResourceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceAppApplication.class, args);
	}

}
