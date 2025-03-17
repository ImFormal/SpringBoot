package com.adrar.bibliotheque.repository;

import com.adrar.bibliotheque.model.MaisonEdition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaisonEditionRepository extends CrudRepository<MaisonEdition, Integer> {
}
