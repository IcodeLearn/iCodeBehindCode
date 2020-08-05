-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: icodedatabase
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `adult_children`
--

DROP TABLE IF EXISTS `adult_children`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adult_children` (
  `adult_id` varchar(255) NOT NULL,
  `student_id` varchar(255) NOT NULL,
  PRIMARY KEY (`adult_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='瀹堕暱鍏宠仈瀛︾敓琛?細';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adult_children`
--

LOCK TABLES `adult_children` WRITE;
/*!40000 ALTER TABLE `adult_children` DISABLE KEYS */;
/*!40000 ALTER TABLE `adult_children` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adult_news`
--

DROP TABLE IF EXISTS `adult_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adult_news` (
  `use_uid` varchar(255) NOT NULL,
  `new_news_id` varchar(255) NOT NULL,
  `adult_news_reply` date DEFAULT NULL,
  PRIMARY KEY (`use_uid`,`new_news_id`),
  KEY `FK_adult_news2` (`new_news_id`),
  CONSTRAINT `FK_adult_news` FOREIGN KEY (`use_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_adult_news2` FOREIGN KEY (`new_news_id`) REFERENCES `news_bank` (`news_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='瀹堕暱娑堟伅绠＄悊琛?瀹堕暱鍥炲?鏃堕棿锛歛dult_news_reply';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adult_news`
--

LOCK TABLES `adult_news` WRITE;
/*!40000 ALTER TABLE `adult_news` DISABLE KEYS */;
/*!40000 ALTER TABLE `adult_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assitant_news`
--

DROP TABLE IF EXISTS `assitant_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assitant_news` (
  `use_uid` varchar(255) NOT NULL,
  `new_news_id` varchar(255) NOT NULL,
  `assitant_news_begin` date DEFAULT NULL,
  PRIMARY KEY (`use_uid`,`new_news_id`),
  KEY `FK_assitant_news2` (`new_news_id`),
  CONSTRAINT `FK_assitant_news` FOREIGN KEY (`use_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_assitant_news2` FOREIGN KEY (`new_news_id`) REFERENCES `news_bank` (`news_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='鏁欏笀/鍔╂暀-娑堟伅绠＄悊琛?鍙戝竷闂?嵎鏃堕棿锛歛ssitant_news_begin\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assitant_news`
--

LOCK TABLES `assitant_news` WRITE;
/*!40000 ALTER TABLE `assitant_news` DISABLE KEYS */;
/*!40000 ALTER TABLE `assitant_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `course_id` varchar(255) NOT NULL,
  `use_uid` varchar(255) DEFAULT NULL,
  `que_qsid` varchar(255) DEFAULT NULL,
  `cname` varchar(30) DEFAULT NULL,
  `cintroduce` varchar(255) DEFAULT NULL,
  `code` varchar(6) DEFAULT NULL,
  `cstate` int(11) DEFAULT NULL,
  `cyear` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FK_course_source` (`que_qsid`),
  KEY `FK_course_user` (`use_uid`),
  CONSTRAINT `FK_course_source` FOREIGN KEY (`que_qsid`) REFERENCES `source` (`source_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_course_user` FOREIGN KEY (`use_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='璇剧▼id:course_id\n璇剧▼鍚嶇О锛歝ourse_name\n璇剧▼浠嬬粛锛歝ourse_intr';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('1',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enclosure`
--

DROP TABLE IF EXISTS `enclosure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enclosure` (
  `enclosure_id` varchar(255) NOT NULL,
  `hom_homework_id` varchar(255) DEFAULT NULL,
  `enclosure_name` varchar(30) DEFAULT NULL,
  `enclosure_type` varchar(10) DEFAULT NULL,
  `enclosure_path` varchar(255) DEFAULT NULL,
  `enclosure_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`enclosure_id`),
  KEY `FK_homework_enclosure` (`hom_homework_id`),
  CONSTRAINT `FK_homework_enclosure` FOREIGN KEY (`hom_homework_id`) REFERENCES `homework` (`homework_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='闄勪欢\n闄勪欢id:enclosure_id\n闄勪欢鍚嶇О锛歟nclosure_name\n闄';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enclosure`
--

LOCK TABLES `enclosure` WRITE;
/*!40000 ALTER TABLE `enclosure` DISABLE KEYS */;
/*!40000 ALTER TABLE `enclosure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homework`
--

DROP TABLE IF EXISTS `homework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homework` (
  `homework_id` varchar(255) NOT NULL,
  `cou_course_id` varchar(255) DEFAULT NULL,
  `homework_name` varchar(30) DEFAULT NULL,
  `homework_content` varchar(255) DEFAULT NULL,
  `homework_begin` date DEFAULT NULL,
  PRIMARY KEY (`homework_id`),
  KEY `FK_course_homework` (`cou_course_id`),
  CONSTRAINT `FK_course_homework` FOREIGN KEY (`cou_course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='浣滀笟琛?浣滀笟id:homework_id\n浣滀笟鍚嶏細homework_name\n浣滀笟鍐';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homework`
--

LOCK TABLES `homework` WRITE;
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge`
--

DROP TABLE IF EXISTS `knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge` (
  `knowledge_id` varchar(255) NOT NULL,
  `knowledge_name` varchar(255) DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`knowledge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge`
--

LOCK TABLES `knowledge` WRITE;
/*!40000 ALTER TABLE `knowledge` DISABLE KEYS */;
INSERT INTO `knowledge` VALUES ('e6209162-c36e-49b2-8250-25a9c850d2d8','这是一次测试','1');
/*!40000 ALTER TABLE `knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge_point`
--

DROP TABLE IF EXISTS `knowledge_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge_point` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `is_root` tinyint(1) DEFAULT NULL,
  `knowledge_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_point`
--

LOCK TABLES `knowledge_point` WRITE;
/*!40000 ALTER TABLE `knowledge_point` DISABLE KEYS */;
INSERT INTO `knowledge_point` VALUES (2,'/1/2','知识点一',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(3,'/1/3','知识点二',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(4,'/1/4','知识点三',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(5,'/1/2/5','人为什么会死',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(6,'/1/2/6','人来自于哪里',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(7,'/1/3/7','缺铁吃铁',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(8,'/1/4/8','美丽新世界',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(9,'/1/4/9','你好',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(10,'/1/4/10','天气挺好',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(11,'/1/4/11','这个好难',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(12,'/1/4/10/12','明天会下雨',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(13,'/1/4/10/13','今天不会下雨',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(14,'/1/4/10/12/14','今天是晴天',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(15,'/1/4/10/12/15','今天不用带伞',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(16,'/1/4/10/13/16','明天记得带伞',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(17,'/1/4/10/12/15/17','阳光明媚',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(18,'/1/18','知识点四',0,'e6209162-c36e-49b2-8250-25a9c850d2d8'),(19,'/1','root',1,'e6209162-c36e-49b2-8250-25a9c850d2d8');
/*!40000 ALTER TABLE `knowledge_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news_bank`
--

DROP TABLE IF EXISTS `news_bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news_bank` (
  `news_id` varchar(255) NOT NULL,
  `news_title` varchar(255) DEFAULT NULL,
  `news_begin` date DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='娑堟伅\n娑堟伅id: news_id\n闂?嵎鏍囬?锛歯ews_title\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_bank`
--

LOCK TABLES `news_bank` WRITE;
/*!40000 ALTER TABLE `news_bank` DISABLE KEYS */;
/*!40000 ALTER TABLE `news_bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `pid` varchar(255) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK_role_permission` (`role_name`),
  CONSTRAINT `FK_role_permission` FOREIGN KEY (`role_name`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `question_id` varchar(255) NOT NULL,
  `question_text` varchar(255) DEFAULT NULL,
  `question_A` varchar(255) DEFAULT NULL,
  `question_B` varchar(255) DEFAULT NULL,
  `question_C` varchar(255) DEFAULT NULL,
  `question_D` varchar(255) DEFAULT NULL,
  `question_E` varchar(255) DEFAULT NULL,
  `question_F` varchar(255) DEFAULT NULL,
  `question_answer` varchar(255) DEFAULT NULL,
  `question_level` varchar(255) DEFAULT NULL,
  `question_parse` varchar(255) DEFAULT NULL,
  `question_type` varchar(255) DEFAULT NULL,
  `l_type` varchar(255) DEFAULT NULL,
  `source_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `FK_question_source` (`source_id`),
  CONSTRAINT `FK_question_source` FOREIGN KEY (`source_id`) REFERENCES `source` (`source_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_link_knowledge`
--

DROP TABLE IF EXISTS `question_link_knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_link_knowledge` (
  `question_id` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_link_knowledge`
--

LOCK TABLES `question_link_knowledge` WRITE;
/*!40000 ALTER TABLE `question_link_knowledge` DISABLE KEYS */;
INSERT INTO `question_link_knowledge` VALUES ('123',1),('123',2),('123',3),('456',1),('456',2),('456',3);
/*!40000 ALTER TABLE `question_link_knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` varchar(255) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('63409f78-6cf5-46b6-8787-41971e4d37fc','ROLE_teacher');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `source`
--

DROP TABLE IF EXISTS `source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `source` (
  `source_id` varchar(255) NOT NULL,
  `source_name` varchar(255) DEFAULT NULL,
  `source_type` varchar(255) DEFAULT NULL,
  `source_upload_time` date DEFAULT NULL,
  `source_path` varchar(255) DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`source_id`),
  KEY `FK_source_course` (`course_id`),
  KEY `FK_source_user` (`uid`),
  CONSTRAINT `FK_source_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_source_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `source`
--

LOCK TABLES `source` WRITE;
/*!40000 ALTER TABLE `source` DISABLE KEYS */;
/*!40000 ALTER TABLE `source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `test_id` varchar(255) NOT NULL,
  `cou_course_id` varchar(255) DEFAULT NULL,
  `test_name` varchar(255) DEFAULT NULL,
  `test_time` int(11) DEFAULT NULL,
  `test_begin` date DEFAULT NULL,
  `test_end` date DEFAULT NULL,
  PRIMARY KEY (`test_id`),
  KEY `FK_course_test` (`cou_course_id`),
  CONSTRAINT `FK_course_test` FOREIGN KEY (`cou_course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='娴嬭瘯id锛歵est_id\n娴嬭瘯鍚嶏細test_name\n娴嬭瘯鏃堕棿锛歵est_time\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_question`
--

DROP TABLE IF EXISTS `test_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_question` (
  `test_id` varchar(255) NOT NULL,
  `question_id` varchar(255) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  KEY `FK_question_test1` (`test_id`),
  KEY `FK_question_test2` (`question_id`),
  CONSTRAINT `FK_question_test1` FOREIGN KEY (`test_id`) REFERENCES `test` (`test_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_question_test2` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_question`
--

LOCK TABLES `test_question` WRITE;
/*!40000 ALTER TABLE `test_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` varchar(255) NOT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `utel` varchar(11) DEFAULT NULL,
  `ugender` varchar(2) DEFAULT NULL,
  `upassword` varchar(255) DEFAULT NULL,
  `uwenvarchart` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `FK_user_role` (`role_id`),
  CONSTRAINT `FK_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='鐢ㄦ埛瀹炰綋\n1. ID:uid\n2. 濮撳悕锛歶name\n3. 鎵嬫満鍙凤細utel\n                         -&';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('69e0299c-0998-41af-9a87-6a200d219bd6','63409f78-6cf5-46b6-8787-41971e4d37fc','test','xxxx',NULL,'$2a$10$7PwKC3xIOtTDM4yc89r4WOpnSdIUN/lm5Ki22fKHjPMfO98eK7bfq',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role_course`
--

DROP TABLE IF EXISTS `user_role_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role_course` (
  `role_name` varchar(255) NOT NULL,
  `use_uid` varchar(255) NOT NULL,
  `cou_course_id` varchar(255) NOT NULL,
  PRIMARY KEY (`role_name`,`use_uid`,`cou_course_id`),
  KEY `FK_user_role_course2` (`use_uid`),
  KEY `FK_user_role_course3` (`cou_course_id`),
  CONSTRAINT `FK_user_role_course` FOREIGN KEY (`role_name`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_role_course2` FOREIGN KEY (`use_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_role_course3` FOREIGN KEY (`cou_course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='鐢ㄦ埛鐨勮?绋嬭?鑹';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role_course`
--

LOCK TABLES `user_role_course` WRITE;
/*!40000 ALTER TABLE `user_role_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_test`
--

DROP TABLE IF EXISTS `user_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_test` (
  `use_uid` varchar(255) NOT NULL,
  `tes_test_id` varchar(255) NOT NULL,
  `ut_grade` int(11) DEFAULT NULL,
  `ut_state` varchar(255) DEFAULT NULL,
  `ut_begin` date DEFAULT NULL,
  PRIMARY KEY (`use_uid`,`tes_test_id`),
  KEY `FK_user_test2` (`tes_test_id`),
  CONSTRAINT `FK_user_test` FOREIGN KEY (`use_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_test2` FOREIGN KEY (`tes_test_id`) REFERENCES `test` (`test_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='鎴愮哗锛歶t_grade\n鐘舵?锛歶t_state\n瀛︾敓寮??绛旈?鏃堕棿锛歶t_begin';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_test`
--

LOCK TABLES `user_test` WRITE;
/*!40000 ALTER TABLE `user_test` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-05 22:48:02
