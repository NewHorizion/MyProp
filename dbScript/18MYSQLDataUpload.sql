ALTER TABLE `property_master`.`prop_users` ADD COLUMN `companyName` VARCHAR(50) AFTER `prop_city_Id`;

ALTER TABLE `property_master`.`prop_transaction` ADD COLUMN `builderSociety` VARCHAR(45) AFTER `custom4`;

ALTER TABLE `property_master`.`prop_info` ADD COLUMN `negotiable` VARCHAR(15) AFTER `prop_purchase_id`;

