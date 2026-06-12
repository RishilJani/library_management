package com.project.library_management.DTOs.response_DTOs;

import java.time.Instant;

import com.project.library_management.entities.User;
import com.project.library_management.utils.enums.Role;

public class UserResponseDTO {

    private long userId;
    private String userName;
    private Role role;
    private String email;
    private Instant createdAt;

    public UserResponseDTO(){
        
    }
    public UserResponseDTO(User us){
        this.userId = us.getUserId();
        this.userName = us.getUserName();
        this.email = us.getEmail();
        this.role = us.getRole();
        this.createdAt = us.getCreatedAt();
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
        this.userName = userName;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
