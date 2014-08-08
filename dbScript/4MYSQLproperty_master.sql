-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.25-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema property_master
--

CREATE DATABASE IF NOT EXISTS property_master;
USE property_master;

--
-- Definition of table `acl_class`
--

DROP TABLE IF EXISTS `acl_class`;
CREATE TABLE `acl_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_uk_2` (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acl_class`
--

/*!40000 ALTER TABLE `acl_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `acl_class` ENABLE KEYS */;


--
-- Definition of table `acl_entry`
--

DROP TABLE IF EXISTS `acl_entry`;
CREATE TABLE `acl_entry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acl_object_identity` int(11) NOT NULL,
  `ace_order` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `mask` int(11) NOT NULL,
  `granting` bit(1) NOT NULL,
  `audit_success` bit(1) NOT NULL,
  `audit_failure` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_uk_4` (`acl_object_identity`,`ace_order`),
  KEY `foreign_fk_5` (`sid`),
  CONSTRAINT `acl_entry_ibfk_1` FOREIGN KEY (`acl_object_identity`) REFERENCES `acl_object_identity` (`id`),
  CONSTRAINT `acl_entry_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `acl_sid` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acl_entry`
--

/*!40000 ALTER TABLE `acl_entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `acl_entry` ENABLE KEYS */;


--
-- Definition of table `acl_object_identity`
--

DROP TABLE IF EXISTS `acl_object_identity`;
CREATE TABLE `acl_object_identity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `object_id_class` int(11) NOT NULL,
  `object_id_identity` int(11) NOT NULL,
  `parent_object` int(11) DEFAULT NULL,
  `owner_sid` int(11) NOT NULL,
  `entries_inheriting` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_uk_3` (`object_id_class`,`object_id_identity`),
  KEY `foreign_fk_1` (`parent_object`),
  KEY `foreign_fk_3` (`owner_sid`),
  CONSTRAINT `acl_object_identity_ibfk_1` FOREIGN KEY (`parent_object`) REFERENCES `acl_object_identity` (`id`),
  CONSTRAINT `acl_object_identity_ibfk_2` FOREIGN KEY (`object_id_class`) REFERENCES `acl_class` (`id`),
  CONSTRAINT `acl_object_identity_ibfk_3` FOREIGN KEY (`owner_sid`) REFERENCES `acl_sid` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acl_object_identity`
--

/*!40000 ALTER TABLE `acl_object_identity` DISABLE KEYS */;
/*!40000 ALTER TABLE `acl_object_identity` ENABLE KEYS */;


--
-- Definition of table `acl_sid`
--

DROP TABLE IF EXISTS `acl_sid`;
CREATE TABLE `acl_sid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `principal` bit(1) NOT NULL,
  `sid` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_uk_1` (`sid`,`principal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acl_sid`
--

/*!40000 ALTER TABLE `acl_sid` DISABLE KEYS */;
/*!40000 ALTER TABLE `acl_sid` ENABLE KEYS */;


--
-- Definition of table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`username`,`authority`) VALUES 
 ('vineet','ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;


--
-- Definition of table `group_authorities`
--

DROP TABLE IF EXISTS `group_authorities`;
CREATE TABLE `group_authorities` (
  `group_id` int(11) NOT NULL,
  `authority` varchar(50) NOT NULL,
  KEY `fk_group_authorities_group` (`group_id`),
  CONSTRAINT `fk_group_authorities_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_authorities`
--

/*!40000 ALTER TABLE `group_authorities` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_authorities` ENABLE KEYS */;


--
-- Definition of table `group_members`
--

DROP TABLE IF EXISTS `group_members`;
CREATE TABLE `group_members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_group_members_group` (`group_id`),
  CONSTRAINT `fk_group_members_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_members`
--

/*!40000 ALTER TABLE `group_members` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_members` ENABLE KEYS */;


--
-- Definition of table `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` (`id`,`group_name`) VALUES 
 (1,'admin');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;


--
-- Definition of table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persistent_logins`
--

/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;


--
-- Definition of table `prop_area`
--

DROP TABLE IF EXISTS `prop_area`;
CREATE TABLE `prop_area` (
  `prop_area_Id` int(11) NOT NULL,
  `covered_Area` int(11) DEFAULT NULL,
  `measurement` varchar(6) DEFAULT NULL,
  `plot_Area` int(11) DEFAULT NULL,
  `land_Area` int(11) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prop_area_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_area`
--

/*!40000 ALTER TABLE `prop_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `prop_area` ENABLE KEYS */;


--
-- Definition of table `prop_categry`
--

DROP TABLE IF EXISTS `prop_categry`;
CREATE TABLE `prop_categry` (
  `categry_id` int(11) NOT NULL,
  `categry_type` varchar(30) NOT NULL,
  PRIMARY KEY (`categry_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_categry`
--

/*!40000 ALTER TABLE `prop_categry` DISABLE KEYS */;
INSERT INTO `prop_categry` (`categry_id`,`categry_type`) VALUES 
 (1,'Residential'),
 (2,'Commercial'),
 (3,'Agriculture');
/*!40000 ALTER TABLE `prop_categry` ENABLE KEYS */;


--
-- Definition of table `prop_state`
--

DROP TABLE IF EXISTS `prop_country`;
CREATE TABLE `prop_country` (
  `prop_country_Id` int(11) NOT NULL,
  `country_Name` varchar(50) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  PRIMARY KEY (`prop_country_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Definition of table `prop_state`
--

DROP TABLE IF EXISTS `prop_state`;
CREATE TABLE `prop_state` (
  `prop_state_Id` int(11) NOT NULL,
  `state_Name` varchar(50) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `prop_country_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`prop_state_Id`),
  CONSTRAINT `prop_country_ibfk_1` FOREIGN KEY (`prop_country_Id`) REFERENCES `prop_country` (`prop_country_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Definition of table `prop_city`
--

DROP TABLE IF EXISTS `prop_city`;
CREATE TABLE `prop_city` (
  `prop_City_Id` int(11) NOT NULL,
  `city_Name` varchar(50) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `prop_state_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`prop_City_Id`),
  CONSTRAINT `prop_state_ibfk_1` FOREIGN KEY (`prop_state_Id`) REFERENCES `prop_state` (`prop_state_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Dumping data for table `prop_city`
--

/*!40000 ALTER TABLE `prop_city` DISABLE KEYS */;
/*!40000 ALTER TABLE `prop_city` ENABLE KEYS */;


--
-- Definition of table `prop_features`
--

DROP TABLE IF EXISTS `prop_features`;
CREATE TABLE `prop_features` (
  `prop_feature_Id` int(11) NOT NULL,
  `bed_Rooms` int(11) DEFAULT NULL,
  `bath_Rooms` int(11) DEFAULT NULL,
  `balconies` int(11) DEFAULT NULL,
  `furnished` tinyint(4) DEFAULT NULL,
  `age_Of_Const` varchar(10) DEFAULT NULL,
  `avail_Floor` int(11) DEFAULT NULL,
  `total_Floors` int(11) DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prop_feature_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_features`
--

/*!40000 ALTER TABLE `prop_features` DISABLE KEYS */;
/*!40000 ALTER TABLE `prop_features` ENABLE KEYS */;


--
-- Definition of table `prop_image`
--

DROP TABLE IF EXISTS `prop_image`;
CREATE TABLE `prop_image` (
  `prop_Image_Id` int(11) NOT NULL,
  `image` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `prop_Info_Id` int(11) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prop_Image_Id`),
  CONSTRAINT `prop_info_ibfk_1` FOREIGN KEY (`prop_Info_Id`) REFERENCES `prop_info` (`prop_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_image`
--

/*!40000 ALTER TABLE `prop_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `prop_image` ENABLE KEYS */;


--
-- Definition of table `prop_info`
--

DROP TABLE IF EXISTS `prop_info`;
CREATE TABLE `prop_info` (
  `prop_Info_Id` int(11) NOT NULL,
  `prop_Type_Id` int(11) DEFAULT NULL,
  `society_Project` varchar(20) DEFAULT NULL,
  `prop_location_Id` int(11) DEFAULT NULL,
  `prop_area_Id` int(11) DEFAULT NULL,
  `prop_feature_Id` int(11) DEFAULT NULL,
  `prop_sale_Price_Id` int(11) DEFAULT NULL,
  `prop_term_Cond_Id` int(11) DEFAULT NULL,
  `prop_transaction_Id` int(11) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  `prop_purchase_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`prop_Info_Id`),
 KEY `FK_prop_info_prop_area` (`prop_area_Id`),
  KEY `FK_prop_info_prop_feature` (`prop_feature_Id`),
  KEY `FK_prop_info_prop_location` (`prop_location_Id`),
  KEY `FK_prop_info_prop_price` (`prop_sale_Price_Id`),
  KEY `FK_prop_info_prop_terms` (`prop_term_Cond_Id`),
  KEY `FK_prop_info_prop_trans` (`prop_transaction_Id`),
  KEY `FK_prop_info_prop_type` (`prop_Type_Id`),
  KEY `FK_prop_purachase_type` (`prop_purchase_id`),
  CONSTRAINT `prop_info_ibfk_8` FOREIGN KEY (`prop_purchase_id`) REFERENCES `prop_purchase_type` (`prop_purchase_id`),
  CONSTRAINT `prop_info_ibfk_9` FOREIGN KEY (`prop_area_Id`) REFERENCES `prop_area` (`prop_area_Id`),
  CONSTRAINT `prop_info_ibfk_2` FOREIGN KEY (`prop_feature_Id`) REFERENCES `prop_features` (`prop_feature_Id`),
  CONSTRAINT `prop_info_ibfk_3` FOREIGN KEY (`prop_location_Id`) REFERENCES `prop_location` (`prop_location_Id`),
  CONSTRAINT `prop_info_ibfk_4` FOREIGN KEY (`prop_sale_Price_Id`) REFERENCES `prop_price` (`prop_sale_Price_Id`),
  CONSTRAINT `prop_info_ibfk_5` FOREIGN KEY (`prop_term_Cond_Id`) REFERENCES `prop_terms_cond` (`prop_term_Cond_Id`),
  CONSTRAINT `prop_info_ibfk_6` FOREIGN KEY (`prop_transaction_Id`) REFERENCES `prop_transaction` (`prop_transaction_Id`),
  CONSTRAINT `prop_info_ibfk_7` FOREIGN KEY (`prop_Type_Id`) REFERENCES `prop_type` (`prop_Type_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_info`
--

/*!40000 ALTER TABLE `prop_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `prop_info` ENABLE KEYS */;


--
-- Definition of table `prop_locality`
--

DROP TABLE IF EXISTS `prop_location`;
CREATE TABLE `prop_location` (
  `prop_Location_Id` int(11) NOT NULL,
  `locality_Name` varchar(25) DEFAULT NULL,
  `prop_City_Id` int(11) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prop_Location_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Dumping data for table `prop_location`
--

/*!40000 ALTER TABLE `prop_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `prop_location` ENABLE KEYS */;


--
-- Definition of table `prop_price`
--

DROP TABLE IF EXISTS `prop_price`;
CREATE TABLE `prop_price` (
  `prop_sale_Price_Id` int(11) NOT NULL,
  `expected_Price` decimal(18,0) DEFAULT NULL,
  `price_Per_Sqr_Ft` decimal(18,0) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prop_sale_Price_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_price`
--

/*!40000 ALTER TABLE `prop_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `prop_price` ENABLE KEYS */;


--
-- Definition of table `prop_purchase_type`
--

DROP TABLE IF EXISTS `prop_purchase_type`;
CREATE TABLE `prop_purchase_type` (
  `prop_purchase_id` int(11) NOT NULL,
  `prop_purchase_desc` varchar(20) NOT NULL,
  PRIMARY KEY (`prop_purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_purchase_type`
--

/*!40000 ALTER TABLE `prop_purchase_type` DISABLE KEYS */;
INSERT INTO `prop_purchase_type` (`prop_purchase_id`,`prop_purchase_desc`) VALUES
 (1,'Sale'),
 (2,'Rent Out');
/*!40000 ALTER TABLE `prop_purchase_type` ENABLE KEYS */;


--
-- Definition of table `prop_terms_cond`
--

DROP TABLE IF EXISTS `prop_terms_cond`;
CREATE TABLE `prop_terms_cond` (
  `prop_term_Cond_Id` int(11) NOT NULL,
  `annual_Dues` decimal(18,0) DEFAULT NULL,
  `tax` decimal(18,0) DEFAULT NULL,
  `fees` decimal(18,0) DEFAULT NULL,
  `term_N_Cond` varchar(50) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prop_term_Cond_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_terms_cond`
--

/*!40000 ALTER TABLE `prop_terms_cond` DISABLE KEYS */;
/*!40000 ALTER TABLE `prop_terms_cond` ENABLE KEYS */;


--
-- Definition of table `prop_transaction`
--

DROP TABLE IF EXISTS `prop_transaction`;
CREATE TABLE `prop_transaction` (
  `prop_transaction_Id` int(11) NOT NULL,
  `transaction_Type` varchar(15) DEFAULT NULL,
  `possession_Status` varchar(15) DEFAULT NULL,
  `available_From` datetime DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prop_transaction_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_transaction`
--

/*!40000 ALTER TABLE `prop_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `prop_transaction` ENABLE KEYS */;


--
-- Definition of table `prop_type`
--

DROP TABLE IF EXISTS `prop_type`;
CREATE TABLE `prop_type` (
  `prop_Type_Id` int(11) NOT NULL,
  `type_Desc` varchar(30) DEFAULT NULL,
  `categry_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`prop_Type_Id`),
  KEY `prop_categry_fk` (`categry_id`),
  CONSTRAINT `prop_type_ibfk_1` FOREIGN KEY (`categry_id`) REFERENCES `prop_categry` (`categry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prop_type`
--

/*!40000 ALTER TABLE `prop_type` DISABLE KEYS */;
INSERT INTO `prop_type` (`prop_Type_Id`,`type_Desc`,`categry_id`) VALUES
 (1,'Multistorey Apartment',1),
 (2,'Builder Floor Apartment',1),
 (3,'Residential House',1),
 (4,'Villa',1),
 (5,'Residential Plot',1),
 (6,'Penthouse',1),
 (7,'Studio Apartment',1),
 (8,'Service Apartment',1),
 (9,'Commercial Office Space',2),
 (10,'Office in IT Park/ SEZ',2),
 (11,'Commercial Shop',2),
 (12,'Space in Shopping Mall',2),
 (13,'Commercial Showroom',2),
 (14,'Kiosk',2),
 (15,'Business Centre',2),
 (16,'Commercial Land',2),
 (17,'Warehouse/ Godown',2),
 (18,'Guest House',2),
 (19,'Hotel',2),
 (20,'Hotel Sites',2),
 (21,'Industrial Land',2),
 (22,'Industrial Building',2),
 (23,'Industrial Shed',2),
 (24,'Agricultural Land',3),
 (25,'Farm House',3);
/*!40000 ALTER TABLE `prop_type` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`username`,`password`,`enabled`) VALUES 
 ('vineet','password',0x01);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;




--
-- Definition of table `prop_info_ext'
--

DROP TABLE IF EXISTS `prop_info_ext`;
CREATE TABLE `prop_info_ext`(
  `prop_Info_Id` int(11) NOT NULL,
  `number_of_clicks` int(11) DEFAULT NULL,
  `last_accessed` datetime DEFAULT NULL,
  `popularity` int(11) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prop_Info_Id`),
  CONSTRAINT `prop_info_ibfk_10` FOREIGN KEY (`prop_Info_Id`) REFERENCES `prop_info` (`prop_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `prop_info_comments_ext`
--

DROP TABLE IF EXISTS `prop_info_comments_ext`;
CREATE TABLE `prop_info_comments_ext`(
  `prop_info_Id` int(11) NOT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `created_Date` datetime DEFAULT NULL,
  `custom1` varchar(10) DEFAULT NULL,
  `custom2` varchar(10) DEFAULT NULL,
  `custom3` varchar(10) DEFAULT NULL,
  `custom4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`prop_info_Id`),
  CONSTRAINT `prop_info_ibfk_11` FOREIGN KEY (`prop_Info_Id`) REFERENCES `prop_info` (`prop_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;