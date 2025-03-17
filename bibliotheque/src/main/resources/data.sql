DROP TABLE IF EXISTS utilisateur;
DROP TABLE IF EXISTS livre;
DROP TABLE IF EXISTS maison_edition;

CREATE TABLE livre (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    datePublication DATE NOT NULL,
    genre VARCHAR(50),
    auteur VARCHAR(50),
    id_utilisateur INT,
    maison_edition_id INT
);


CREATE TABLE utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE maison_edition (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libele VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL
);

INSERT INTO utilisateur (firstname, lastname, email, password) VALUES
    ('Mathieu', 'Mithridate', 'mathieumith@test.com', '1234'),
    ('Jean', 'Albert', 'jeanalbert@test.fr', '1234'),
    ('Marie', 'Durand', 'mariedurand@mail.com', '1234');

INSERT INTO livre (titre, description, datePublication, id_utilisateur, maison_edition_id) VALUES
    ('Le Petit Prince', 'Un conte poétique et philosophique', '1943-04-06', 1, 1),
    ('1984', 'Un roman dystopique sur un futur totalitaire', '1949-06-08', 2, 1),
    ('Le Meilleur des mondes', 'Un roman de science-fiction sur une société futuriste', '1932-08-31', 3, 1);

INSERT INTO maison_edition (libele, description) VALUES ('Hachette', 'Maison édition Hachette');

CREATE USER test PASSWORD '1234' ADMIN;