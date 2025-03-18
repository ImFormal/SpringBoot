package com.adrar.bibliotheque.controller;

import com.adrar.bibliotheque.exception.AddLivreAlreadyExistsException;
import com.adrar.bibliotheque.exception.LivreNotFoundException;
import com.adrar.bibliotheque.exception.NoLivreFoundException;
import com.adrar.bibliotheque.exception.UpdateNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LivreExceptionController {

    @ExceptionHandler(LivreNotFoundException.class)
    public ResponseEntity<Map<String, String>> livreNotFound(LivreNotFoundException livreNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", livreNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoLivreFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noLivres(NoLivreFoundException noLivreFound) {
        return noLivreFound.getMessage();
    }

    @ExceptionHandler(UpdateNotFoundException.class)
    public ResponseEntity<Map<String, String>> updateLivreNotFound(UpdateNotFoundException updateNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", updateNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(AddLivreAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> saveLivreExists(AddLivreAlreadyExistsException addLivreAlreadyExists) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", addLivreAlreadyExists.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage())
                );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}