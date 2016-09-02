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
-- Table structure for table `diabeticinformation`
--

DROP TABLE IF EXISTS `diabeticinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diabeticinformation` (
  `DiabeticInfoID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `HCPID` int(11) DEFAULT NULL,
  `PriscillaWhiteClassification` varchar(5) DEFAULT NULL,
  `CalorieADADiet` varchar(15) DEFAULT NULL,
  `Compliance` tinyint(1) DEFAULT '0',
  `FollowUpWithDietitian` varchar(50) DEFAULT NULL,
  `PrevInsulinReqMorning` varchar(50) DEFAULT NULL,
  `PrevInsulinReqEvening` varchar(50) DEFAULT NULL,
  `PrevInsulinReqBedtime` varchar(50) DEFAULT NULL,
  `CurrentInsulinReqMorning` varchar(50) DEFAULT NULL,
  `CurrentInsulinReqEvening` varchar(50) DEFAULT NULL,
  `CurrentInsulinReqBedtime` varchar(50) DEFAULT NULL,
  `InsulinReqComments` varchar(7996) DEFAULT NULL,
  `InsulinReqRecommendations` varchar(512) DEFAULT NULL,
  `LabWorkOrdered` varchar(254) DEFAULT NULL,
  `RecordCreateDate` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `ReportType` varchar(25) DEFAULT NULL,
  `DiabeticMedication` varchar(50) DEFAULT NULL,
  `UrineDipProtein` varchar(10) DEFAULT NULL,
  `UrineDipGlucose` varchar(10) DEFAULT NULL,
  `ComplianceNo` tinyint(1) DEFAULT '0',
  `EDD` datetime DEFAULT NULL,
  `EGA` double DEFAULT NULL,
  PRIMARY KEY (`DiabeticInfoID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diabeticinformation`
--

LOCK TABLES `diabeticinformation` WRITE;
/*!40000 ALTER TABLE `diabeticinformation` DISABLE KEYS */;
/*!40000 ALTER TABLE `diabeticinformation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 21:58:35
