package com.mbooking.controller;

import com.mbooking.model.Author;
import com.mbooking.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    @GetMapping("/author/{id}")
    public Author author(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> authors() {
        return  authorService.findAll();
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
