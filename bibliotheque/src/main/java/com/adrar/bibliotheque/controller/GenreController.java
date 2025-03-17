package com.adrar.bibliotheque.controller;

import com.adrar.bibliotheque.model.Genre;
import com.adrar.bibliotheque.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}