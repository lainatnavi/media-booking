package com.mbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Domain model Book entity
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    // @Column name can be ommitted since defaults to columns name
    private String isbn;

    @ManyToMany(cascade = CascadeType.PERSIST) // cascade only save operations
    @JoinTable(
        name = "BOOK_AUTHOR",
        joinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID"))
    @JsonIgnoreProperties("books") // Avoid recursive child references
    private Set<Author> authors;

    protected Book() {}

    public Book(Long id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public Book(String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
