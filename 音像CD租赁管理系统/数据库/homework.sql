/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : homework

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2023-07-03 13:58:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `administrator`
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_bin NOT NULL,
  `password` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'yigo', '123456');

-- ----------------------------
-- Table structure for `cd`
-- ----------------------------
DROP TABLE IF EXISTS `cd`;
CREATE TABLE `cd` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Cno` varchar(30) COLLATE utf8_bin NOT NULL,
  `Cname` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `Cauthor` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `Cprice` double(5,2) DEFAULT NULL,
  `Cnum` int DEFAULT NULL,
  `Cshelf` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `Cremark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cd
-- ----------------------------
INSERT INTO `cd` VALUES ('1', '1', '《臥虎藏龍》', '李安', '138.00', '2', '武侠电影', '一代大侠李慕白（周润发饰）有退出江湖之意，托付红颜知己俞秀莲（杨紫琼饰）将青冥剑转交给贝勒爷（郎雄饰）收藏，不料当夜遭玉娇龙（章子怡）窃取。俞秀莲暗中查访也大约知道是玉府小姐玉蛟龙所为，她想办法迫使玉蛟龙归还宝剑，免伤和气。但李慕白发现了害死师傅的碧眼狐狸（郑佩佩饰）的踪迹，她隐匿于玉府并收玉蛟龙为弟子。而玉蛟龙欲以青冥剑来斩断阻碍罗小虎（张震饰）的枷锁，他们私定终身。关系变得错综复杂，俞秀莲和李慕白爱惜玉蛟龙人才难得，苦心引导，但玉蛟龙却使性任气不听劝阻……');
INSERT INTO `cd` VALUES ('2', '2', '《BTTB》', '坂本龍一', '330.00', '5', '轻音乐', '1999年末，坂本龙一在日本推出了一张个人钢琴独奏专辑《BTTB》，这么张内敛静默的唱片竟然成了日本几乎人手一张的超级热卖碟。更有意思的是，《BTTB》中有一首名为“Energy Flow”（流动的能量）的曲子。当时，坂本写作它的时候是为某成药电视广告所作的配乐，可谁又想到坂本龙一完全的应景之作竟掀起了一阵抢购风潮。甚至，这张唱片的销售业绩大大超过了原本是主角的药片。可能这首带有法国印象派韵味的“Energy Flow”的疗效比该药片更胜一筹吧。坂本说：“这首曲子献给那些承受社会压力的人们。”');
INSERT INTO `cd` VALUES ('3', '3', '《瓦合》', '草东没有派对', '120.00', '2', '摇滚音乐', '草东2023年新专辑');
INSERT INTO `cd` VALUES ('4', '4', '《大象席地而坐》', '胡波', '180.00', '0', '剧情电影', '《大象席地而坐》是由胡波（笔名胡迁）执导的处女作，讲述在一座并不发达的河北小城中，四个陷入人生困境的人物寻求救赎的故事。');
INSERT INTO `cd` VALUES ('5', '5', '《霸王别姬》', '陈凯歌', '188.00', '4', '剧情电影', '　段小楼（张丰毅）与程蝶衣（张国荣）是一对打小一起长大的师兄弟，两人一个演生，一个饰旦，一向配合天衣无缝，尤其一出《霸王别姬》，更是誉满京城，为此，两人约定合演一辈子《霸王别姬》。但两人对戏剧与人生关系的理解有本质不同，段小楼深知戏非人生，程蝶衣则是人戏不分。');
INSERT INTO `cd` VALUES ('6', '6', '《重慶森林》', '王家卫', '160.00', '1', '剧情电影', '编号为223的警察（金城武）失恋后患上失恋综合症，在与金发女杀手（林青霞）擦肩而过又离奇相遇并有了一晚温情后，原本以为包括“爱情”在内的所有东西都有保质期的他意外地迎来心灵的短暂温暖。可是，他们的爱情还是结束了。');
INSERT INTO `cd` VALUES ('7', '7', '《冀西南林路行》', '万能青年旅店', '140.00', '2', '摇滚音乐', '《冀西南林路行》为总标题，以此延伸出三段独立作品，为泥河，采石，山雀');

