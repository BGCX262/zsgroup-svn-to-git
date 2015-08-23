/*
SQLyog Enterprise - MySQL GUI v7.11 
MySQL - 5.0.41-community-nt : Database - group
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`group` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `group`;

/*Table structure for table `customer` */

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(50) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `navigate` */

CREATE TABLE `navigate` (
  `id` int(20) NOT NULL auto_increment,
  `parentId` int(20) default NULL,
  `text` varchar(60) character set gbk default NULL,
  `number` int(20) default NULL,
  `leaf` int(2) default NULL,
  `href` varchar(50) character set gbk default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `news` */

CREATE TABLE `news` (
  `id` int(10) NOT NULL auto_increment,
  `title` varchar(240) collate utf8_bin default NULL,
  `path` varchar(240) collate utf8_bin default NULL,
  `content` text collate utf8_bin,
  `addtime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `test` */

CREATE TABLE `test` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `zs_news` */

CREATE TABLE `zs_news` (
  `id` varchar(20) collate utf8_bin NOT NULL COMMENT '唯一标识',
  `newsid` varchar(20) collate utf8_bin default NULL COMMENT '新闻分类标识',
  `title` varchar(200) collate utf8_bin default NULL COMMENT '标题',
  `slbt` varchar(120) collate utf8_bin default NULL COMMENT '缩略标题',
  `name` varchar(20) collate utf8_bin default NULL COMMENT '编辑人',
  `img_path` varchar(120) collate utf8_bin default NULL COMMENT '图片路径',
  `nrjy` text collate utf8_bin COMMENT '内容简要',
  `content` text collate utf8_bin COMMENT '详细内容',
  `click_count` bigint(20) default NULL COMMENT '点击次数',
  `tjnews` int(10) default '0' COMMENT '推荐新闻',
  `create_date` datetime default NULL COMMENT '发表日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `zs_newsclass` */

CREATE TABLE `zs_newsclass` (
  `news_id` varchar(20) collate utf8_bin NOT NULL,
  `lb_name` varchar(100) collate utf8_bin default NULL COMMENT '新闻类别名称',
  `create_date` datetime default NULL,
  PRIMARY KEY  (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
