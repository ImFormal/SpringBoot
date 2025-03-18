package com.adrar.bibliotheque.controller;

import com.adrar.bibliotheque.model.Produit;
import com.adrar.bibliotheque.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private ProduitService produitService;

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

    @GetMapping("/produit")
    public String produit(Model model) {
        Produit produit = new Produit("Livre", "Livre de 50 pages", 14.99);
        model.addAttribute("produit", produit);
        return "produit";
    }

    @GetMapping("/produit/{id}")
    public String produitById(@PathVariable Integer id, Model model) {
        Optional<Produit> produit = produitService.getProduitById(id);
        model.addAttribute("produit", produit.get());
        return "produit";
    }
}

