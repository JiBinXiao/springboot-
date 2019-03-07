/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : demo2

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-03-07 09:25:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `demo_log`
-- ----------------------------
DROP TABLE IF EXISTS `demo_log`;
CREATE TABLE `demo_log` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `clientIp` varchar(20) DEFAULT NULL COMMENT '客户端请求ip',
  `uri` varchar(100) DEFAULT NULL COMMENT '客户端请求路径',
  `type` varchar(50) DEFAULT '' COMMENT '终端请求方式,普通请求,ajax请求',
  `method` varchar(10) DEFAULT NULL COMMENT '请求方式method,post,get等',
  `classMethod` varchar(100) DEFAULT NULL COMMENT '请求的类及方法',
  `paramData` text COMMENT '请求参数内容,json',
  `sessionId` varchar(64) DEFAULT NULL COMMENT '请求接口唯一session标识',
  `createBy` varchar(100) DEFAULT NULL COMMENT '访问女用户',
  `createTime` datetime DEFAULT NULL COMMENT '请求时间',
  `returnTime` datetime DEFAULT NULL COMMENT '接口返回时间',
  `timeConsuming` int(11) DEFAULT NULL COMMENT '请求耗时毫秒单位',
  `httpStatusCode` varchar(4) DEFAULT NULL COMMENT '请求时httpStatusCode代码，如：200,400,404等',
  `exceptionMessage` text COMMENT '异常描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_log
-- ----------------------------
