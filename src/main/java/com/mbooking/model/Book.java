package com.mbooking.model;

public class Book extends Media {

    private String isbn;

    public Book(long id, String name, String author, String isbn) {
        super(id, name, author);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
