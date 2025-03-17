package com.adrar.bibliotheque.service;

import com.adrar.bibliotheque.model.Genre;
import com.adrar.bibliotheque.model.MaisonEdition;
import com.adrar.bibliotheque.repository.GenreRepository;
import com.adrar.bibliotheque.repository.MaisonEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    //Récupére tous les comptes utilisateurs
    public Iterable<Genre> findAllGenre() {
        if(genreRepository.count() == 0) {
            return null;
        }
        return genreRepository.findAll();
    }

    //récupére un compte utilisateur par son id
    public Optional<Genre> findGenreById(Integer id) {
        return Optional.of(genreRepository.findById(id).orElse(new Genre()));
    }
}