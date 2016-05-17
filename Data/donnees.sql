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


INSERT INTO `status` (`Status_Name`) VALUES
('Secretary'),
('Technician'),
('Validator'),
('Customer');

INSERT INTO `samplestate`(`idState`, `State_name`) VALUES 
(1,'First analysis pending'),
(2,'First analysis done'),
(3,'Second analysis pending'),
(4,'Second analysis done'),
(5,'Third analysis pending'),
(6,'Third analysis done'),
(7,'Done');


INSERT INTO `user` (`User_Login`,`User_Mail`,`User_Name`,`User_LastName`,`User_Password`,`Status_Name`) VALUES
('clrousseau','claire.rousseau@lab.com','Claire','Rousseau','cr051Se','Secretary'),
('thdequipe','thomas.dequipe@lab.com','Thomas','Dequipe','td040Te','Technician'),
('josaulnier','johnny.saulnier@lab.com','Johnny','Saulnier','js065Va','Validator'),
('GPhyPoitiers','quentin.bonenfant@mail.com','Quentin','Bonenfant','qb045Cu','Customer'),
('SNCFPoitiers','Jean-Christophe.greaux@mail.com','Jean-Christophe','Greaux','jg067Cu','Customer'),
('SNCFLaRochelle','aye.assohoun@mail.com','Will','Assohoun','wa053Cu','Customer'),
('SNCFFrance','nicolas.villeriot@mail.com','Nicolas','Villeriot','nv050Cu','Customer');

insert into `order` (`Order_Status`, `Analysis_Name`, `Customer_Login`) values ('Waiting','Sexing', 'SNCFFRance'),
('completed','Scrapie', 'SNCFFRance'),
('inAnalysis','Sexing', 'SNCFPoitiers'),
('toAnalyze','Scrapie', 'SNCFPoitiers'),
('inAnalysis','Scrapie', 'SNCFLaRochelle'),
('inAnalysis','Sexing', 'SNCFLaRochelle'),
('completed','Sexing', 'GphyPoitiers'),
('inAnalysis','Scrapie', 'GphyPoitiers');

insert into `sample` (`Specie_Name`, `Order_ID`) values ('Lynx lynx lynx','1'),
('Lynx lynx lynx','1'),
('Lynx lynx lynx','1'),
('Lynx lynx lynx','1'),
('Panthera tigris sumatrae','2'),
('Panthera tigris sumatrae','2'),
('Panthera tigris sumatrae','2'),
('Panthera tigris sumatrae','3'),
('Panthera tigris sumatrae','3'),
('Panthera tigris sumatrae','3'),
('Panthera tigris sumatrae','3'),
('Panthera tigris sumatrae','4'),
('Panthera tigris sumatrae','4'),
('Panthera tigris sumatrae','4'),
('Panthera tigris sumatrae','5'),
('Panthera tigris sumatrae','5'),
('Lynx lynx lynx','6'),
('Lynx lynx lynx','6'),
('Lynx lynx lynx','6'),
('Lynx lynx lynx','7'),
('Lynx lynx lynx','7'),
('Panthera tigris sumatrae','8'),
('Panthera tigris sumatrae','8'),
('Panthera tigris sumatrae','8');

SET FOREIGN_KEY_CHECKS=1;
