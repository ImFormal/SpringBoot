package com.adrar.bibliotheque.service;
import com.adrar.bibliotheque.dto.LivreDTO;
import com.adrar.bibliotheque.model.Genre;
import com.adrar.bibliotheque.model.Livre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivreDtoWrapper {
    public static LivreDTO toDto(Livre livre) {

        //Création d'une liste vide
        List<String> genres = new ArrayList<>();
        //Ajouter des libele de genre à la liste
        for (Genre genre : livre.getGenres()) {
            genres.add(genre.getName());
        }

        return new LivreDTO(livre.getId(), livre.getTitre(), livre.getAuteur(), livre.getDatePublication(), livre.getUser().getEmail(), livre.getMaisonEdition().getLibele(), genres);
    }
}