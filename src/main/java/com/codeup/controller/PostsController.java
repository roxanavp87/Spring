package com.codeup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/posts/{id}")
    public String ViewAPosts(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        return "posts";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String ShowPostForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return  "create a new post";
    }
}
