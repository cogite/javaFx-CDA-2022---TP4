# javaFx-CDA-2022---tp4
javaFx CDA 2022 - Projet existant


Détails du TP dans TP4.pdf


# Script SQL création bdd :________________________________

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS `cda` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cda`;

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `fil` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

INSERT INTO `etudiant` (`id`, `Nom`, `Prenom`, `fil`) VALUES
(1, 'Themove', 'Martine', 'Littéraire'),
(2, 'Martin', 'Jacques', 'Musique'),
(3, 'Zola', 'Emilie', 'Littéraire'),
(4, 'Beugdanoeuf', 'Gary', 'Scientifique'),
(5, 'Oldman', 'Gary', 'Cinématographique'),
(7, 'Thomas', 'André', 'JavaFX'),
(15, 'b', 'b', 'b');
COMMIT;
