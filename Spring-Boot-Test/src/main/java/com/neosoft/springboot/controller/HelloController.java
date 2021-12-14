package com.neosoft.springboot.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	// URI: http://localhost:8080/hello
	@GetMapping("/hello")
	public String hello() {
		return "Hello!! Welcome to Spring Boot REST!!";
	}
	
	@GetMapping("/today")
	public String today() {
		return "Today is :"+new Date().toString();
	}
}
