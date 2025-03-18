package com.adrar.bibliotheque.repository;

import com.adrar.bibliotheque.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
}