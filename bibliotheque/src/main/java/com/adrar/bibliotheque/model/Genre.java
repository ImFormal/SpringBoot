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
@Table(name = "genre")
public class Genre {

    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    @NotBlank(message = "le nom doit être renseigné")
    @Size(min = 3, message = "Le nom doit posséder au moins 3 caractères")
    private String name;


    //Constructeur
    public Genre() {}

    public Genre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}