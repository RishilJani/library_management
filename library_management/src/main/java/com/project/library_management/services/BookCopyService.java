package com.project.library_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.library_management.DTOs.insert_DTOs.BookCopyRequestDTO;
import com.project.library_management.DTOs.response_DTOs.ResponseDTO;
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

    public ResponseDTO getAllBookCopies(){
        return new ResponseDTO(false, "Book Copies",this.bookCopyRepo.findAll());
    }
    
    public ResponseDTO getBookCopiesByBookId(long bookId){
        return new ResponseDTO(false,"Book Copies By book id",this.bookCopyRepo.findByBookBookId(bookId));
    }
    
    public BookCopy getBookCopyById(long bookCopyId){
        return this.bookCopyRepo.findById(bookCopyId).orElse(null);
    }

    public ResponseDTO insertBookCopy(BookCopyRequestDTO bookCopyRequestDTO){
        try {
            Book book = this.bookRepo.findById(bookCopyRequestDTO.getBookId()).orElse(null);
            if(book == null) return ResponseDTO.notFoundResponse("Book Not found");
            
            BookCopy copy = this.bookCopyRepo.save(new BookCopy(book,bookCopyRequestDTO.getStatus(),bookCopyRequestDTO.getShelfLocation()));
            return new ResponseDTO(false, "Book Copy Added", copy);
        } catch (Exception e) {
            System.out.println("Error at insert book copy = " + e.getMessage());
            return ResponseDTO.errorResponse(e);
        }

    }
}
