package com.project.library_management.entities;

import java.time.Instant;
import java.util.Map;
import com.project.library_management.utils.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userName;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	private String email;
	private String password;
	private Instant createdAt;

	public User() {

	}

	public User(long userId, String userName, Role role, String email, Instant createdAt) {
		super();
		this.userId = userId;
		this.userName = userName ;
		this.role = role;
		this.email = email;
		this.createdAt = createdAt;
	}

	public User(long userId, String userName, Role role, String email,String password, Instant createdAt) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.role = role;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}
	
	// When user is created
	public User(String userName, String password, Role role, String email) {
		super();
		this.userName = userName ;
		this.password = password ;
		this.role = role ;
		this.email = email;
		this.createdAt = Instant.now();
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = Instant.now();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName != null ? userName : this.userName;
	}

	public Role getRole() {
		return role;
	}

	public static Role getRole(String role) {
		if (role.equals("ADMIN")) {
			return Role.ADMIN;
		} else if (role.equals("LIBRARIAN")) {
			return Role.LIBRARIAN;
		} else if (role.equals("MEMBER")) {
			return Role.MEMBER;
		}
		return null;
	}

	public void setRole(Role role) {
		this.role = role != null ? role : this.role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email != null ? email : this.email;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt != null ? createdAt : this.createdAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password != null ? password : this.password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", role=" + role + ", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}

	public static User fromMap(Map<String,String> mp){
		String userName = mp.getOrDefault("userName", null);
		String password = mp.getOrDefault("password",null);
		String tempRole = mp.getOrDefault("role", null);
		String email = mp.getOrDefault("email", null);
		Role role  = User.getRole(tempRole);
		return new User(userName, password, role, email);
	}
}
