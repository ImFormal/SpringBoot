package com.adrar.bibliotheque.exception;

public class AddMaisonEditionAlreadyExistsException extends RuntimeException {
    public AddMaisonEditionAlreadyExistsException() {
        super("La maison d'édition que vous souhaitez rajouter existe déjà");
    }
}
