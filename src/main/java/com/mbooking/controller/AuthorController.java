package com.mbooking.controller;

import com.mbooking.model.Author;
import com.mbooking.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author/{id}")
    public Author author(@PathVariable Long id) {
        return authorService.findById(id);
    }
}
