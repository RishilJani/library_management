package com.project.library_management.services;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.library_management.DTOs.insert_DTOs.UserRequestDTO;
import com.project.library_management.DTOs.response_DTOs.ResponseDTO;
import com.project.library_management.entities.User;
import com.project.library_management.repo.UserRepo;

@Service
public class UserService {
	 
    @Autowired
	UserRepo repo;

	// To get all users 
	public ResponseDTO getAllUsers(){
		return new ResponseDTO(false, "Users data",repo.findAll());
	}

	// To get user by id 	
	public ResponseDTO getUserById(long userId) {
		User us = repo.findById(userId).orElse(null);
		if(us != null)
			return new ResponseDTO(false, "User Found" , us);
		else
			return ResponseDTO.notFoundResponse("User Not found");

	}
	
	// To get user by id 	
	public ResponseDTO insertUser(UserRequestDTO us) {
		try {			
			User user = new User(us.getUserName(), us.getPassword(), us.getRole(), us.getEmail());
			User temp = this.repo.save(user);
			return new ResponseDTO(false , "User Added" , temp);
		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
			return ResponseDTO.errorResponse(e);
		}
	}

	// to delete user by id
	public ResponseDTO deleteUser(long userId){
		try {
			repo.deleteById(userId);
			return new ResponseDTO(false,	"User Deleted", userId);
		} catch (Exception e) {
			System.out.println("Exception at deleteUser = " + e.getMessage());
			return ResponseDTO.errorResponse(e);
		}
	}

	// to update the user
	public ResponseDTO updateUser(Map<String,String> mp, long id){
		try {
			User user = this.repo.findById(id).orElse(null);
			User us = User.fromMap(mp);
			if(user == null){
				return ResponseDTO.notFoundResponse("User not found");
			}
			
			user.setUserName(us.getUserName());
			user.setPassword(us.getPassword());
			user.setEmail(us.getEmail());
			user.setRole(us.getRole());
			user.setCreatedAt(us.getCreatedAt());

			this.repo.save(user);
			System.out.println("User updated");
			return new ResponseDTO(false, "User data edited", user);
		} catch (Exception e) {
			System.out.println("Error at updateUser = " + e.getMessage());
			return new ResponseDTO(true, "Some Error Occurred", e);
		}
	}

	public ResponseDTO loginUser(Map<String,String> mp){
		try {
			String email = mp.getOrDefault("email",null);
			String password = mp.getOrDefault("password", null);
			if(email == null || password == null){
				return new ResponseDTO(true,"Incomplete Credentials", new Exception());
			}
			User us = this.repo.findByEmail(email).get();
			System.out.println("User u = " + us);
			
			// TODO
			if(us.getPassword() == password){
				return new ResponseDTO(false,"Login Successfull", us);
			}else{
				return new ResponseDTO(true,"Credentials Don't match", us);
			}

		} catch (Exception e) {
			System.out.println("Error at loginUser = " + e.getMessage());
			return new ResponseDTO(true,"No User Found", e);
		}
	}
}
