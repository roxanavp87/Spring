package com.codeup.controller;

import com.codeup.models.User;
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
public class AuthenticationController {
    @GetMapping("/users/login")
    public String showLoginForm() {
        return "users/login";
    }



}
