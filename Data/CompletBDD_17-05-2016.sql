-- MySQL Script generated by MySQL Workbench
-- 05/16/16 12:22:05
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema genindexe
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `genindexe` ;

-- -----------------------------------------------------
-- Schema genindexe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `genindexe` DEFAULT CHARACTER SET utf8 ;
USE `genindexe` ;

-- -----------------------------------------------------
-- Table `genindexe`.`analysis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`analysis` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`analysis` (
  `Analysis_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Analysis_Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`customer` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`customer` (
  `Customer_Login` VARCHAR(45) NOT NULL,
  `Customer_Name` VARCHAR(45) NOT NULL,
  `Customer_Town` VARCHAR(45) NOT NULL,
  `Customer_Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Customer_Login`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`order` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`order` (
  `Order_Id` INT NOT NULL AUTO_INCREMENT,
  `Order_Status` VARCHAR(45) NOT NULL,
  `Analysis_Name` VARCHAR(45) NOT NULL,
  `Customer_Login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Order_Id`),
  INDEX `fk_order_analysis_idx` (`Analysis_Name` ASC),
  INDEX `fk_order_customer_login_idx` (`Customer_Login` ASC),
  CONSTRAINT `fk_order_analysis`
    FOREIGN KEY (`Analysis_Name`)
    REFERENCES `genindexe`.`analysis` (`Analysis_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_customer_login`
    FOREIGN KEY (`Customer_Login`)
    REFERENCES `genindexe`.`customer` (`Customer_Login`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`category` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`category` (
  `Category_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Category_Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`specie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`specie` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`specie` (
  `Specie_Name` VARCHAR(45) NOT NULL,
  `Category_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Specie_Name`),
  INDEX `fk_specie_category_idx` (`Category_Name` ASC),
  CONSTRAINT `fk_specie_category`
    FOREIGN KEY (`Category_Name`)
    REFERENCES `genindexe`.`category` (`Category_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `genindexe`.`sample`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`sample` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`sample` (
  `Sample_Id` INT NOT NULL AUTO_INCREMENT,
  `Specie_Name` VARCHAR(45) NOT NULL,
  `Order_Id` INT NOT NULL,
  `Result1` int ,
  `Result2` int ,
  `Result3` int ,
  PRIMARY KEY (`Sample_Id`),
  INDEX `fk_sample_specie_idx` (`Specie_Name` ASC),
  INDEX `fk_sample_order_idx` (`Order_Id` ASC),
  INDEX `fk_sample_result1_idx` (`result1` ASC),
  INDEX `fk_sample_result2_idx` (`result2` ASC),
  INDEX `fk_sample_result3_idx` (`result3` ASC),
  CONSTRAINT `fk_sample_specie`
    FOREIGN KEY (`Specie_Name`)
    REFERENCES `genindexe`.`specie` (`Specie_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_sample_order`
    FOREIGN KEY (`Order_Id`)
    REFERENCES `genindexe`.`order` (`Order_Id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_sample_result1`
    FOREIGN KEY (`result1`)
    REFERENCES `genindexe`.`result` (`Result_Id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_sample_result2`
    FOREIGN KEY (`result2`)
    REFERENCES `genindexe`.`result` (`Result_Id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_sample_result3`
    FOREIGN KEY (`result3`)
    REFERENCES `genindexe`.`result` (`Result_Id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`sample`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`result` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`result` (
  `Result_Id` INT NOT NULL AUTO_INCREMENT,
  `RD_pos1` INT NOT NULL default 0,
  `RD_val1` INT NOT NULL default 0,
  `RD_pos2` INT NULL default 0,
  `RD_val2` INT NULL default 0,
  `Result_interpretation` VARCHAR(150),
  `FirstRead` BOOLEAN not null,
  `SecondRead` BOOLEAN not null,
  `Status` Varchar(45) not null,
  PRIMARY KEY (`Result_Id`)
  )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `genindexe`.`relevant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`relevant` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`relevant` (
  `Specie_Name` VARCHAR(45) NOT NULL,
  `Analysis_Name` VARCHAR(45) NOT NULL,
  `Val1` INT default 340,
  `Val2` INT default 55,
  `Val3` INT default 356,
  `Val4` INT default 34,
  PRIMARY KEY (`Specie_Name`, `Analysis_Name`),
  INDEX `fk_relevant_analysis_idx` (`Analysis_Name` ASC),
  CONSTRAINT `fk_relevant_specie`
    FOREIGN KEY (`Specie_Name`)
    REFERENCES `genindexe`.`specie` (`Specie_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_relevant_analysis`
    FOREIGN KEY (`Analysis_Name`)
    REFERENCES `genindexe`.`analysis` (`Analysis_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`status` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`status` (
  `Status_Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Status_Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`user` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`user` (
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
    REFERENCES `genindexe`.`status` (`Status_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`modifySpecie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`modifySpecie` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`modifySpecie` (
  `Specie_Name` VARCHAR(45) NOT NULL,
  `User_Login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Specie_Name`, `User_Login`),
  INDEX `fk_modifyspecie_user_idx` (`User_Login` ASC),
  CONSTRAINT `fk_modifyspecie_specie`
    FOREIGN KEY (`Specie_Name`)
    REFERENCES `genindexe`.`specie` (`Specie_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_modifyspecie_user`
    FOREIGN KEY (`User_Login`)
    REFERENCES `genindexe`.`user` (`User_Login`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`modifyCategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`modifyCategory` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`modifyCategory` (
  `Category_Name` VARCHAR(45) NOT NULL,
  `User_Login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Category_Name`, `User_Login`),
  INDEX `fk_modifyspecie_user_idx` (`User_Login` ASC),
  CONSTRAINT `fk_modifycategory_category`
    FOREIGN KEY (`Category_Name`)
    REFERENCES `genindexe`.`category` (`Category_Name`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_modifycategory_user`
    FOREIGN KEY (`User_Login`)
    REFERENCES `genindexe`.`user` (`User_Login`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genindexe`.`modifyOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genindexe`.`modifyOrder` ;

CREATE TABLE IF NOT EXISTS `genindexe`.`modifyOrder` (
  `Order_Id` INT NOT NULL,
  `User_Login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Order_Id`, `User_Login`),
  INDEX `fk_modifyspecie_user_idx` (`User_Login` ASC),
  CONSTRAINT `fk_modifyorder_order`
    FOREIGN KEY (`Order_Id`)
    REFERENCES `genindexe`.`order` (`Order_Id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_modifyorder_user`
    FOREIGN KEY (`User_Login`)
    REFERENCES `genindexe`.`user` (`User_Login`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SET FOREIGN_KEY_CHECKS=0;
INSERT INTO `analysis` (`Analysis_Name`) VALUES
('Scrapie'),
('Sexing');


INSERT INTO `category` (`Category_Name`) VALUES
('Bird'),
('Cattle'),
('Felines'),
('Reptiles');


INSERT INTO `customer` (`Customer_Login`, `Customer_Name`, `Customer_Town`,`Customer_Password`) VALUES
('GPhyPoitiers', 'GPhy', 'Poitiers','qb045Cu'),
('SNCFFrance', 'SNCF', 'France','nv050Cu'),
('SNCFPoitiers', 'SNCF', 'Poitiers','jg067Cu'),
('SNCFLaRochelle', 'SNCF', 'LaRochelle','wa053Cu');


INSERT INTO `relevant` (`Specie_Name`, `Analysis_Name`) VALUES
('Panthera tigris sumatrae', 'Scrapie'),
('Lynx lynx lynx', 'Sexing'),
('Panthera tigris sumatrae', 'Sexing');


INSERT INTO `specie` (`Specie_Name`, `Category_Name`) VALUES
('Felis silvestris silvestris', 'felines'),
('Lynx lynx lynx', 'felines'),
('Panthera tigris altaica', 'felines'),
('Panthera tigris sumatrae', 'felines'),
('Archaeolacerta bedriagae', 'reptiles'),
('Coronella austriaca Laurenti', 'reptiles');


INSERT INTO `status` (`Status_Name`) VALUES
('Secretary'),
('Technician'),
('Validator'),
('Customer');


INSERT INTO `user` (`User_Login`,`User_Mail`,`User_Name`,`User_LastName`,`User_Password`,`Status_Name`) VALUES
('clrousseau','claire.rousseau@lab.com','Claire','Rousseau','cr051Se','Secretary'),
('thdequipe','thomas.dequipe@lab.com','Thomas','Dequipe','td040Te','Technician'),
('josaulnier','johnny.saulnier@lab.com','Johnny','Saulnier','js065Va','Validator'),
('GPhyPoitiers','quentin.bonenfant@mail.com','Quentin','Bonenfant','qb045Cu','Customer'),
('SNCFPoitiers','Jean-Christophe.greaux@mail.com','Jean-Christophe','Greaux','jg067Cu','Customer'),
('SNCFLaRochelle','aye.assohoun@mail.com','Will','Assohoun','wa053Cu','Customer'),
('SNCFFrance','nicolas.villeriot@mail.com','Nicolas','Villeriot','nv050Cu','Customer'),
('s','test.mail@lab.com','FirstName','LastName','s','Secretary'),
('t','test.mail@lab.com','FirstName','LastName','t','Technician'),
('v','test.mail@lab.com','FirstName','LastName','v','Validator');

insert into `order` (`Order_Status`, `Analysis_Name`, `Customer_Login`) values 
('completed','Sexing', 'SNCFPoitiers'),
('completed','Scrapie', 'SNCFLaRochelle'),
('inAnalysis','Sexing', 'SNCFPoitiers'),
('toAnalyze','Scrapie', 'SNCFFRance');

insert into `sample` (`Specie_Name`, `Order_ID`,`Result1`,`Result2`) values 
('Lynx lynx lynx','1','1',NULL),
('Lynx lynx lynx','1','2',NULL),
('Lynx lynx lynx','1','3',NULL),
('Lynx lynx lynx','1','4','9'),
('Panthera tigris sumatrae','2','5',NULL),
('Panthera tigris sumatrae','2','6',NULL),
('Panthera tigris sumatrae','2','7',NULL),
('Lynx lynx lynx','3','8',NULL),
('Lynx lynx lynx','3',NULL,NULL),
('Lynx lynx lynx','3',NULL,NULL),
('Lynx lynx lynx','3',NULL,NULL),
('Lynx lynx lynx','3',NULL,NULL),
('Panthera tigris sumatrae','4',NULL,NULL),
('Panthera tigris sumatrae','4',NULL,NULL),
('Panthera tigris sumatrae','4',NULL,NULL);

INSERT INTO `result`(`RD_pos1`, `RD_val1`, `RD_pos2`, `RD_val2`, `Result_interpretation`, `FirstRead`, `SecondRead`, `Status`) VALUES 
('100','45','','','Good','true','true','VALIDATED'),
('100','47','','','Good','true','true','VALIDATED'),
('100','39','','','Pretty good','true','true','VALIDATED'),
('100','68','','','bad','true','false','UNREADABLE'),
('120','47','120','50','Good','true','true','VALIDATED'),
('120','47','120','50','Good','true','true','VALIDATED'),
('120','47','120','50','Good','true','true','VALIDATED'),
('130','42','','','Good','true','true','VALIDATED'),
('100','39','','','Pretty good','true','true','VALIDATED');





SET FOREIGN_KEY_CHECKS=1;
