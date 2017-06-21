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
    private final PostSvc postSvc;

    @Autowired
    public PostsController(PostSvc postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String all(Model model) {
        List<Post> posts = postSvc.all();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/show")
    public String viewAPosts(@RequestParam("post_id") long post_id, Model model) {
        Post post = postSvc.findById(post_id);
        model.addAttribute("post", post);
        return "posts/show";
    }

//    @GetMapping("/posts/create")
//    public String ShowPostForm() {
//        return "posts/create";
//    }

//    @PostMapping("/posts/create")
//    public String savePost(@RequestParam("title") String title, @RequestParam("body") String body, Model model) {
//        postSvc.createPost(title, body);
//        return "redirect:/posts";
//    }

    @GetMapping("/posts/create")
    public String ShowPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@ModelAttribute Post post) {
        postSvc.createPost(post.getTitle(), post.getBody());
        return "redirect:/posts";
    }
}
