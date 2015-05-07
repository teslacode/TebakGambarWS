/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.6.16 : Database - tebakgambar
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tebakgambar` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `tebakgambar`;

/*Table structure for table `rf_soal` */

DROP TABLE IF EXISTS `rf_soal`;

CREATE TABLE `rf_soal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(500) DEFAULT NULL,
  `jawaban` varchar(500) DEFAULT NULL,
  `tema_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rf_soal` (`tema_id`),
  CONSTRAINT `FK_rf_soal` FOREIGN KEY (`tema_id`) REFERENCES `rf_tema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

/*Table structure for table `rf_tema` */

DROP TABLE IF EXISTS `rf_tema`;

CREATE TABLE `rf_tema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_player` int(11) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `tema_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_room` (`tema_id`),
  CONSTRAINT `FK_room` FOREIGN KEY (`tema_id`) REFERENCES `rf_tema` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `room_user` */

DROP TABLE IF EXISTS `room_user`;

CREATE TABLE `room_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) DEFAULT NULL,
  `player` varchar(500) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ready` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_room_user` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
