package com.project.library_management.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.library_management.utils.enums.BookStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "book_copy")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookCopyId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus status;

    private String shelfLocation;

    public BookCopy(){}
    
    public BookCopy(Book book, BookStatus status,String shelfLocation){
        this.book = book;
        this.status = status;
        this.shelfLocation = shelfLocation;
    }


    public long getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(long bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public BookStatus getStatus() {
        return status;
    }

    public BookStatus getStatus(String bookStatus) {
        if (bookStatus.equals("AVAILABLE")) {
            return BookStatus.AVAILABLE;
        } else if (bookStatus.equals("ISSUED")) {
            return BookStatus.ISSUED;
        } else if (bookStatus.equals("LOST")) {
            return BookStatus.LOST;
        }
        return null;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }   

    public void setBook(Book book) {
        this.book = book;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    
}
