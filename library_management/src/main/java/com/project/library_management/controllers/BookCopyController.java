package com.project.library_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.library_management.DTOs.insert_DTOs.BookCopyRequestDTO;
import com.project.library_management.DTOs.response_DTOs.ResponseDTO;
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
    public ResponseDTO getAllBooks() {
        return this.bookCopyService.getAllBookCopies();
    }
    
    @GetMapping("/bookcopies/book/{bookId}")
    public ResponseDTO getBookCopiesByBookId(@PathVariable long bookId) {
        return this.bookCopyService.getBookCopiesByBookId(bookId);
    }

    @PostMapping("/bookcopies")
    public ResponseDTO insertBookCopy(@RequestBody BookCopyRequestDTO newBookCopy) {
        return this.bookCopyService.insertBookCopy(newBookCopy);
    }
    
}
