package com.mbooking.controller;

import com.mbooking.model.Author;
import com.mbooking.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody // at class level, no need on author(), authors() methods...
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

}
