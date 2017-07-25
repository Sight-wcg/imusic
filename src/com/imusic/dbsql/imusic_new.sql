-- MySQL dump 10.16  Distrib 10.2.7-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: imusic
-- ------------------------------------------------------
-- Server version	10.2.7-MariaDB-10.2.7+maria~xenial-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `albumID` int(11) NOT NULL AUTO_INCREMENT,
  `albumName` varchar(20) NOT NULL,
  `singerID` int(11) NOT NULL,
  `releaseDate` date DEFAULT NULL,
  `albumImg` varchar(100) NOT NULL DEFAULT 'system/image/defaultAlbum.jpg',
  `description` text NOT NULL,
  PRIMARY KEY (`albumID`),
  KEY `singerID` (`singerID`),
  CONSTRAINT `singerID` FOREIGN KEY (`singerID`) REFERENCES `singer` (`singerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `focus`
--

DROP TABLE IF EXISTS `focus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `focus` (
  `fanID` int(11) NOT NULL,
  `focusID` int(11) NOT NULL,
  `focusDate` date NOT NULL,
  PRIMARY KEY (`fanID`,`focusID`),
  KEY `userFocusUser_toUserID_fk` (`focusID`),
  CONSTRAINT `userFocusUser_fromUserID_fk` FOREIGN KEY (`fanID`) REFERENCES `user` (`userID`),
  CONSTRAINT `userFocusUser_toUserID_fk` FOREIGN KEY (`focusID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `focus`
--

LOCK TABLES `focus` WRITE;
/*!40000 ALTER TABLE `focus` DISABLE KEYS */;
/*!40000 ALTER TABLE `focus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list`
--

DROP TABLE IF EXISTS `list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list` (
  `listID` int(11) NOT NULL AUTO_INCREMENT,
  `creatorID` int(11) NOT NULL COMMENT '歌单创建者',
  `description` varchar(30) DEFAULT NULL,
  `createDate` date NOT NULL,
  `listName` varchar(20) NOT NULL,
  `listImage` varchar(50) NOT NULL DEFAULT 'system/image/List.jpg',
  `listAccessTimes` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`listID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='歌单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list`
--

LOCK TABLES `list` WRITE;
/*!40000 ALTER TABLE `list` DISABLE KEYS */;
/*!40000 ALTER TABLE `list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_comment`
--

DROP TABLE IF EXISTS `list_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list_comment` (
  `listCommentID` int(11) NOT NULL AUTO_INCREMENT,
  `listComment` varchar(100) NOT NULL COMMENT '歌单的评论内容',
  `listCommentDate` date NOT NULL,
  `userID` int(11) NOT NULL,
  `listID` int(11) NOT NULL,
  `agreeNumber` int(10) NOT NULL DEFAULT 10,
  PRIMARY KEY (`listCommentID`),
  KEY `playlistComment_user_userID_fk` (`userID`),
  KEY `playlistComment_playlist_playlistID_fk` (`listID`),
  CONSTRAINT `playlistComment_playlist_playlistID_fk` FOREIGN KEY (`listID`) REFERENCES `list` (`listID`),
  CONSTRAINT `playlistComment_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_comment`
--

LOCK TABLES `list_comment` WRITE;
/*!40000 ALTER TABLE `list_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_comment_reply`
--

DROP TABLE IF EXISTS `list_comment_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list_comment_reply` (
  `listCommentID` int(11) NOT NULL AUTO_INCREMENT,
  `replyContent` varchar(100) NOT NULL,
  `replyDate` date NOT NULL,
  `userID` int(11) NOT NULL,
  `listCommentReplyID` int(11) NOT NULL,
  `agreeNumber` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`listCommentID`),
  KEY `playlistCommentReply_user_userID_fk` (`userID`),
  KEY `playlistCommentReply_playlistComment_pCommentID_fk` (`listCommentReplyID`),
  CONSTRAINT `playlistCommentReply_playlistComment_pCommentID_fk` FOREIGN KEY (`listCommentReplyID`) REFERENCES `list_comment` (`listCommentID`),
  CONSTRAINT `playlistCommentReply_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_comment_reply`
--

LOCK TABLES `list_comment_reply` WRITE;
/*!40000 ALTER TABLE `list_comment_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_comment_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_song`
--

DROP TABLE IF EXISTS `list_song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list_song` (
  `listID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  PRIMARY KEY (`listID`,`songID`),
  KEY `songID` (`songID`),
  CONSTRAINT `playlistHasSong_ibfk_1` FOREIGN KEY (`listID`) REFERENCES `list` (`listID`),
  CONSTRAINT `playlistHasSong_ibfk_2` FOREIGN KEY (`songID`) REFERENCES `song` (`songID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_song`
--

LOCK TABLES `list_song` WRITE;
/*!40000 ALTER TABLE `list_song` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_tag`
--

DROP TABLE IF EXISTS `list_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list_tag` (
  `listID` int(11) NOT NULL,
  `tag` varchar(20) NOT NULL,
  PRIMARY KEY (`listID`,`tag`),
  CONSTRAINT `list_tag_list_listID_fk` FOREIGN KEY (`listID`) REFERENCES `list` (`listID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_tag`
--

LOCK TABLES `list_tag` WRITE;
/*!40000 ALTER TABLE `list_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listen_record`
--

DROP TABLE IF EXISTS `listen_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listen_record` (
  `userID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  `listenDate` date NOT NULL,
  PRIMARY KEY (`userID`,`songID`),
  KEY `songID` (`songID`),
  CONSTRAINT `userListenHistory_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `userListenHistory_ibfk_2` FOREIGN KEY (`songID`) REFERENCES `song` (`songID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listen_record`
--

LOCK TABLES `listen_record` WRITE;
/*!40000 ALTER TABLE `listen_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `listen_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `singer`
--

DROP TABLE IF EXISTS `singer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `singer` (
  `singerID` int(11) NOT NULL AUTO_INCREMENT,
  `singerName` varchar(20) NOT NULL,
  `singerGender` int(11),
  `nationality` varchar(20) DEFAULT NULL,
  `focusNumber` int(11) DEFAULT 0,
  `description` varchar(500) DEFAULT NULL,
  `image` varchar(50) NOT NULL DEFAULT 'system/image/singer.jpg',
  `age` varchar(10) DEFAULT 'NULL' COMMENT '年代-eg：90后',
  PRIMARY KEY (`singerID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `singer`
--

LOCK TABLES `singer` WRITE;
/*!40000 ALTER TABLE `singer` DISABLE KEYS */;
INSERT INTO `singer` VALUES (1,'戴荃',0,'中国',0,'China-soul（中国灵魂乐）风格创行者，C-pop、新国风独立音乐人，将古风、国风、戏曲、民族、民间等中国各元素融入流行音乐的灵魂歌者；集词、曲、唱、编、制作等才华于一身的全能音乐人。代表作《悟空》、《老神仙》、《渡人》、《喝汤》、《上海三月》。','image/singerImage/戴荃.jpg',NULL),(2,'Tez Cadey',1,'法国',0,'法国23岁音乐制作人，以《Seve》出名。','image/singerImage/2.jpg',NULL),(3,'陈绮贞',1,'中国台湾',0,'陳綺貞官方宣傳資訊交流站。個人官網：http://www.cheerego.com/ 經紀信箱：team.ear@gmail.com','image/singerImage/3.jpg',NULL),(4,'刘瑞琦',1,'中国',0,'华语流行唱作女歌手','image/singerImage/4.jpg',NULL),(5,'神马乐团',4,'中国',0,'许云上：歌手，音乐人，神马乐团男主唱，代表作《爱河》','image/singerImage/5.jpg',NULL),(6,'The Chainsmokers',4,'美国',0,'The Chainsmokers，是来自美国纽约的DJ组合。由成员安德鲁·塔格特和亚历克斯·鲍尔组成，2014年因一曲《#Selfie》而出名。','system/image/singer.jpg',NULL),(7,'周杰伦',1,'中国台湾',0,'著名歌手，音乐人，词曲创作人，编曲及制作人，MV及电影导演。新世纪华语歌坛领军人物，中国风歌曲始祖，被时代周刊誉为“亚洲猫王”，是2000年后亚洲流行乐坛最具革命性与指标性的创作歌手，亚洲销量超过3100万张，有“亚洲流行天王”之称，开启华语乐坛“R&B时代”与“流行乐中国风”的先河，周杰伦的出现打破了亚洲流行乐坛长年停滞不前的局面，为亚洲流行乐坛翻开了新的一页，是华语乐坛真正把R&B提升到主流高度的人物，引领华语乐坛革命整十年，改写了华语乐坛的流行方向。','system/image/singer.jpg',NULL),(8,'胡彦斌',1,'中国',0,'华语男歌手，音乐制作人。 工作联系太歌文化工作室：service@tigerhuclub.com','image/singerImage/8.jpg',NULL),(9,'丹妮',1,NULL,0,NULL,'system/image/singer.jpg',NULL),(10,'冯曦妤',1,'中国香港',0,'冯曦妤，（Fiona Fung ）香港歌手兼作词人，以歌声清脆而著名。1999年，16岁的冯曦妤加入陈光荣的音乐室，开始参与电影的配乐以及和音演唱的幕后工作。 2007年，她决定由幕后转移至幕前，并于2008年加盟SONY BMG进军乐坛，以冯曦妤作为艺名。代表作：《再见警察》，《我在那一角落患过伤风》等。','system/image/singer.jpg',NULL);
/*!40000 ALTER TABLE `singer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `song` (
  `songID` int(11) NOT NULL AUTO_INCREMENT,
  `songName` varchar(20) NOT NULL,
  `singerID` int(11) NOT NULL,
  `albumID` int(11) DEFAULT NULL,
  `songType` varchar(20) DEFAULT NULL,
  `songURL` varchar(100) DEFAULT NULL,
  `songDownTimes` int(11) DEFAULT 0,
  `songAccessTimes` int(11) NOT NULL DEFAULT 0,
  `imageURL` varchar(50) DEFAULT 'default.jpg',
  `singerName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`songID`),
  KEY `albumID` (`albumID`),
  CONSTRAINT `albumID` FOREIGN KEY (`albumID`) REFERENCES `album` (`albumID`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,'悟空',1,NULL,'国风','song/1.mp3',0,0,'default.jpg','戴荃'),(2,'seve',2,NULL,'burinning','song/2.mp3',0,0,'default.jpg','Tez Cadey'),(3,'我喜欢上你时的内心活动',3,NULL,'民谣','song/3.mp3',0,0,'default.jpg','陈绮贞'),(4,'房间',4,NULL,'情歌','song/4.mp3',0,0,'default.jpg','刘瑞琦'),(5,'爱河',5,NULL,'情歌','song/5.mp3',0,0,'default.jpg','神马乐团'),(6,'Something Just Like ',6,NULL,'电音','song/6.mp3',0,0,'default.jpg','The Chainsmokers'),(7,'夜的第七章',7,NULL,'安静','song/7.mp3',0,0,'default.jpg','周杰伦'),(8,'月光',8,NULL,'古风','song/8.mp3',0,0,'default.jpg','胡彦斌'),(9,'五百年沧海桑田',9,NULL,'游戏','song/9.mp3',0,0,'default.jpg','丹妮'),(10,'A Little Love',10,NULL,'memory','song/10.mp3',0,0,'default.jpg','冯曦妤'),(11,'Fade',11,NULL,'电音','song/11.mp3',0,0,'default.jpg','Alan Walker'),(12,'Sky',0,NULL,'电音','song/12.mp3',0,0,'default.jpg','Asher Book'),(13,'Unity',0,NULL,'电音','song/13.mp3',0,0,'default.jpg','TheFatRat'),(14,'Five Hours',0,NULL,'电音','song/14.mp3',0,0,'default.jpg','Deorro'),(15,'Seven',0,NULL,'电音','song/15.mp3',0,0,'default.jpg','Tobu'),(16,'Higher',0,NULL,'电音','song/16.mp3',0,0,'default.jpg','Tobu'),(17,'You',0,NULL,'电音','song/17.mp3',0,0,'default.jpg','Approaching Nirvana'),(18,'Life',0,NULL,'电音','song/18.mp3',0,0,'default.jpg','Tobu'),(19,'Masked Heroes',0,NULL,'电音','song/19.mp3',0,0,'default.jpg','Vexento'),(20,'Energy Drink',0,NULL,'电音','song/20.mp3',0,0,'default.jpg','Virtual Roit'),(21,'南山南',0,NULL,'民谣','song/21.mp3',0,0,'default.jpg','马頔'),(22,'平凡之路',0,NULL,'民谣','song/22.mp3',0,0,'default.jpg','朴树'),(23,'活着',0,NULL,'民谣','song/23.mp3',0,0,'default.jpg','郝云'),(24,'安河桥',0,NULL,'民谣','song/24.mp3',0,0,'default.jpg','宋冬野'),(25,'当你老了',0,NULL,'民谣','song/25.mp3',0,0,'default.jpg','赵照'),(26,'风吹麦浪',0,NULL,'民谣','song/26.mp3',0,0,'default.jpg','李健'),(27,'少年锦时',0,NULL,'民谣','song/27.mp3',0,0,'default.jpg','赵雷'),(28,'天空之城',0,NULL,'民谣','song/28.mp3',0,0,'default.jpg','李志'),(29,'莉莉安',0,NULL,'民谣','song/29.mp3',0,0,'default.jpg','宋冬野'),(30,'三十岁的女人',0,NULL,'民谣','song/30.mp3',0,0,'default.jpg','赵雷'),(31,'南方姑娘',0,NULL,'民谣','song/31.mp3',0,0,'default.jpg','赵雷'),(32,'男孩别哭',0,NULL,'民谣','song/32.mp3',0,0,'default.jpg','海龟先生'),(33,'Locked Away',0,NULL,'流行','song/33.mp3',0,0,'default.jpg','Sam Tsui'),(34,'Alive',0,NULL,'流行','song/34.mp3',0,0,'default.jpg','Bo Bruce'),(35,'Healer',0,NULL,'流行','song/35.mp3',0,0,'default.jpg','Kari Jobe'),(36,'Restless',0,NULL,'流行','song/36.mp3',0,0,'default.jpg','Audrey Assad'),(37,'I Know You Were Trou',0,NULL,'流行','song/37.mp3',0,0,'default.jpg','Madilyn Bailey'),(38,'Good to Be Alone',0,NULL,'流行','song/38.mp3',0,0,'default.jpg','Thomas Jonak'),(39,'That\'s What I Like',0,NULL,'流行','song/39.mp3',0,0,'default.jpg','Jason Chen'),(40,'Try',0,NULL,'流行','song/40.mp3',0,0,'default.jpg','Asher Book'),(41,'You Are Holy',0,NULL,'流行','song/41.mp3',0,0,'default.jpg','Nichole Nordeman'),(42,'Time',0,NULL,'流行','song/42.mp3',0,0,'default.jpg','Lena'),(43,'You Will Never Be',0,NULL,'流行','song/43.mp3',0,0,'default.jpg','Julia Sheer'),(44,'当爱已成往事',0,NULL,'华语','song/44.mp3',0,0,'default.jpg','张国荣'),(45,'海阔天空',0,NULL,'华语','song/45.mp3',0,0,'default.jpg','Beyond'),(46,'窗外',0,NULL,'华语','song/46.mp3',0,0,'default.jpg','李琛'),(47,'红豆',0,NULL,'华语','song/47.mp3',0,0,'default.jpg','王菲'),(48,'过火',0,NULL,'华语','song/48.mp3',0,0,'default.jpg','张信哲'),(49,'朋友',0,NULL,'华语','song/49.mp3',0,0,'default.jpg','周华健'),(50,'一剪梅',0,NULL,'华语','song/50.mp3',0,0,'default.jpg','费玉清'),(51,'忘情水',0,NULL,'华语','song/51.mp3',0,0,'default.jpg','刘德华'),(52,'心太软',0,NULL,'华语','song/52.mp3',0,0,'default.jpg','任贤齐'),(53,'假行僧',0,NULL,'华语','song/53.mp3',0,0,'default.jpg','崔健'),(54,'删除',0,NULL,'华语','song/54.mp3',0,0,'default.jpg','箱子君'),(55,'城府',0,NULL,'华语','song/55.mp3',0,0,'default.jpg','许嵩'),(56,'空心',0,NULL,'华语','song/56.mp3',0,0,'default.jpg','光泽'),(57,'依恋',0,NULL,'华语','song/57.mp3',0,0,'default.jpg','蔡淳佳'),(58,'有没有一首歌会让你想起我',0,NULL,'华语','song/58.mp3',0,0,'default.jpg','周华健'),(59,'从前慢',0,NULL,'民谣','song/59.mp3',0,0,'default.jpg','洪尘'),(60,'二十岁的某一天',0,NULL,'民谣','song/60.mp3',0,0,'default.jpg','花粥'),(61,'理想',0,NULL,'民谣','song/61.mp3',0,0,'default.jpg','赵雷'),(62,'童话镇',0,NULL,'流行','song/62.mp3',0,0,'default.jpg','陈一发儿'),(63,'刚好遇见你',0,NULL,'流行','song/63.mp3',0,0,'default.jpg','李玉刚'),(64,'红色高跟鞋',0,NULL,'流行','song/64.mp3',0,0,'default.jpg','蔡健雅'),(65,'她说',0,NULL,'流行','song/65.mp3',0,0,'default.jpg','林俊杰'),(66,'一次就好',0,NULL,'流行','song/66.mp3',0,0,'default.jpg','杨宗纬'),(67,'Lean On',0,NULL,'电音','song/67.mp3',0,0,'default.jpg','Major Lazer'),(68,'Intro',0,NULL,'电音','song/68.mp3',0,0,'default.jpg','The xx'),(69,'Take me hand',0,NULL,'电音','song/69.mp3',0,0,'default.jpg','DAISHI DANCE'),(70,'Hope',0,NULL,'电音','song/70.mp3',0,0,'default.jpg','Tobu');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song_comment`
--

DROP TABLE IF EXISTS `song_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `song_comment` (
  `commentID` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(100) NOT NULL,
  `commentDate` date NOT NULL,
  `userID` int(11) NOT NULL COMMENT '评论者',
  `songID` int(11) NOT NULL COMMENT '被评论的歌曲',
  `agreeNumber` int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`commentID`),
  KEY `songComment_user_userID_fk` (`userID`),
  KEY `songComment_song_songID_fk` (`songID`),
  CONSTRAINT `songComment_song_songID_fk` FOREIGN KEY (`songID`) REFERENCES `song` (`songID`),
  CONSTRAINT `songComment_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song_comment`
--

LOCK TABLES `song_comment` WRITE;
/*!40000 ALTER TABLE `song_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `song_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song_comment_reply`
--

DROP TABLE IF EXISTS `song_comment_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `song_comment_reply` (
  `replyID` int(11) NOT NULL AUTO_INCREMENT,
  `reply` varchar(100) NOT NULL,
  `replyDate` date NOT NULL,
  `userID` int(11) NOT NULL,
  `commentID` int(11) NOT NULL,
  `agreeNumber` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`replyID`),
  KEY `songCommentReply_user_userID_fk` (`userID`),
  KEY `songCommentReply_songComment_sCommentID_fk` (`commentID`),
  CONSTRAINT `songCommentReply_songComment_sCommentID_fk` FOREIGN KEY (`commentID`) REFERENCES `song_comment` (`commentID`),
  CONSTRAINT `songCommentReply_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song_comment_reply`
--

LOCK TABLES `song_comment_reply` WRITE;
/*!40000 ALTER TABLE `song_comment_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `song_comment_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `level` int(2) NOT NULL DEFAULT 0,
  `registerDate` date DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `headImage` varchar(30) DEFAULT 'system/image/default.jpg',
  `description` text DEFAULT NULL,
  `lastLoginDate` date NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `user_userName_uindex` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'yl','123','1@',0,3,0,NULL,NULL,NULL,'system/image/default.jpg',NULL,'0000-00-00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_collect_list`
--

DROP TABLE IF EXISTS `user_collect_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_collect_list` (
  `listID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `collectDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_collect_list`
--

LOCK TABLES `user_collect_list` WRITE;
/*!40000 ALTER TABLE `user_collect_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_collect_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_collect_song`
--

DROP TABLE IF EXISTS `user_collect_song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_collect_song` (
  `userID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  `collectDate` date NOT NULL,
  PRIMARY KEY (`userID`,`songID`),
  KEY `userCollectedSongs_song_songID_fk` (`songID`),
  CONSTRAINT `userCollectedSongs_song_songID_fk` FOREIGN KEY (`songID`) REFERENCES `song` (`songID`),
  CONSTRAINT `userCollectedSongs_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_collect_song`
--

LOCK TABLES `user_collect_song` WRITE;
/*!40000 ALTER TABLE `user_collect_song` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_collect_song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-25 10:26:10
