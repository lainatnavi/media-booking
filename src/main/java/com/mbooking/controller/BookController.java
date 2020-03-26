package com.mbooking.controller;

import com.mbooking.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@ResponseBody // don't produce a view
public class BookController {

    private static final String book = "mockedBookData id = %d";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/book") // HTTP requests to /book are mapped to the book() method
    public Book book(
            @RequestParam(value = "id", defaultValue = "1")  // binds the value of the query string parameter id
                    // into the id parameter of the book method
                    long id) {
        return new Book(counter.incrementAndGet(),
                String.format(book,id), "George Orwell", "");
    }
}
