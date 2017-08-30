/*
Navicat MySQL Data Transfer

Source Server         : mysql01
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : mydb2

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-08-29 15:13:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` varchar(23) DEFAULT NULL,
  `adminName` varchar(23) DEFAULT NULL,
  `adminPwd` varchar(23) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');
INSERT INTO `admin` VALUES ('2', 'adonai', 'adonai');

-- ----------------------------
-- Table structure for `client`
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `cardId` int(15) NOT NULL,
  `clientName` varchar(20) DEFAULT NULL,
  `clientAmount` int(20) DEFAULT NULL,
  PRIMARY KEY (`cardId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', 'owen', '100');
INSERT INTO `client` VALUES ('2', 'tim', '100');
INSERT INTO `client` VALUES ('3', 'sam', '100');
INSERT INTO `client` VALUES ('111', '中国惊奇先生', '111');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuId` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `password` varchar(15) NOT NULL,
  `major` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'owen', '男', '13509007535', '33', '四川内江', null, '123', '计算机应用');
INSERT INTO `student` VALUES ('10', 'aa', '男', '133009999012', '22', '湖南', null, '111', 'spark');
INSERT INTO `student` VALUES ('2', 'Ocean', '男', '13809786543', '23', '四川德阳', null, '123', '计算机科学');
INSERT INTO `student` VALUES ('3', 'Sam', '男', '13709555533', '26', '四川成都', null, '123', '软件工程');
INSERT INTO `student` VALUES ('4', 'Blue', '男', '13609896677', '21', '北京朝阳', null, '123', '电气自动化');
INSERT INTO `student` VALUES ('5', 'Stephen', '男', '13709557890', '18', '四川巴中', null, '123', '机电一体化');
INSERT INTO `student` VALUES ('6', 'Richle', '女', '13000557890', '38', '美国洛杉矶', null, '123', '大数据');
INSERT INTO `student` VALUES ('7', 'Tiantian', '女', '13300553300', '18', '日本火之国', null, '123', '人工智能');
INSERT INTO `student` VALUES ('8', 'Xiaoying', '女', '13300999900', '18', '日本火之国', null, '123', 'python');
INSERT INTO `student` VALUES ('9', 'adonai', '男', '13809786545', '21', '四川', null, '111', 'spark');

-- ----------------------------
-- Table structure for `student1`
-- ----------------------------
DROP TABLE IF EXISTS `student1`;
CREATE TABLE `student1` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student1
-- ----------------------------
INSERT INTO `student1` VALUES ('王振华', '121');
INSERT INTO `student1` VALUES ('aa', '111');
