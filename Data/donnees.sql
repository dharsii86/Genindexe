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
('Coronella austriaca Laurenti', 'reptilEs');
SET FOREIGN_KEY_CHECKS=1;

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
('SNCFFrance','nicolas.villeriot@mail.com','Nicolas','Villeriot','nv050Cu','Customer');


