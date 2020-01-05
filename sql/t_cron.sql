/*
Navicat MySQL Data Transfer

Source Server         : localhost3308
Source Server Version : 50721
Source Host           : localhost:3308
Source Database       : springboot-shiro

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-01-05 19:56:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_cron
-- ----------------------------
DROP TABLE IF EXISTS `t_cron`;
CREATE TABLE `t_cron` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cron` varchar(255) DEFAULT NULL COMMENT 'cron表达式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cron
-- ----------------------------
INSERT INTO `t_cron` VALUES ('1', '0/2 * * * * ?');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `perms` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123456', 'user:add');
INSERT INTO `t_user` VALUES ('2', 'lisi', '123456', 'user:update');
