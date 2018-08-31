/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50555
Source Host           : localhost:3306
Source Database       : login_db

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2018-08-08 13:25:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `pwd` varchar(10) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `love` varchar(255) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `createDate` varchar(255) DEFAULT NULL,
  `updateDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123', '0', '文学,音乐', '1981-11-11', 'jining', 'esemila', '2017-10-19 16:08:42', '2018-08-07 17:30:04');
