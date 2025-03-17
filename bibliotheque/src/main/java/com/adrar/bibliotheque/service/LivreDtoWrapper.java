package com.adrar.bibliotheque.service;
import com.adrar.bibliotheque.dto.LivreDTO;
import com.adrar.bibliotheque.model.Livre;
import org.springframework.stereotype.Service;

@Service
public class LivreDtoWrapper {
    public static LivreDTO toDto(Livre livre) {
        return new LivreDTO(livre.getId(), livre.getTitre(), livre.getAuteur(), livre.getDatePublication(), livre.getUser().getEmail(), livre.getMaisonEdition().getLibele(), livre.getGenres());
    }
}