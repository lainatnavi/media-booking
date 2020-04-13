package com.mbooking.controller;

import com.mbooking.model.Book;
import com.mbooking.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/books/{id}")
    ResponseEntity<?> book(@PathVariable Long id) {
        Book book = bookService.findById(id);
        EntityModel<Book> entityModel = assembler.toModel(book);
        return new ResponseEntity<>(entityModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    CollectionModel<EntityModel<Book>> books() {
        List<EntityModel<Book>> books = bookService.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(books,
                linkTo(methodOn(BookController.class).books()).withSelfRel());
    }

    @PostMapping("/books")
    ResponseEntity<?> newBook(@RequestBody Book book) {
        Book newBook = bookService.save(book);
        EntityModel<Book> entityModel = assembler.toModel(newBook);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PutMapping("/books/{id}")
    ResponseEntity<?> replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
        Book updatedBook = bookService.replace(newBook, id);
        EntityModel<Book> entityModel = assembler.toModel(updatedBook);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/books/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
