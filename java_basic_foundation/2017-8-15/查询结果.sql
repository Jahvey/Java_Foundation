
/*
http://blog.csdn.net/tangtong1/article/details/70578482
Navicat MySQL Data Transfer

Source Server         : mysql01
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : mydb1

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-08-15 16:55:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(10) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(12) NOT NULL,
  `stu_age` int(11) NOT NULL,
  `stu_date` date NOT NULL,
  `stu_gender` varchar(4) NOT NULL,
  `stu_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '吴俊华', '12', '2017-04-07', '男', '科华北路移动营业厅');
INSERT INTO `student` VALUES ('3', 'adonai1', '12', '2017-05-07', '男', '外江');
INSERT INTO `student` VALUES ('4', '谢亚军1', '12', '2017-02-11', '男', '内江');
INSERT INTO `student` VALUES ('8', '吴俊华2', '12', '2017-02-11', '男', '外江');
INSERT INTO `student` VALUES ('9', 'adonai2', '12', '2017-04-07', '男', '华夏惊奇先生');
INSERT INTO `student` VALUES ('10', 'sky', '32', '2017-08-08', '女', '内江');
INSERT INTO `student` VALUES ('11', 'adonay3', '33', '2017-08-16', '男', '成都');
INSERT INTO `student` VALUES ('12', 'jenhvay', '23', '2017-08-16', '男', '内江');
INSERT INTO `student` VALUES ('13', 'jdddim', '24', '2017-08-16', '女', '成都');
INSERT INTO `student` VALUES ('15', 'jjim', '87', '2017-08-02', '女', '外江');
INSERT INTO `student` VALUES ('16', 'tjjim', '34', '2017-08-01', '男', '内江');
INSERT INTO `student` VALUES ('17', 'tttim', '76', '2017-08-05', '男', '成都');





# Host: localhost  (Version: 5.5.53)
# Date: 2017-08-15 11:27:57
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(10) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(12) NOT NULL,
  `stu_age` int(11) NOT NULL,
  `stu_date` date NOT NULL,
  `stu_gender` varchar(4) NOT NULL,
  `stu_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (2,'吴俊华',12,'2017-04-07','男','科华北路移动营业厅'),(3,'adonai1',12,'2017-05-07','男','外江'),(4,'谢亚军1',12,'2017-02-11','男','内江'),(8,'吴俊华2',12,'2017-02-11','男','外江'),(9,'adonai2',12,'2017-04-07','男','华夏惊奇先生'),(10,'sky',32,'2017-08-08','女','内江'),(11,'adonay3',33,'2017-08-16','男','成都'),(12,'jenhvay',23,'2017-08-16','男','内江');




use mydb1;
--1.获取websites表中name不以G开头的所有记录

SELECT * from websites WHERE name NOT like 'G%'

--2.获取websites表中name不包含G或者F的所有记录
SELECT * from websites WHERE name NOT like '%G%' and name not like '%F%' 
--SELECT * from websites WHERE name  like '%G%' or name  like '%F%' 

--1.获取websites表中name不以G开头的所有记录
--2.获取websites表中name不包含G或者F的所有记录
--3.选取 url 以字母 "https" 开始的所有网站
SELECT * from websites where url like 'https%'
select * from websites where url regexp 'https'
--4.选取 url 包含 "oo" 的所有网站：
SELECT * from websites where url like '%oo%'
select * from websites where url regexp 'o{2}'
--5.选取 name 以一个任意字符开始，然后是 "oogle" 的所有客户：
SELECT * from websites where name like '_oogle'
select * from websites where name REGEXP '^[a-zA-Z0-9_]oogle'
--6.选取 name 以 A 到 H 字母开头的网站：
SELECT * from websites where name  REGEXP  '^[A-H]'
--7.选取 name 不以 A 到 H 字母开头的网站：
SELECT * from websites where name  not REGEXP  '^[A-H]'
--8.选取student表中以name以im结尾首字母为j或者t的学生信息
SELECT * from student where stu_name   REGEXP  '^[jt][a-zA-Z]*(im)$'
SELECT * from student where stu_name   REGEXP  '^[jt].*(im)$'
SELECT * from student where stu_name   REGEXP  '^[jt][a-zA-Z]{0,}(im)$'
SELECT * from student where stu_name  like  '%im' and stu_name REGEXP '^[jk]'



