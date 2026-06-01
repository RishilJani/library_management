package com.project.library_management.entities;

import java.time.Instant;

import com.project.library_management.utils.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String userName;
	private Role role;
	private String email;
	
	private Instant createdAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = Instant.now();
	}
		
}
