package com.project.library_management.DTOs.insert_DTOs;

import com.project.library_management.utils.enums.BookStatus;

public class BookCopyRequestDTO {
    private Long bookId;
    private BookStatus status;
    private String shelfLocation;
    
    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public BookStatus getStatus() {
        return status;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }
    public String getShelfLocation() {
        return shelfLocation;
    }
    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }
    
}
