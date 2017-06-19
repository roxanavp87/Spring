package com.codeup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by roxana on 6/19/17.
 */
@Controller
public class PostsController {
    @GetMapping("/posts")
    public String Posts() {
        return "posts";
    }

//    @GetMapping("/posts/{id}")
//    public String ViewAPosts(@PathVariable int id) {
//        return "posts/id";
//    }
}
