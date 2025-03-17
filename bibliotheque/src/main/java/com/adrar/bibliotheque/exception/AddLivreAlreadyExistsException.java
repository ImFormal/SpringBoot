package com.adrar.bibliotheque.exception;

public class AddLivreAlreadyExistsException extends RuntimeException {
    public AddLivreAlreadyExistsException() {
        super("Le livre que vous souhaitez rajouter existe déjà");
    }
}
