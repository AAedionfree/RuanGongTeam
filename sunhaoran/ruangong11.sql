/*
 Navicat Premium Data Transfer

 Source Server         : sunhaoran
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : ruangong11

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/04/2020 20:21:30
*/

SET NAMES utf8mb4;
drop database if exists ruangong11 ;
create database ruangong11 ;
use ruangong11 ;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dev_fault
-- ----------------------------
DROP TABLE IF EXISTS `t_dev_fault`;
CREATE TABLE `t_dev_fault`  (
  `fault_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '故障编号',
  `dev_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备编号',
  `dev_work_sta` int(1) NULL DEFAULT NULL COMMENT '设备工作状态(1:空闲,2:出借)',
  `fault_sta` int(1) NULL DEFAULT NULL COMMENT '设备状态(1.正常,2.报废,3.故障,4.维修)',
  `duty_user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人id',
  `dodate` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更改日期,格式\"xxxxyear_xxmonth_xxday\"(24小时制)',
  PRIMARY KEY (`fault_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

alter table t_dev_fault comment '设备故障记录表';

-- ----------------------------
-- Table structure for t_dev_log
-- ----------------------------
DROP TABLE IF EXISTS `t_dev_log`;
CREATE TABLE `t_dev_log`  (
  `log_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志编号',
  `dev_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备编号',
  `dev_work_sta` int(1) NULL DEFAULT NULL COMMENT '设备工作状态(1:空闲,2:出借)',
  `dev_sta` int(1) NULL DEFAULT NULL COMMENT '设备状态(1:正常,2:报废,3:故障,4:维修)',
  `token_id` int(1) NULL DEFAULT NULL COMMENT '指令编号(1:借取,2:归还,3:修理,4:报废)',
  `token_sta` int(1) NULL DEFAULT NULL COMMENT '指令执行状态(1:执行成功,2:执行失败)',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行操作用户编号',
  `dodate` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更改日期,格式\"xxxxyear_xxmonth_xxday\"(24小时制)',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

alter table t_dev_log comment '设备日志记录表';

-- ----------------------------
-- Table structure for t_device
-- ----------------------------
DROP TABLE IF EXISTS `t_device`;
CREATE TABLE `t_device`  (
  `dev_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备编号',
  `dev_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备类别',
  `dev_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名称',
  `dev_mdl` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备型号',
  `dev_size` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备规格',
  `dev_prise` float(10, 2) NOT NULL COMMENT '设备单价',
  `dev_date` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购置日期,格式\"xxxxyear_xxmonth_xxday\"(24小时制)',
  `dev_prov` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产厂家',
  `dev_life` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '保质期',
  `buy_user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人id',
  `duty_user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人id',
  `dev_work_sta` int(1) NULL DEFAULT NULL COMMENT '设备工作状态(1:空闲,2:出借)',
  `dev_sta` int(1) NULL DEFAULT NULL COMMENT '设备状态(1:正常,2:报废,3:故障,4:维修)',
  PRIMARY KEY (`dev_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

alter table t_device comment '设备信息表';

SET FOREIGN_KEY_CHECKS = 1;
