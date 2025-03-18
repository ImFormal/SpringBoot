package com.adrar.bibliotheque.controller;

import com.adrar.bibliotheque.model.Genre;
import com.adrar.bibliotheque.model.Livre;
import com.adrar.bibliotheque.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genre")
    public Iterable<Genre> getAllGenres() {
        return genreService.findAllGenre();
    }

    @GetMapping("/genre/{id}")
    public Optional<Genre> getGenreById(@PathVariable Integer id) {
        return genreService.findGenreById(id);
    }

    @PostMapping("/genre")
    @ResponseStatus(HttpStatus.CREATED)
    public Genre addGenre(@RequestBody @Valid Genre genre) {

        return genreService.addGenre(genre);
    }
}