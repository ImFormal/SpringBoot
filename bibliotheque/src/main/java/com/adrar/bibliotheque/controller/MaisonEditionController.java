package com.adrar.bibliotheque.controller;

import com.adrar.bibliotheque.model.MaisonEdition;
import com.adrar.bibliotheque.service.MaisonEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MaisonEditionController {

    @Autowired
    private MaisonEditionService maisonEditionService;

    @GetMapping("/maisonedition")
    public Iterable<MaisonEdition> getAllMaisonEdition() {
        return maisonEditionService.findAllMaisonEdition();
    }

    @GetMapping("/maisonedition/{id}")
    public Optional<MaisonEdition> getMaisonEditionById(@PathVariable Integer id) {
        return maisonEditionService.findMaisonEditionById(id);
    }
}

