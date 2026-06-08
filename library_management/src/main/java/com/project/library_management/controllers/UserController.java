package com.project.library_management.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.library_management.DTOs.insert_DTOs.UserRequestDTO;
import com.project.library_management.entities.User;
import com.project.library_management.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable long userId) {
		return this.userService.getUserById(userId);
	}
	

	@PostMapping("/users")
	public String insertUser(@RequestBody UserRequestDTO us) {
		try {
			// User us = User.fromMap(mp);
			this.userService.insertUser(us);
			return "User Added";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "ERROR";
		}
	}

	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable long userId){
		boolean b = this.userService.deleteUser(userId);
		if(b)
			return "DELETED";
		else 
			return "ERROR";
	}

	// Edit the user
	@PutMapping("/users/{id}")
	public String updateUser(@PathVariable long id, @RequestBody Map<String,String> mp) {
		User us = User.fromMap(mp);
		if(us == null){
			return "ERROR";
		}
		try {
			this.userService.updateUser(us,id);
		} catch (Exception e) {
			return "ERROR";
		}
		return "User Updated";
	}
}
