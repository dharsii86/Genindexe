-- MySQL Script generated by MySQL Workbench
-- 05/13/16 14:50:47
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema genindexe
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `genindexe` ;

-- -----------------------------------------------------
-- Table `genindexe`.`Analysis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`Analysis` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`Analysis` (
  `Analysis_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Analysis_Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`Customer` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`Customer` (
  `Customer_Login` VARCHAR(45) NOT NULL,
  `Customer_Name` VARCHAR(45) NOT NULL,
  `Customer_Town` VARCHAR(45) NOT NULL,
  `Customer_Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Customer_Login`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`Order` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`Order` (
  `Order_Id` INT NOT NULL AUTO_INCREMENT,
  `Order_Status` VARCHAR(45) NOT NULL,
  `Analysis_Name` VARCHAR(45) NOT NULL,
  `Customer_Login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Order_Id`),
  INDEX `fk_order_analysis_idx` (`Analysis_Name` ASC),
  INDEX `fk_order_customer_login_idx` (`Customer_Login` ASC),
  CONSTRAINT `fk_order_analysis`
    FOREIGN KEY (`Analysis_Name`)
    REFERENCES `genindexe`.`Analysis` (`Analysis_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_customer_login`
    FOREIGN KEY (`Customer_Login`)
    REFERENCES `genindexe`.`Customer` (`Customer_Login`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`Category` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`Category` (
  `Category_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Category_Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`Specie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`Specie` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`Specie` (
  `Specie_Name` VARCHAR(45) NOT NULL,
  `Category_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Specie_Name`),
  INDEX `fk_specie_category_idx` (`Category_Name` ASC),
  CONSTRAINT `fk_specie_category`
    FOREIGN KEY (`Category_Name`)
    REFERENCES `genindexe`.`Category` (`Category_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `genindexe`.`Status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`Status` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`Status` (
  `Status_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Status_Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`User` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`User` (
  `User_Login` VARCHAR(45) NOT NULL,
  `User_Mail` VARCHAR(45) NOT NULL,
  `User_Name` VARCHAR(45) NOT NULL,
  `User_LastName` VARCHAR(45) NOT NULL,
  `User_Password` VARCHAR(45) NOT NULL,
  `Status_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`User_Login`),
  INDEX `fk_user_status_idx` (`Status_Name` ASC),
  CONSTRAINT `fk_user_status`
    FOREIGN KEY (`Status_Name`)
    REFERENCES `genindexe`.`Status` (`Status_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`ModifySpecie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`ModifySpecie` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`ModifySpecie` (
  `Specie_Name` VARCHAR(45) NOT NULL,
  `User_Login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Specie_Name`, `User_Login`),
  INDEX `fk_modifyspecie_user_idx` (`User_Login` ASC),
  CONSTRAINT `fk_modifyspecie_specie`
    FOREIGN KEY (`Specie_Name`)
    REFERENCES `genindexe`.`Specie` (`Specie_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_modifyspecie_user`
    FOREIGN KEY (`User_Login`)
    REFERENCES `genindexe`.`User` (`User_Login`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`ModifyCategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`ModifyCategory` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`ModifyCategory` (
  `Category_Name` VARCHAR(45) NOT NULL,
  `User_Login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Category_Name`, `User_Login`),
  INDEX `fk_modifyspecie_user_idx` (`User_Login` ASC),
  CONSTRAINT `fk_modifycategory_category`
    FOREIGN KEY (`Category_Name`)
    REFERENCES `genindexe`.`Category` (`Category_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_modifycategory_user`
    FOREIGN KEY (`User_Login`)
    REFERENCES `genindexe`.`User` (`User_Login`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `genindexe`.`Sample`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`Sample` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`Sample` (
  `Sample_Id` INT NOT NULL AUTO_INCREMENT,
  `Specie_Name` VARCHAR(45) NOT NULL,
  `Order_Id` INT NOT NULL,
  PRIMARY KEY (`Sample_Id`),
  INDEX `fk_sample_specie_idx` (`Specie_Name` ASC),
  INDEX `fk_sample_order_idx` (`Order_Id` ASC),
  CONSTRAINT `fk_sample_specie`
    FOREIGN KEY (`Specie_Name`)
    REFERENCES `genindexe`.`Specie` (`Specie_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_sample_order`
    FOREIGN KEY (`Order_Id`)
    REFERENCES `genindexe`.`Order` (`Order_Id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`ModifyOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`ModifyOrder` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`ModifyOrder` (
  `Order_Id` INT NOT NULL,
  `User_Login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Order_Id`, `User_Login`),
  INDEX `fk_modifyspecie_user_idx` (`User_Login` ASC),
  CONSTRAINT `fk_modifyorder_order`
    FOREIGN KEY (`Order_Id`)
    REFERENCES `genindexe`.`Order` (`Order_Id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_modifyorder_user`
    FOREIGN KEY (`User_Login`)
    REFERENCES `genindexe`.`User` (`User_Login`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `genindexe`.`Relevant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`Relevant` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`Relevant` (
  `Specie_Name` VARCHAR(45) NOT NULL,
  `Analysis_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Specie_Name`, `Analysis_Name`),
  INDEX `fk_relevant_analysis_idx` (`Analysis_Name` ASC),
  CONSTRAINT `fk_relevant_specie`
    FOREIGN KEY (`Specie_Name`)
    REFERENCES `genindexe`.`Specie` (`Specie_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_relevant_analysis`
    FOREIGN KEY (`Analysis_Name`)
    REFERENCES `genindexe`.`Analysis` (`Analysis_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
