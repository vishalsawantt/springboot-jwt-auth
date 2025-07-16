package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee newEmployee);
	String verify(Employee checkEmployee);
	List<Employee> getAllEmployee();
}


