package com.project.library_management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library_management.DTOs.insert_DTOs.BookCopyRequestDTO;
import com.project.library_management.entities.Book;
import com.project.library_management.entities.BookCopy;
import com.project.library_management.repo.BookCopyRepo;
import com.project.library_management.repo.BookRepo;

@Service
public class BookCopyService {
    
    @Autowired
    BookCopyRepo bookCopyRepo;
    @Autowired
    BookRepo bookRepo;

    public List<BookCopy> getAllBookCopies(){
        return this.bookCopyRepo.findAll();
    }
    public List<BookCopy> getBookCopiesByBookId(long bookId){
        return this.bookCopyRepo.findByBookBookId(bookId);
    }
    
    public BookCopy getBookCopyById(long bookCopyId){
        return this.bookCopyRepo.findById(bookCopyId).orElse(null);
    }

    public String insertBookCopy(BookCopyRequestDTO bookCopyRequestDTO){
        Book book = this.bookRepo.findById(bookCopyRequestDTO.getBookId()).orElse(null);
        
        if(book == null) return "Book not found !!";

        this.bookCopyRepo.save(new BookCopy(book,bookCopyRequestDTO.getStatus(),bookCopyRequestDTO.getShelfLocation()));
        return "Copy Added";
    }
}
