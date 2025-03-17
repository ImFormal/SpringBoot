package com.adrar.bibliotheque.repository;

import com.adrar.bibliotheque.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}