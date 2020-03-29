package com.mbooking.controller;

import com.mbooking.model.Book;
import com.mbooking.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody // don't produce a view
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // @PathVariable binds the value of the query string parameter id
    // into the id parameter of the book method
    // HTTP requests to /book are mapped to the book() method
    @GetMapping("/book/{id}")
    public Book book(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> books() {
        return bookService.findAll();
    }

    @PostMapping("/book")
    Book newBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/book/{id}")
    Book replaceBook(@RequestBody Book book, @PathVariable Long id) {
        return bookService.replace(book, id);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}
