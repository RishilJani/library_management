package com.project.library_management.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.project.library_management.DTOs.insert_DTOs.BookCopyRequestDTO;
import com.project.library_management.DTOs.response_DTOs.ResponseDTO;
import com.project.library_management.services.BookCopyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class BookCopyController {
    
    final BookCopyService bookCopyService;

    BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    // to get all books
    @GetMapping("/bookcopies")
    public ResponseDTO getAllBookCopies() {
        return this.bookCopyService.getAllBookCopies();
    }

    @GetMapping("/bookcopies/{bookCopyId}")
    public ResponseDTO getMethodName(@PathVariable long bookCopyId) {
        return this.bookCopyService.getBookCopyById(bookCopyId);
    }
    
    
    // to get book copies by the book id
    @GetMapping("/bookcopies/book/{bookId}")
    public ResponseDTO getBookCopiesByBookId(@PathVariable long bookId) {
        return this.bookCopyService.getBookCopiesByBookId(bookId);
    }

    // to insert a new book copy
    @PostMapping("/bookcopies")
    public ResponseDTO insertBookCopy(@RequestBody BookCopyRequestDTO newBookCopy) {
        return this.bookCopyService.insertBookCopy(newBookCopy);
    }
    
    // to delete book copy by id
    @DeleteMapping("/bookcopies/{bookCopyId}")
    public ResponseDTO deleteBookCopy(@PathVariable long bookCopyId){
        return this.bookCopyService.deleteBookCopy(bookCopyId);
    }

}
