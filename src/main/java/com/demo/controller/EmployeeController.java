package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/register")
	public String insertEmployee(@RequestBody Employee addEmployee){
		System.out.println("Received request");
		Employee aEmployee = employeeService.addEmployee(addEmployee);
		return "Employee Added Successfully";
	}
	
	@PostMapping("/login")
	public String userLogin(@RequestBody Employee checkEmployee) {
		return employeeService.verify(checkEmployee);	
	}
	
	@GetMapping("/getAll")
	public List<Employee> displayAll() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/profile")
	public ResponseEntity<String> getProfile() {
	    return ResponseEntity.ok("Welcome Vishal! This is your profile.");
	}

}
