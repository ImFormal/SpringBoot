package com.adrar.bibliotheque.service;

import com.adrar.bibliotheque.model.MaisonEdition;
import com.adrar.bibliotheque.repository.MaisonEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaisonEditionService {

    @Autowired
    private MaisonEditionRepository maisonEditionRepository;

    //Récupére tous les comptes utilisateurs
    public Iterable<MaisonEdition> findAllMaisonEdition() {
        if(maisonEditionRepository.count() == 0) {
            return null;
        }
        return maisonEditionRepository.findAll();
    }

    //récupére un compte utilisateur par son id
    public Optional<MaisonEdition> findMaisonEditionById(Integer id) {
        return Optional.of(maisonEditionRepository.findById(id).orElse(new MaisonEdition()));
    }

}