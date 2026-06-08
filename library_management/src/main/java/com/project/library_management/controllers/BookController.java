package com.project.library_management.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.library_management.DTOs.insert_DTOs.BookRequestDTO;
import com.project.library_management.DTOs.response_DTOs.ResponseDTO;
import com.project.library_management.services.BookService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BookController {
    
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseDTO getAllBooks(){
        return this.bookService.getAllBooks();
    } 
    
    @GetMapping("/books/{bookId}")
    public ResponseDTO getBookById(@PathVariable long bookId){
        return this.bookService.getBookByID(bookId);
    }

    @PostMapping("/books")
    public ResponseDTO insertBook(@RequestBody BookRequestDTO book){
        return this.bookService.insertBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseDTO deleteBook(@PathVariable long bookId){
        return this.bookService.deleteBookById(bookId);
    }
    
    @PutMapping("/users/{bookId}")
    public ResponseDTO updateUser(@PathVariable long id , @RequestBody Map<String, String> mp){
        return this.bookService.updateBook(mp, id);
    }
}
