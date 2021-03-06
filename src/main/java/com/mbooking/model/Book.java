package com.mbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_ID_GEN")
    @SequenceGenerator(name = "BOOK_ID_GEN", sequenceName = "BOOK_SEQ_GEN", allocationSize = 100)
    private Long id;

    private String title;

    @Column(unique = true)
    private String isbn;

    @ManyToMany(cascade = CascadeType.PERSIST) // cascade only save operations
    @JoinTable(
        name = "BOOK_AUTHOR",
        joinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"BOOK_ID", "AUTHOR_ID"}))
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
