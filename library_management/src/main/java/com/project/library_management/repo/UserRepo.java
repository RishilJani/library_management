package com.project.library_management.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.library_management.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
    
}
