package com.project.library_management.services;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.project.library_management.DTOs.insert_DTOs.BookCopyRequestDTO;
import com.project.library_management.DTOs.response_DTOs.ResponseDTO;
import com.project.library_management.entities.Book;
import com.project.library_management.entities.BookCopy;
import com.project.library_management.repo.BookCopyRepo;
import com.project.library_management.repo.BookRepo;

@Service
public class BookCopyService {
    
    final BookCopyRepo bookCopyRepo;
    final BookRepo bookRepo;

    BookCopyService(BookCopyRepo bookCopyRepo, BookRepo bookRepo) {
        this.bookCopyRepo = bookCopyRepo;
        this.bookRepo = bookRepo;
    }

    public ResponseDTO getAllBookCopies(){
        return new ResponseDTO(false, "Book Copies",this.bookCopyRepo.findAll());
    }
    
    public ResponseDTO getBookCopiesByBookId(long bookId){
        return new ResponseDTO(false,"Book Copies By book id",this.bookCopyRepo.findByBookBookId(bookId));
    }
    
    public ResponseDTO getBookCopyById(long bookCopyId){
        BookCopy copy = this.bookCopyRepo.findById(bookCopyId).orElse(null);
        if(copy == null){
            return ResponseDTO.notFoundResponse("Book Copy not found");
        }else{
            return new ResponseDTO(false ,"Book Copy found" , copy);
        }
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

    public ResponseDTO deleteBookCopy(long bookCopyId){
        try {
            this.bookCopyRepo.deleteById(bookCopyId);
            return new ResponseDTO(false , "Book Copy deleted", bookCopyId);
        } catch (Exception e) {
            System.out.println("Error at deleteBookCopy = " + e.getMessage());
            return ResponseDTO.errorResponse(e);
        }
    }

    public ResponseDTO updateBookCopy(Map<String,String> mp , long id){
        try {
            BookCopy copy = this.bookCopyRepo.findById(id).orElse(null);
            if(copy == null){
                return ResponseDTO.notFoundResponse("Book Copy Not found");
            }
            // BookCopy cpy = BookCopy.fromMap(mp);

            copy.setBookCopyId(id);
            copy.setShelfLocation(mp.getOrDefault("shelfLocation", null));
            copy.setStatus(mp.getOrDefault("status", null));
            return new ResponseDTO(false , "", null);
        } catch (Exception e) {
            System.out.println("Error at updateBookCopy = " + e.getMessage());
            return ResponseDTO.errorResponse(e);
        }
    }
}
