/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : webtest

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-07-07 08:30:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `chinese` float DEFAULT NULL,
  `english` float DEFAULT NULL,
  `math` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张小明', '89', '78', '90');
INSERT INTO `student` VALUES ('2', '李进', '67', '98', '56');
INSERT INTO `student` VALUES ('3', '王五', '87', '78', '77');
INSERT INTO `student` VALUES ('4', '李一', '88', '98', '90');
INSERT INTO `student` VALUES ('5', '李来财', '82', '84', '67');
INSERT INTO `student` VALUES ('6', '张进宝', '55', '85', '45');
INSERT INTO `student` VALUES ('7', '黄蓉', '75', '65', '30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(60) DEFAULT NULL,
  `brithday` date DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `job` varchar(60) DEFAULT NULL,
  `salary` float(10,2) DEFAULT NULL,
  `resume` text,
  `image` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zs', '2016-07-07', '2016-07-07', 'web前端', '1280.85', '好人', null);
