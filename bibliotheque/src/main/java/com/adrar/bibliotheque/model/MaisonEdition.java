package com.adrar.bibliotheque.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

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
    private String libele;

    @Column(name = "description", nullable = false, length = 255)
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