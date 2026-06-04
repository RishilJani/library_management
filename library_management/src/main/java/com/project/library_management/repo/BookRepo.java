package com.project.library_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.library_management.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
