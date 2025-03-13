package com.adrar.bibliotheque.controller;

import com.adrar.bibliotheque.model.Livre;
import com.adrar.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping("/livres")
    public Iterable<Livre> getAllLivres() {
        return livreService.findAllLivres();
    }

    @GetMapping("/livre/{id}")
    public Optional<Livre> getLivreById(@PathVariable Integer id) {
        return livreService.findLivreById(id);
    }

    @PostMapping("livre/add")
    public void addLivre(@RequestBody Livre livre) {
        livreService.addLivre(livre);
    }

    @PutMapping("livre/update/{id}")
    public void updateLivre(@PathVariable int id, @RequestBody Livre livre) {
        livreService.updateLivre(id, livre);
    }

    @DeleteMapping("livre/delete/{id}")
    public void deleteLivre(@PathVariable int id) {
        livreService.deleteLivre(id);
    }
}