package com.mbooking.service;

import com.mbooking.model.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorService {
    Author findById(Long id);
    List<Author> findAll();
    Author save(Author author);
}
