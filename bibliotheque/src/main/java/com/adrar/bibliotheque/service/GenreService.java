package com.adrar.bibliotheque.service;

import com.adrar.bibliotheque.exception.AddGenreAlreadyExistsException;
import com.adrar.bibliotheque.exception.AddMaisonEditionAlreadyExistsException;
import com.adrar.bibliotheque.model.Genre;
import com.adrar.bibliotheque.model.MaisonEdition;
import com.adrar.bibliotheque.repository.GenreRepository;
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

    public Genre addGenre(Genre genre) {
        if(genreRepository.findByName(genre.getName())){
            throw new AddGenreAlreadyExistsException();
        }
        return genreRepository.save(genre);
    }
}