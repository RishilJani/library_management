package com.project.library_management.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.library_management.entities.BookCopy;

public interface BookCopyRepo extends JpaRepository<BookCopy,Long>{
    List<BookCopy> findByBookBookId(Long bookId);
}