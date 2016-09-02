CREATE DATABASE  IF NOT EXISTS `dbo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbo`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dbo
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `immunizationshistorytable`
--

DROP TABLE IF EXISTS `immunizationshistorytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `immunizationshistorytable` (
  `ImmunizationsID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `Vaccine` varchar(128) DEFAULT NULL,
  `ImmunizationDate` date DEFAULT NULL,
  `ExperationDate` date DEFAULT NULL,
  `Delivery` varchar(128) DEFAULT NULL,
  `Comments` varchar(254) DEFAULT NULL,
  `HCPId` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ImmunizationsID`),
  KEY `I_PatientID` (`PatientID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immunizationshistorytable`
--

LOCK TABLES `immunizationshistorytable` WRITE;
/*!40000 ALTER TABLE `immunizationshistorytable` DISABLE KEYS */;
INSERT INTO `immunizationshistorytable` VALUES (1,1,'Flu','2017-05-30','2017-06-02','shot','',1,0),(2,1,'Polio','2016-08-16','2017-08-16','Shot','Hello World!',1,0),(3,1,'Rabies','2016-06-02','2020-06-03','Shot','Ouch!',1,0),(4,1,'Distemper','2015-02-14','2017-07-08','Shot','Bark!',1,0),(5,1,'Flu','2017-05-30','2016-06-10','shot','',1,0),(6,1,'Testing','2015-07-08','2017-07-08','shot','NOOOOo',1,0);
/*!40000 ALTER TABLE `immunizationshistorytable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 21:58:36
