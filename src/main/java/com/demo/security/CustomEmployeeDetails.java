package com.demo.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.model.Employee;

public class CustomEmployeeDetails implements UserDetails{//UserDetails is an interface

	public Employee employee;
	 public CustomEmployeeDetails(Employee employee) {
	        this.employee = employee;
	    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("Employee"));
	}

	@Override
	public String getPassword() {
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		return employee.getName();
	}

}
