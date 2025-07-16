package com.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class MyEmployeeDetailsService implements UserDetailsService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByName(name);
		if(employee==null) {
			throw new UsernameNotFoundException("Employee Not Found");
		}
		return new CustomEmployeeDetails(employee);
	}
}
