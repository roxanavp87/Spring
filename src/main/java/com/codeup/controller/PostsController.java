package com.codeup.controller;

import com.codeup.models.Post;
import com.codeup.models.PostImg;
import com.codeup.models.User;
import com.codeup.svcs.PostImgSvc;
import com.codeup.svcs.PostSvc;
import com.codeup.svcs.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by roxana on 6/19/17.
 */
@Controller
public class PostsController {
    private final PostSvc postSvc;
    private final UserSvc userSvc;
    private final PostImgSvc postImgSvc;

    @Autowired
    public PostsController(PostSvc postSvc, UserSvc userSvc, PostImgSvc postImgSvc) {
        this.postSvc = postSvc;
        this.userSvc = userSvc;
        this.postImgSvc = postImgSvc;
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

        //Testing
//        for(int i=0; i<2;i++) {
//            String url = post.getImages().get(0).getUrl();
//        }

        return "posts/show";
    }

    @GetMapping("/posts/edit")
    public String editPost(@RequestParam("post_id") long post_id, Model model) {
        Post post = postSvc.findById(post_id);
        String email = post.getOwner().getEmail();
        model.addAttribute("post", post);
        model.addAttribute("post_id", post_id);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String updatePost(@ModelAttribute Post post) {
        String email = post.getOwner().getEmail();
        postSvc.update(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String ShowPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@ModelAttribute Post post) {
         User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         post.setOwner(user);
         postSvc.save(post);
         return "redirect:/posts";
    }

    @GetMapping("/posts/delete")
    public String deletePost(@RequestParam("post_id") long post_id) {
         Post post = postSvc.findById(post_id);
         postSvc.delete(post);
         return "redirect:/posts";
    }
}
