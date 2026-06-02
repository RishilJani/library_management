package com.project.library_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library_management.entities.User;
import com.project.library_management.repo.UserRepo;

@Service
public class UserService {
	 
	@Autowired
	UserRepo repo;
	
	// To get all users 
	public List<User> getAllUsers(){
		return repo.findAll();
	}

	// To get user by id 	
	public User getUserById(long userId) {
		return repo.findById(userId).orElse(null);
	}
	
	// To get user by id 	
	public void insertUser(User us) {
		try {			
			repo.save(us);
		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
			
		}
	}

	// to delete user by id
	public boolean deleteUser(long userId){
		try {
			repo.deleteById(userId);
			return true;
		} catch (Exception e) {
			System.out.println("Exception at deleteUser = " + e.getMessage());
			return false;
		}
	}

	// to update the user
	public boolean updateUser(User us, long id){
		try {
			User user = this.repo.findById(id).get();
			user.setUserName(us.getUserName());
			user.setPassword(us.getPassword());
			user.setEmail(us.getEmail());
			user.setRole(us.getRole());
			user.setCreatedAt(us.getCreatedAt());

			this.repo.save(user);
			System.out.println("User updated");
			return true;
		} catch (Exception e) {
			System.out.println("Error at updateUser = " + e.getMessage());
			return false;
		}
	}
}
