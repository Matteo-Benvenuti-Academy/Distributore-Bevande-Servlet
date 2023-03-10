DROP DATABASE IF EXISTS distributore_bevande;
CREATE DATABASE distributore_bevande;
USE distributore_bevande;

CREATE TABLE Bevande(
	bevandaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    descrizione VARCHAR(250) NOT NULL,
    gradoAlcolico FLOAT NOT NULL
);


INSERT INTO Bevande(nome, descrizione, gradoAlcolico) VALUES
("Birra", "Bionda", 6.0),
("Amaro montenegro", "Sapore vero", 23.0);

SELECT * FROM Bevande
