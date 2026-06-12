package com.project.library_management.DTOs.response_DTOs;

import java.util.List;

import com.project.library_management.entities.Book;
import com.project.library_management.entities.BookCopy;

public class BookResponsDTO {
    private long bookId;
    private String isbn;
    private String title;
    private String description;
    private String publication;
    private List<BookCopy> bookCopies;

    public BookResponsDTO() {

    }

    public BookResponsDTO(Book book) {
        this.bookId = book.getBookId();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.isbn = book.getIsbn();
        this.publication = book.getPublication();
        this.bookCopies = book.getBookCopies();
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

}
