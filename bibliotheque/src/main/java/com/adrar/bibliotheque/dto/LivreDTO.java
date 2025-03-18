package com.adrar.bibliotheque.dto;

import java.sql.Date;
import java.util.List;

public record LivreDTO(
        int id,
        String titre,
        String auteur,
        Date datePublication,
        String user,
        String libele,
        List<String> genres
){}