package com.adrar.bibliotheque.dto;

import com.adrar.bibliotheque.model.Genre;

import java.sql.Date;
import java.util.List;

public record LivreDTO(
        int id,
        String titre,
        String auteur,
        Date datePublication,
        String user,
        String libele,
        List<Genre> genres
){}