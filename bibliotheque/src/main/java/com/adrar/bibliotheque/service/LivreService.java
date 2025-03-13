package com.adrar.bibliotheque.service;

import com.adrar.bibliotheque.model.Livre;
import com.adrar.bibliotheque.repository.LivreRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    //Récupère tous les livres
    public Iterable<Livre> findAllLivres() {
        if(livreRepository.count() == 0) {
            return null;
        }
        return livreRepository.findAll();
    }

    //Récupère un livre par son id
    public Optional<Livre> findLivreById(Integer id) {
        return Optional.of(livreRepository.findById(id).orElse(new Livre()));
    }

    //Ajoute un livre
    public void addLivre(Livre livre) {
        livreRepository.save(livre);
    }

    //Update un livre
    public void updateLivre(Integer id, Livre livre) {

        if(livreRepository.findById(id).isPresent()) {
            Livre livreToUpdate = livreRepository.findById(id).get();

            livreToUpdate.setTitre(livre.getTitre());
            livreToUpdate.setDescription(livre.getDescription());
            livreToUpdate.setDate_publication(livre.getDate_publication());

            livreRepository.save(livreToUpdate);
        }
    }

    //Supprime un livre
    public void deleteLivre(Integer id) {
        if(livreRepository.findById(id).isPresent()){
            livreRepository.deleteById(id);
        }
    }
}