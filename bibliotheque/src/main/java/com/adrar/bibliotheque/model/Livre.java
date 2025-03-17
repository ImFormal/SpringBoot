package com.adrar.bibliotheque.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "livre")
public class Livre {

    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titre", nullable = false, unique = true, length = 50)
    private String titre;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "datePublication", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePublication;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "auteur", length = 50)
    private String auteur;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private User user;

    @ManyToOne
    @JoinColumn(name = "maison_edition_id")
    private MaisonEdition maisonEdition;

    //Constructeur
    public Livre() {}

    public Livre(String titre, String description, Date datePublication) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
    }

    public Livre(String titre, String description, Date datePublication, String genre, String auteur, User user, MaisonEdition maisonEdition) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.genre = genre;
        this.auteur = auteur;
        this.user = user;
        this.maisonEdition = maisonEdition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public MaisonEdition getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEdition maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", genre='" + genre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", user='" + user + '\'' +
                ", maisonEdition='" + maisonEdition + '\'' +
                '}';
    }
}