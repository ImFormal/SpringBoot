package com.adrar.bibliotheque.exception;

public class AddGenreAlreadyExistsException extends RuntimeException {
    public AddGenreAlreadyExistsException() {
        super("Le genre que vous souhaitez rajouter existe déjà");
    }
}