-- ----------------------------
-- Table structure for `cdshelf`
-- ----------------------------
DROP TABLE IF EXISTS `cdshelf`;
CREATE TABLE `cdshelf` (
  `id` int NOT NULL AUTO_INCREMENT,
  `no` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `area` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `location` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cdshelf
-- ----------------------------
INSERT INTO `cdshelf` VALUES ('1', '1', '5平方', 'a区1号', '轻音乐', '古典音乐');
INSERT INTO `cdshelf` VALUES ('2', '2', '5平方', 'a区3号', '摇滚音乐', '近代摇滚');
INSERT INTO `cdshelf` VALUES ('3', '3', '5平方', 'b区6号', '剧情电影', '高票房剧情电影');
INSERT INTO `cdshelf` VALUES ('4', '4', '5平方', 'b区2号', '武侠电影', '高评分武侠电影');

-- ----------------------------
-- Table structure for `cd_appointment_relation`
-- ----------------------------
DROP TABLE IF EXISTS `cd_appointment_relation`;
CREATE TABLE `cd_appointment_relation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Vno` int DEFAULT NULL,
  `Cno` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cd_appointment_relation
-- ----------------------------
INSERT INTO `cd_appointment_relation` VALUES ('1', '1', '3');
INSERT INTO `cd_appointment_relation` VALUES ('2', '2', '5');
INSERT INTO `cd_appointment_relation` VALUES ('3', '2', '4');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Dno` varchar(30) COLLATE utf8_bin NOT NULL,
  `Dname` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '1', '会员');
INSERT INTO `department` VALUES ('2', '2', '超级会员');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Mno` varchar(30) COLLATE utf8_bin NOT NULL,
  `Mname` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `Mdept` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '1', '大学生', '会员');
INSERT INTO `major` VALUES ('2', '2', '律师', '超级会员');
INSERT INTO `major` VALUES ('3', '3', '教师', '超级会员');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sender` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `receiver` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `message` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', 'yigo', 'zzq', '您已超时欠费，请及时缴清欠款。', '2023-06-20');
INSERT INTO `notice` VALUES ('2', '张三', 'yifo', '您好，我想要续时。', '2023-06-22');
INSERT INTO `notice` VALUES ('3', 'zzq', 'yigo', '已较轻欠款。', '2023-06-25');
INSERT INTO `notice` VALUES ('4', 'admin', '1', '你们好', '2023-06-29');
INSERT INTO `notice` VALUES ('5', 'admin', '2', '你们好', '2023-06-29');
INSERT INTO `notice` VALUES ('6', '2', '张三', '我是zzq', '2023-06-29');
INSERT INTO `notice` VALUES ('7', '2', 'admin', '我是zzq', '2023-06-29');
INSERT INTO `notice` VALUES ('8', '1', '2', '我是张三', '2023-06-29');
INSERT INTO `notice` VALUES ('9', 'admin', '1', '您好', '2023-06-29');
INSERT INTO `notice` VALUES ('10', 'admin', '2', '您好', '2023-06-29');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Vno` int NOT NULL,
  `username` varchar(30) COLLATE utf8_bin NOT NULL,
  `password` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '张三', '123456');
INSERT INTO `user` VALUES ('2', '2', 'zzq', '123456');

-- ----------------------------
-- Table structure for `vip`
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Vno` int DEFAULT NULL,
  `Vname` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `Vage` int DEFAULT NULL,
  `Vsex` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `Vtel` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `Vmajor` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('1', '1', '张三', '30', '男', '13030303086', '律师');
INSERT INTO `vip` VALUES ('2', '2', 'zzq', '23', '男', '4564213212315', '大学生');

-- ----------------------------
-- Table structure for `vip_borrow_relation`
-- ----------------------------
DROP TABLE IF EXISTS `vip_borrow_relation`;
CREATE TABLE `vip_borrow_relation` (
  `id` int NOT NULL,
  `Vno` int DEFAULT NULL,
  `num` int DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of vip_borrow_relation
-- ----------------------------
INSERT INTO `vip_borrow_relation` VALUES ('1', '1', '2', '1');
INSERT INTO `vip_borrow_relation` VALUES ('2', '2', '6', '1');

-- ----------------------------
-- Table structure for `vip_cd_relation`
-- ----------------------------
DROP TABLE IF EXISTS `vip_cd_relation`;
CREATE TABLE `vip_cd_relation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Vno` int DEFAULT NULL,
  `Cno` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `renew` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of vip_cd_relation
-- ----------------------------
INSERT INTO `vip_cd_relation` VALUES ('1', '1', '3', '2023-05-03', '1');
INSERT INTO `vip_cd_relation` VALUES ('6', '2', '4', '2023-06-29', '0');
INSERT INTO `vip_cd_relation` VALUES ('7', '2', '1', '2023-06-29', '0');
INSERT INTO `vip_cd_relation` VALUES ('8', '2', '6', '2023-06-29', '0');

-- ----------------------------
-- Table structure for `vip_fine_relation`
-- ----------------------------
DROP TABLE IF EXISTS `vip_fine_relation`;
CREATE TABLE `vip_fine_relation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Vno` int DEFAULT NULL,
  `money` double(5,1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of vip_fine_relation
-- ----------------------------
INSERT INTO `vip_fine_relation` VALUES ('1', '2', '14.0');
