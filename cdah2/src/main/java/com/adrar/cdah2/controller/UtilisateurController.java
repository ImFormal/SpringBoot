package com.adrar.cdah2.controller;

import com.adrar.cdah2.model.Utilisateur;
import com.adrar.cdah2.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/users")
    public Iterable<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.findAllUtilisateurs();
    }

    @GetMapping("/user/{id}")
    public Optional<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.findUtilisateurById(id);
    }
}
