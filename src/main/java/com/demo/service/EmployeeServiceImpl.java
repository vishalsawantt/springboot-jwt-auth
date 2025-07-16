package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.security.JWTService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTService jwtService;
	
	private AuthenticationProvider authenticationProvider;
	public EmployeeServiceImpl(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider=authenticationProvider;
	}

	@Override
	public Employee addEmployee(Employee newEmployee) {
		String encryptedPassword = passwordEncoder.encode(newEmployee.getPassword());
		newEmployee.setPassword(encryptedPassword);
		return employeeRepository.save(newEmployee);
	}

	@Override
	public String verify(Employee checkEmployee) {
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
				checkEmployee.getName(), checkEmployee.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(checkEmployee.getName());		
		}
		return "fail";
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
}
