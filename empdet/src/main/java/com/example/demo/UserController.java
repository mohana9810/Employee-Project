package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
@Autowired 
UserRepository ur;
@RequestMapping ("/login")
public String verifyUser(@RequestBody User postmanuser)
{
	 
	Optional<User> dbuser = ur.findById(postmanuser.getUserid());
	String r =null;
	if(dbuser.isPresent()) {
		dbuser.ifPresent(user -> {
     String result=null;
		    if(user.getPassword().equals(postmanuser.getPassword())){
		    result = "true";	
		    }
		    else {
		    	result = "false";
		    }
	
		});
	}
		
	return r;
}
}
