package com.project.library_management.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.library_management.DTOs.insert_DTOs.UserRequestDTO;
import com.project.library_management.DTOs.response_DTOs.ResponseDTO;
import com.project.library_management.entities.User;
import com.project.library_management.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseDTO getAllUsers(){
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseDTO getUserById(@PathVariable long userId) {
		return this.userService.getUserById(userId);
	}

	@PostMapping("/users")
	public ResponseDTO insertUser(@RequestBody UserRequestDTO us) {
		try {
			return this.userService.insertUser(us);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseDTO(true, "Some Error Occured" , e);
		}
	}

	@DeleteMapping("/users/{userId}")
	public ResponseDTO deleteUser(@PathVariable long userId){
		return this.userService.deleteUser(userId);
	}

	// Edit the user
	@PutMapping("/users/{id}")
	public ResponseDTO updateUser(@PathVariable long id, @RequestBody Map<String,String> mp) {
		return this.userService.updateUser(mp, id);
	}

	@PostMapping("/login")
	public ResponseDTO postMethodName(@RequestBody Map<String,String> mp) {
		return this.userService.loginUser(mp);
	}
	
}
