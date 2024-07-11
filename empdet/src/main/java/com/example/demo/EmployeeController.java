package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@RestController
public class EmployeeController {
 //@Autowired
 //EmployeeService empser;
    @Autowired
    EmployeeRepository rep;
 
	@RequestMapping("/index")
	public String index(){
		System.out.println("@@@@@Index controller@@@");
		return "hi";
	}
@PostMapping("/save")
public String saveEmployee(@RequestBody Employee e) {
	System.out.println("entered in save employee");
    //Employee emp = empser.save(e);
	rep.save(e);
	return ("inserted successfully");	
}
@PutMapping("/update/{id}")
public String updateEmployee(@RequestBody Employee e, @PathVariable (value ="id") int empid){
       //rep.deleteById(e.getEmpid());
	     Optional<Employee> oldEmp = rep.findById(empid);
	     if (oldEmp.isPresent()) {
	    	 rep.save(e);
	     }
	     else {
	    	 return ("employee not found");
	     }
       return ("updated successfully");
}
@DeleteMapping("/delete/{id}")
public Map<String, Boolean> deleteEmployee(@PathVariable (value ="id") int empid) {
    Optional<Employee> oldEmp = rep.findById(empid);
    Map <String, Boolean> map = new HashMap<>();
    if (oldEmp.isPresent()) {
    	rep.deleteById(empid);
    	map.put("deletestatus", true);
    }
    else {
    	map.put("deletestatus", false);
    }
	return map;
}


 
}
