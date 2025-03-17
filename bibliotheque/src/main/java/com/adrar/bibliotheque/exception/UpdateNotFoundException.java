package com.adrar.bibliotheque.exception;

public class UpdateNotFoundException extends RuntimeException {
    public UpdateNotFoundException() {
        super("Le livre que vous voulez modifier n'existe pas");
    }
}