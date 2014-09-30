DROP TABLE IF EXISTS `property_master`.`prop_company`;
CREATE TABLE  `property_master`.`prop_company` (
  `companyId` int(10) unsigned NOT NULL,
  `companyName` varchar(45) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `custom1` varchar(45) DEFAULT NULL,
  `custom2` varchar(45) DEFAULT NULL,
  `custom3` varchar(45) DEFAULT NULL,
  `custom4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `property_master`.`prop_users` CHANGE COLUMN `companyName` `companyId` INT(11) UNSIGNED DEFAULT NULL,
 ADD CONSTRAINT `FK_prop_users_company` FOREIGN KEY `FK_prop_users_company` (`companyId`)
    REFERENCES `prop_company` (`companyId`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT;
    
    
update prop_state set state_Name = 'Haryana' where state_Name = 'Harayana';

ALTER TABLE `property_master`.`prop_features` MODIFY COLUMN `furnished` VARCHAR(15);

ALTER TABLE `property_master`.`prop_terms_cond` MODIFY COLUMN `description` VARCHAR(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL;

insert into prop_type values(26,'Plot',1);
insert into prop_type values(27,'Builder Floor',1);

ALTER TABLE `property_master`.`prop_users` MODIFY COLUMN `mobileNo` VARCHAR(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL;