package com.mbooking.controller;

import com.mbooking.model.Author;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class AuthorModelAssembler implements RepresentationModelAssembler<Author, EntityModel<Author>> {

    @Override
    public EntityModel<Author> toModel(Author author) {
        return new EntityModel<>(author,
                linkTo(methodOn(AuthorController.class).author(author.getId())).withSelfRel(),
                linkTo(methodOn(AuthorController.class).authors()).withRel("authors"));
    }
}
