package com.mbooking.service;

import com.mbooking.model.Author;
import com.mbooking.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
