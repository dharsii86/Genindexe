SET FOREIGN_KEY_CHECKS=0;
INSERT INTO `analysis` (`Analysis_Name`) VALUES
('Scrapie'),
('Sexing');


INSERT INTO `category` (`Category_Name`) VALUES
('Bird'),
('Cattle'),
('Felines'),
('Reptiles');


INSERT INTO `customer` (`Customer_Id`, `Customer_Name`, `Customer_Town`) VALUES
(2, 'GPhy', 'Poitiers'),
(3, 'SNCF', 'France'),
(4, 'SNCF', 'Poitiers'),
(5, 'SNCF', 'Poitiers');


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
('Coronella austriaca Laurenti', 'reptilEs');
SET FOREIGN_KEY_CHECKS=1;




