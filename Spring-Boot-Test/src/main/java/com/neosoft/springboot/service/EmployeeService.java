package com.neosoft.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.model.Employee;
import com.neosoft.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	//Inject our EmpRepo
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}
	
	public Optional<Employee> getEmployee(long id) {
		return employeeRepo.findById(id);
	}
	
	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
	}
	
	public void deleteEmployee(long id) {
		employeeRepo.deleteById(id);
	}
	
	public void updateEmployee(Employee employee, long id)  {
		if(employeeRepo.findById(id).isPresent())
			employeeRepo.save(employee);		
	}
}
