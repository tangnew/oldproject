/*
SQLyog v10.2 
MySQL - 5.7.12-log : Database - hotel_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel_system` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `hotel_system`;

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '客户姓名',
  `identity` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '客户身份证号',
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  PRIMARY KEY (`id`,`identity`),
  UNIQUE KEY `index_identity` (`identity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户身份证信息';

/*Data for the table `client` */

/*Table structure for table `client_house` */

DROP TABLE IF EXISTS `client_house`;

CREATE TABLE `client_house` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `batch_no` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '批次号，这批次有多个客户',
  `house_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '房间id',
  `client_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户id',
  `start_time` datetime NOT NULL COMMENT '客户入住时间',
  `end_time` datetime DEFAULT NULL COMMENT '客户退房时间',
  `description` text COLLATE utf8_bin COMMENT '房间物品登记',
  `status` int(2) DEFAULT NULL COMMENT '该记录的状态，是否有效',
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  PRIMARY KEY (`id`,`start_time`,`created_time`,`updated_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户与房间的对应关系';

/*Data for the table `client_house` */

/*Table structure for table `house` */

DROP TABLE IF EXISTS `house`;

CREATE TABLE `house` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `number` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '房间号',
  `house_type_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '房间类型',
  `description` text COLLATE utf8_bin COMMENT '基本描述',
  `use_status` int(2) DEFAULT NULL COMMENT '当前房间使用状态',
  `created_time` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '记录最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_number` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='房间信息';

/*Data for the table `house` */

/*Table structure for table `house_type` */

DROP TABLE IF EXISTS `house_type`;

CREATE TABLE `house_type` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `name` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '类型名称',
  `description` text COLLATE utf8_bin COMMENT '简单描述',
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='房间类型表';

/*Data for the table `house_type` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
