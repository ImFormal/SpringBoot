package com.adrar.bibliotheque.controller;

import com.adrar.bibliotheque.dto.LivreDTO;
import com.adrar.bibliotheque.exception.LivreNotFoundException;
import com.adrar.bibliotheque.exception.NoLivreFoundException;
import com.adrar.bibliotheque.exception.UpdateNotFoundException;
import com.adrar.bibliotheque.model.Livre;
import com.adrar.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping("/livres")
    public Iterable<Livre> getAllLivres() {
        if(livreService.countLivre() == 0) {
            throw new NoLivreFoundException();
        }
        return livreService.findAllLivres();
    }

    @GetMapping("/livre/{id}")
    public Livre getLivreById(@PathVariable Integer id) {
        return livreService.findLivreById(id).orElseThrow(()-> new LivreNotFoundException(id));
    }

    @PostMapping("livre")
    @ResponseStatus(HttpStatus.CREATED)
    public Livre addLivre(@RequestBody Livre livre) {
        return livreService.addLivre(livre);
    }

    @PutMapping("livre/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Livre updateLivre(@PathVariable int id, @RequestBody Livre livre) {
        return livreService.updateLivre(id, livre).orElseThrow(UpdateNotFoundException::new);
    }

    @DeleteMapping("livre/{id}")
    public ResponseEntity<String> deleteLivre(@PathVariable int id) {
        if(livreService.findLivreById(id).isPresent()) {
            livreService.deleteLivre(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Livre supprimé !");
        }
        throw new LivreNotFoundException(id);
    }

    @GetMapping("/test")
    public String testadd() {
        if(livreService.test()){
            return "not exist";
        }
        else
            return "exist";
    }


    @GetMapping("/livresdto")
    public Iterable<LivreDTO> getAllLivresDTO() {
        return livreService.getAllLivresDTO();
    }

    @GetMapping("/livredto/{id}")
    public Stream<LivreDTO> getLivreByIdDTO(@PathVariable Integer id) {
        return livreService.getLivreDTOById(id);
    }
}