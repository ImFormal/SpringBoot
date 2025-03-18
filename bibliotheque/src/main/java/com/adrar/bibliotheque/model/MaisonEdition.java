package com.adrar.bibliotheque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "maison_edition")
public class MaisonEdition {

    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "libele", nullable = false, length = 50)
    @NotBlank(message = "le libellé doit être renseigné")
    @Size(min = 2, message = "Le libellé doit posséder au moins 2 caractères")
    private String libele;

    @Column(name = "description", nullable = false, length = 255)
    @NotBlank(message = "la description doit être renseignée")
    @Size(min = 5, message = "La description doit posséder au moins 5 caractères")
    private String description;

    //Constructeur
    public MaisonEdition() {}

    public MaisonEdition(String libele, String description) {
        this.libele = libele;
        this.description = description;
    }

    @Override
    public String toString() {
        return "MaisonEdition{" +
                "id=" + id +
                ", libele='" + libele + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}