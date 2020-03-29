package com.mbooking.controller;

import com.mbooking.model.Book;
import com.mbooking.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@ResponseBody // don't produce a view (make this a REST controller)
//@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired()
    public void setAssembler(BookModelAssembler assembler) {
        this.assembler = assembler;
    }

    private BookModelAssembler assembler;

    // @PathVariable binds the value of the query string parameter id
    // into the id parameter of the book method
    // HTTP requests to /book are mapped to the book() method
    @GetMapping("/book/{id}")
    public EntityModel<Book> book(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return assembler.toModel(book);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public CollectionModel<EntityModel<Book>> books() {
        List<EntityModel<Book>> books = bookService.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(books,
                linkTo(methodOn(BookController.class).books()).withSelfRel());
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
