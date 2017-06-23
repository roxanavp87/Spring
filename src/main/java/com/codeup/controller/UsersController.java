package com.codeup.controller;

import com.codeup.models.User;
import com.codeup.svcs.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by roxana on 6/23/17.
 */
@Controller
public class UsersController {

    @Autowired
    private UserSvc userSvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/users/register")
    public String saveUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userSvc.save(user);
        return "redirect:/login";
    }
}
