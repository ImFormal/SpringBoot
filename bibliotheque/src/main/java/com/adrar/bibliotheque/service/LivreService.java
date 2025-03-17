package com.adrar.bibliotheque.service;

import com.adrar.bibliotheque.dto.LivreDTO;
import com.adrar.bibliotheque.exception.AddLivreAlreadyExistsException;
import com.adrar.bibliotheque.exception.LivreNotFoundException;
import com.adrar.bibliotheque.exception.UpdateNotFoundException;
import com.adrar.bibliotheque.model.Livre;
import com.adrar.bibliotheque.repository.LivreRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Data
@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    //Méthode qui retourne tous les objets Livre
    public Iterable<Livre> findAllLivres(){
        return livreRepository.findAll();
    }

    public Long countLivre() {
        return livreRepository.count();
    }

    //Méthode qui retourne un Livre par son id
    public Optional<Livre> findLivreById(int id){
        return livreRepository.findById(id);
    }
    //Méthode qui ajoute un Livre
    public Livre addLivre(Livre livre){
        if(!livreRepository.findByTitreAndDescription(livre.getTitre(), livre.getDescription()).isEmpty()){
            throw new AddLivreAlreadyExistsException();
        }
        return livreRepository.save(livre);
    }

    public boolean test(){

        Livre livre = new Livre();
        livre.setTitre("Test");
        livre.setDescription("Test");
        livre.setDatePublication(Date.valueOf("2024-10-10"));
        if(livreRepository.findByTitreAndDescription(livre.getTitre(), livre.getDescription()).isEmpty()){
            return true;
        }
        else
            return false;
    }

    //Méthode qui supprime un Livre par son id
    public boolean deleteLivre(int id) {
        if(!livreRepository.existsById(id)) {
            return false;
        }
        livreRepository.deleteById(id);
        return true;
    }

    //Méthode qui met à jour un Livre
    public Optional<Livre> updateLivre(int id, Livre livre){
        if(!livreRepository.existsById(id)) {
            throw new UpdateNotFoundException();
        }
        livre.setId(id);
        return Optional.of(livreRepository.save(livre));
    }

    //Méthode qui retourne la liste des livres au format LivreDTO
    public Iterable<LivreDTO> getAllLivresDTO(){
        List<LivreDTO> livresDTO = new ArrayList<>();

        for(Livre livre : livreRepository.findAll()){
            livresDTO.add(LivreDtoWrapper.toDto(livre));
        }
        return livresDTO;
    }

    //Méthode qui retourne un livre par son id au format LivreDTO
    public Stream<LivreDTO> getLivreDTOById(int id){
        return livreRepository.findById(id).stream().map(LivreDtoWrapper::toDto);
    }
}