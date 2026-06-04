package com.project.library_management.entities;

import java.util.List;
import java.util.Map;
import jakarta.persistence.*;

@Entity
@Table(name = "books", uniqueConstraints = @UniqueConstraint(columnNames = { "isbn" }))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    private String isbn;
    private String title;
    private String description;
    private String publication;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookCopy> bookCopies;

    public Book() {
        super();
    }

    // To get book object
    public Book(long bookId, String isbn, String title, String description, String publication) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.publication = publication;
    }

    // To create Object DTO
    public Book(String isbn, String title, String description, String publication) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.publication = publication;
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
        this.isbn = isbn != null ? isbn : this.isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title != null ? title : this.title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description != null ? description : this.description;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication != null ? publication : this.publication;
    }

    public static Book fromMap(Map<String, String> mp) {
        String isbn = mp.getOrDefault("isbn", null);
        String title = mp.getOrDefault("title", null);
        String description = mp.getOrDefault("description", null);
        String publication = mp.getOrDefault("publication", null);

        return new Book(isbn, title, description, publication);
    }
}
