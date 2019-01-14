-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: courses-db
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `instructor` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK51k53m6m5gi9n91fnlxkxgpmv` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,14,'2018-10-22 10:38:13','Dojo Man','Java/Spring',NULL,1),(8,5,'2018-10-22 12:16:46','jairo burgos','procrastination 101',NULL,2),(9,10,'2018-10-22 13:12:47','Dr.Smitty ','Shingles and you',NULL,5);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joined_courses`
--

DROP TABLE IF EXISTS `joined_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `joined_courses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKryrag2j3s81env03qndj9xnjb` (`course_id`),
  KEY `FK96pnm96u8q36x58vrpay84e0i` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joined_courses`
--

LOCK TABLES `joined_courses` WRITE;
/*!40000 ALTER TABLE `joined_courses` DISABLE KEYS */;
INSERT INTO `joined_courses` VALUES (2,'2018-09-22 11:13:01',NULL,1,1),(3,'2018-10-11 11:37:00',NULL,1,2),(8,'2018-09-21 12:26:27',NULL,8,2),(9,'2018-10-22 12:27:32',NULL,8,3),(16,'2018-10-22 13:13:25',NULL,8,1),(11,'2018-10-22 12:28:23',NULL,8,4),(13,'2018-10-22 12:58:48',NULL,8,5),(15,'2018-10-22 13:13:01',NULL,9,5);
/*!40000 ALTER TABLE `joined_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2018-10-22 10:23:56','sallyshells@seashore.co.jp','Sally','Seashore','$2a$10$q0XQjepCcQizHb4z8/Zb0.TyZKgrpjF.0JHvhFdzA5EmoCGfT14he',NULL),(2,'2018-10-22 11:36:48','juan@one.com','juan','da one','$2a$10$WD83LP5luPOgVQonhoCcaezxvhqil1Vtk2nLCyzPMeS4sAyuxtiR.',NULL),(3,'2018-10-22 12:27:25','steve@steve.com','steve','stevenson','$2a$10$UOWKzh/W2zkLs40A9LmtMe4pSEO1Ns0AYhtR7QIqGAKVHVvkjho7W',NULL),(4,'2018-10-22 12:28:15','simon@simon.com','simon','simonson','$2a$10$pQj6Uzc.1zbJciUl2MAiUefZ9Q4gFa2RVwUC2c4mu.rbwYMXG1vuG',NULL),(5,'2018-10-22 12:29:37','john@john.com','johnny','johnny','$2a$10$lcPpRx8RECcduMsaYfTD..3ixSJyKMD0tcg..II3dBrFSB0MVVGNS',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-22 13:17:22
