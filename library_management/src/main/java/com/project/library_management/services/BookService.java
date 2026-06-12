package com.project.library_management.services;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.project.library_management.DTOs.insert_DTOs.BookRequestDTO;
import com.project.library_management.DTOs.response_DTOs.BookResponsDTO;
import com.project.library_management.DTOs.response_DTOs.ResponseDTO;
import com.project.library_management.entities.Book;
import com.project.library_management.repo.BookRepo;

@Service
public class BookService {

    final BookRepo bookRepo;

    BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    // get all book records
    public ResponseDTO getAllBooks() {
        List<BookResponsDTO> res = this.bookRepo.findAll().stream().map(BookResponsDTO::new).toList();
        return new ResponseDTO(false, "Books Data", res);
    }

    // get book record by id
    public ResponseDTO getBookByID(long bookId) {
        Book book = this.bookRepo.findById(bookId).orElse(null);
        if (book != null) {
            return new ResponseDTO(false, "Book Found", book);
        } else {
            return ResponseDTO.notFoundResponse("Book not found");
        }
    }

    // to create book record
    public ResponseDTO insertBook(BookRequestDTO bookDTO) {
        try {
            Book book = new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getDescription(),
                    bookDTO.getPublication());
            Book res = this.bookRepo.save(book);
            return new ResponseDTO(false, "Book Added", res);
        } catch (Exception e) {
            System.err.println("Error at insertBook : " + e.getMessage());
            return ResponseDTO.errorResponse(e);
        }
    }

    // to delete book record by id
    // TODO : delete all the copis also
    public ResponseDTO deleteBookById(long bookId) {
        try {
            this.bookRepo.deleteById(bookId);
            return new ResponseDTO(false, "Book Deleted", bookId);
        } catch (Exception e) {
            System.err.println("Error at deleteBookById = " + e.getMessage());
            return ResponseDTO.errorResponse(e);
        }
    }

    // to update the book record
    public ResponseDTO updateBook(Map<String, String> mp, long id) {
        try {
            Book book = this.bookRepo.findById(id).orElse(null);
            Book newBook = Book.fromMap(mp);
            if (book == null) {
                return ResponseDTO.notFoundResponse("Boo not found");
            }
            book.setIsbn(newBook.getIsbn());
            book.setTitle(newBook.getTitle());
            book.setDescription(newBook.getDescription());
            book.setPublication(newBook.getPublication());

            Book res = this.bookRepo.save(book);
            return new ResponseDTO(false, "Book Edited", res);
        } catch (Exception e) {
            System.out.println("Error at updateBook = " + e.getMessage());
            return ResponseDTO.errorResponse(e);
        }
    }
}
