package com.adrar.hello.service;

import com.adrar.hello.model.Livre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class LivreService {

    //Attribut
    private List<Livre> livres;

    //Constructeur
    public LivreService() {
        this.livres = new ArrayList<>();
    }

    //Getter et Setter
    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public void add(){
        System.out.println("Entrez le nom du livre : ");
        Scanner scanner = new Scanner(System.in);
        String nom = scanner.nextLine();
        System.out.println("Entrez la description du livre : ");
        String description = scanner.nextLine();
        System.out.println("Entrez la date de publication du livre : ");
        String date = scanner.nextLine();
        System.out.println("Entrez le genre du livre : ");
        String genre = scanner.nextLine();
        Livre livre = new Livre(nom, description, date, genre);
        livres.add(livre);
        System.out.println("Livre " + nom + " ajouté !");
    }

    public void remove(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du livre a supprimer : ");
        String titre = scanner.nextLine();

        for(Livre livre : livres){
            if(livre.getTitle().equals(titre)){
                livres.remove(livre);
                System.out.println("Livre " + titre + " supprimé !");
                return;
            }
        }
        System.out.println("Le livre n'existe pas !");
    }

    public void findAll(){

        if(livres != null && !livres.isEmpty()){
            for(Livre livre : livres){
                System.out.println(getLivre(livre));
            }
        }
        else{
            System.out.println("La collection ne possède pas de livres ou n'existe pas !");
        }
    }

    public Livre getLivre(Livre livre){
        return livre;
    }
}