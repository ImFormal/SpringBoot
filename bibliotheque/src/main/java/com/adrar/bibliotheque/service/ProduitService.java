package com.adrar.bibliotheque.service;

import com.adrar.bibliotheque.model.Produit;
import com.adrar.bibliotheque.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    //Récupère le produit par son id
    public Optional<Produit> getProduitById(Integer id) {
        return Optional.of(produitRepository.findById(id).orElse(new Produit()));
    }

    //Récupère tous les produits
    public Iterable<Produit> GetProduits() {
        if(produitRepository.count() == 0) {
            return null;
        }
        return produitRepository.findAll();
    }
}



