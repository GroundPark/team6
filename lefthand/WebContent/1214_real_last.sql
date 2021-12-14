-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: lefthand
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_admin_info`
--

DROP TABLE IF EXISTS `t_admin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_info` (
  `ai_idx` int NOT NULL AUTO_INCREMENT,
  `ai_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ai_pw` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `api_id` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ai_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ai_phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ai_tel` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ai_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ai_isact` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'y',
  `ai_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ai_id`),
  UNIQUE KEY `ai_idx` (`ai_idx`),
  KEY `fk_admin_info_api_id` (`api_id`),
  CONSTRAINT `fk_admin_info_api_id` FOREIGN KEY (`api_id`) REFERENCES `t_admin_part_info` (`api_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_info`
--

LOCK TABLES `t_admin_info` WRITE;
/*!40000 ALTER TABLE `t_admin_info` DISABLE KEYS */;
INSERT INTO `t_admin_info` VALUES (1,'admin1','1111','a','박지상','010-7418-5296','1111','admin1@lefthand.com','y','2021-11-17 11:06:19'),(2,'admin2','2222','b','윤무현','010-3692-5814','2222','admin2@lefthand.com','y','2021-11-17 11:06:20'),(3,'admin3','3333','c','이민지','010-7894-5612','3333','admin3@lefthand.com','y','2021-11-17 11:06:20'),(4,'admin4','4444','d','이예솔','010-3216-5498','4444','admin4@lefthand.com','y','2021-11-17 11:06:21'),(5,'admin5','5555','e','이장호','010-9638-5274','5555','admin5@lefthand.com','y','2021-11-17 11:06:22'),(6,'admin6','6666','f','이민현','010-2741-7412','6666','admin6@lefthand.com','y','2021-11-17 11:06:23');
/*!40000 ALTER TABLE `t_admin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin_menu`
--

DROP TABLE IF EXISTS `t_admin_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_menu` (
  `am_idx` int NOT NULL,
  `m_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`am_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_menu`
--

