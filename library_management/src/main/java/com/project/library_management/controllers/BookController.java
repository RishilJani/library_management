package com.project.library_management.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.library_management.DTOs.insert_DTOs.BookRequestDTO;
import com.project.library_management.entities.Book;
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
    public List<Book> getAllBooks(){
        return this.bookService.getAllBooks();
    } 
    
    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable long bookId){
        return this.bookService.getBookByID(bookId);
    }

    @PostMapping("/books")
    public String insertBook(@RequestBody BookRequestDTO book){
        try {
            this.bookService.insertBook(book);
            return "Added";
        } catch (Exception e) {
            System.out.println("Error at insertBook = " + e.getMessage());
            return "ERROR";
        }
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable long bookId){
        try {
            this.bookService.deleteBookById(bookId);
            return "Deleted";
        } catch (Exception e) {
            System.out.println("Error at deleteBook = " + e.getMessage());
            return "ERROR";
        }
    }
    
    @PutMapping("/users/{bookId}")
    public String updateUser(@PathVariable long id , @RequestBody Map<String, String> mp){
        try {
            Book book = Book.fromMap(mp);
            if(book == null){
                return "ERROR";
            }
            this.bookService.updateBook(book, id);
            return "";
        } catch (Exception e) {
            System.out.println("Error at updateUser = " + e.getMessage());
            return "ERROR";
        }
    }
}
