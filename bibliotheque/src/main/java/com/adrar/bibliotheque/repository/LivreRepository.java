package com.adrar.bibliotheque.repository;

import com.adrar.bibliotheque.model.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Integer> {
    List<Livre> findByTitreAndDescription(String titre, String description);
}