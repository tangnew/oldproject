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
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `identity` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(4) COLLATE utf8_bin DEFAULT NULL,
  `batch_no` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `client` */

insert  into `client`(`id`,`created_time`,`updated_time`,`name`,`identity`,`gender`,`batch_no`) values ('376a21b0-93a1-4d38-8ea8-f74d060ab96c','2016-12-27 12:41:41','2016-12-27 12:41:41','asdadsad','121212','男','511dcb97-e2ab-4b4f-85d1-4cf0bb61b91d'),('4acfda4b-c708-481c-ac68-7afe5428e815','2016-12-27 13:07:49','2016-12-27 13:07:49','12','12','男','0ee483f3-5449-483f-9b7d-ca86357690ae'),('7041f759-0b46-4869-b136-299bf9e7876f','2016-12-27 12:41:41','2016-12-27 12:41:41','cxzczc','dsadsadasd','女','511dcb97-e2ab-4b4f-85d1-4cf0bb61b91d'),('fbf8ce1e-f1e2-4bad-b753-9fbf2693185f','2016-12-27 12:39:51','2016-12-27 12:39:51','2221','12','男','f92a7ead-aba1-42d9-9cfe-7cb98c6c19bc');

/*Table structure for table `client_house` */

DROP TABLE IF EXISTS `client_house`;

CREATE TABLE `client_house` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  `batch_no` varchar(36) COLLATE utf8_bin NOT NULL,
  `house_number` varchar(50) COLLATE utf8_bin NOT NULL,
  `house_thing` text COLLATE utf8_bin,
  `client_number` int(3) DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  `house_type` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `client_house` */

insert  into `client_house`(`id`,`created_time`,`updated_time`,`batch_no`,`house_number`,`house_thing`,`client_number`,`start_time`,`end_time`,`status`,`house_type`) values ('6c6542a1-e65b-4465-b8eb-d935543d7cc3','2016-12-27 13:07:49','2016-12-27 13:07:49','0ee483f3-5449-483f-9b7d-ca86357690ae','12','12',2,'2016-12-27 13:07:49',NULL,1,'twea'),('ba98dd70-b093-4e6b-86ce-35a7869cd215','2016-12-27 12:41:41','2016-12-27 12:43:35','511dcb97-e2ab-4b4f-85d1-4cf0bb61b91d','122','1dcsafa',2,'2016-12-27 12:41:41','2016-12-27 12:43:16',0,'单人间'),('ffc9667d-3fec-4c7f-9c1e-bdec87f0c650','2016-12-27 12:39:51','2016-12-27 12:43:23','f92a7ead-aba1-42d9-9cfe-7cb98c6c19bc','12','1212121',12,'2016-12-27 12:39:51',NULL,0,'单人间');

/*Table structure for table `house_type` */

DROP TABLE IF EXISTS `house_type`;

CREATE TABLE `house_type` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime DEFAULT NULL,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `description` text COLLATE utf8_bin,
  `status` int(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `house_type` */

insert  into `house_type`(`id`,`created_time`,`updated_time`,`name`,`description`,`status`) values ('352be33e-b82f-496b-96db-7bd2971c63b1','2016-12-27 11:04:47','2016-12-27 11:15:57','fdaf','fdafa',0),('3f4d5d10-f200-4cc5-9928-2cecdd4519eb','2016-12-27 10:57:26','2016-12-27 11:32:24','12','sda',0),('4c7f6ce2-79dc-4131-80c0-5445110e2088','2016-12-27 13:08:00','2016-12-27 13:08:00','1212','12',1),('63115cdc-19ec-4c51-a261-5327e9e5b4af','2016-12-27 13:02:46','2016-12-27 13:02:46','twea','as',1),('6beb1d67-9ea6-48e9-8148-222f0dae6bfc','2016-12-27 11:16:04','2016-12-27 11:25:17','fdasf','daf',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
