/*
SQLyog Job Agent Version 8.32 Copyright(c) Webyog Softworks Pvt. Ltd. All Rights Reserved.


MySQL - 5.5.29 : Database - myshopping
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`myshopping` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `myshopping`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `aid` varchar(20) NOT NULL,
  `alogin` varchar(20) NOT NULL,
  `aname` varchar(20) DEFAULT NULL,
  `apass` varchar(20) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`aid`,`alogin`,`aname`,`apass`) values ('arac','arac','小王','arac'),('tom','tom','小李','tom'),('lucy','lucy','小路','lucy'),('michael','michael','迈克尔','michael');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `ctype` varchar(20) NOT NULL,
  `chot` tinyint(1) DEFAULT '0',
  `aid` varchar(20) NOT NULL,
  PRIMARY KEY (`cid`),
  KEY `Refaccount1` (`aid`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`cid`,`ctype`,`chot`,`aid`) values (10,'服装',1,'tom'),(2,'数码',1,'arac'),(3,'家电',1,'michael'),(4,'精品图书',1,'tom'),(11,'体育用品',0,'tom'),(6,'运动户外',0,'tomone');

/*Table structure for table `forder` */

DROP TABLE IF EXISTS `forder`;

CREATE TABLE `forder` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ftotal` double(18,1) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `fphone` varchar(20) NOT NULL,
  `fremark` varchar(50) NOT NULL,
  `femail` varchar(20) NOT NULL,
  `fpost` varchar(10) NOT NULL,
  `uid` int(11) NOT NULL,
  `aid` varchar(20) DEFAULT NULL,
  `sid` int(11) NOT NULL DEFAULT '1',
  `faddress` varchar(50) NOT NULL,
  PRIMARY KEY (`fid`),
  KEY `Refusers3` (`uid`),
  KEY `Refaccount5` (`aid`),
  KEY `Refstatus6` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=2011113007 DEFAULT CHARSET=utf8;

/*Data for the table `forder` */

insert  into `forder`(`fid`,`fdate`,`ftotal`,`fname`,`fphone`,`fremark`,`femail`,`fpost`,`uid`,`aid`,`sid`,`faddress`) values (2011113001,'2013-04-22 20:57:44',1200.0,'莉莉','15079688296','周六周日请不要发货哦亲','haiyasheji@163.com','343009',1,'arac',2,'井冈山大学北区'),(2011113002,'2013-04-22 21:02:10',689.0,'李宁','18679609364','请发申通快递哦亲','644004075@qq.com','343009',2,'tom',1,'井冈山大学南区'),(2011113003,'2013-05-05 17:29:24',11.1,'黄晓明','10010','good!','100000@qq.com','100000',2,NULL,1,'井大'),(2011113004,'2013-05-05 17:32:30',100.0,'王歌','15079688296','哈哈','644004075@qq.com','343009',2,NULL,1,'江西省吉安市井冈山大学北区32栋'),(2011113005,'2013-05-24 10:25:28',199.0,'王歌','15079688296','','644004075@qq.com','343009',2,NULL,1,'江西省吉安市井冈山大学北区32栋'),(2011113006,'2013-05-24 10:26:33',980.0,'王歌','15079688296','','644004075@qq.com','343009',2,NULL,1,'江西省吉安市井冈山大学北区32栋');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(20) NOT NULL,
  `gprice` double(18,1) NOT NULL,
  `gpic` varchar(100) NOT NULL,
  `gremark` varchar(500) NOT NULL,
  `gdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gxremark` varchar(1000) DEFAULT NULL,
  `giscommend` tinyint(1) NOT NULL DEFAULT '0',
  `gisopen` tinyint(1) NOT NULL DEFAULT '1',
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`gid`),
  KEY `Refcategory2` (`cid`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`gid`,`gname`,`gprice`,`gpic`,`gremark`,`gdate`,`gxremark`,`giscommend`,`gisopen`,`cid`) values (1,'手机',900.0,'1.jpg','简单易用','2013-04-21 22:04:35','性价比很高的产品',1,1,2),(2,'电脑',4000.0,'1.jpg','超极本','2013-04-21 22:05:50','四核8G内存超长待机',1,1,2),(3,'相机',5000.0,'1.jpg','尼康产品','2013-04-21 22:07:00','单反，您身边的摄影专家',1,1,2),(4,'平板',2000.0,'1.jpg','苹果平板','2013-04-21 22:08:37','苹果，荣享尊贵生活',1,1,2),(5,'女装',100.0,'1.jpg','美特斯邦威','2013-04-21 22:11:00','让您的夏天与众不同',1,1,10),(6,'男装',199.0,'1.jpg','贵人鸟','2013-04-21 22:12:14','商务品牌男装',1,1,10),(7,'内衣',66.0,'1.jpg','伊妹儿','2013-04-21 22:13:20','舒适您的生活每一天',1,1,10),(8,'童装',80.0,'1.jpg','老顽童','2013-04-21 22:14:36','让您的孩子拥有难忘的童年',1,1,10),(9,'厨电',201.0,'1.jpg','海尔','2013-04-21 22:16:40','卓越品质，值得信赖',1,1,3),(10,'视听',679.0,'1.jpg','华为','2013-04-21 22:17:21','精彩时刻，与您共享',1,1,3),(11,'净水',356.0,'1.jpg','保洁','2013-04-21 22:18:01','为您的健康生活保驾护航',1,1,3),(12,'个人护理',997.0,'1.jpg','李宁体育','2013-04-21 22:19:01','健康生活每一天，从锻炼开始',1,1,3),(13,'图书',22.0,'1.jpg','教科书','2013-04-21 22:20:08','清华大学出版社',1,1,4),(14,'电子书',3.0,'1.jpg','宜搜小说','2013-04-21 22:21:01','精彩书刊',1,1,4),(15,'文具',24.0,'1.jpg','文都','2013-04-21 22:22:14','为您的成功保驾护航',1,1,4),(16,'乐器',189.0,'1.jpg','尚艺','2013-04-21 22:23:41','艺术是一种人生景仰',1,1,4),(30,'水杯',10.5,'1.jpg','好看好用','2013-05-08 22:00:43','用了都说好！',0,0,10),(25,'护肤',89.0,'1.jpg','美容美肤','2013-04-22 16:25:40','木人牌',0,1,7),(26,'彩妆',346.0,'1.jpg','法国品牌','2013-04-22 16:26:42','精彩时刻怎能少了我',0,1,7),(27,'大宝SOD蜜',12.8,'1.jpg','保洁公司','2013-04-22 16:27:47','大宝，天天见!',0,0,7),(28,'功效',563.0,'1.jpg','美白','2013-04-22 16:28:42','美白，看得见',0,1,7);

/*Table structure for table `sorder` */

DROP TABLE IF EXISTS `sorder`;

CREATE TABLE `sorder` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `sprice` double(18,1) DEFAULT NULL,
  `snumber` int(11) DEFAULT NULL,
  `fid` int(11) NOT NULL,
  `gid` int(11) NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `Refforder4` (`fid`),
  KEY `Refgoods7` (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `sorder` */

insert  into `sorder`(`sid`,`sname`,`sprice`,`snumber`,`fid`,`gid`) values (1,'尼康数码相机',1200.0,1,2011113001,3),(2,'手机',689.0,1,2011113002,1),(3,'测试',11.1,1,2011113003,1),(4,'女装',100.0,1,2011113004,5),(5,'男装',199.0,1,2011113005,6),(6,'童装',80.0,1,2011113006,8),(7,'手机',900.0,1,2011113006,1);

/*Table structure for table `status` */

DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `status` */

insert  into `status`(`sid`,`status`) values (1,'未支付'),(2,'已支付'),(3,'废单');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `ulogin` varchar(20) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `upass` varchar(20) NOT NULL,
  `usex` varchar(4) NOT NULL,
  `uphone` varchar(20) DEFAULT NULL,
  `upost` varchar(20) DEFAULT NULL,
  `uemail` varchar(20) DEFAULT NULL,
  `uaddress` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`uid`,`ulogin`,`uname`,`upass`,`usex`,`uphone`,`upost`,`uemail`,`uaddress`) values (1,'huawei','华伟','huawei','男','18970672826','343009','11798234@qq.com','江西省吉安市井冈山大学北区32栋'),(2,'arac','王歌','arac','男','15079688296','343009','644004075@qq.com','江西省吉安市井冈山大学北区32栋'),(3,'toby','小陈','toby','男','18679609364','343009','170345678@qq.com','江西省吉安市井冈山大学北区32栋'),(4,'lily','小丽','lily','女','15979602933','343009','345555789@qq.com','江西省吉安市井冈山大学南区23栋'),(5,'wangge','wangge','wangge','女','13217968090','610396','644004075@qq.com','湖北省武汉市汉口区解放大道123号'),(6,'skyarac','skyarac','skyarac','女','13217968090','345007','644004075@qq.com','湖北省武汉市武昌区解放大道101号'),(8,'eric','瑞可','eric','男','010-6780327','100001','2285845368@qq.com','北京市朝阳区解放路11号'),(9,'Ali','阿狸','ali','女','010225876','010225','010225876@163.com','北京市朝阳区'),(10,'obma','奥巴马','obma','男','123456','123456','123456@163.com','美国.白宫');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