LOCK TABLES `t_admin_menu` WRITE;
/*!40000 ALTER TABLE `t_admin_menu` DISABLE KEYS */;
INSERT INTO `t_admin_menu` VALUES (1,'일정 관리'),(2,'관리자 관리'),(3,'회원 관리'),(4,'상품 관리'),(5,'도전펀딩 관리'),(6,'펀딩 관리'),(7,'주문 관리'),(8,'신고 관리'),(9,'고객센터'),(10,'통계');
/*!40000 ALTER TABLE `t_admin_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin_part_info`
--

DROP TABLE IF EXISTS `t_admin_part_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_part_info` (
  `api_id` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `api_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`api_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_part_info`
--

LOCK TABLES `t_admin_part_info` WRITE;
/*!40000 ALTER TABLE `t_admin_part_info` DISABLE KEYS */;
INSERT INTO `t_admin_part_info` VALUES ('a','마스터'),('b','인사'),('c','CS'),('d','상품'),('e','펀딩'),('f','마케팅');
/*!40000 ALTER TABLE `t_admin_part_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin_permission`
--

DROP TABLE IF EXISTS `t_admin_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_permission` (
  `ap_idx` int NOT NULL AUTO_INCREMENT,
  `ai_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `am_idx` int NOT NULL,
  `ap_pms` int DEFAULT '0',
  `ap_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ai_id`,`am_idx`),
  UNIQUE KEY `ap_idx` (`ap_idx`),
  KEY `fk_admin_permission_am_idx` (`am_idx`),
  CONSTRAINT `fk_admin_permission_ai_id` FOREIGN KEY (`ai_id`) REFERENCES `t_admin_info` (`ai_id`),
  CONSTRAINT `fk_admin_permission_am_idx` FOREIGN KEY (`am_idx`) REFERENCES `t_admin_menu` (`am_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_permission`
--

LOCK TABLES `t_admin_permission` WRITE;
/*!40000 ALTER TABLE `t_admin_permission` DISABLE KEYS */;
INSERT INTO `t_admin_permission` VALUES (1,'admin1',1,3,'2021-11-17 11:13:01'),(2,'admin1',2,3,'2021-11-17 11:13:02'),(3,'admin1',3,3,'2021-11-17 11:13:02'),(4,'admin1',4,3,'2021-11-17 11:13:03'),(5,'admin1',5,3,'2021-11-17 11:13:04'),(6,'admin1',6,3,'2021-11-17 11:13:05'),(7,'admin1',7,3,'2021-11-17 11:13:05'),(8,'admin1',8,3,'2021-11-17 11:13:06'),(9,'admin1',9,3,'2021-11-17 11:13:07'),(10,'admin1',10,3,'2021-11-17 11:13:09'),(11,'admin2',1,3,'2021-11-17 11:13:10'),(12,'admin2',2,3,'2021-11-17 11:13:11'),(13,'admin3',3,3,'2021-11-17 11:13:12'),(14,'admin3',8,3,'2021-11-17 11:13:13'),(15,'admin3',9,3,'2021-11-17 11:13:13'),(16,'admin4',4,3,'2021-11-17 11:13:14'),(17,'admin4',7,3,'2021-11-17 11:13:15'),(18,'admin5',5,3,'2021-11-17 11:13:16'),(19,'admin5',6,3,'2021-11-17 11:13:19'),(20,'admin5',10,3,'2021-11-17 11:13:21');
/*!40000 ALTER TABLE `t_admin_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin_schedule`
--

DROP TABLE IF EXISTS `t_admin_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_schedule` (
  `as_idx` int NOT NULL AUTO_INCREMENT,
  `ai_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `as_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `as_stime` char(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `as_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `as_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`as_idx`),
  KEY `fk_admin_schedule_ai_id` (`ai_id`),
  CONSTRAINT `fk_admin_schedule_ai_id` FOREIGN KEY (`ai_id`) REFERENCES `t_admin_info` (`ai_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_schedule`
--

LOCK TABLES `t_admin_schedule` WRITE;
/*!40000 ALTER TABLE `t_admin_schedule` DISABLE KEYS */;
INSERT INTO `t_admin_schedule` VALUES (1,'admin2','왼손잡이용 글러브 추가','2021-12-22 00:00','2021-12-22에 왼손잡이용 글러브가 추가됩니다.','2021-11-17 11:15:36'),(2,'admin2','왼손잡이용 칼 추가','2021-12-23 00:00','2021-12-23에 왼손잡이용 칼가 추가됩니다.','2021-11-17 11:15:37'),(3,'admin2','왼손잡이용 자 추가','2021-12-24 00:00','2021-12-24에 왼손잡이용 자가 추가됩니다.','2021-11-17 11:15:38'),(4,'admin1','title','2021-12-08 08:00','일정 테스트','2021-12-12 10:18:57'),(5,'admin1','title','2021-12-10 14:11','10일의 일정','2021-12-12 15:16:41'),(6,'admin1','title','2021-12-21 07:00','데이터를 입력','2021-12-12 15:16:52'),(7,'admin1','title','2021-12-09 00:00','허허','2021-12-13 13:09:34'),(8,'admin1','title','2021-12-09 00:00','허허2','2021-12-13 13:09:41'),(9,'admin1','title','2021-12-01 00:00','안녕하ㅔㅅ요','2021-12-13 16:51:43');
/*!40000 ALTER TABLE `t_admin_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_challenge_good`
--

DROP TABLE IF EXISTS `t_challenge_good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_challenge_good` (
  `cg_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ci_idx` int DEFAULT NULL,
  `cg_history` int NOT NULL,
  PRIMARY KEY (`cg_idx`),
  KEY `fk_challenge_good_mi_id` (`mi_id`),
  KEY `fk_challenge_good_ci_idx` (`ci_idx`),
  CONSTRAINT `fk_challenge_good_ci_idx` FOREIGN KEY (`ci_idx`) REFERENCES `t_challenge_info` (`ci_idx`),
  CONSTRAINT `fk_challenge_good_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_challenge_good`
--

LOCK TABLES `t_challenge_good` WRITE;
/*!40000 ALTER TABLE `t_challenge_good` DISABLE KEYS */;
INSERT INTO `t_challenge_good` VALUES (1,'eunbyul95',1,1),(2,'eunbyul95',1,0),(7,'chan135',12,1),(8,'chan135',12,0),(9,'chan135',12,1),(10,'chan135',12,0),(11,'chan135',12,1),(12,'chan135',12,0),(13,'chan135',12,1),(14,'chan135',12,0),(15,'chan135',12,1),(16,'chan135',12,0),(17,'chan135',12,1),(18,'chan135',12,1),(19,'chan135',12,1),(20,'chan135',12,0),(21,'chan135',12,1),(22,'chan135',12,0),(23,'chan135',12,1),(24,'chan135',10,1),(25,'chan135',4,0),(26,'chan135',8,1),(27,'chan135',1,0),(28,'chan135',1,0),(29,'chan135',1,0),(30,'chan135',12,0),(31,'chan135',12,0),(32,'chan135',12,0),(33,'chan135',12,0),(34,'chan135',1,0),(35,'chan135',1,0),(36,'chan135',12,1),(37,'chan135',12,1),(38,'chan135',12,1),(39,'chan135',12,1),(40,'chan135',12,1),(41,'chan135',12,1),(42,'chan135',1,1),(43,'chan135',1,1),(44,'chan135',12,1),(45,'chan135',12,1),(46,'chan135',12,0),(47,'chan135',12,1),(48,'chan135',12,0),(49,'chan135',12,1),(50,'chan135',12,0),(51,'chan135',12,1),(52,'chan135',12,0),(53,'chan135',12,1),(54,'chan135',12,0),(55,'chan135',12,1),(56,'chan135',12,0),(57,'chan135',12,1),(58,'chan135',12,0),(59,'chan135',12,1),(60,'chan135',12,0),(61,'chan135',4,1),(62,'chan135',4,0),(63,'chan135',3,1),(64,'chan135',3,0),(65,'chan135',3,1),(66,'chan135',3,0),(67,'chan135',3,1),(68,'chan135',3,0),(69,'chan135',3,1),(70,'chan135',3,0),(71,'chan135',3,1),(72,'chan135',3,0),(73,'chan135',3,1),(74,'chan135',3,0),(75,'chan135',3,1),(76,'chan135',3,0),(77,'chan135',3,1),(78,'chan135',20,1),(79,'chan135',20,0),(80,'chan135',20,1),(81,'chan135',1,0),(82,'chan135',1,1),(83,'chan135',1,0),(84,'chan135',1,1),(85,'chan135',1,0),(86,'chan135',33,1),(87,'chan135',33,0),(88,'chan135',3,0),(89,'chan135',34,1),(90,'chan135',35,1),(91,'chan135',36,1),(92,'chan135',37,1),(93,'chan135',39,1),(94,'chan135',39,0),(95,'chan135',38,1),(96,'chan135',38,0);
/*!40000 ALTER TABLE `t_challenge_good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_challenge_info`
--

DROP TABLE IF EXISTS `t_challenge_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_challenge_info` (
  `ci_idx` int NOT NULL,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ci_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ci_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ci_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ci_thum_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ci_good` int DEFAULT '0',
  `ci_sdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `ci_edate` datetime DEFAULT NULL,
  `ci_step` int DEFAULT '1',
  `ci_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `ci_isview` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'y',
  PRIMARY KEY (`ci_idx`),
  KEY `fk_challenge_mi_id` (`mi_id`),
  CONSTRAINT `fk_challenge_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_challenge_info`
--

LOCK TABLES `t_challenge_info` WRITE;
/*!40000 ALTER TABLE `t_challenge_info` DISABLE KEYS */;
INSERT INTO `t_challenge_info` VALUES (1,'chan135','왼손잡이용 디자인 문구 세트','왼손을 사용하는 사람들을 만나면 그렇게 반가울 수가 없습니다. TV에 출연한 유명인이 왼손을 사용하면 이상하게도 눈에 잘 들어오더군요. 이들을 보면 동질감이 느껴지면서도, 한편으로는 측은한 마음이 들기도 합니다. 저들도 나와 비슷한 불편함을 겪고 있겠구나 하는 생각이 절로 들기 때문입니다.허허 아님말구\r\n\r\n\r\n사실 평범한 일상생활을 하지 못할 정도로 불편한 것은 아닙니다. 정말 소소하고 작은 곳에서 불편함이 찾아오곤 하죠. 오른손에 맞게 설계된 가위를 왼손으로 사용하다 보면 손가락이 금세 저려온다든지, 새로 산 휴대폰 다이어리 케이스를 끼웠다가 왼손으로 열고 닫는 것이 불편해 바로 빼버린다든지 하는 정도입니다. 서울에 갓 상경했을 땐 왼손으로 교통카드를 찍은 채 오른쪽 지하철 개찰구를 빠져나가려다 쇠막대기에 배를 강타당한 뼈아픈 기억도 있습니다.\r\n\r\n\r\n언젠가 커뮤니티 게시판에서 왼손잡이들이 생활 속 불편함을 토로한 글을 읽으며 엄청나게 공감한 적이 있습니다. 그리고 이런 불편함은 왜 우리만 감수해야 하는지, 왜 우리는 쉽게 배려받지 못하는 것인지 의아한 마음이 들었습니다. 인류의 대략 10%가 왼손잡이라는데, 세상 모든 물건의 10%는 왜 왼손잡이용이 아닌걸까요? 대한민국의 왼손잡이 인구는 대략 250만명정도로 추정된다는데, 이들을 위한 왼손잡이 전용 물품은 과연 실생활에서 쉽게 만날 수 있을까요. 궁금한 마음만 가득합니다\r\n\r\n\r\n생활용품을 취급하는 잡화점도 방문해 봤습니다. 평상시 가장 큰 불편함을 느꼈던 가위 판매대부터 찾아가봤습니다. 대략 열 종류 정도의 가위 중 왼손잡이용 가위는 하나도 없었습니다. 대형 서점의 문구 코너에 방문해서야 겨우 일본제 왼손전용 가위 한 종류를 발견할 수 있었습니다. 숟가락, 젓가락이 진열된 판매대에서 유아용 젓가락 교정기를 발견하고 꺼내봤습니다. 손에 잡히는 것은 모두 오른손용이었습니다. 끝까지 들춰봤지만 왼손용은 하나도 찾을 수 없었습니다.\r\n\r\n\r\n            \r\n            \r\n            \r\n            \r\n            \r\n            \r\n            \r\n            \r\n            \r\n            \r\n            \r\n            ','chal_info_1.jpg','thum_chal_info_1.jpg',18,'2021-12-12 12:33:04','2021-12-19 12:33:04',1,'a','y'),(2,'chan135','시연용 이미지 null','시연용 텍스트 내용','null','null',0,'2021-12-04 22:13:16','2021-12-11 22:13:04',1,'a','y'),(3,'hah228','시연용 2차 넘기기용 테스트','시연용 1차 -> 2차 내용입니다\r\n            ','chal_test_101.jpg','chal_test_101.jpg',50,'2021-12-14 02:11:41','2022-01-14 02:11:41',2,'a','y'),(4,'hanbi1','시연용 2차 테스트','시연용 2차 내용입니다','chal_test_102.jpg','chal_test_102.jpg',179,'2021-12-04 22:13:16','2021-12-28 22:13:04',2,'a','y'),(5,'khb83249','시연용 마감 테스트','시연용 1차 마감 내용입니다','chal_test_103.jpg','chal_test_103.jpg',100,'2021-11-22 22:13:16','2021-12-11 22:13:04',1,'b','y'),(6,'lee193','시연용 확정 테스트','시연용 2차 확정 내용입니다','chal_test_104.jpg','chal_test_104.jpg',500,'2021-11-14 22:13:16','2021-12-14 22:13:04',2,'c','y'),(7,'sj2348','왼손잡이용 크림메이더','사실 평범한 일상생활을 하지 못할 정도로 불편한 것은 아닙니다. 정말 소소하고 작은 곳에서 불편함이 찾아오곤 하죠. 오른손에 맞게 설계된 가위를 왼손으로 사용하다 보면 손가락이 금세 저려온다든지, 새로 산 휴대폰 다이어리 케이스를 끼웠다가 왼손으로 열고 닫는 것이 불편해 바로 빼버린다든지 하는 정도입니다. 서울에 갓 상경했을 땐 왼손으로 교통카드를 찍은 채 오른쪽 지하철 개찰구를 빠져나가려다 쇠막대기에 배를 강타당한 뼈아픈 기억도 있습니다.\r\n\r\n\n\n\n언젠가 커뮤니티 게시판에서 왼손잡이들이 생활 속 불편함을 토로한 글을 읽으며 엄청나게 공감한 적이 있습니다. 그리고 이런 불편함은 왜 우리만 감수해야 하는지, 왜 우리는 쉽게 배려받지 못하는 것인지 의아한 마음이 들었습니다. 인류의 대략 10%가 왼손잡이라는데, 세상 모든 물건의 10%는 왜 왼손잡이용이 아닌걸까요? 대한민국의 왼손잡이 인구는 대략 250만명정도로 추정된다는데, 이들을 위한 왼손잡이 전용 물품은 과연 실생활에서 쉽게 만날 수 있을까요. 궁금한 마음만 가득합니다\r\n\r\n\n','chal_test_107.jpg','chal_test_107.jpg',23,'2021-12-06 22:13:16','2021-12-06 22:13:04',1,'b','y'),(8,'park90','왼손배려용 주방용품','사실 평범한 일상생활을 하지 못할 정도로 불편한 것은 아닙니다. 정말 소소하고 작은 곳에서 불편함이 찾아오곤 하죠. 오른손에 맞게 설계된 가위를 왼손으로 사용하다 보면 손가락이 금세 저려온다든지, 새로 산 휴대폰 다이어리 케이스를 끼웠다가 왼손으로 열고 닫는 것이 불편해 바로 빼버린다든지 하는 정도입니다. 서울에 갓 상경했을 땐 왼손으로 교통카드를 찍은 채 오른쪽 지하철 개찰구를 빠져나가려다 쇠막대기에 배를 강타당한 뼈아픈 기억도 있습니다.\r\n\r\n\n\n\n언젠가 커뮤니티 게시판에서 왼손잡이들이 생활 속 불편함을 토로한 글을 읽으며 엄청나게 공감한 적이 있습니다. 그리고 이런 불편함은 왜 우리만 감수해야 하는지, 왜 우리는 쉽게 배려받지 못하는 것인지 의아한 마음이 들었습니다. 인류의 대략 10%가 왼손잡이라는데, 세상 모든 물건의 10%는 왜 왼손잡이용이 아닌걸까요? 대한민국의 왼손잡이 인구는 대략 250만명정도로 추정된다는데, 이들을 위한 왼손잡이 전용 물품은 과연 실생활에서 쉽게 만날 수 있을까요. 궁금한 마음만 가득합니다\r\n\r\n\n','chal_test_108.jpg','chal_test_108.jpg',2,'2021-12-05 22:13:16','2021-12-12 22:13:04',1,'a','y'),(9,'luo391','형광등 양손잡이용','저는 왼손잡이입니다. 조금 더 정확히 말하자면 왼손을 쓰는 게 훨씬 편한 양손잡이입니다. 젓가락질과 연필을 쥐는 것 외에 모든 일상생활에서 왼손을 사용하고 있습니다. 어렸을 때 부모님이, 학교 선생님이 오른손을 쓰라고 가르치지 않았다면 지금쯤 왼손으로 젓가락과 연필을 쥐고 있을지도 모릅니다\r\n\r\n\n\n\n왼손을 사용하는 사람들을 만나면 그렇게 반가울 수가 없습니다. TV에 출연한 유명인이 왼손을 사용하면 이상하게도 눈에 잘 들어오더군요. 이들을 보면 동질감이 느껴지면서도, 한편으로는 측은한 마음이 들기도 합니다. 저들도 나와 비슷한 불편함을 겪고 있겠구나 하는 생각이 절로 들기 때문입니다.\r\n\r\n','chal_test_109.jpg','chal_test_109.jpg',82,'2021-11-04 22:13:16','2021-12-04 22:13:04',2,'b','y'),(10,'kty8294','왼손 특화 낚시바늘','저는 왼손잡이입니다. 조금 더 정확히 말하자면 왼손을 쓰는 게 훨씬 편한 양손잡이입니다. 젓가락질과 연필을 쥐는 것 외에 모든 일상생활에서 왼손을 사용하고 있습니다. 어렸을 때 부모님이, 학교 선생님이 오른손을 쓰라고 가르치지 않았다면 지금쯤 왼손으로 젓가락과 연필을 쥐고 있을지도 모릅니다\r\n\r\n\n\n\n왼손을 사용하는 사람들을 만나면 그렇게 반가울 수가 없습니다. TV에 출연한 유명인이 왼손을 사용하면 이상하게도 눈에 잘 들어오더군요. 이들을 보면 동질감이 느껴지면서도, 한편으로는 측은한 마음이 들기도 합니다. 저들도 나와 비슷한 불편함을 겪고 있겠구나하는 생각이 절로 들기 때문입니다.\r\n\r\n','chal_test_110.jpg','chal_test_110.jpg',37,'2021-12-03 22:13:16','2021-12-10 22:13:04',1,'a','y'),(11,'jang086','공업용 양손 걸게','다이슨이 전기차를 개발할 당시, VR 기술이 적용된 분야는 다양한데요. 크게는 가상 시뮬레이션 기술을 활용한 주행 경험이 있습니다. \n다이슨에서는 완전한 가상 시뮬레이션 기술을 통해 엔지니어가 직접 운전석에 앉아 핸들을 잡고 주행을 하고, 어깨 너머로 뒤를 본다거나 차량 내부와 외부의 주변 환경을 관찰하며 주차까지 해 볼 수 있도록 구현했다고 합니다.\r\n\n\n제임스 다이슨은 처음 가상 현실에서 차를 운전해 보았을 때, 헤어 드라이어나 무선 청소기 프로토타입을 처음 사용했을 때와 같은 느낌을 받았다. 체험하면서 곧바로 어떤 점이 개선되어야 할지 보였다 라고 전했습니다. \n시뮬레이션을 할 때는 정확하고 뚜렷하게 보이는 것이 중요한데, 시간이 지나면서 VR의 시각적 해상도가 점차 개선되어 \n차량 내 인터페이스를 더욱 집중적으로 연구하고 분석할 수 있게 되었다고 합니다.\r\n','chal_test_111.jpg','chal_test_111.jpg',120,'2021-11-06 22:13:16','2021-12-06 22:13:04',2,'b','y'),(12,'chan135','카본 폴더 무지개색','생활용품을 취급하는 잡화점도 방문해 봤습니다. 평상시 가장 큰 불편함을 느꼈던 가위 판매대부터 찾아가봤습니다. 대략 열 종류 정도의 가위 중 왼손잡이용 가위는 하나도 없었습니다. 대형 서점의 문구 코너에 방문해서야 겨우 일본제 왼손전용 가위 한 종류를 발견할 수 있었습니다. 숟가락, 젓가락이 진열된 판매대에서 유아용 젓가락 교정기를 발견하고 꺼내봤습니다. 손에 잡히는 것은 모두 오른손용이었습니다. 끝까지 들춰봤지만 왼손용은 하나도 찾을 수 없었습니다.\r\n\r\n\n\n사실 평범한 일상생활을 하지 못할 정도로 불편한 것은 아닙니다. 정말 소소하고 작은 곳에서 불편함이 찾아오곤 하죠. 오른손에 맞게 설계된 가위를 왼손으로 사용하다 보면 손가락이 금세 저려온다든지, 새로 산 휴대폰 다이어리 케이스를 끼웠다가 왼손으로 열고 닫는 것이 불편해 바로 빼버린다든지 하는 정도입니다. 서울에 갓 상경했을 땐 왼손으로 교통카드를 찍은 채 오른쪽 지하철 개찰구를 빠져나가려다 쇠막대기에 배를 강타당한 뼈아픈 기억도 있습니다.\r\n\r\n','chal_test_112.jpg','chal_test_112.jpg',15,'2021-12-07 22:13:16','2021-12-14 22:13:04',1,'a','y'),(13,'chan135','왼손잡이용 집게','제임스 다이슨은 처음 가상 현실에서 차를 운전해 보았을 때, 헤어 드라이어나 무선 청소기 프로토타입을 처음 사용했을 때와 같은 느낌을 받았다. 체험하면서 곧바로 어떤 점이 개선되어야 할지 보였다 라고 전했습니다. \n시뮬레이션을 할 때는 정확하고 뚜렷하게 보이는 것이 중요한데, 시간이 지나면서 VR의 시각적 해상도가 점차 개선되어 \n차량 내 인터페이스를 더욱 집중적으로 연구하고 분석할 수 있게 되었다고 합니다.\r\n\n\n언젠가 커뮤니티 게시판에서 왼손잡이들이 생활 속 불편함을 토로한 글을 읽으며 엄청나게 공감한 적이 있습니다. 그리고 이런 불편함은 왜 우리만 감수해야 하는지, 왜 우리는 쉽게 배려받지 못하는 것인지 의아한 마음이 들었습니다. 인류의 대략 10%가 왼손잡이라는데, 세상 모든 물건의 10%는 왜 왼손잡이용이 아닌걸까요? 대한민국의 왼손잡이 인구는 대략 250만명정도로 추정된다는데, 이들을 위한 왼손잡이 전용 물품은 과연 실생활에서 쉽게 만날 수 있을까요. 궁금한 마음만 가득합니다\r\n\r\n','chal_test_113.jpg','chal_test_113.jpg',432,'2021-10-03 22:13:16','2021-11-02 22:13:04',2,'c','y'),(14,'chan135','양손잡이용 미싱책장','제임스 다이슨은 처음 가상 현실에서 차를 운전해 보았을 때, 헤어 드라이어나 무선 청소기 프로토타입을 처음 사용했을 때와 같은 느낌을 받았다. 체험하면서 곧바로 어떤 점이 개선되어야 할지 보였다 라고 전했습니다. \n시뮬레이션을 할 때는 정확하고 뚜렷하게 보이는 것이 중요한데, 시간이 지나면서 VR의 시각적 해상도가 점차 개선되어 \n차량 내 인터페이스를 더욱 집중적으로 연구하고 분석할 수 있게 되었다고 합니다.\r\n\n\n언젠가 커뮤니티 게시판에서 왼손잡이들이 생활 속 불편함을 토로한 글을 읽으며 엄청나게 공감한 적이 있습니다. 그리고 이런 불편함은 왜 우리만 감수해야 하는지, 왜 우리는 쉽게 배려받지 못하는 것인지 의아한 마음이 들었습니다. 인류의 대략 10%가 왼손잡이라는데, 세상 모든 물건의 10%는 왜 왼손잡이용이 아닌걸까요? 대한민국의 왼손잡이 인구는 대략 250만명정도로 추정된다는데, 이들을 위한 왼손잡이 전용 물품은 과연 실생활에서 쉽게 만날 수 있을까요. 궁금한 마음만 가득합니다\r\n\r\n','chal_test_114.jpg','chal_test_114.jpg',47,'2021-11-27 22:13:16','2021-12-04 22:13:04',1,'b','y'),(15,'chan135','시연용 제목 이미지 있음','시연용 텍스트 내용ㄹㄹㄹ','null','null',0,'2021-12-09 15:12:12','2021-12-16 15:12:07',1,'b','n'),(16,'chan135','시연용 제목ㄹㅈㄹ','시연용 텍스트 내용ㅈㄷㄹ','나도공지나한번.png','나도공지나한번.png',0,'2021-12-09 15:13:20','2021-12-16 15:13:11',2,'c','n'),(17,'chan135','시연용 제목ㅂㅈㅇ','시연용 텍스트 내용ㅂㅈㅇ','업로드 테스트용 이미지.jpg','업로드 테스트용 이미지.jpg',0,'2021-12-09 15:13:57','2021-12-16 15:13:43',2,'c','n'),(18,'chan135','시연용 제목','시연용 텍스트 내용ㅇㅇㅇㅇㅁㅇ','null','null',0,'2021-12-12 16:46:50','2021-12-19 16:46:46',2,'c','n'),(19,'chan135','시연용 제목ㅁㄴㅇㅁㄴㅇㅁㄴㅇ','시연용 텍스트 내용','업로드 테스트용 이미지1.jpg','업로드 테스트용 이미지1.jpg',0,'2021-12-12 16:47:02','2021-12-19 16:46:56',2,'c','n'),(20,'chan135','시연용 제목','시연용 텍스트 내용\r\n            ','null','null',1,'2021-12-16 15:49:32','2021-12-23 15:49:16',2,'c','n'),(21,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:25:10','2021-12-19 18:25:08',2,'c','n'),(22,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:25:15','2021-12-19 18:25:14',1,'c','n'),(23,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:25:23','2021-12-19 18:25:22',2,'c','n'),(24,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:26:34','2021-12-19 18:26:32',2,'c','n'),(25,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:26:37','2021-12-19 18:26:36',1,'c','n'),(26,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:26:39','2021-12-19 18:26:39',1,'c','n'),(27,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:26:42','2021-12-19 18:26:42',1,'c','n'),(28,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:26:44','2021-12-19 18:26:44',1,'b','n'),(29,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:26:46','2021-12-19 18:26:46',1,'b','n'),(30,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:26:48','2021-12-19 18:26:48',1,'b','n'),(31,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:26:56','2021-12-19 18:26:55',1,'b','n'),(32,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-12 18:46:21','2021-12-19 18:46:16',1,'a','n'),(33,'chan135','시연용 제목','시연용 텍스트 내용\r\n            \r\n            ','fd101_info_3.jpg','fd101_info_3.jpg',0,'2021-12-12 18:46:39','2021-12-19 18:46:33',1,'a','n'),(34,'chan135','시연용 2차 넘기기','시연용 텍스트 내용','b116_info_1.jpg','b116_info_1.jpg',50,'2021-12-13 00:47:44','2022-01-13 00:47:44',2,'a','n'),(35,'chan135','시연용 확정 넘기기','시연용 텍스트 내용','b111_info_1.jpg','b111_info_1.jpg',200,'2021-12-13 00:45:15','2021-12-20 00:45:02',2,'c','n'),(36,'chan135','시연용 2차 넘기기','시연용 텍스트 내용','b116_info_11.jpg','b116_info_11.jpg',50,'2021-12-13 16:47:30','2022-01-13 16:47:30',2,'a','n'),(37,'chan135','시연용 확정 넘기기','시연용 텍스트 내용','b111_info_11.jpg','b111_info_11.jpg',200,'2021-12-13 00:49:58','2022-01-13 00:49:20',2,'c','n'),(38,'eunbyul95','시연용 댓글 확인','시연용 텍스트 내용','d118_info_1.jpg','d118_info_1.jpg',0,'2021-12-13 12:16:04','2021-12-20 12:15:32',1,'a','y'),(39,'chan135','시연용 제목','시연용 텍스트 내용','null','null',0,'2021-12-13 16:46:38','2021-12-20 16:46:34',1,'a','n'),(40,'chan135','시연용 2차 넘기기','시연용 텍스트 내용','d107_info_1.jpg','d107_info_1.jpg',49,'2021-12-13 19:19:23','2021-12-20 19:18:34',1,'a','y'),(41,'chan135','시연용 확정 넘기기','시연용 텍스트 내용','d112_info_1.jpg','d112_info_1.jpg',199,'2021-12-13 19:19:43','2021-01-13 19:19:28',1,'a','y'),(42,'chan135','시연용 이미지 null','시연용 텍스트 내용','null','null',0,'2021-12-14 09:35:16','2021-12-21 09:35:07',1,'a','y');
/*!40000 ALTER TABLE `t_challenge_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_challenge_reply`
--

DROP TABLE IF EXISTS `t_challenge_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_challenge_reply` (
  `cr_idx` int NOT NULL AUTO_INCREMENT,
  `ci_idx` int DEFAULT NULL,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cr_content` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `cr_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `cr_isview` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'y',
  PRIMARY KEY (`cr_idx`),
  KEY `fk_challenge_reply_ci_idx` (`ci_idx`),
  KEY `fk_challenge_reply_mi_id` (`mi_id`),
  CONSTRAINT `fk_challenge_reply_ci_idx` FOREIGN KEY (`ci_idx`) REFERENCES `t_challenge_info` (`ci_idx`),
  CONSTRAINT `fk_challenge_reply_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_challenge_reply`
--

LOCK TABLES `t_challenge_reply` WRITE;
/*!40000 ALTER TABLE `t_challenge_reply` DISABLE KEYS */;
INSERT INTO `t_challenge_reply` VALUES (1,1,'jang086','헐 좋은데요?!!','2021-11-17 12:34:40','y'),(2,1,'eunbyul95','저도 이런 거 한번 생각해본 적 있었어요. 밥 먹다가 문득 든 생각인데 ','2021-11-17 12:34:41','y'),(3,1,'chan135','감사합니다 ㅎㅎ','2021-11-17 12:34:44','y'),(4,1,'chan135','헐..','2021-12-05 05:02:47','y'),(5,1,'chan135','댓글 테스트입니다.','2021-12-05 05:27:51','y'),(6,12,'chan135','그렇군요','2021-12-05 05:31:26','y'),(7,8,'chan135','좋은 생각입니다 ','2021-12-05 05:31:40','y'),(8,4,'chan135','시연용 댓글임','2021-12-05 11:20:56','y'),(9,4,'chan135','ajax 테스트임','2021-12-05 11:22:14','y'),(10,4,'chan135','댓글 테스트','2021-12-05 15:11:37','y'),(11,15,'chan135','11번 댓글입니다','2021-12-05 15:12:15','y'),(12,3,'chan135','12번 댓글입니다','2021-12-08 16:46:17','y'),(13,12,'chan135','댓글 테스트 135','2021-12-09 17:48:39','y'),(14,8,'chan135','다른회원글 댓글 테스트','2021-12-09 17:49:03','y'),(15,2,'chan135','댓글 없을때 댓글 테스트 ','2021-12-09 17:49:30','y'),(16,2,'chan135','그 다음 바로 댓글 테스트','2021-12-09 17:49:43','y'),(17,12,'chan135','댓글 테스트 136번','2021-12-09 17:57:22','y'),(18,3,'chan135','댓글 테스트 하세요','2021-12-09 18:50:14','y'),(19,10,'chan135','10번글 댓글 테스트1','2021-12-12 00:51:22','y'),(20,20,'chan135','아이디어 좋습니다','2021-12-12 15:55:29','y'),(21,20,'hah228','아이디어 좋습니다','2021-12-12 15:56:35','y'),(22,10,'chan135','댓글 테스트입니다','2021-12-12 18:49:29','n'),(23,1,'chan135','댓글 테스트13','2021-12-12 18:49:41','n'),(24,38,'eunbyul95','eunbyul95의 댓글 테스트입니다','2021-12-13 12:20:27','y'),(25,38,'chan135','다른 사람이 올린 글에서의 댓글입니다','2021-12-13 12:21:26','y'),(26,39,'chan135','안녕하세요','2021-12-13 16:48:57','y'),(27,38,'chan135','안녕하세요','2021-12-13 16:49:20','n');
/*!40000 ALTER TABLE `t_challenge_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_challenge_reply_report`
--

DROP TABLE IF EXISTS `t_challenge_reply_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_challenge_reply_report` (
  `crr_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `cr_idx` int NOT NULL,
  `crr_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `crr_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `crr_opdate` datetime DEFAULT NULL,
  `ai_idx` int DEFAULT '0',
  PRIMARY KEY (`cr_idx`,`mi_id`),
  UNIQUE KEY `crr_idx` (`crr_idx`),
  KEY `fk_challenge_reply_report_mi_id` (`mi_id`),
  CONSTRAINT `fk_challenge_reply_report_cr_idx` FOREIGN KEY (`cr_idx`) REFERENCES `t_challenge_reply` (`cr_idx`),
  CONSTRAINT `fk_challenge_reply_report_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_challenge_reply_report`
--

LOCK TABLES `t_challenge_reply_report` WRITE;
/*!40000 ALTER TABLE `t_challenge_reply_report` DISABLE KEYS */;
INSERT INTO `t_challenge_reply_report` VALUES (2,'eunbyul95',1,'a','2021-11-17 13:10:37',NULL,0),(1,'jang086',2,'a','2021-11-17 13:10:35',NULL,0);
/*!40000 ALTER TABLE `t_challenge_reply_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_faq_list`
--

DROP TABLE IF EXISTS `t_faq_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_faq_list` (
  `fl_idx` int NOT NULL,
  `fl_cata_big` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `fl_cata_small` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `fl_question` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fl_answer` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fl_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`fl_idx`),
  KEY `fk_faq_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_faq_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_faq_list`
--

LOCK TABLES `t_faq_list` WRITE;
/*!40000 ALTER TABLE `t_faq_list` DISABLE KEYS */;
INSERT INTO `t_faq_list` VALUES (1,'a','a','일반상품의 주문/결제  관련 FAQ입니다1','일반상품의 주문/결제  관련 FAQ 답변입니다1','2021-11-17 16:27:52',3),(2,'a','b','일반상품의 배송/조회 관련 FAQ입니다1','일반상품의 배송/조회 관련 FAQ 답변입니다1','2021-11-17 16:27:53',3),(3,'b','a','펀딩의 상품 관련 FAQ입니다1','펀딩의 상품 관련 FAQ 답변입니다1','2021-11-17 16:27:54',3);
/*!40000 ALTER TABLE `t_faq_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_free_info`
--

DROP TABLE IF EXISTS `t_free_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_free_info` (
  `fi_idx` int NOT NULL,
  `fi_ismem` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'n',
  `fi_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  `fi_writer` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_good` int DEFAULT '0',
  `fi_bad` int DEFAULT '0',
  `fi_read` int DEFAULT '0',
  `fi_ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`fi_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_free_info`
--

LOCK TABLES `t_free_info` WRITE;
/*!40000 ALTER TABLE `t_free_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_free_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_funding_info`
--

DROP TABLE IF EXISTS `t_funding_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_funding_info` (
  `fi_idx` int NOT NULL AUTO_INCREMENT,
  `fi_id` char(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_img1` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_img2` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_img3` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fi_price` int DEFAULT '0',
  `fi_ordercnt` int DEFAULT '0',
  `fi_goal` int DEFAULT '0',
  `fi_rate` float DEFAULT '0',
  `fi_support` int DEFAULT '0',
  `fi_total` int DEFAULT '0',
  `fi_good` int DEFAULT '0',
  `fi_sdate` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `fi_edate` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `fi_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `fi_isview` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'n',
  `fi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`fi_id`),
  UNIQUE KEY `fi_idx` (`fi_idx`),
  KEY `fk_funding_info_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_funding_info_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_funding_info`
--

LOCK TABLES `t_funding_info` WRITE;
/*!40000 ALTER TABLE `t_funding_info` DISABLE KEYS */;
INSERT INTO `t_funding_info` VALUES (1,'fd101','왼손잡이 아이용 매듭 연습키트','fd101_info_1.jpg','fd101_info_2.jpg','fd101_info_3.jpg','fd101_desc.jpg',5000,10,500000,0.7,70,350000,33,'2021-10-16','2021-11-15','c','n','2021-10-15 00:00:00',5),(2,'fd102','왼손잡이용 주방 식기 세트','fd102_info_1.jpg','fd102_info_2.jpg','fd102_info_3.jpg','fd102_desc.jpg',30000,10,3000000,3,300,9000000,157,'2021-11-20','2021-12-19','b','y','2021-11-19 00:00:00',5),(3,'fd103','왼손잡이용 폴더 세트','fd103_info_1.jpg','fd103_info_2.jpg','fd103_info_3.jpg','fd103_desc.jpg',12000,5,600000,0.1,5,60000,0,'2021-11-26','2021-12-25','a','y','2021-10-15 00:00:00',5),(4,'fd104','왼손잡이 아이용 매듭 연습키트','fd104_info_1.jpg','fd104_info_2.jpg','fd104_info_3.png','fd104_info_desc.jpg',5000,11,500000,0.11,71,55000,33,'2021-11-27','2021-12-26','a','y','2021-12-12 15:42:16',5),(5,'fd105','왼손잡이 골프 장갑','fd105_info_1.jpg','fd105_info_2.jpg','fd105_info_3.jpg','fd105_info_desc.jpg',25000,37,1250000,0.74,30,925000,30,'2021-11-27','2021-12-26','a','y','2021-12-12 15:42:16',5),(6,'fd106','왼손잡이 아이용 연습 젓가락','fd106_info_1.jpg','fd106_info_2.jpg','fd106_info_3.jpg','fd106_info_desc.jpg',7000,21,350000,0.42,20,147000,20,'2021-11-27','2021-12-26','a','y','2021-12-12 15:42:16',5),(7,'fd107','왼손잡이 무선용 마우스','fd107_info_1.jpg','fd107_info_2.jpg','fd107_info_3.jpg','fd107_info_desc.jpg',50000,46,2500000,0.92,43,2300000,42,'2021-11-28','2021-12-27','a','y','2021-12-12 15:42:16',5),(8,'fd108','왼손잡이 팔목 보호대','fd108_info_1.jpg','fd108_info_2.jpg','fd108_info_3.jpg','fd108_info_desc.jpg',3000,12,150000,0.24,11,36000,11,'2021-11-28','2021-12-27','a','y','2021-12-12 15:42:16',5),(9,'fd109','왼손잡이 야구 세트','fd109_info_1.jpg','fd109_info_2.jpg','fd109_info_3.jpg','fd109_info_desc.jpg',70000,15,3500000,0.3,10,1050000,10,'2021-11-28','2021-12-27','a','y','2021-12-12 15:42:16',5),(10,'fd110','왼손잡이 잘 잘리는 가위','fd110_info_1.jpg','fd110_info_2.jpg','fd110_info_3.jpg','fd110_info_desc.jpg',5000,52,500000,0.52,35,260000,32,'2021-11-28','2021-12-27','a','y','2021-12-12 15:42:16',5),(11,'fd111','왼손잡이 수동 연필깎기','fd111_info_1.jpg','fd111_info_2.jpg','fd111_info_3.jpg','fd111_info_desc.jpg',1500,27,75000,0.54,24,40500,24,'2021-11-28','2021-12-27','a','y','2021-12-12 15:42:16',5),(12,'fd112','왼손잡이 드릴 도구','fd112_info_1.jpg','fd112_info_2.jpg','fd112_info_3.jpg','fd112_info_desc.jpg',45000,10,2250000,0.2,6,450000,6,'2021-11-28','2021-12-27','a','y','2021-12-12 15:42:16',5),(13,'fd113','왼손잡이 게이밍 마우스','fd113_info_1.jpg','fd113_info_2.jpg','fd113_info_3.jpg','fd113_info_desc.jpg',95000,5,4750000,0.1,1,475000,1,'2021-11-28','2021-12-27','a','y','2021-12-12 15:42:16',5),(14,'fd114','왼손잡이 비싼 골프체','fd114_info_1.jpg','fd114_info_2.jpg','fd114_info_3.jpg','fd114_info_desc.jpg',400000,48,20000000,0.96,25,19200000,25,'2021-11-29','2021-12-28','a','y','2021-12-12 15:42:16',5),(15,'fd115','왼손잡이 일랙기타','fd115_info_1.jpg','fd115_info_2.jpg','fd115_info_3.jpg','fd115_info_desc.jpg',350000,50,17500000,0.1,10,17500000,10,'2021-11-29','2021-12-28','a','y','2021-12-12 15:42:16',5),(16,'fd116','왼손잡이 사무용 마우스','fd116_info_1.jpg','fd116_info_2.jpg','fd116_info_3.jpg','fd116_info_desc.jpg',5000,12,500000,0.24,10,60000,10,'2021-11-29','2021-12-28','a','y','2021-12-12 15:42:16',5),(17,'fd117','왼손잡이 총 모양 일랙기타','fd117_info_1.jpg','fd117_info_2.jpg','fd117_info_3.jpg','fd117_info_desc.jpg',250000,37,12500000,0.74,24,9250000,24,'2021-11-29','2021-12-28','a','y','2021-12-12 15:42:16',5),(18,'fd118','왼손잡이 빨간 일랙기타','fd118_info_1.jpg','fd118_info_2.jpg','fd118_info_3.jpg','fd118_info_desc.jpg',270000,42,13500000,0.84,12,11340000,12,'2021-11-29','2021-12-28','a','y','2021-12-12 15:42:16',5),(19,'fd119','왼손잡이 통기타','fd119_info_1.jpg','fd119_info_2.jpg','fd119_info_3.jpg','fd119_info_desc.jpg',150000,17,7500000,0.34,12,2550000,11,'2021-11-29','2021-12-28','a','y','2021-12-12 15:42:16',5),(20,'fd120','왼손잡이 게이밍 패드','fd120_info_1.jpg','fd120_info_2.jpg','fd120_info_3.jpg','fd120_info_desc.jpg',110000,19,5500000,0.38,17,2090000,16,'2021-11-29','2021-12-28','a','y','2021-12-12 15:42:16',5);
/*!40000 ALTER TABLE `t_funding_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_funding_order_detail`
--

DROP TABLE IF EXISTS `t_funding_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_funding_order_detail` (
  `fod_idx` int NOT NULL AUTO_INCREMENT,
  `foi_id` char(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `fi_id` char(5) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `fod_cnt` int DEFAULT '1',
  `fod_pname` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fod_pimg` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fod_pprice` int DEFAULT '0',
  PRIMARY KEY (`fod_idx`),
  KEY `fk_funding_order_detail_foi_id` (`foi_id`),
  KEY `fk_funding_order_detail_fi_id` (`fi_id`),
  CONSTRAINT `fk_funding_order_detail_fi_id` FOREIGN KEY (`fi_id`) REFERENCES `t_funding_info` (`fi_id`),
  CONSTRAINT `fk_funding_order_detail_foi_id` FOREIGN KEY (`foi_id`) REFERENCES `t_funding_order_info` (`foi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_funding_order_detail`
--

LOCK TABLES `t_funding_order_detail` WRITE;
/*!40000 ALTER TABLE `t_funding_order_detail` DISABLE KEYS */;
INSERT INTO `t_funding_order_detail` VALUES (10,'211212XZI102','fd107',1,'왼손잡이 무선용 마우스','fd107_info_1.jpg',50000),(11,'211212EBV102','fd104',1,'왼손잡이 아이용 매듭 연습키트','fd104_info_1.jpg',5000),(12,'211212TWR101','fd120',3,'왼손잡이 게이밍 패드','fd120_info_1.jpg',110000),(13,'211212XHA102','fd119',2,'왼손잡이 통기타','fd119_info_1.jpg',150000),(14,'211213PAA101','fd110',2,'왼손잡이 잘 잘리는 가위','fd110_info_1.jpg',5000),(15,'211213JLR101','fd110',2,'왼손잡이 잘 잘리는 가위','fd110_info_1.jpg',5000),(16,'211213FPQ104','fd110',10,'왼손잡이 잘 잘리는 가위','fd110_info_1.jpg',5000);
/*!40000 ALTER TABLE `t_funding_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_funding_order_info`
--

DROP TABLE IF EXISTS `t_funding_order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_funding_order_info` (
  `foi_id` char(12) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `foi_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `foi_phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `foi_zip` char(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `foi_addr1` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `foi_addr2` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `foi_memo` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `foi_pay` int DEFAULT '0',
  `foi_point` int DEFAULT '0',
  `foi_delipay` int DEFAULT '0',
  `foi_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'b',
  `foi_invoice` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `foi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `foi_modify` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT '0',
  PRIMARY KEY (`foi_id`),
  KEY `fk_funding_order_mi_id` (`mi_id`),
  CONSTRAINT `fk_funding_order_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_funding_order_info`
--

LOCK TABLES `t_funding_order_info` WRITE;
/*!40000 ALTER TABLE `t_funding_order_info` DISABLE KEYS */;
INSERT INTO `t_funding_order_info` VALUES ('211212EBV102','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','',5000,0,0,'b',NULL,'2021-12-12 16:13:20','2021-12-12 16:13:20',0),('211212TWR101','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','',330000,0,0,'b',NULL,'2021-12-12 18:55:14','2021-12-12 18:55:14',0),('211212XHA102','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','',300000,0,0,'c','','2021-12-12 19:04:55','2021-12-12 19:09:51',1),('211212XZI102','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','',50000,0,0,'b',NULL,'2021-12-12 15:51:45','2021-12-12 15:51:45',0),('211213FPQ104','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','',50000,0,0,'c','','2021-12-13 16:50:41','2021-12-14 10:29:58',1),('211213JLR101','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','',10000,0,0,'b','','2021-12-13 12:51:26','2021-12-13 14:35:40',1),('211213PAA101','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','',10000,0,0,'b',NULL,'2021-12-13 12:51:00','2021-12-13 12:51:00',0);
/*!40000 ALTER TABLE `t_funding_order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_address`
--

DROP TABLE IF EXISTS `t_member_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_member_address` (
  `ma_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ma_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ma_receiver` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ma_phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ma_zip` char(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ma_addr1` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ma_addr2` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ma_basic` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'y',
  `ma_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ma_idx`),
  KEY `fk_member_address_mi_id` (`mi_id`),
  CONSTRAINT `fk_member_address_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_address`
--

LOCK TABLES `t_member_address` WRITE;
/*!40000 ALTER TABLE `t_member_address` DISABLE KEYS */;
INSERT INTO `t_member_address` VALUES (1,'chan135','집','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','y','2021-11-17 11:20:08'),(2,'jang086','집','이희원','010-4567-8521','64581','서울시 강남구 개포동','490 203동 205호','y','2021-11-17 11:20:09'),(3,'eunbyul95','집','고은별','010-6485-8451','65133','서울시 강동구 강일동 ','284 은별빌라 203동','y','2021-11-17 11:20:10'),(4,'lee193','집','이기현','010-8844-1354','63512','서울시 강남구 논현동','348 513동 201호','y','2021-11-17 11:20:11'),(5,'park90','회사','박소담','02-4651-8745','98132','서울시 강남구 대치동','249 494동 104호','n','2021-11-17 11:20:12'),(6,'hanbi1','집','이한비','010-4654-4444','64515','서울시 관악구 남현동','389 583동 104호','y','2021-11-17 11:20:12'),(7,'kty8294','집','김태윤','010-8665-8511','47898','서울시 강남구 도곡동','472 2948동 705호','y','2021-11-17 11:20:13'),(8,'luo391','회사','이은우','02-9465-7845','12353','서울시 강남구 삼성동','298 39동 104호','n','2021-11-17 11:20:14'),(9,'khb83249','집','김현빈','010-6648-4456','64516','경기도 안양시 만안구','509 284동 306호','y','2021-11-17 11:20:15'),(10,'sj2348','집','김서재','010-6451-4413','91898','서울시 마포구 마포동','394 842동 305호','y','2021-11-17 11:20:16');
/*!40000 ALTER TABLE `t_member_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_info`
--

DROP TABLE IF EXISTS `t_member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_member_info` (
  `mi_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mi_pw` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mi_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mi_gender` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mi_birth` char(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mi_phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mi_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mi_grade` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `mi_point` int DEFAULT '0',
  `mi_recommend` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `mi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `mi_isact` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'y',
  `mi_hand` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'l',
  PRIMARY KEY (`mi_id`),
  UNIQUE KEY `mi_idx` (`mi_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_info`
--

LOCK TABLES `t_member_info` WRITE;
/*!40000 ALTER TABLE `t_member_info` DISABLE KEYS */;
INSERT INTO `t_member_info` VALUES (1,'chan135','Kwang1','김광찬','m','1996-05-21','010-7534-8945','chan135@naver.com','a',491000,NULL,'2021-11-17 11:18:57','y','l'),(3,'eunbyul95','gogo10','고은별','f','1995-12-05','010-6485-8451','eunbyul95@naver.com','a',1500,NULL,'2021-11-17 11:19:00','y','l'),(12,'hah228','dlgkdms','이하은','f','1996-02-28','010-7534-8945','hah228@gmail.com','a',2000,NULL,'2021-11-17 16:45:08','y','l'),(6,'hanbi1','leehanbi1','이한비','f','2001-01-23','010-4654-4444','hanbi1@naver.com','b',10000,NULL,'2021-11-17 11:19:03','y','b'),(2,'jang086','one123','이희원','m','1990-06-01','010-4567-8521','jang086@nate.com','a',2000,NULL,'2021-11-17 11:18:58','y','r'),(9,'khb83249','gusqls00','김현빈','m','2000-02-01','010-6648-4456','khb83249@naver.com','b',5000,NULL,'2021-11-17 11:19:06','y','l'),(7,'kty8294','xodbs123','김태윤','m','1994-04-13','010-8665-8511','kty8294@naver.com','a',500,NULL,'2021-11-17 11:19:04','n','l'),(4,'lee193','hyun1','이기현','m','1993-11-04','010-8844-1354','lee195@daum.com','b',10000,NULL,'2021-11-17 11:19:00','n','l'),(8,'luo391','dldmsdn88','이은우','m','1988-07-15','010-6515-6845','luo391@naver.com','a',1000,NULL,'2021-11-17 11:19:05','y','b'),(5,'park90','sosohe1','박소담','f','1990-05-11','010-7534-8945','park90@naver.com','a',1000,NULL,'2021-11-17 11:19:02','y','r'),(10,'sj2348','tjwo2904','김서재','m','2004-09-17','010-6451-4413','sj2348@naver.com','a',1000,NULL,'2021-11-17 11:19:07','y','r');
/*!40000 ALTER TABLE `t_member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_point`
--

DROP TABLE IF EXISTS `t_member_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_member_point` (
  `mp_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `mp_kind` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mp_point` int DEFAULT '0',
  `mp_content` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mp_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT '0',
  PRIMARY KEY (`mp_idx`),
  KEY `fk_member_point_mi_id` (`mi_id`),
  CONSTRAINT `fk_member_point_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_point`
--

LOCK TABLES `t_member_point` WRITE;
/*!40000 ALTER TABLE `t_member_point` DISABLE KEYS */;
INSERT INTO `t_member_point` VALUES (2,'hah228','b',1000,'가입축하금','2021-11-17 16:45:08',0),(3,'luo391','c',2000,'관리자 재량','2021-11-17 16:46:28',3),(4,'luo391','d',2000,'관리자 재량','2021-11-17 16:46:57',3),(5,'chan135','b',1000,'상품구매-211208UIM101','2021-12-08 16:43:14',0),(6,'chan135','b',1000,'상품구매-211212HKZ101','2021-12-12 13:56:10',0),(7,'chan135','b',1000,'상품구매-211212MVF102','2021-12-12 13:57:20',0),(8,'chan135','b',1000,'상품구매-211212RIH101','2021-12-12 19:04:35',0),(9,'chan135','b',1940194,'상품구매-211213LSX101','2021-12-13 13:03:38',0),(10,'chan135','b',4500,'상품구매-211213OJO102','2021-12-13 14:14:43',0),(11,'chan135','b',4500,'상품구매-211213EQA103','2021-12-13 16:45:14',0);
/*!40000 ALTER TABLE `t_member_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_notice_list`
--

DROP TABLE IF EXISTS `t_notice_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_notice_list` (
  `nl_idx` int NOT NULL,
  `nl_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nl_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nl_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`nl_idx`),
  KEY `fk_notice_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_notice_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_notice_list`
--

LOCK TABLES `t_notice_list` WRITE;
/*!40000 ALTER TABLE `t_notice_list` DISABLE KEYS */;
INSERT INTO `t_notice_list` VALUES (1,'왼손잡상점이 홈페이지를 오픈하였습니다.','왼손잡상점은 왼손잡이 전용 상품 판매 사이트로...','2021-11-17 16:25:44',3),(2,'왼손잡상점 오픈 기념 이벤트','왼손잡상점에서 30,000원 이상 구매 시...','2021-11-17 16:25:45',3),(3,'왼손잡상점 개인정보 처리방침 변경에 대한 안내 말씀드립니다.','안녕하세요, 왼손잡상점입니다. 다음달부터...','2021-11-17 16:25:46',3);
/*!40000 ALTER TABLE `t_notice_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pdt_cata`
--

DROP TABLE IF EXISTS `t_pdt_cata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_pdt_cata` (
  `pc_id` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pc_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pdt_cata`
--

LOCK TABLES `t_pdt_cata` WRITE;
/*!40000 ALTER TABLE `t_pdt_cata` DISABLE KEYS */;
INSERT INTO `t_pdt_cata` VALUES ('a','가위'),('b','문구'),('c','주방'),('d','etc');
/*!40000 ALTER TABLE `t_pdt_cata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pdt_history`
--

DROP TABLE IF EXISTS `t_pdt_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_pdt_history` (
  `ph_idx` int NOT NULL AUTO_INCREMENT,
  `pi_id` char(4) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ph_oldprice` int DEFAULT '0',
  `ph_newprice` int DEFAULT '0',
  `ph_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`ph_idx`),
  KEY `fk_history_pi_id` (`pi_id`),
  KEY `fk_history_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_history_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`),
  CONSTRAINT `fk_history_pi_id` FOREIGN KEY (`pi_id`) REFERENCES `t_product_info` (`pi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pdt_history`
--

LOCK TABLES `t_pdt_history` WRITE;
/*!40000 ALTER TABLE `t_pdt_history` DISABLE KEYS */;
INSERT INTO `t_pdt_history` VALUES (1,'a101',10000,11000,'2021-11-17 18:38:35',4),(2,'a101',11000,15000,'2021-12-12 15:13:11',4),(3,'a101',15000,25000,'2021-12-12 15:13:26',4),(4,'a101',25000,15000,'2021-12-12 15:13:29',4),(5,'a101',15000,17000,'2021-12-12 18:44:09',4);
/*!40000 ALTER TABLE `t_pdt_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_info`
--

DROP TABLE IF EXISTS `t_product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_product_info` (
  `pi_idx` int NOT NULL AUTO_INCREMENT,
  `pi_id` char(4) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pc_id` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `pi_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pi_price` int DEFAULT '0',
  `pi_discount` float DEFAULT '0',
  `pi_img1` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pi_img2` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pi_img3` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pi_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pi_stock` int DEFAULT '0',
  `pi_good` int DEFAULT '0',
  `pi_salecnt` int DEFAULT '0',
  `pi_review` int DEFAULT '0',
  `pi_score` float DEFAULT '0',
  `pi_soldout` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'n',
  `pi_isview` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'n',
  `pi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`pi_id`),
  UNIQUE KEY `pi_idx` (`pi_idx`),
  KEY `fk_product_pc_id` (`pc_id`),
  KEY `fk_product_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_product_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`),
  CONSTRAINT `fk_product_pc_id` FOREIGN KEY (`pc_id`) REFERENCES `t_pdt_cata` (`pc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_info`
--

LOCK TABLES `t_product_info` WRITE;
/*!40000 ALTER TABLE `t_product_info` DISABLE KEYS */;
INSERT INTO `t_product_info` VALUES (1,'a101','a','재단용 왼손잡이용 가위',17000,0.2,'a101_info_1.jpg','a101_info_2.jpg','a101_info_3.jpg','a101_desc.jpg',100,0,0,14,3.92857,'n','y','2021-11-17 12:26:55',4),(2,'a102','a','사무용 왼손잡이용 가위',5000,0.1,'a102_info_1.jpg','a102_info_2.jpg','a102_info_3.jpg','a102_desc.jpg',98,0,2,0,0,'n','y','2021-11-17 12:26:57',4),(3,'a103','a','아이용 왼손잡이용 가위',3000,0.4,'a103_info_1.jpg','a103_info_2.jpg','a103_info_3.jpg','a103_desc.jpg',0,0,2,0,0,'y','y','2021-11-17 12:26:58',4),(4,'a104','a','아이용 왼손잡이용 가위2',7000,0.3,'a104_info_1.jpg','a104_info_2.jpg','a104_info_3.jpg','a104_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(5,'a105','a','사무용 왼손잡이 가위2',10000,0.1,'a105_info_1.jpg','a105_info_2.jpg','a105_info_3.jpg','a105_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(6,'a106','a','아이용 왼손잡이용 가위3',7000,0.1,'a106_info_1.jpg','a106_info_2.jpg','a106_info_3.jpg','a106_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(7,'a107','a','왼손용 미용가위',23000,0.2,'a107_info_1.jpg','a107_info_2.jpg','a107_info_3.jpg','a107_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(8,'a108','a','왼손용 미용가위2',28000,0.1,'a108_info_1.jpg','a108_info_2.jpg','a108_info_3.jpg','a108_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(9,'a109','a','아이용 왼손잡이용 가위3',6000,0.1,'a109_info_1.jpg','a109_info_2.jpg','a109_info_3.jpg','a109_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(10,'a110','a','사무용 왼손잡이 가위3',10000,0.2,'a110_info_1.jpg','a110_info_2.jpg','a110_info_3.jpg','a110_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(11,'a111','a','아이용 왼손잡이용 가위4',7000,0.3,'a111_info_1.jpg','a111_info_2.jpg','a111_info_3.jpg','a111_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(12,'a112','a','네일용 왼손잡이용 가위',12000,0.1,'a112_info_1.jpg','a112_info_2.jpg','a112_info_3.jpg','a112_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(13,'b101','b','왼손잡이용 펜',2000,0,'b101_info_1.jpg','b101_info_2.jpg','b101_info_3.jpg','b101_desc.jpg',99,0,1,0,0,'n','y','2021-11-29 02:35:31',4),(14,'b102','b','왼손잡이 사무용 black 세트',10000,0.1,'b102_info_1.jpg','b102_info_2.jpg','b102_info_3.jpg','b102_desc.jpg',97,0,3,0,0,'n','y','2021-11-29 02:35:31',4),(15,'b103','b','왼손잡이용 잉크펜',15000,0.15,'b103_info_1.jpg','b103_info_2.jpg','b103_info_3.jpg','b103_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(16,'b104','b','미국산 문구세트',25000,0.1,'b104_info_1.jpg','b104_info_2.jpg','b104_info_3.jpg','b104_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(17,'b105','b','겨울 테마 왼손용 연필',25000,0,'b105_info_1.jpg','b105_info_2.jpg','b105_info_3.jpg','b105_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(18,'b106','b','무지개색 폴더',5000,0,'b106_info_1.jpg','b106_info_2.jpg','b106_info_3.jpg','b106_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(19,'b107','b','노트 정리 폼',1000,0,'b107_info_1.jpg','b107_info_2.jpg','b107_info_3.jpg','b107_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(20,'b108','b','왼손잡이 만년펜',20000,0.1,'b108_info_1.jpg','b108_info_2.jpg','b108_info_3.jpg','b108_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(21,'b109','b','캐릭터 연필',1000,0,'b109_info_1.jpg','b109_info_2.jpg','b109_info_3.jpg','b109_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(22,'b110','b','문서정리용 집기판',1000,0,'b110_info_1.jpg','b110_info_2.jpg','b110_info_3.jpg','b110_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(23,'b111','b','문서정리용 클립',500,0,'b111_info_1.jpg','b111_info_2.jpg','b111_info_3.jpg','b111_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(24,'b112','b','왼손잡이용 샤프',1000,0,'b112_info_1.jpg','b112_info_2.jpg','b112_info_3.jpg','b112_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(25,'b113','b','책상정리용 바구니',2000,0,'b113_info_1.jpg','b113_info_2.jpg','b113_info_3.jpg','b113_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(26,'b114','b','책상정리용 바구니와 문구 세트',20000,0.15,'b114_info_1.jpg','b114_info_2.jpg','b114_info_3.jpg','b114_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(27,'b115','b','문서정리용 박스',10000,0.05,'b115_info_1.jpg','b115_info_2.jpg','b115_info_3.jpg','b115_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(28,'b116','b','왼손잡이용 계산기',5000,0,'b116_info_1.jpg','b116_info_2.jpg','b116_info_3.jpg','b116_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(29,'b117','b','왼손잡이용 형광펜',2500,0,'b117_info_1.jpg','b117_info_2.jpg','b117_info_3.jpg','b117_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(30,'b118','b','왼손잡이 선물용 세트',12500,0.3,'b118_info_1.jpg','b118_info_2.jpg','b118_info_3.jpg','b118_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(31,'b119','b','왼손잡이용 싸인펜',2500,0,'b119_info_1.jpg','b119_info_2.jpg','b119_info_3.jpg','b119_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(32,'b120','b','책 표시 스티커',500,0,'b120_info_1.jpg','b120_info_2.jpg','b120_info_3.jpg','b120_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(33,'b121','b','아동용 스테이플러',1500,0,'b121_info_1.jpg','b121_info_2.jpg','b121_info_3.jpg','b121_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(34,'b122','b','왼손용 사무 세트 blue',11500,0.05,'b122_info_1.jpg','b122_info_2.jpg','b122_info_3.jpg','b122_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(35,'b123','b','정리용 거치 바구니',11500,0.1,'b123_info_1.jpg','b123_info_2.jpg','b123_info_3.jpg','b123_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(36,'b124','b','왼손잡이용 스테이플러',1500,0,'b124_info_1.jpg','b124_info_2.jpg','b124_info_3.jpg','b124_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(37,'b125','b','왼손잡이용 캐릭터 연필깎이',1500,0,'b125_info_1.jpg','b125_info_2.jpg','b125_info_3.jpg','b125_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:35:31',4),(39,'c101','c','왼손잡이용 캔 따개',1500,0,'c101_info_1.jpg','c101_info_2.jpg','c101_info_3.jpg','c101_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(40,'c102','c','왼손잡이용 빵 커터',5500,0.05,'c102_info_1.jpg','c102_info_2.jpg','c102_info_3.jpg','c102_desc.jpg',99,0,1,0,0,'n','y','2021-11-29 02:39:10',4),(41,'c103','c','왼손잡이 테마 컵',2500,0,'c103_info_1.jpg','c103_info_2.jpg','c103_info_3.jpg','c103_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(42,'c104','c','사업장용 도마',10500,0,'c104_info_1.jpg','c104_info_2.jpg','c104_info_3.jpg','c104_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(43,'c105','c','왼손잡이용 냄비',12500,0.1,'c105_info_1.jpg','c105_info_2.jpg','c105_info_3.jpg','c105_desc.jpg',95,0,5,0,0,'n','y','2021-11-29 02:39:10',4),(44,'c106','c','스테인리스 팬',30000,0,'c106_info_1.jpg','c106_info_2.jpg','c106_info_3.jpg','c106_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(45,'c107','c','전기포트',15000,0,'c107_info_1.jpg','c107_info_2.jpg','c107_info_3.jpg','c107_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(46,'c108','c','센치한 도마',2500,0.1,'c108_info_1.jpg','c108_info_2.jpg','c108_info_3.jpg','c108_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(47,'c109','c','숫가락 젓가락 세트',18800,0.1,'c109_info_1.jpg','c109_info_2.jpg','c109_info_3.jpg','c109_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(48,'c110','c','구리 주방 용품',22500,0.1,'c110_info_1.jpg','c110_info_2.jpg','c110_info_3.jpg','c110_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(49,'c111','c','왼손잡이용 덮개 팬',19000,0.3,'c111_info_1.jpg','c111_info_2.jpg','c111_info_3.jpg','c111_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(50,'c112','c','스탠다드 식기 세트',19000,0.1,'c112_info_1.jpg','c112_info_2.jpg','c112_info_3.jpg','c112_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(51,'c113','c','스테인리스 주방 용품 세트',25000,0,'c113_info_1.jpg','c113_info_2.jpg','c113_info_3.jpg','c113_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(52,'c114','c','비건 도마',10000,0.2,'c114_info_1.jpg','c114_info_2.jpg','c114_info_3.jpg','c114_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(53,'c115','c','주방용 식기 세트',10000,0,'c115_info_1.jpg','c115_info_2.jpg','c115_info_3.jpg','c115_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(54,'c116','c','강화 유리병',20000,0,'c116_info_1.jpg','c116_info_2.jpg','c116_info_3.jpg','c116_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(55,'c117','c','고무 주방 용품',2000,0,'c117_info_1.jpg','c117_info_2.jpg','c117_info_3.jpg','c117_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(56,'c118','c','주방 기구 Set Black',2000,0,'c118_info_1.jpg','c118_info_2.jpg','c118_info_3.jpg','c118_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(57,'c119','c','코팅 팬',40000,0.2,'c119_info_1.jpg','c119_info_2.jpg','c119_info_3.jpg','c119_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(58,'c120','c','스테인리스 가정용 세트',30000,0.15,'c120_info_1.jpg','c120_info_2.jpg','c120_info_3.jpg','c120_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(59,'c121','c','스탠다드 냄비',25000,0,'c121_info_1.jpg','c121_info_2.jpg','c121_info_3.jpg','c121_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(60,'c122','c','스탠다드 뚝배기',25000,0,'c122_info_1.jpg','c122_info_2.jpg','c122_info_3.jpg','c122_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(61,'c123','c','주방용 냄비 Set',55000,0.1,'c123_info_1.jpg','c123_info_2.jpg','c123_info_3.jpg','c123_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(62,'c124','c','전기 찜기',15000,0.1,'c124_info_1.jpg','c124_info_2.jpg','c124_info_3.jpg','c124_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(63,'c125','c','오가닉 도마',5000,0,'c125_info_1.jpg','c125_info_2.jpg','c125_info_3.jpg','c125_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(64,'d101','d','캐릭터 상품 문어',1000,0,'d101_info_1.jpg','d101_info_2.jpg','d101_info_3.jpg','d101_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(65,'d102','d','왼손잡이용 줄자',2000,0,'d102_info_1.jpg','d102_info_2.jpg','d102_info_3.jpg','d102_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(66,'d103','d','왼손잡이 테마 액자',5000,0.1,'d103_info_1.jpg','d103_info_2.jpg','d103_info_3.jpg','d103_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(67,'d104','d','야외용 보호 패드',1000,0,'d104_info_1.jpg','d104_info_2.jpg','d104_info_3.jpg','d104_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(68,'d105','d','케로베로스 뱃지',3000,0,'d105_info_1.jpg','d105_info_2.jpg','d105_info_3.jpg','d105_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(69,'d106','d','정리용 줄',100,0,'d106_info_1.jpg','d106_info_2.jpg','d106_info_3.jpg','d106_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(70,'d107','d','기념사진 주문',5000,0,'d107_info_1.jpg','d107_info_2.jpg','d107_info_3.jpg','d107_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(71,'d108','d','냥이 뱃지',1000,0,'d108_info_1.jpg','d108_info_2.jpg','d108_info_3.jpg','d108_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(72,'d109','d','왼손잡이 아동용 세트',5000,0.1,'d109_info_1.jpg','d109_info_2.jpg','d109_info_3.jpg','d109_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(73,'d110','d','왼손잡이 남자용 세면 세트',3000,0.1,'d110_info_1.jpg','d110_info_2.jpg','d110_info_3.jpg','d110_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(74,'d111','d','유기농 정리대',1000,0,'d111_info_1.jpg','d111_info_2.jpg','d111_info_3.jpg','d111_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(75,'d112','d','휴가 테마 주머니',2900,0.1,'d112_info_1.jpg','d112_info_2.jpg','d112_info_3.jpg','d112_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(76,'d113','d','연예인 캐릭터 상품 악세서리',900,0,'d113_info_1.jpg','d113_info_2.jpg','d113_info_3.jpg','d113_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(77,'d114','d','만화 캐릭터 상품 악세서리',900,0,'d114_info_1.jpg','d114_info_2.jpg','d114_info_3.jpg','d114_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(78,'d115','d','아이용 가방',11900,0.15,'d115_info_1.jpg','d115_info_2.jpg','d115_info_3.jpg','d115_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(79,'d116','d','보라색 지갑',6900,0,'d116_info_1.jpg','d116_info_2.jpg','d116_info_3.jpg','d116_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(80,'d117','d','밤비 지갑',16900,0,'d117_info_1.jpg','d117_info_2.jpg','d117_info_3.jpg','d117_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(81,'d118','d','크리스마스 테마 엽서',1900,0,'d118_info_1.jpg','d118_info_2.jpg','d118_info_3.jpg','d118_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(82,'d119','d','스탠다드 지갑',31900,0.5,'d119_info_1.jpg','d119_info_2.jpg','d119_info_3.jpg','d119_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(83,'d120','d','캔들 케어 키트',11900,0,'d120_info_1.jpg','d120_info_2.jpg','d120_info_3.jpg','d120_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4),(84,'d121','d','정리용 집게',5900,0,'d121_info_1.jpg','d121_info_2.jpg','d121_info_3.jpg','d121_desc.jpg',100,0,0,0,0,'n','y','2021-11-29 02:39:10',4);
/*!40000 ALTER TABLE `t_product_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `pdt_tr` AFTER UPDATE ON `t_product_info` FOR EACH ROW begin
	declare oldprice, newprice, aiidx int;
	declare piid char(7);
    set oldprice = old.pi_price;	-- update전 상품가격
    set newprice = new.pi_price;	-- update후 상품가격
    set aiidx = new.ai_idx;			-- update시킨 관리자 번호
    set piid = old.pi_id;			-- update되는 상품의 id
    
    if oldprice <> newprice then	-- 가격변동이 있는 경우
		insert into t_pdt_history (pi_id, ph_oldprice, ph_newprice, ai_idx) values (piid, oldprice, newprice, aiidx);
	end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `t_product_order_cart`
--

DROP TABLE IF EXISTS `t_product_order_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_product_order_cart` (
  `poc_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `pi_id` char(7) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `poc_cnt` int DEFAULT '1',
  `poc_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`poc_idx`),
  KEY `fk_product_order_cart_mi_id` (`mi_id`),
  KEY `fk_product_order_cart_pi_id` (`pi_id`),
  CONSTRAINT `fk_product_order_cart_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`),
  CONSTRAINT `fk_product_order_cart_pi_id` FOREIGN KEY (`pi_id`) REFERENCES `t_product_info` (`pi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_order_cart`
--

LOCK TABLES `t_product_order_cart` WRITE;
/*!40000 ALTER TABLE `t_product_order_cart` DISABLE KEYS */;
INSERT INTO `t_product_order_cart` VALUES (2,'jang086','a102',1,'2021-11-17 13:22:20'),(3,'eunbyul95','a103',1,'2021-11-17 13:22:21'),(5,'luo391','a101',2,'2021-11-17 17:06:31'),(6,'luo391','a102',1,'2021-11-17 17:06:32'),(20,'chan135','a101',4,'2021-12-13 17:11:44'),(21,'chan135','c102',1,'2021-12-14 09:33:43'),(23,'chan135','d103',1,'2021-12-14 09:34:05');
/*!40000 ALTER TABLE `t_product_order_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_order_detail`
--

DROP TABLE IF EXISTS `t_product_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_product_order_detail` (
  `pod_idx` int NOT NULL AUTO_INCREMENT,
  `poi_id` char(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `pi_id` char(7) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `pod_cnt` int DEFAULT '1',
  `pod_pname` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pod_pimg` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pod_pprice` int DEFAULT '0',
  PRIMARY KEY (`pod_idx`),
  KEY `fk_product_order_detail_poi_id` (`poi_id`),
  KEY `fk_product_order_detail_pi_id` (`pi_id`),
  CONSTRAINT `fk_product_order_detail_pi_id` FOREIGN KEY (`pi_id`) REFERENCES `t_product_info` (`pi_id`),
  CONSTRAINT `fk_product_order_detail_poi_id` FOREIGN KEY (`poi_id`) REFERENCES `t_product_order_info` (`poi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_order_detail`
--

LOCK TABLES `t_product_order_detail` WRITE;
/*!40000 ALTER TABLE `t_product_order_detail` DISABLE KEYS */;
INSERT INTO `t_product_order_detail` VALUES (26,'211203abc101','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(27,'211203dsf102','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(28,'211203kpe103','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(29,'211203dji105','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(30,'211209hes101','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(31,'211209kow102','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(32,'211209qlo103','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(33,'211209mve104','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(34,'211209svw105','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(35,'211209dov106','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(36,'211209pmc107','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(37,'211209svw108','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(38,'211210scs101','a101',1,'재단용 왼손잡이용 가위','a101_info_1.jpg',8800),(39,'211212RIH101','c105',2,'왼손잡이용 냄비','c105_info_1.jpg',12500),(40,'211213LSX101','c105',3,'왼손잡이용 냄비','c105_info_1.jpg',12500),(41,'211213OJO102','a102',1,'사무용 왼손잡이용 가위','a102_info_1.jpg',5000),(42,'211213EQA103','a102',1,'사무용 왼손잡이용 가위','a102_info_1.jpg',5000),(43,'211213EQA103','c102',1,'왼손잡이용 빵 커터','c102_info_1.jpg',5500);
/*!40000 ALTER TABLE `t_product_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_order_info`
--

DROP TABLE IF EXISTS `t_product_order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_product_order_info` (
  `poi_id` char(12) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `poi_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `poi_phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `poi_zip` char(5) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `poi_addr1` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `poi_addr2` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `poi_memo` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `poi_payment` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `poi_pay` int DEFAULT '0',
  `poi_point` int DEFAULT '0',
  `poi_discount` int DEFAULT '0',
  `poi_delipay` int DEFAULT '0',
  `poi_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `poi_invoice` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `poi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `poi_modify` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT '0',
  PRIMARY KEY (`poi_id`),
  KEY `fk_product_order_info_mi_id` (`mi_id`),
  CONSTRAINT `fk_product_order_info_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_order_info`
--

LOCK TABLES `t_product_order_info` WRITE;
/*!40000 ALTER TABLE `t_product_order_info` DISABLE KEYS */;
INSERT INTO `t_product_order_info` VALUES ('210130acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130acg116','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130acg119','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130cbd117','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130cbd120','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130ehc118','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210130ehc121','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-01-01 00:00:00','2021-12-12 17:56:46',0),('210201acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210201acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210201acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210201acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210201cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210201cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210201cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210201ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210201ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210201ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-02-01 00:00:00','2021-12-12 17:56:46',0),('210301acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg116','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg119','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg123','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg126','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg129','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg133','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg136','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg139','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg143','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg146','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg149','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg153','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg156','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301acg159','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd117','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd120','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd124','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd127','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd130','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd134','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd137','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd140','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd144','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd147','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd150','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd154','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd157','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301cbd160','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc118','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc121','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc122','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc125','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc128','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc131','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc132','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc135','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc138','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc141','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc142','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc145','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc148','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc151','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc152','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc155','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210301ehc158','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-03-01 00:00:00','2021-12-12 17:56:46',0),('210401acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-04-01 00:00:00','2021-12-12 17:56:46',0),('210401acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-04-01 00:00:00','2021-12-12 17:56:46',0),('210401cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-04-01 00:00:00','2021-12-12 17:56:46',0),('210401cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-04-01 00:00:00','2021-12-12 17:56:46',0),('210401ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-04-01 00:00:00','2021-12-12 17:56:46',0),('210501acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501acg116','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501acg119','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501acg123','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501acg126','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501acg129','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd117','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd120','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd124','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd127','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501cbd130','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc118','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc121','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc122','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc125','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210501ehc128','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-05-01 00:00:00','2021-12-12 17:56:46',0),('210601acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601acg116','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601acg119','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601acg123','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601acg126','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601acg129','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd117','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd120','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd124','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd127','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601cbd130','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc118','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc121','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc122','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc125','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210601ehc128','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-06-01 00:00:00','2021-12-12 17:56:46',0),('210701acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701acg116','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701acg119','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701cbd117','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701cbd120','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210701ehc118','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-07-01 00:00:00','2021-12-12 17:56:46',0),('210801acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210801ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-08-01 00:00:00','2021-12-12 17:56:46',0),('210901acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg116','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg119','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg123','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg126','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg129','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg133','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg136','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901acg139','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd117','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd120','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd124','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd127','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd130','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd134','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd137','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901cbd140','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc118','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc121','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc122','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc125','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc128','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc131','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc132','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc135','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('210901ehc138','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-09-01 00:00:00','2021-12-12 17:56:46',0),('211001acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg116','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg119','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg123','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg126','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg129','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg133','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg136','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001acg139','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd117','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd120','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd124','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd127','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd130','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd134','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd137','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001cbd140','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc118','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc121','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc122','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc125','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc128','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc131','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc132','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc135','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211001ehc138','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-10-01 00:00:00','2021-12-12 17:56:46',0),('211101acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101acg116','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101acg119','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101cbd117','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101cbd120','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211101ehc118','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-11-01 00:00:00','2021-12-12 17:56:46',0),('211201acg101','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg104','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg107','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg110','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg113','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg116','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg119','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg123','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg126','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg129','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg133','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg136','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg139','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg143','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg146','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg149','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg153','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg156','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg159','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg163','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg166','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg169','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg173','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg176','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201acg179','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd102','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd105','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd108','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd111','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd114','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd117','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd120','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd124','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd127','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd130','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd134','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd137','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd140','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd144','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd147','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd150','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd154','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd157','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd160','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd164','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd167','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd170','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd174','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd177','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201cbd180','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc103','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc106','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc109','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc112','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc115','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc118','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc121','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc122','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc125','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc128','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc131','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc132','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc135','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc138','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc141','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc142','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc145','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc148','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc151','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc152','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc155','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc158','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc161','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc162','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc165','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc168','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc171','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc172','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc175','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211201ehc178','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',12500,0,0,2500,'a',NULL,'2021-12-01 00:00:00','2021-12-12 17:56:46',0),('211203abc101','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211203dji105','sj2348','김서재','010-6451-4413','91898','서울시 마포구 마포동','394 842동 305호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211203dsf102','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211203kfs104','khb83249','김현빈','010-6648-4456','64516','경기도 안양시 만안구','509 284동 306호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211203kpe103','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211209dov106','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211209hes101','park90','박소담','010-7534-8945','98132','서울시 강남구 대치동','249 494동 104호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211209kow102','eunbyul95','고은별','010-6485-8451','65133','서울시 강동구 강일동','284 은별빌라 203동','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211209mve104','khb83249','김현빈','010-6648-4456','64516','경기도 안양시 만안구','509 284동 306호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211209pmc107','khb83249','김현빈','010-6648-4456','64516','경기도 안양시 만안구','509 284동 306호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211209qlo103','luo391','이은우','010-6515-6845','12353','서울시 강남구 삼성동','298 39동 104호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211209svw105','sj2348','김서재','010-6451-4413','91898','서울시 마포구 마포동','394 842동 305호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211209svw108','sj2348','김서재','010-6451-4413','91898','서울시 마포구 마포동','394 842동 305호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211210scs101','sj2348','김서재','010-6451-4413','91898','서울시 마포구 마포동','394 842동 305호','고생하세요','a',11300,0,0,2500,'a',NULL,'2021-12-12 17:51:14','2021-12-12 17:51:14',0),('211212RIH101','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','','A',24000,1000,0,2500,'b','','2021-12-12 19:04:35','2021-12-12 19:09:18',1),('211213EQA103','chan135','김광찬','010-7534-8945','06035','서울 강남구 가로수길 5','','','A',7725,4500,0,2500,'a','','2021-12-13 16:45:14','2021-12-13 16:54:44',1),('211213LSX101','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','','A',0,1000,0,0,'a',NULL,'2021-12-13 13:03:38','2021-12-13 13:03:38',0),('211213OJO102','chan135','김광찬','010-7534-8945','38439','경기도 군포시 산본1동','039 103동 503호','','A',2500,4500,0,2500,'a',NULL,'2021-12-13 14:14:43','2021-12-13 14:14:43',0);
/*!40000 ALTER TABLE `t_product_order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_qna_answer`
--

DROP TABLE IF EXISTS `t_qna_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_qna_answer` (
  `qa_idx` int NOT NULL AUTO_INCREMENT,
  `qq_idx` int DEFAULT NULL,
  `qa_answer` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ai_idx` int DEFAULT NULL,
  `qa_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`qa_idx`),
  KEY `fk_qna_qq_idx` (`qq_idx`),
  KEY `fk_qna_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_qna_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`),
  CONSTRAINT `fk_qna_qq_idx` FOREIGN KEY (`qq_idx`) REFERENCES `t_qna_question` (`qq_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_qna_answer`
--

LOCK TABLES `t_qna_answer` WRITE;
/*!40000 ALTER TABLE `t_qna_answer` DISABLE KEYS */;
INSERT INTO `t_qna_answer` VALUES (1,1,'고객님, 안녕하세요...',3,'2021-11-17 16:33:54'),(2,2,'고객님, 안녕하세요...',3,'2021-11-17 16:33:55'),(3,3,'고객님, 안녕하세요...',3,'2021-11-17 16:33:56');
/*!40000 ALTER TABLE `t_qna_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_qna_question`
--

DROP TABLE IF EXISTS `t_qna_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_qna_question` (
  `qq_idx` int NOT NULL,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `qq_cata_big` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `qq_cata_small` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `qq_content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `qq_file` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `qq_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `qq_isanswer` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'n',
  PRIMARY KEY (`qq_idx`),
  KEY `fk_qna_mi_id` (`mi_id`),
  CONSTRAINT `fk_qna_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_qna_question`
--

LOCK TABLES `t_qna_question` WRITE;
/*!40000 ALTER TABLE `t_qna_question` DISABLE KEYS */;
INSERT INTO `t_qna_question` VALUES (1,'chan135','a','a','일반쇼핑에서 상품관련 문의입니다.',NULL,'2021-11-17 16:29:41','y'),(2,'jang086','a','b','일반쇼핑에서 주문/결제관련 문의입니다.',NULL,'2021-11-17 16:29:42','y'),(3,'eunbyul95','b','a','펀딩에서 상품관련 문의입니다.',NULL,'2021-11-17 16:29:43','y');
/*!40000 ALTER TABLE `t_qna_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_review_good`
--

DROP TABLE IF EXISTS `t_review_good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_review_good` (
  `rg_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rl_idx` int NOT NULL,
  `rg_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mi_id`,`rl_idx`),
  UNIQUE KEY `rg_idx` (`rg_idx`),
  KEY `fk_review_good_rl_idx` (`rl_idx`),
  CONSTRAINT `fk_review_good_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`),
  CONSTRAINT `fk_review_good_rl_idx` FOREIGN KEY (`rl_idx`) REFERENCES `t_review_list` (`rl_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_review_good`
--

LOCK TABLES `t_review_good` WRITE;
/*!40000 ALTER TABLE `t_review_good` DISABLE KEYS */;
INSERT INTO `t_review_good` VALUES (6,'chan135',24,'2021-12-13 11:22:27'),(8,'chan135',33,'2021-12-13 17:11:04'),(7,'chan135',35,'2021-12-13 16:43:42'),(5,'chan135',36,'2021-12-12 18:41:41');
/*!40000 ALTER TABLE `t_review_good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_review_list`
--

DROP TABLE IF EXISTS `t_review_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_review_list` (
  `rl_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `poi_id` char(12) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pi_id` char(4) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rl_content` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rl_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `rl_score` int DEFAULT '5',
  `rl_good` int DEFAULT '0',
  `rl_point` int DEFAULT '0',
  `rl_isview` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'y',
  `rl_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mi_id`,`poi_id`,`pi_id`),
  UNIQUE KEY `rl_idx` (`rl_idx`),
  KEY `fk_review_list_poi_id` (`poi_id`),
  KEY `fk_review_list_pi_id` (`pi_id`),
  CONSTRAINT `fk_review_list_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`),
  CONSTRAINT `fk_review_list_pi_id` FOREIGN KEY (`pi_id`) REFERENCES `t_product_info` (`pi_id`),
  CONSTRAINT `fk_review_list_poi_id` FOREIGN KEY (`poi_id`) REFERENCES `t_product_order_info` (`poi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_review_list`
--

LOCK TABLES `t_review_list` WRITE;
/*!40000 ALTER TABLE `t_review_list` DISABLE KEYS */;
INSERT INTO `t_review_list` VALUES (24,'hanbi1','211203dsf102','a101','굳굳',NULL,4,1,0,'y','2021-12-12 17:51:14'),(29,'hanbi1','211209kow102','a101','주위에 선물하려고 구매합니다',NULL,4,0,0,'y','2021-12-12 17:51:14'),(26,'khb83249','211203kfs104','a101','너무 편해요',NULL,5,0,0,'y','2021-12-12 17:51:14'),(31,'khb83249','211209mve104','a101','평범합니다',NULL,3,0,0,'y','2021-12-12 17:51:14'),(34,'khb83249','211209pmc107','a101','여기서만 가위 구매합니당',NULL,4,0,0,'y','2021-12-12 17:51:14'),(25,'luo391','211203kpe103','a101','평범하네요',NULL,3,0,0,'y','2021-12-12 17:51:14'),(33,'luo391','211209dov106','a101','선물 받은 사람이 너무 좋아했어요!',NULL,5,1,0,'y','2021-12-12 17:51:14'),(30,'luo391','211209qlo103','a101','무난하게 쓰기 좋아요',NULL,3,0,0,'y','2021-12-12 17:51:14'),(23,'park90','211203abc101','a101','처음 사보는데 기대됩니다',NULL,4,0,0,'y','2021-12-12 17:51:14'),(28,'park90','211209hes101','a101','재구매 합니다~',NULL,5,0,0,'y','2021-12-12 17:51:14'),(27,'sj2348','211203dji105','a101','별로에요',NULL,1,0,0,'y','2021-12-12 17:51:14'),(32,'sj2348','211209svw105','a101','잘 쓰다가 잃어버려서 재구매합니다',NULL,5,0,0,'y','2021-12-12 17:51:14'),(35,'sj2348','211209svw108','a101','왼손잡이용 가위 종류가 많아서 좋아용',NULL,4,1,0,'y','2021-12-12 17:51:14'),(36,'sj2348','211210scs101','a101','매번 여기서만 구매해요',NULL,5,1,0,'y','2021-12-12 17:51:14');
/*!40000 ALTER TABLE `t_review_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_review_report`
--

DROP TABLE IF EXISTS `t_review_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_review_report` (
  `rr_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `rl_idx` int NOT NULL,
  `rr_status` char(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT 'a',
  `rr_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `rr_opdate` datetime DEFAULT NULL,
  `ai_idx` int DEFAULT '0',
  PRIMARY KEY (`mi_id`,`rl_idx`),
  UNIQUE KEY `rr_idx` (`rr_idx`),
  KEY `fk_review_report_rl_idx` (`rl_idx`),
  CONSTRAINT `fk_review_report_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`),
  CONSTRAINT `fk_review_report_rl_idx` FOREIGN KEY (`rl_idx`) REFERENCES `t_review_list` (`rl_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_review_report`
--

LOCK TABLES `t_review_report` WRITE;
/*!40000 ALTER TABLE `t_review_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_review_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_mem_stat_info`
--

DROP TABLE IF EXISTS `v_mem_stat_info`;
/*!50001 DROP VIEW IF EXISTS `v_mem_stat_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_mem_stat_info` AS SELECT 
 1 AS `poi_id`,
 1 AS `mi_id`,
 1 AS `mi_hand`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_mem_stat_info2`
--

DROP TABLE IF EXISTS `v_mem_stat_info2`;
/*!50001 DROP VIEW IF EXISTS `v_mem_stat_info2`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_mem_stat_info2` AS SELECT 
 1 AS `foi_id`,
 1 AS `mi_id`,
 1 AS `mi_hand`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_review_info`
--

DROP TABLE IF EXISTS `v_review_info`;
/*!50001 DROP VIEW IF EXISTS `v_review_info`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_review_info` AS SELECT 
 1 AS `mi_id`,
 1 AS `pi_name`,
 1 AS `rl_content`,
 1 AS `rl_score`,
 1 AS `rl_good`,
 1 AS `rl_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'lefthand'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `evt_apply_edate` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `evt_apply_edate` ON SCHEDULE EVERY 1 DAY STARTS '2021-11-01 00:00:00' ON COMPLETION NOT PRESERVE ENABLE DO update t_challenge_info set ci_status = 'b' where left(ci_edate, 10) = left(now(), 10) */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'lefthand'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_lefthand_review` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_lefthand_review`(miid varchar(20) , poiid char(12)
	,piid char(4) ,rlcontent varchar(300) ,rlimg varchar(50), rlscore int )
begin
    begin
		insert into t_review_list(mi_id , poi_id ,pi_id ,rl_content ,rl_img , rl_score )
		values(miid , poiid ,piid ,rlcontent ,rlimg , rlscore);
        
        update t_product_info set pi_review = pi_review + 1, pi_score = (select avg(rl_score) from
        t_review_list where pi_id =piid) where pi_id =piid;
        -- 상품 테이블에서 리뷰개수 증가와 평점 평균 변경 쿼리
    end;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_member_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_member_insert`(
	miid varchar(20), mipw varchar(20), miname varchar(20), migender char(1), mibirth char(10), miphone	varchar(13), 
	miemail	varchar(50), mipoint int, mirecommend varchar(20), mihand char(1), mpcontent varchar(50)
)
begin
	declare err int default 0;
	declare continue handler for sqlexception set err = 1;
    start transaction;
    
		insert into t_member_info (mi_id, mi_pw, mi_name, mi_gender, mi_birth, mi_phone, mi_email, mi_point, mi_recommend, mi_hand) 
		values (miid, mipw, miname, migender, mibirth, miphone, miemail, mipoint, mirecommend, mihand);

		-- 포인트 적립내역 추가
		call sp_member_point(miid, 'b', mipoint, mpcontent, 0);
        
    if err = 0 then
		commit;	
	else		
		rollback;
	end if;	
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_member_point` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_member_point`(miid varchar(20), mpkind char(1), mppoint int, mpcontent varchar(50), aiidx int)
begin
	declare pnt int default 0;
    
	insert into t_member_point(mi_id, mp_kind, mp_point, mp_content, ai_idx) values(miid, mpkind, mppoint, mpcontent, aiidx);
    
    if mpkind = 'b' or mpkind = 'c' then	-- 포인트 b.적립 또는 c.관리(적립)일 경우			
		set pnt = mppoint;
    else									-- 포인트 a.사용 또는 d.관리(회수)일 경우
		set pnt = mppoint * -1;				
    end if;
    
    update t_member_info set mi_point = mi_point + pnt where mi_id = miid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_product_order_cart` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_product_order_cart`(kind char(1), pocidx int, miid varchar(20), piid char(4), poccnt int)
begin
	declare idx int default 0;	-- 동일상품/옵션을 가진 장바구니 인덱스번호를 저장할 변수
    
	select ifnull(poc_idx, 0) into idx from t_product_order_cart 
	where mi_id = miid and pi_id = piid and poc_idx <> pocidx;
    -- 등록 또는 수정하려는 상품과 동일한 상품(옵션 포함)의 인덱스번호를 추출하는 쿼리(없으면 0)

	if idx <> 0 and kind <> 'd' then	-- 삭제가 아니며 이미 동일한 상품이 있을 경우
    begin
		update t_product_order_cart set poc_cnt = poc_cnt + poccnt where poc_idx = idx and mi_id = miid;

        if kind = 'u' then
			delete from t_product_order_cart where poc_idx = pocidx and mi_id = miid;
        end if;
    end;
	elseif idx = 0 and kind <> 'd' then	-- 삭제가 아니며 동일한 상품이 없을 경우
    begin
		if kind = 'i' then		-- 장바구니 등록일 경우
			insert into t_product_order_cart (mi_id, pi_id, poc_cnt) values (miid, piid, poccnt);
		elseif kind = 'u' then	-- 장바구니 수정일 경우
			update t_product_order_cart set poc_cnt = poccnt where poc_idx = pocidx and mi_id = miid;
		end if;
	end;
    else					-- 장바구니 삭제일 경우
		delete from t_product_order_cart where poc_idx = pocidx and mi_id = miid;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_mem_stat_info`
--

/*!50001 DROP VIEW IF EXISTS `v_mem_stat_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_mem_stat_info` AS select `a`.`poi_id` AS `poi_id`,`b`.`mi_id` AS `mi_id`,`b`.`mi_hand` AS `mi_hand` from (`t_product_order_info` `a` join `t_member_info` `b`) where (`a`.`mi_id` = `b`.`mi_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_mem_stat_info2`
--

/*!50001 DROP VIEW IF EXISTS `v_mem_stat_info2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_mem_stat_info2` AS select `a`.`foi_id` AS `foi_id`,`b`.`mi_id` AS `mi_id`,`b`.`mi_hand` AS `mi_hand` from (`t_funding_order_info` `a` join `t_member_info` `b`) where (`a`.`mi_id` = `b`.`mi_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_review_info`
--

/*!50001 DROP VIEW IF EXISTS `v_review_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_review_info` AS select `a`.`mi_id` AS `mi_id`,`b`.`pi_name` AS `pi_name`,`a`.`rl_content` AS `rl_content`,`a`.`rl_score` AS `rl_score`,`a`.`rl_good` AS `rl_good`,`a`.`rl_date` AS `rl_date` from (`t_review_list` `a` join `t_product_info` `b`) where (`a`.`pi_id` = `b`.`pi_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-14 11:56:34
