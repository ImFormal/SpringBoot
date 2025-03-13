package com.adrar.hello.controller;

import com.adrar.hello.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LivreController {

    @Autowired
    private LivreService livreService;

    //Methode
    public void router(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ?\n(1) Ajouter un livre\n(2) Supprimer un livre\n(3) Retirer un livre\n(0) Ne rien faire\n");
        int choice = scanner.nextInt();
        while(choice != 0){
            switch (choice) {
                case 1:
                    livreService.add();
                    break;
                case 2:
                    livreService.remove();
                    break;
                case 3:
                    livreService.findAll();
                    break;
                default:
                    break;
            }

            System.out.println("\nQue voulez-vous faire ?\n(1) Ajouter un livre\n(2) Supprimer un livre\n(3) Voir la collection\n(0) Ne rien faire\n");
            choice = scanner.nextInt();
        }
    }
}