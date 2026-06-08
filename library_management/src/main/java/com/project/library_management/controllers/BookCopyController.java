package com.project.library_management.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.project.library_management.DTOs.insert_DTOs.BookCopyRequestDTO;
import com.project.library_management.entities.BookCopy;
import com.project.library_management.services.BookCopyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BookCopyController {
    
    @Autowired
    BookCopyService bookCopyService;

    @GetMapping("/bookcopies")
    public List<BookCopy> getAllBooks() {
        return this.bookCopyService.getAllBookCopies();
    }
    
    @GetMapping("/bookcopies/book/{bookId}")
    public List<BookCopy> getMethodName(@PathVariable long bookId) {
        return this.bookCopyService.getBookCopiesByBookId(bookId);
    }

    @PostMapping("/bookcopies")
    public String insertBookCopy(@RequestBody BookCopyRequestDTO newBookCopy) {
        try {
            return this.bookCopyService.insertBookCopy(newBookCopy);
        } catch (Exception e) {
            System.out.println("Error at insertBookCopy = " + e.getMessage());
            return "ERROR";
        }
    }
    
    
}
