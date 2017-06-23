package com.codeup.controller;

import com.codeup.models.User;
import com.codeup.svcs.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by roxana on 6/23/17.
 */
@Controller
public class UsersController {

    @Autowired
    UserSvc userSvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/users/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/users/register")
    public String saveUser(@RequestParam("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userSvc.save(user);
        return "redirect:/users/login";
    }
}
