package com.project.library_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.library_management.entities.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
