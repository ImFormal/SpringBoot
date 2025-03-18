package com.adrar.bibliotheque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "livre")
public class Livre {

    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titre", nullable = false, unique = true, length = 50)
    @NotBlank(message = "le titre doit être renseigné")
    @Size(min = 3, message = "Le titre doit posséder au moins 3 caractères")
    private String titre;

    @Column(name = "description", nullable = false, length = 255)
    @NotBlank(message = "la description doit être renseignée")
    @Size(min = 5, message = "Le Nom doit posséder au moins 5 caractères")
    private String description;

    @Column(name = "datePublication", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePublication;

    @Column(name = "auteur", length = 50)
    @NotBlank(message = "l'auteur doit être renseigné")
    private String auteur;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private User user;

    @ManyToOne
    @JoinColumn(name = "maison_edition_id")
    private MaisonEdition maisonEdition;

    @ManyToMany
    @JoinTable(
            name = "livre_genre",
            joinColumns = @JoinColumn(name = "livre_id"),
            inverseJoinColumns = @JoinColumn(name = "genres_id")
    )
    private List<Genre> genres;

    //Constructeur
    public Livre() {}

    public Livre(String titre, String description, Date datePublication) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
    }

    public Livre(String titre, String description, Date datePublication, List<Genre> genres, String auteur, User user, MaisonEdition maisonEdition) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.genres = genres;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", auteur='" + auteur + '\'' +
                ", user=" + user +
                ", maisonEdition=" + maisonEdition +
                ", genres=" + genres +
                '}';
    }
}


//Livre : date min 1800 et max 2025,
