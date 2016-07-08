/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : webtest

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-07-08 08:23:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(100) NOT NULL,
  `product` varchar(20) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '电视', '900.00');
INSERT INTO `orders` VALUES ('2', '洗衣机', '100.00');
INSERT INTO `orders` VALUES ('3', '洗衣粉', '90.00');
INSERT INTO `orders` VALUES ('4', '桔子', '9.00');
INSERT INTO `orders` VALUES ('5', '洗衣粉', '90.00');
