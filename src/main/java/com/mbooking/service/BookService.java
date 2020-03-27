package com.mbooking.service;

import com.mbooking.model.Book;
import com.mbooking.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book findById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

}
