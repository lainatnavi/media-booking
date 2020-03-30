package com.mbooking.controller;

import com.mbooking.model.Author;
import com.mbooking.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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

    @GetMapping("/author/{id}")
    public EntityModel<Author> author(@PathVariable Long id) {
        return assembler.toModel(
                authorService.findById(id));
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public CollectionModel<EntityModel<Author>> authors() {
        List<EntityModel<Author>> authors = authorService.findAll()
                .stream().map(assembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(authors,
                linkTo(methodOn(AuthorController.class)).withSelfRel());
    }

    @PostMapping("/author")
    public Author newAuthor(@RequestBody Author newAuthor) {
        return authorService.save(newAuthor);
    }

    @PutMapping("/author/{id}")
    public Author replace(@RequestBody Author newAuthor,@PathVariable Long id) {
        return authorService.replace(newAuthor, id);
    }

    @DeleteMapping("/author/{id}")
    public void delete(@PathVariable Long id) {
        authorService.deleteById(id);
    }

}
