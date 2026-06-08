package com.project.library_management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.library_management.DTOs.insert_DTOs.BookRequestDTO;
import com.project.library_management.entities.Book;
import com.project.library_management.repo.BookRepo;

@Service
public class BookService {
    
    @Autowired
    BookRepo bookRepo;

    // get all book records
    public List<Book> getAllBooks(){
        return this.bookRepo.findAll();
    }
    
    // get book record by id
    public Book getBookByID(long bookId){
        return this.bookRepo.findById(bookId).orElse(null);
    }

    // to create book record
    public boolean insertBook(BookRequestDTO bookDTO){
        try {
            Book book = new Book(bookDTO.getIsbn(),bookDTO.getTitle(), bookDTO.getDescription(), bookDTO.getPublication());
            this.bookRepo.save(book);
            return true;
        } catch (Exception e) {
            System.err.println("Error at insertBook : " + e.getMessage());
            return false;
        }
    }

    // to delete book record by id
    // TODO : delete all the copis also
    public boolean deleteBookById(long bookId){
        try {
            this.bookRepo.deleteById(bookId);
            return true;
       } catch (Exception e) {
            System.err.println("Error at deleteBookById = " + e.getMessage());
            return false;
        }
    }

    // to update the book record
    public boolean updateBook(Book newBook, long id){
        try {
            Book book = this.bookRepo.findById(id).get();
            book.setIsbn(newBook.getIsbn());
            book.setTitle(newBook.getTitle());
            book.setDescription(newBook.getDescription());
            book.setPublication(newBook.getPublication());

            this.bookRepo.save(book);
            return true;
        } catch (Exception e) {
            System.out.println("Error at updateBook = " + e.getMessage());
            return false;
        }
    }
}
