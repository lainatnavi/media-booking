package com.mbooking.service;

import com.mbooking.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // Inject interface for mock implementation (test purposes)
public interface BookService {
    Book findById(Long id);
    List<Book> findAll();
    Book save(Book book);
    void deleteById(Long id);
}
