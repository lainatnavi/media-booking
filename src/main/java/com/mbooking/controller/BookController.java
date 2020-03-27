package com.mbooking.controller;

import com.mbooking.model.Book;
import com.mbooking.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody // don't produce a view
public class BookController {

    @Autowired
    private BookService bookService;

    // @PathVariable binds the value of the query string parameter id
    // into the id parameter of the book method
    @GetMapping("/book/{id}") // HTTP requests to /book are mapped to the book() method
    public Book book(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/book")
    Book newBook(@RequestBody Book book) {
        return bookService.save(book);
    }
}
