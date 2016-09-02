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
-- Table structure for table `pastpregnanciestable`
--

DROP TABLE IF EXISTS `pastpregnanciestable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pastpregnanciestable` (
  `PastPregnanciesID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `PregnancyDate` varchar(25) DEFAULT NULL,
  `EGA` double DEFAULT NULL,
  `LengthOfLabor` varchar(25) DEFAULT NULL,
  `BirthWeightLbs` double DEFAULT NULL,
  `BirthWeightOunces` double DEFAULT NULL,
  `Sex` varchar(10) DEFAULT NULL,
  `TypeOfDelivery` varchar(50) DEFAULT NULL,
  `PlaceOfDelivery` varchar(75) DEFAULT NULL,
  `PreTermLabor` tinyint(1) DEFAULT '0',
  `Comments` varchar(512) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `NumberOfFetuses` int(11) DEFAULT NULL,
  `Corionicity` varchar(50) DEFAULT NULL,
  `Choncordant` tinyint(1) DEFAULT '0',
  `TwinToTwinTransSyndrome` tinyint(1) DEFAULT '0',
  `LMP` datetime DEFAULT NULL,
  `EDD` datetime DEFAULT NULL,
  `EGAEstMethod` varchar(50) DEFAULT NULL,
  `OnBCPAtConceptionYes` tinyint(1) DEFAULT '0',
  `OnBCPAtConceptionNo` tinyint(1) DEFAULT '0',
  `Current` tinyint(1) DEFAULT '0',
  `DateStamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `EGACalculationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`PastPregnanciesID`),
  KEY `I_PatientID` (`PatientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pastpregnanciestable`
--

LOCK TABLES `pastpregnanciestable` WRITE;
/*!40000 ALTER TABLE `pastpregnanciestable` DISABLE KEYS */;
/*!40000 ALTER TABLE `pastpregnanciestable` ENABLE KEYS */;
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
