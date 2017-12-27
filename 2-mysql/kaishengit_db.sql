/*
Navicat MySQL Data Transfer

Source Server         : db_24
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : kaishengit_db

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-08-08 10:28:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `cust_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_name` char(50) NOT NULL,
  `cust_address` char(50) DEFAULT NULL,
  `cust_city` char(50) DEFAULT NULL,
  `cust_state` char(5) DEFAULT NULL,
  `cust_zip` char(10) DEFAULT NULL,
  `cust_country` char(50) DEFAULT NULL,
  `cust_contact` char(50) DEFAULT NULL,
  `cust_email` char(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('10001', 'Coyote Inc.', '200 Maple Lane', 'Detroit', 'MI', '44444', 'USA', 'Y Lee', 'ylee@coyote.com');
INSERT INTO `customers` VALUES ('10002', 'Mouse House', '333 Fromage Lane', 'Columbus', 'OH', '43333', 'USA', 'Jerry Mouse', null);
INSERT INTO `customers` VALUES ('10003', 'Wascals', '1 Sunny Place', 'Muncie', 'IN', '42222', 'USA', 'Jim Jones', 'rabbit@wascally.com');
INSERT INTO `customers` VALUES ('10004', 'Yosemite Place', '829 Riverside Drive', 'Phoenix', 'AZ', '88888', 'USA', 'Y Sam', 'sam@yosemite.com');
INSERT INTO `customers` VALUES ('10005', 'E Fudd', '4545 53rd Street', 'Chicago', 'IL', '54545', 'USA', 'E Fudd', null);

-- ----------------------------
-- Table structure for orderitems
-- ----------------------------
DROP TABLE IF EXISTS `orderitems`;
CREATE TABLE `orderitems` (
  `order_num` int(11) NOT NULL,
  `order_item` int(11) NOT NULL,
  `prod_id` char(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `item_price` decimal(8,2) NOT NULL,
  PRIMARY KEY (`order_num`,`order_item`),
  KEY `fk_orderitems_products` (`prod_id`),
  CONSTRAINT `fk_orderitems_orders` FOREIGN KEY (`order_num`) REFERENCES `orders` (`order_num`),
  CONSTRAINT `fk_orderitems_products` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitems
-- ----------------------------
INSERT INTO `orderitems` VALUES ('20005', '1', 'ANV01', '10', '5.99');
INSERT INTO `orderitems` VALUES ('20005', '2', 'ANV02', '3', '9.99');
INSERT INTO `orderitems` VALUES ('20005', '3', 'TNT2', '5', '10.00');
INSERT INTO `orderitems` VALUES ('20005', '4', 'FB', '1', '10.00');
INSERT INTO `orderitems` VALUES ('20006', '1', 'JP2000', '1', '55.00');
INSERT INTO `orderitems` VALUES ('20007', '1', 'TNT2', '100', '10.00');
INSERT INTO `orderitems` VALUES ('20008', '1', 'FC', '50', '2.50');
INSERT INTO `orderitems` VALUES ('20009', '1', 'FB', '1', '10.00');
INSERT INTO `orderitems` VALUES ('20009', '2', 'OL1', '1', '8.99');
INSERT INTO `orderitems` VALUES ('20009', '3', 'SLING', '1', '4.49');
INSERT INTO `orderitems` VALUES ('20009', '4', 'ANV03', '1', '14.99');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_num` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` datetime NOT NULL,
  `cust_id` int(11) NOT NULL,
  PRIMARY KEY (`order_num`),
  KEY `fk_orders_customers` (`cust_id`),
  CONSTRAINT `fk_orders_customers` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20011 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('20005', '2005-09-01 00:00:00', '10001');
INSERT INTO `orders` VALUES ('20006', '2005-09-12 00:00:00', '10003');
INSERT INTO `orders` VALUES ('20007', '2005-09-30 00:00:00', '10004');
INSERT INTO `orders` VALUES ('20008', '2005-10-03 00:00:00', '10005');
INSERT INTO `orders` VALUES ('20009', '2005-10-08 00:00:00', '10001');
INSERT INTO `orders` VALUES ('20010', '2005-09-01 10:10:10', '10001');

-- ----------------------------
-- Table structure for productnotes
-- ----------------------------
DROP TABLE IF EXISTS `productnotes`;
CREATE TABLE `productnotes` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_id` char(10) NOT NULL,
  `note_date` datetime NOT NULL,
  `note_text` text,
  PRIMARY KEY (`note_id`),
  FULLTEXT KEY `note_text` (`note_text`)
) ENGINE=MyISAM AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productnotes
-- ----------------------------
INSERT INTO `productnotes` VALUES ('101', 'TNT2', '2005-08-17 00:00:00', 'Customer complaint:\r\nSticks not individually wrapped, too easy to mistakenly detonate all at once.\r\nRecommend individual wrapping.');
INSERT INTO `productnotes` VALUES ('102', 'OL1', '2005-08-18 00:00:00', 'Can shipped full, refills not available.\r\nNeed to order new can if refill needed.');
INSERT INTO `productnotes` VALUES ('103', 'SAFE', '2005-08-18 00:00:00', 'Safe is combination locked, combination not provided with safe.\r\nThis is rarely a problem as safes are typically blown up or dropped by customers.');
INSERT INTO `productnotes` VALUES ('104', 'FC', '2005-08-19 00:00:00', 'Quantity varies, sold by the sack load.\r\nAll guaranteed to be bright and orange, and suitable for use as rabbit bait.');
INSERT INTO `productnotes` VALUES ('105', 'TNT2', '2005-08-20 00:00:00', 'Included fuses are short and have been known to detonate too quickly for some customers.\r\nLonger fuses are available (item FU1) and should be recommended.');
INSERT INTO `productnotes` VALUES ('106', 'TNT2', '2005-08-22 00:00:00', 'Matches not included, recommend purchase of matches or detonator (item DTNTR).');
INSERT INTO `productnotes` VALUES ('107', 'SAFE', '2005-08-23 00:00:00', 'Please note that no returns will be accepted if safe opened using explosives.');
INSERT INTO `productnotes` VALUES ('108', 'ANV01', '2005-08-25 00:00:00', 'Multiple customer returns, anvils failing to drop fast enough or falling backwards on purchaser. Recommend that customer considers using heavier anvils.');
INSERT INTO `productnotes` VALUES ('109', 'ANV03', '2005-09-01 00:00:00', 'Item is extremely heavy. Designed for dropping, not recommended for use with slings, ropes, pulleys, or tightropes.');
INSERT INTO `productnotes` VALUES ('110', 'FC', '2005-09-01 00:00:00', 'Customer complaint: rabbit has been able to detect trap, food apparently less effective now.');
INSERT INTO `productnotes` VALUES ('111', 'SLING', '2005-09-02 00:00:00', 'Shipped unassembled, requires common tools (including oversized hammer).');
INSERT INTO `productnotes` VALUES ('112', 'SAFE', '2005-09-02 00:00:00', 'Customer complaint:\r\nCircular hole in safe floor can apparently be easily cut with handsaw.');
INSERT INTO `productnotes` VALUES ('113', 'ANV01', '2005-09-05 00:00:00', 'Customer complaint:\r\nNot heavy enough to generate flying stars around head of victim. If being purchased for dropping, recommend ANV02 or ANV03 instead.');
INSERT INTO `productnotes` VALUES ('114', 'SAFE', '2005-09-07 00:00:00', 'Call from individual trapped in safe plummeting to the ground, suggests an escape hatch be added.\r\nComment forwarded to vendor.');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `prod_id` char(10) NOT NULL,
  `vend_id` int(11) NOT NULL,
  `prod_name` char(255) NOT NULL,
  `prod_price` decimal(8,2) NOT NULL,
  `prod_desc` text,
  PRIMARY KEY (`prod_id`),
  KEY `fk_products_vendors` (`vend_id`),
  CONSTRAINT `fk_products_vendors` FOREIGN KEY (`vend_id`) REFERENCES `vendors` (`vend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('ANV01', '1001', '.5 ton anvil', '5.99', '.5 ton anvil, black, complete with handy hook');
INSERT INTO `products` VALUES ('ANV02', '1001', '1 ton anvil', '9.99', '1 ton anvil, black, complete with handy hook and carrying case');
INSERT INTO `products` VALUES ('ANV03', '1001', '2 ton anvil', '14.99', '2 ton anvil, black, complete with handy hook and carrying case');
INSERT INTO `products` VALUES ('DTNTR', '1003', 'Detonator', '13.99', 'Detonator (plunger powered), fuses not included');
INSERT INTO `products` VALUES ('FB', '1003', 'Bird seed', '10.00', 'Large bag (suitable for road runners)');
INSERT INTO `products` VALUES ('FC', '1003', 'Carrots', '2.50', 'Carrots (rabbit hunting season only)');
INSERT INTO `products` VALUES ('FU1', '1002', 'Fuses', '3.42', '1 dozen, extra long');
INSERT INTO `products` VALUES ('JP1000', '1005', 'JetPack 1000', '35.00', 'JetPack 1000, intended for single use');
INSERT INTO `products` VALUES ('JP2000', '1005', 'JetPack 2000', '55.00', 'JetPack 2000, multi-use');
INSERT INTO `products` VALUES ('OL1', '1002', 'Oil can', '8.99', 'Oil can, red');
INSERT INTO `products` VALUES ('SAFE', '1003', 'Safe', '50.00', 'Safe with combination lock');
INSERT INTO `products` VALUES ('SLING', '1003', 'Sling', '4.49', 'Sling, one size fits all');
INSERT INTO `products` VALUES ('TNT1', '1003', 'TNT (1 stick)', '2.50', 'TNT, red, single stick');
INSERT INTO `products` VALUES ('TNT2', '1003', 'TNT (5 sticks)', '10.00', 'TNT, red, pack of 10 sticks');

-- ----------------------------
-- Table structure for vendors
-- ----------------------------
DROP TABLE IF EXISTS `vendors`;
CREATE TABLE `vendors` (
  `vend_id` int(11) NOT NULL AUTO_INCREMENT,
  `vend_name` char(50) NOT NULL,
  `vend_address` char(50) DEFAULT NULL,
  `vend_city` char(50) DEFAULT NULL,
  `vend_state` char(5) DEFAULT NULL,
  `vend_zip` char(10) DEFAULT NULL,
  `vend_country` char(50) DEFAULT NULL,
  PRIMARY KEY (`vend_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vendors
-- ----------------------------
INSERT INTO `vendors` VALUES ('1001', 'Anvils R Us', '123 Main Street', 'Southfield', 'MI', '48075', 'USA');
INSERT INTO `vendors` VALUES ('1002', 'LT Supplies', '500 Park Street', 'Anytown', 'OH', '44333', 'USA');
INSERT INTO `vendors` VALUES ('1003', 'ACME', '555 High Street', 'Los Angeles', 'CA', '90046', 'USA');
INSERT INTO `vendors` VALUES ('1004', 'Furball Inc.', '1000 5th Avenue', 'New York', 'NY', '11111', 'USA');
INSERT INTO `vendors` VALUES ('1005', 'Jet Set', '42 Galaxy Road', 'London', null, 'N16 6PS', 'England');
INSERT INTO `vendors` VALUES ('1006', 'Jouets Et Ours', '1 Rue Amusement', 'Paris', null, '45678', 'France');

-- ----------------------------
-- View structure for v_products_vendors
-- ----------------------------
DROP VIEW IF EXISTS `v_products_vendors`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%`  VIEW `v_products_vendors` AS select pro.*,v.vend_name from products pro,vendors v 
where pro.vend_id = v.vend_id ;

-- ----------------------------
-- View structure for v_products_vendors_2
-- ----------------------------
DROP VIEW IF EXISTS `v_products_vendors_2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%`  VIEW `v_products_vendors_2` AS select pro.*,v.vend_name from products pro,vendors v 
where pro.vend_id = v.vend_id order by prod_name DESC ;

-- ----------------------------
-- Procedure structure for pro_1
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_1`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `pro_1`()
BEGIN
select * from products;
update products set prod_price=13.99 where prod_id = 'DTNTR';
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pro_2
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_2`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `pro_2`(OUT maxp DECIMAL(8,2)
,OUT minp DECIMAL(8,2))
BEGIN
select max(prod_price) INTO maxp from products;
select min(prod_price) INTO minp from products;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pro_3
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_3`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `pro_3`(IN id CHAR(10))
BEGIN
select * from products where prod_id = id;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pro_4
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro_4`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `pro_4`(IN userName VARCHAR(255))
BEGIN
insert into t_user (name) values(userName);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for p_1
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_1`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `p_1`()
BEGIN
select MAX(prod_price) as maxPrice from products;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for p_2
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_2`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `p_2`(OUT maxP DECIMAL(8,2),OUT minP DECIMAL(8,2))
BEGIN
select MAX(prod_price) INTO maxP from products;
select MIN(prod_price) INTO minP from products;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for p_3
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_3`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `p_3`(IN vid INT)
BEGIN
select * from products where vend_id = vid;
end
;;
DELIMITER ;
SET FOREIGN_KEY_CHECKS=1;
