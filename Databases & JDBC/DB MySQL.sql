# Host: localhost  (Version 5.7.21-log)
# Date: 2018-03-07 07:29:22
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "carrello"
#

DROP TABLE IF EXISTS `carrello`;
CREATE TABLE `carrello` (
  `ordine_nordine` varchar(20) NOT NULL,
  `prodotto_codiceProdotto2` varchar(10) NOT NULL,
  `quantità` int(99) NOT NULL,
  PRIMARY KEY (`ordine_nordine`,`prodotto_codiceProdotto2`),
  KEY `prodotto_codiceProdotto2_idx` (`prodotto_codiceProdotto2`),
  CONSTRAINT `ordine_nordine` FOREIGN KEY (`ordine_nordine`) REFERENCES `ordine` (`nordine`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `prodotto_codiceProdotto2` FOREIGN KEY (`prodotto_codiceProdotto2`) REFERENCES `prodotto` (`codice_prodotto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "carrello"
#

INSERT INTO `carrello` VALUES ('DFE394','H90YJH',2),('DHHDD99','HDON34',1),('FER35Y','ZFIEF43',3),('FKEJ455','JEGR9T',5),('GKL44H','ITUH9P',1);

#
# Structure for table "cliente"
#

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `ID` int(5) unsigned zerofill NOT NULL,
  `nome` char(24) NOT NULL,
  `cognome` char(24) NOT NULL,
  `nordini` int(10) unsigned DEFAULT NULL,
  `eta` int(3) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "cliente"
#

INSERT INTO `cliente` VALUES (00001,'Mario','Rossi',2,15),(12356,'Giuseppe','Caiazzo',0,17),(23754,'Giuseppe','Pappalardo',0,32),(34295,'Alessio','Rizzolo',0,20),(45693,'Gian','Scala',0,11),(46824,'Nina','Peluso',0,24),(54985,'Dave','Smith',1,25),(67690,'Giovanni','Caiazzo',1,50),(74938,'Michele','Genovesi',1,30),(78308,'Simone','Auriemma',0,30),(85327,'Giuseppe','Sordano',0,67),(88348,'Ildegardo','Esposito',1,56);

#
# Structure for table "genere"
#

DROP TABLE IF EXISTS `genere`;
CREATE TABLE `genere` (
  `nome_genere` char(45) NOT NULL,
  PRIMARY KEY (`nome_genere`),
  UNIQUE KEY `nome_genere_UNIQUE` (`nome_genere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "genere"
#

INSERT INTO `genere` VALUES ('Avventura'),('Azione'),('GDR'),('MMO'),('MMOPRG'),('Picchiaduro'),('Plattform'),('Simulazione'),('Sparatutto');

#
# Structure for table "prodotto"
#

DROP TABLE IF EXISTS `prodotto`;
CREATE TABLE `prodotto` (
  `codice_prodotto` varchar(10) NOT NULL,
  `nome` mediumtext NOT NULL,
  `descrizione` mediumtext NOT NULL,
  `costo_unario` float unsigned NOT NULL,
  PRIMARY KEY (`codice_prodotto`),
  UNIQUE KEY `codice_prodotto_UNIQUE` (`codice_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "prodotto"
#

INSERT INTO `prodotto` VALUES ('5674h','Spyro','Gioco di Spyro',19.9),('GH5875','League of Legends','Gioco per Pc',10),('H69864','Metin 2','Gioco Metin 2 per Pc',4.99),('H90YJH','Volante da corsa \"Driving Force\"','Volante per tutti i tipi di console. ',250),('HDISK32','The Sims 4','Gioco di simulazione',24.99),('HDON34','JoJo','Ciaone',100.99),('HFDU8','The Legend of Zelda','Gioco della saga di Zelda per Nintendo',35),('ITUH9P','Microfono','Microfono per multiplayer',15.99),('JEGR9T','Cuffie Wireless','Cuffie per qualsiasi piattaforma',39.99),('JRH8G8','Crash Bandicoot N. Sane Trilogy','Copia del gioco Crash Bandicoot N. Sane Trilogy',19.99),('JRK4JK','Nintendo Classic Mini','Console di gioco Nintendo Classic Mini di colore grigio. Dimensioni: 30X20',79.9),('KFEJ4T','God Of War 4','Gioco God of War per XBOX (digital delivery)',49.99),('KJL569','PlayStation 4','PlayStation 4 da 1TB',235.98),('ZFIEF43','XBOX One','XBOX One da 1TB',229.99);

#
# Structure for table "periferica"
#

DROP TABLE IF EXISTS `periferica`;
CREATE TABLE `periferica` (
  `prodotto1_codice_prodotto` varchar(10) NOT NULL,
  `tipo` char(35) NOT NULL,
  PRIMARY KEY (`prodotto1_codice_prodotto`),
  UNIQUE KEY `prodotto1_codice_prodotto_UNIQUE` (`prodotto1_codice_prodotto`),
  CONSTRAINT `prodotto1_codice_prodotto` FOREIGN KEY (`prodotto1_codice_prodotto`) REFERENCES `prodotto` (`codice_prodotto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "periferica"
#

INSERT INTO `periferica` VALUES ('H90YJH','controller'),('ITUH9P','input audio'),('JEGR9T','output audio');

#
# Structure for table "appartiene"
#

DROP TABLE IF EXISTS `appartiene`;
CREATE TABLE `appartiene` (
  `videogame_prodotto_codice_prodotto` varchar(10) NOT NULL,
  `genere_nome_genere` char(45) NOT NULL,
  PRIMARY KEY (`videogame_prodotto_codice_prodotto`,`genere_nome_genere`),
	UNIQUE KEY  PRIMARY KEY (`videogame_prodotto_codice_prodotto`,`genere_nome_genere`),
  KEY `genere_nome_genere` (`genere_nome_genere`),
  CONSTRAINT `genere_nome_genere` FOREIGN KEY (`genere_nome_genere`) REFERENCES `genere` (`nome_genere`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `videogame_prodotto_codice_prodotto` FOREIGN KEY (`videogame_prodotto_codice_prodotto`) REFERENCES `prodotto` (`codice_prodotto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "appartiene"
#

INSERT INTO `appartiene` VALUES ('5674h','Avventura'),('5674h','Azione'),('GH5875','GDR'),('GH5875','MMO'),('H69864','Azione'),('H69864','MMOPRG'),('HDISK32','Simulazione'),('HDON34','Avventura'),('HDON34','Picchiaduro'),('HFDU8','Avventura'),('HFDU8','Azione'),('JRH8G8','Avventura'),('JRH8G8','Plattform'),('KFEJ4T','Azione'),('KFEJ4T','Picchiaduro');

#
# Structure for table "console"
#

DROP TABLE IF EXISTS `console`;
CREATE TABLE `console` (
  `prodotto2_codice_prodotto` varchar(10) NOT NULL,
  `versione` varchar(15) NOT NULL,
  PRIMARY KEY (`prodotto2_codice_prodotto`),
  UNIQUE KEY `prodotto2_codice_prodotto_UNIQUE` (`prodotto2_codice_prodotto`),
  CONSTRAINT `prodotto2_codice_prodotto` FOREIGN KEY (`prodotto2_codice_prodotto`) REFERENCES `prodotto` (`codice_prodotto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "console"
#

INSERT INTO `console` VALUES ('JRK4JK','Classic Mini'),('KJL569','4'),('ZFIEF43','One');

#
# Structure for table "colore"
#

DROP TABLE IF EXISTS `colore`;
CREATE TABLE `colore` (
  `prodotto3_codice_prodotto` varchar(10) NOT NULL,
  `nome_colore` char(30) NOT NULL,
  PRIMARY KEY (`prodotto3_codice_prodotto`,`nome_colore`),
	UNIQUE KEY (`prodotto3_codice_prodotto`,`nome_colore`),
  CONSTRAINT `prodotto3_codice_prodotto` FOREIGN KEY (`prodotto3_codice_prodotto`) REFERENCES `prodotto` (`codice_prodotto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "colore"
#

INSERT INTO `colore` VALUES ('5674h','Azzuro'),('GH5875','Verde'),('H69864','Rosso'),('H90YJH','Blu'),('HDISK32','Verde'),('HDON34','Viola'),('HFDU8','Verde'),('ITUH9P','Verde'),('JEGR9T','Arancione'),('JRH8G8','Blu'),('JRK4JK','Bianco'),('KFEJ4T','Rosso'),('KJL569','Blu'),('ZFIEF43','Bianco');

#
# Structure for table "recensione"
#

DROP TABLE IF EXISTS `recensione`;
CREATE TABLE `recensione` (
  `cliente_id` int(5) unsigned zerofill NOT NULL,
  `prodotto_codice_prodotto` varchar(10) NOT NULL,
  `titolo` tinytext NOT NULL,
  `descrizione` mediumtext NOT NULL,
  `punteggio` int(1) NOT NULL,
  PRIMARY KEY (`cliente_id`,`prodotto_codice_prodotto`),
	UNIQUE KEY PRIMARY KEY (`cliente_id`,`prodotto_codice_prodotto`),
  KEY `prodotto_codice_prodotto_idx` (`prodotto_codice_prodotto`),
  KEY `cliente_idx` (`cliente_id`),
  CONSTRAINT `cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `prodotto_codice_prodotto` FOREIGN KEY (`prodotto_codice_prodotto`) REFERENCES `prodotto` (`codice_prodotto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "recensione"
#

INSERT INTO `recensione` VALUES (00001,'HFDU8','Bello','Un bel gioco',5),(54985,'JRH8G8','Male','Gioco rilasciato troppo presto e ottimizzato male.Presenta numerosi bug, attenderò una patch',2),(67690,'ITUH9P','Pessimo','Prodotto difettoso. Dopo due giorni di utilizzo ha smesso di funzionare',1),(74938,'JEGR9T','Si trova di meglio','Cuffie discrete. A quel prezzo si trova di meglio',3),(88348,'JRK4JK','Quanti ricordi!','Console che mi ha fatto ricordare i bei vecchi tempi di quan\'ero più piccolo. Qualità ottima',5);

#
# Structure for table "spedizione"
#

DROP TABLE IF EXISTS `spedizione`;
CREATE TABLE `spedizione` (
  `nspedizione` varchar(20) NOT NULL,
  `corriere` char(15) NOT NULL,
  `indirizzo_consegna` varchar(45) NOT NULL,
  `costo_spedizione` float unsigned NOT NULL,
  `cliente1_ID` int(5) unsigned NOT NULL,
  PRIMARY KEY (`nspedizione`),
  UNIQUE KEY `nspedizione_UNIQUE` (`nspedizione`),
  KEY `CLIENTE.ID_idx` (`cliente1_ID`),
  CONSTRAINT `cliente1_ID` FOREIGN KEY (`cliente1_ID`) REFERENCES `cliente` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "spedizione"
#

INSERT INTO `spedizione` VALUES ('DEFEI39','TNT','Abbey Road',0,54985),('DWU782','GLS','Via Alan Turing',1.5,67690),('FERHF48','DHL','Via Tazio Nuvolari',15.99,1),('KTO4I03','BARTOLINI','Via Bartali',9.99,74938),('UREI30G','FEDEX','Via Togliatti',5.99,88348);

#
# Structure for table "ordine"
#

DROP TABLE IF EXISTS `ordine`;
CREATE TABLE `ordine` (
  `nordine` varchar(20) NOT NULL,
  `stato` char(15) NOT NULL,
  `costo_totale` float unsigned NOT NULL,
  `cliente_id` int(5) unsigned zerofill NOT NULL,
  `spedizione_nspedizione` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nordine`),
  UNIQUE KEY `nordine_UNIQUE` (`nordine`),
  KEY `cliente.id_idx` (`cliente_id`),
  KEY `spedizione_nspedizione_idx` (`spedizione_nspedizione`),
  CONSTRAINT `cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `spedizione_nspedizione` FOREIGN KEY (`spedizione_nspedizione`) REFERENCES `spedizione` (`nspedizione`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "ordine"
#

INSERT INTO `ordine` VALUES ('DFE394','IN CORSO',41.48,67690,'DWU782'),('DHHDD99','IN CORSO',4.99,00001,NULL),('DWF323','SOSPESO',175,54985,'DEFEI39'),('FER35Y','IN CORSO',275.98,88348,'UREI30G'),('FKEJ455','PRESA IN CARICO',79.95,00001,'FERHF48'),('GKL44H','CONCLUSO',29.98,74938,'KTO4I03');

#
# Structure for table "videogame"
#

DROP TABLE IF EXISTS `videogame`;
CREATE TABLE `videogame` (
  `prodotto_codiceprodotto` varchar(10) NOT NULL,
  `formato` char(20) NOT NULL,
  `piattaforma` char(50) NOT NULL,
  PRIMARY KEY (`prodotto_codiceprodotto`),
  CONSTRAINT `prodotto_codiceprodotto` FOREIGN KEY (`prodotto_codiceprodotto`) REFERENCES `prodotto` (`codice_prodotto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "videogame"
#

INSERT INTO `videogame` VALUES ('5674h','Fisico','XBoX'),('GH5875','Digitale','PC'),('H69864','Digitale','PC'),('HDISK32','Digitale','PC'),('HDON34','Fisico','PlayStation 4'),('HFDU8','Fisico','Nintendo'),('JRH8G8','Fisico','PlayStation 4'),('KFEJ4T','Digitale','XBOX');
