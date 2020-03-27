package com.mbooking.service;

import com.mbooking.model.Book;
import com.mbooking.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * select b.title, b.isbn, a.name author
     *  from book b
     * join book_author ba on b.id = ba.book_id
     * join author a on a.id = ba.author_id
     * where b.id = ?
     */

    public Book findById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

}
