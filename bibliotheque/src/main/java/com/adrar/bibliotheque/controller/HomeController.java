package com.adrar.bibliotheque.controller;

import com.adrar.bibliotheque.exception.LivreNotFoundException;
import com.adrar.bibliotheque.model.Livre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("firstname", "Mathieu");
        return "hello";
    }

    @GetMapping("/hello/{firstname}")
    public String helloFirstname(@PathVariable String firstname, Model model) {
        model.addAttribute("firstname", firstname);
        return "hellofirstname";
    }
}