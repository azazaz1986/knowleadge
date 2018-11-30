/*
SQLyog v10.2 
MySQL - 5.7.21 : Database - knowleadge
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`knowleadge` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `knowleadge`;

/*Table structure for table `tag_table` */

DROP TABLE IF EXISTS `tag_table`;

CREATE TABLE `tag_table` (
  `tag_id` varchar(40) NOT NULL COMMENT 'tag主键',
  `tag_text` varchar(30) NOT NULL COMMENT 'tag内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'tag创建时间',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tag_table` */

insert  into `tag_table`(`tag_id`,`tag_text`,`create_time`) values ('0','234','2018-11-29 14:58:13'),('1','23454','2018-11-29 14:58:30'),('24d561a5-e45e-44ef-9e19-a27e66','342124','2018-11-29 15:47:39'),('c33f994a-afdb-4582-ac9e-0acfa9','ewt','2018-11-29 17:48:19'),('f220d0d5-7b9c-4da7-beba-8fe3b6','3424','2018-11-29 15:38:19');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
