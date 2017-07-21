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
-- you can create database in this file if you want
-- eg: create database imusic;
--     use imusic;
--

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
  `albumCreateDate` date DEFAULT NULL,
  PRIMARY KEY (`albumID`),
  KEY `singerID` (`singerID`),
  CONSTRAINT `singerID` FOREIGN KEY (`singerID`) REFERENCES `singer` (`singerID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist` (
  `playlistID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL COMMENT '歌单创建者',
  `playlistDescription` varchar(30) DEFAULT NULL,
  `playlistCreateDate` date NOT NULL,
  PRIMARY KEY (`playlistID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='歌单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlistComment`
--

DROP TABLE IF EXISTS `playlistComment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlistComment` (
  `pCommentID` int(11) NOT NULL AUTO_INCREMENT,
  `pCommentContent` varchar(100) NOT NULL COMMENT '歌单的评论内容',
  `pCommentDate` date NOT NULL,
  `userID` int(11) NOT NULL,
  `playlistID` int(11) NOT NULL,
  PRIMARY KEY (`pCommentID`),
  KEY `playlistComment_user_userID_fk` (`userID`),
  KEY `playlistComment_playlist_playlistID_fk` (`playlistID`),
  CONSTRAINT `playlistComment_playlist_playlistID_fk` FOREIGN KEY (`playlistID`) REFERENCES `playlist` (`playlistID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `playlistComment_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlistComment`
--

LOCK TABLES `playlistComment` WRITE;
/*!40000 ALTER TABLE `playlistComment` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlistComment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlistCommentReply`
--

DROP TABLE IF EXISTS `playlistCommentReply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlistCommentReply` (
  `pCReplyID` int(11) NOT NULL AUTO_INCREMENT,
  `pCReplyContent` varchar(100) NOT NULL,
  `pCReplyDate` date NOT NULL,
  `userID` int(11) NOT NULL,
  `pCommentID` int(11) NOT NULL,
  PRIMARY KEY (`pCReplyID`),
  KEY `playlistCommentReply_playlistComment_pCommentID_fk` (`pCommentID`),
  KEY `playlistCommentReply_user_userID_fk` (`userID`),
  CONSTRAINT `playlistCommentReply_playlistComment_pCommentID_fk` FOREIGN KEY (`pCommentID`) REFERENCES `playlistComment` (`pCommentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `playlistCommentReply_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlistCommentReply`
--

LOCK TABLES `playlistCommentReply` WRITE;
/*!40000 ALTER TABLE `playlistCommentReply` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlistCommentReply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlistHasSong`
--

DROP TABLE IF EXISTS `playlistHasSong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlistHasSong` (
  `playlistID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  PRIMARY KEY (`playlistID`,`songID`),
  KEY `playlistHasSong_ibfk_2` (`songID`),
  CONSTRAINT `playlistHasSong_ibfk_1` FOREIGN KEY (`playlistID`) REFERENCES `playlist` (`playlistID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `playlistHasSong_ibfk_2` FOREIGN KEY (`songID`) REFERENCES `song` (`songID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlistHasSong`
--

LOCK TABLES `playlistHasSong` WRITE;
/*!40000 ALTER TABLE `playlistHasSong` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlistHasSong` ENABLE KEYS */;
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
  `singerGender` int(11) DEFAULT NULL,
  `singerNationality` varchar(20) DEFAULT NULL,
  `singerHotkey` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`singerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `singer`
--

LOCK TABLES `singer` WRITE;
/*!40000 ALTER TABLE `singer` DISABLE KEYS */;
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
  `albumID` int(11) DEFAULT NULL,
  `songType` varchar(20) DEFAULT NULL,
  `songURL` varchar(100) DEFAULT NULL,
  `songDownTimes` int(11) DEFAULT 0,
  `songAccessTimes` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`songID`),
  KEY `albumID` (`albumID`),
  CONSTRAINT `albumID` FOREIGN KEY (`albumID`) REFERENCES `album` (`albumID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songComment`
--

DROP TABLE IF EXISTS `songComment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `songComment` (
  `sCommentID` int(11) NOT NULL AUTO_INCREMENT,
  `sCommentContent` varchar(100) NOT NULL,
  `sCommentDate` date NOT NULL,
  `userID` int(11) NOT NULL COMMENT '评论者',
  `songID` int(11) NOT NULL COMMENT '被评论的歌曲',
  PRIMARY KEY (`sCommentID`),
  KEY `songComment_song_songID_fk` (`songID`),
  KEY `songComment_user_userID_fk` (`userID`),
  CONSTRAINT `songComment_song_songID_fk` FOREIGN KEY (`songID`) REFERENCES `song` (`songID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `songComment_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songComment`
--

LOCK TABLES `songComment` WRITE;
/*!40000 ALTER TABLE `songComment` DISABLE KEYS */;
/*!40000 ALTER TABLE `songComment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songCommentReply`
--

DROP TABLE IF EXISTS `songCommentReply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `songCommentReply` (
  `sCReplyID` int(11) NOT NULL AUTO_INCREMENT,
  `sCReplyContent` varchar(100) NOT NULL,
  `sCReplyDate` date NOT NULL,
  `userID` int(11) NOT NULL,
  `sCommentID` int(11) NOT NULL,
  PRIMARY KEY (`sCReplyID`),
  KEY `songCommentReply_songComment_sCommentID_fk` (`sCommentID`),
  KEY `songCommentReply_user_userID_fk` (`userID`),
  CONSTRAINT `songCommentReply_songComment_sCommentID_fk` FOREIGN KEY (`sCommentID`) REFERENCES `songComment` (`sCommentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `songCommentReply_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songCommentReply`
--

LOCK TABLES `songCommentReply` WRITE;
/*!40000 ALTER TABLE `songCommentReply` DISABLE KEYS */;
/*!40000 ALTER TABLE `songCommentReply` ENABLE KEYS */;
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
  `userPassword` varchar(20) NOT NULL,
  `userEmail` varchar(20) NOT NULL,
  `userGender` int(11) DEFAULT 3,
  `userRegisterDate` date DEFAULT curdate(),
  `userBirthday` date DEFAULT NULL,
  `userAddress` varchar(30) DEFAULT NULL,
  `userHeadPortrait` varchar(30) DEFAULT '''system/image/default.jpg''',
  `userDescription` text DEFAULT 'introduce yourself~',
  `userLastLoginDate` date DEFAULT curdate(),
  PRIMARY KEY (`userID`),
  UNIQUE KEY `user_userName_uindex` (`userName`),
  UNIQUE KEY `user_userID_uindex` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COMMENT='用户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userCollectedSongs`
--

DROP TABLE IF EXISTS `userCollectedSongs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userCollectedSongs` (
  `userID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  `collectedDate` date NOT NULL,
  PRIMARY KEY (`userID`,`songID`),
  KEY `userCollectedSongs_song_songID_fk` (`songID`),
  CONSTRAINT `userCollectedSongs_song_songID_fk` FOREIGN KEY (`songID`) REFERENCES `song` (`songID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userCollectedSongs_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userCollectedSongs`
--

LOCK TABLES `userCollectedSongs` WRITE;
/*!40000 ALTER TABLE `userCollectedSongs` DISABLE KEYS */;
/*!40000 ALTER TABLE `userCollectedSongs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userFocusUser`
--

DROP TABLE IF EXISTS `userFocusUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userFocusUser` (
  `fromUserID` int(11) NOT NULL,
  `toUserID` int(11) NOT NULL,
  `focusDate` date NOT NULL,
  PRIMARY KEY (`fromUserID`,`toUserID`),
  KEY `userFocusUser_toUserID_fk` (`toUserID`),
  CONSTRAINT `userFocusUser_fromUserID_fk` FOREIGN KEY (`fromUserID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userFocusUser_toUserID_fk` FOREIGN KEY (`toUserID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userFocusUser`
--

LOCK TABLES `userFocusUser` WRITE;
/*!40000 ALTER TABLE `userFocusUser` DISABLE KEYS */;
/*!40000 ALTER TABLE `userFocusUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userListenHistory`
--

DROP TABLE IF EXISTS `userListenHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userListenHistory` (
  `userID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  `listenDate` date NOT NULL,
  PRIMARY KEY (`userID`,`songID`),
  KEY `userListenHistory_ibfk_2` (`songID`),
  CONSTRAINT `userListenHistory_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userListenHistory_ibfk_2` FOREIGN KEY (`songID`) REFERENCES `song` (`songID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userListenHistory`
--

LOCK TABLES `userListenHistory` WRITE;
/*!40000 ALTER TABLE `userListenHistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `userListenHistory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-21 21:41:48
