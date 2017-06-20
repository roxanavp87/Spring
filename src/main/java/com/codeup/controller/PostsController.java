package com.codeup.controller;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roxana on 6/19/17.
 */
@Controller
public class PostsController {
    private PostSvc postSvc;

    @Autowired
    public PostsController(PostSvc postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String all(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("first post", "some content"));
        posts.add(new Post("second post", "some content"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewAPosts(@PathVariable long id, Model model) {
        Post post = new Post("first post", "some content");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String ShowPostForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@RequestParam("title") String title, @RequestParam("body") String body, Model model) {
        Post post = new Post(title, body);
        model.addAttribute("post", post);
        return  "posts/show";
    }
}
