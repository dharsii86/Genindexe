-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 12 Mai 2016 à 15:02
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `genindexe`
--
CREATE DATABASE IF NOT EXISTS `genindexe` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `genindexe`;

-- --------------------------------------------------------

--
-- Structure de la table `analysis`
--

DROP TABLE IF EXISTS `analysis`;
CREATE TABLE IF NOT EXISTS `analysis` (
  `Analysis_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Analysis_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `analysis`
--

INSERT INTO `analysis` (`Analysis_Name`) VALUES
('Scrapie'),
('Sexing');

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `Category_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Category_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `category`
--

INSERT INTO `category` (`Category_Name`) VALUES
('Bird'),
('Cattle'),
('Felines'),
('Reptiles');

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Customer_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_Name` varchar(45) NOT NULL,
  `Customer_Town` varchar(45) NOT NULL,
  PRIMARY KEY (`Customer_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `customer`
--

INSERT INTO `customer` (`Customer_Id`, `Customer_Name`, `Customer_Town`) VALUES
(2, 'GPhy', 'Poitiers'),
(3, 'SNCF', 'France'),
(4, 'SNCF', 'Poitiers'),
(5, 'SNCF', 'Poitiers');

-- --------------------------------------------------------

--
-- Structure de la table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `Order_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Order_Status` varchar(45) NOT NULL,
  `Analysis_Name` varchar(45) NOT NULL,
  `Customer_Id` int(11) NOT NULL,
  PRIMARY KEY (`Order_Id`),
  KEY `fk_order_analysis_idx` (`Analysis_Name`),
  KEY `fk_order_customer_idx` (`Customer_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `relevant`
--

DROP TABLE IF EXISTS `relevant`;
CREATE TABLE IF NOT EXISTS `relevant` (
  `Specie_Name` varchar(45) NOT NULL,
  `Analysis_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Specie_Name`,`Analysis_Name`),
  KEY `fk_relevant_analysis_idx` (`Analysis_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `relevant`
--

INSERT INTO `relevant` (`Specie_Name`, `Analysis_Name`) VALUES
('Panthera tigris sumatrae', 'Scrapie'),
('Lynx lynx lynx', 'Sexing'),
('Panthera tigris sumatrae', 'Sexing');

-- --------------------------------------------------------

--
-- Structure de la table `sample`
--

DROP TABLE IF EXISTS `sample`;
CREATE TABLE IF NOT EXISTS `sample` (
  `Sample_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Specie_Name` varchar(45) NOT NULL,
  `Order_Id` int(11) NOT NULL,
  PRIMARY KEY (`Sample_Id`),
  KEY `fk_sample_specie_idx` (`Specie_Name`),
  KEY `fk_sample_order_idx` (`Order_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `specie`
--

DROP TABLE IF EXISTS `specie`;
CREATE TABLE IF NOT EXISTS `specie` (
  `Specie_Name` varchar(45) NOT NULL,
  `Category_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Specie_Name`),
  KEY `fk_specie_category_idx` (`Category_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `specie`
--

INSERT INTO `specie` (`Specie_Name`, `Category_Name`) VALUES
('Felis silvestris silvestris', 'felines'),
('Lynx lynx lynx', 'felines'),
('Panthera tigris altaica', 'felines'),
('Panthera tigris sumatrae', 'felines'),
('Archaeolacerta bedriagae', 'reptiles'),
('Coronella austriaca Laurenti', 'reptilEs');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_order_analysis` FOREIGN KEY (`Analysis_Name`) REFERENCES `analysis` (`Analysis_Name`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_order_customer` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Customer_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `relevant`
--
ALTER TABLE `relevant`
  ADD CONSTRAINT `fk_relevant_analysis` FOREIGN KEY (`Analysis_Name`) REFERENCES `analysis` (`Analysis_Name`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_relevant_specie` FOREIGN KEY (`Specie_Name`) REFERENCES `specie` (`Specie_Name`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `sample`
--
ALTER TABLE `sample`
  ADD CONSTRAINT `fk_sample_order` FOREIGN KEY (`Order_Id`) REFERENCES `order` (`Order_Id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_sample_specie` FOREIGN KEY (`Specie_Name`) REFERENCES `specie` (`Specie_Name`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `specie`
--
ALTER TABLE `specie`
  ADD CONSTRAINT `fk_specie_category` FOREIGN KEY (`Category_Name`) REFERENCES `category` (`Category_Name`) ON UPDATE CASCADE;
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
