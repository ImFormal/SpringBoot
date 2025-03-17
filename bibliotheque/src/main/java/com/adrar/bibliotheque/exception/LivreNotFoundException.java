package com.adrar.bibliotheque.exception;

public class LivreNotFoundException extends RuntimeException {
    public LivreNotFoundException(Integer id) {
        super("Le livre avec id : " + id + " n'existe pas");
    }
}