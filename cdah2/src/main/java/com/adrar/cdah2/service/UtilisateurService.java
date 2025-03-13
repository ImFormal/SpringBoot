package com.adrar.cdah2.service;

import com.adrar.cdah2.model.Utilisateur;
import com.adrar.cdah2.repository.UtilisateurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    //Récupère tous les comptes utilisateurs
    public Iterable<Utilisateur> findAllUtilisateurs() {
        if(utilisateurRepository.count() == 0) {
            return null;
        }
        return utilisateurRepository.findAll();
    }

    //Récupère un compte utilisateur par son id
    public Optional<Utilisateur> findUtilisateurById(Long id) {
        return Optional.of(utilisateurRepository.findById(id).orElse(new Utilisateur()));
    }
}
