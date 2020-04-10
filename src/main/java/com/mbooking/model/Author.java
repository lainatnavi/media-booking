package com.mbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Domain model Author entity
 */
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_SEQ_GEN")
    @SequenceGenerator(name = "AUTHOR_SEQ_GEN", sequenceName = "AUTHOR_SEQ_GEN", allocationSize = 1)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnoreProperties("authors") // Avoid recursive parent references
    private Set<Book> books;

    protected Author() {}

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
