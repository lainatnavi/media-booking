package com.mbooking.service;

import com.mbooking.error.AuthorNotFoundException;
import com.mbooking.model.Author;
import com.mbooking.dao.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author replace(Author newAuthor, Long id) {
        return authorRepository.findById(id)
                .map(author -> {
                    author.setName(newAuthor.getName());
                    author.setBooks(newAuthor.getBooks());
                    return authorRepository.save(author);
                }).orElseGet(() -> {
                    newAuthor.setId(id);
                    return authorRepository.save(newAuthor);
                });
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
