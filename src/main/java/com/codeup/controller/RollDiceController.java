package com.codeup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by roxana on 6/19/17.
 */
@Controller
public class RollDiceController {
    @GetMapping("/rolldice")
    public String RollDiceC() {
        return "rolldice";
    }

    @PostMapping("/rolldice")
    public String create(@RequestParam(name = "guessedNumber") String number, Model model){
        int random = (int) (Math.round(Math.random()*5) + 1);
        if(Integer.parseInt(number) == random) {
            model.addAttribute("youGess", true);
        } else {
            model.addAttribute("youGess", false);
        }
        return "rolldice_view";
    }
}
