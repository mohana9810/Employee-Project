package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
    //@Autowired
	private EmployeeRepository rep;
	
	
	public Employee save(Employee emp){
	Employee em = rep.save(emp);
	return em;
	}
	
}
