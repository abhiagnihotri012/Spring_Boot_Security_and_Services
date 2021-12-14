package com.neosoft.springboot.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.model.Employee;
import com.neosoft.springboot.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class EmployeeController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){		
		return employeeService.getEmployees();
	}	
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable long id) {
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/employee/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		employee.setId(id);
		employeeService.updateEmployee(employee, id);
	}
	
	//==================Response Entity ====================
	@PostMapping("/employees/response")
	public ResponseEntity<Employee> addEmployeeResponse(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/response/{id}")
	public ResponseEntity<Object> getEmployeeResponse(@PathVariable long id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
		if(employee.isPresent())
			return new ResponseEntity<Object>(employee,HttpStatus.OK);
		else			
			return new ResponseEntity<Object>("No Such ID: "+id,HttpStatus.NOT_FOUND);		
	}
	
	@GetMapping("/customHeader")
	ResponseEntity<String> customHeader(){
		return ResponseEntity.ok()
				.header("Custom-Header", "Neosoft")
				.body("Custom header set");
	}	
	
	//implement the same things for remaining 3 methods	
	
	//add some log info,warn,err
	@GetMapping("/logger")
	public String getLogger() {
		logger.info("/info logger method ::"+new java.util.Date().toString());
		logger.warn("/warn logger method ::"+new java.util.Date().toString());
		logger.error("/error logger method ::"+new java.util.Date().toString());
		
		return "Logger test";
	}
	
	
}
