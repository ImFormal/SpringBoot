package com.adrar.bibliotheque.controller;

import com.adrar.bibliotheque.model.Genre;
import com.adrar.bibliotheque.model.MaisonEdition;
import com.adrar.bibliotheque.service.MaisonEditionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/maisonedition")
    @ResponseStatus(HttpStatus.CREATED)
    public MaisonEdition addMaisonEdition(@RequestBody @Valid MaisonEdition maisonEdition) {

        return maisonEditionService.addMaisonEdition(maisonEdition);
    }
}

