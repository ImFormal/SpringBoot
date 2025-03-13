package com.adrar.hello.model;

public class Livre {

    //Attribut
    private String title;
    private String description;
    private String datePublication;
    private String genre;

    //Constructeur
    public Livre(){}
    public Livre(String title, String description, String datePublication, String genre) {
        this.title = title;
        this.description = description;
        this.datePublication = datePublication;
        this.genre = genre;
    }

    //Getter et Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Livre : " + '\n' +
                "   title : " + title + '\n' +
                "   description : " + description + '\n' +
                "   datePublication : " + datePublication + '\n' +
                "   genre : " + genre;
    }
}