package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

//@Service
@Component
public class DeptService {
@Autowired
private DepartmentRepository rep;
public String saveDeptService(Department d){
	System.out.println ("Entered in Service");
	Department dd = rep.save(d);
	return (" Dept inserted successfully");
	

}
	

}
