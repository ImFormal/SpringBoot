CREATE TABLE IF NOT EXISTS livre (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    titre VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    date_publication DATE
);