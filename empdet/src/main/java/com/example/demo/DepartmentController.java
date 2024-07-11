package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.employee.service.DeptService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentRepository rep;
//@Autowired 
private DeptService deptservices = new DeptService();

//@Autowired
//public DepartmentController(DeptService deptservices) {
//	this.deptservices = deptservices;
//}

@PostMapping("/saved")
public String savedept(@RequestBody Department d) {
	System.out.println("entered in save department");
	//DepartmentController deptcon = new DepartmentController(deptservices);
	Department dd = rep.save(d);
	//String result = deptservices.saveDeptService(d);
	//return result;
	return ("inserted successfully");
	
}

}
