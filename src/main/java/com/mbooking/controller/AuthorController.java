package com.mbooking.controller;

import com.mbooking.model.Author;
import com.mbooking.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    @Autowired
    private AuthorModelAssembler assembler;

    @GetMapping("/authors/{id}")
    public EntityModel<Author> author(@PathVariable Long id) {
        Author author = authorService.findById(id);
        return assembler.toModel(author);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public CollectionModel<EntityModel<Author>> authors() {
        List<EntityModel<Author>> authors = authorService.findAll()
                .stream().map(assembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(authors,
                linkTo(methodOn(AuthorController.class)).withSelfRel());
    }

    @PostMapping("/authors")
    public ResponseEntity<?> newAuthor(@RequestBody Author newAuthor) {
        Author insertedAuthor = authorService.save(newAuthor);
        EntityModel<Author> entityModel = assembler.toModel(insertedAuthor);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<?> replace(@RequestBody Author newAuthor,@PathVariable Long id) {
        Author updatedAuthor = authorService.replace(newAuthor, id);
        EntityModel<Author> entityModel = assembler.toModel(updatedAuthor);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/authors/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
