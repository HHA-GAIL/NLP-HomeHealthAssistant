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
-- Table structure for table `generalmedicalhistorytable`
--

DROP TABLE IF EXISTS `generalmedicalhistorytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `generalmedicalhistorytable` (
  `GeneralMedicalHistoryID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `MaritalStatus` varchar(25) DEFAULT NULL,
  `Education` varchar(25) DEFAULT NULL,
  `GrowthAndDevelopment` varchar(128) DEFAULT NULL,
  `Pregnancies` varchar(128) DEFAULT NULL,
  `BehavioralHistory` varchar(254) DEFAULT NULL,
  `Tobacco` varchar(50) DEFAULT NULL,
  `TobaccoHRF` tinyint(1) DEFAULT '0',
  `TobaccoQuantity` varchar(75) DEFAULT NULL,
  `Tobaccoduraton` varchar(75) DEFAULT NULL,
  `Alcohol` varchar(50) DEFAULT NULL,
  `AlcoholHRF` tinyint(1) DEFAULT '0',
  `AlcoholQuantity` varchar(75) DEFAULT NULL,
  `Alcoholduration` varchar(75) DEFAULT NULL,
  `Drug` varchar(25) DEFAULT NULL,
  `DrugHRF` tinyint(1) DEFAULT '0',
  `DrugType` varchar(254) DEFAULT NULL,
  `Drugduration` varchar(75) DEFAULT NULL,
  `Dietary` varchar(254) DEFAULT NULL,
  `DietHRF` tinyint(1) DEFAULT '0',
  `Travel` varchar(254) DEFAULT NULL,
  `TravelHRF` tinyint(1) DEFAULT '0',
  `BloodType` varchar(10) DEFAULT NULL,
  `Rh` varchar(10) DEFAULT NULL,
  `MedicalHistoryNotes` varchar(4000) DEFAULT NULL,
  `HxObtainedBy` varchar(50) DEFAULT NULL,
  `HxConfirmedByHCP` tinyint(1) DEFAULT '0',
  `UnableToObtainHxReason` varchar(75) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `LMPDate` datetime DEFAULT NULL,
  `LMPStatus` varchar(128) DEFAULT NULL,
  `LMP` tinyint(1) DEFAULT '0',
  `Pregnant` tinyint(1) DEFAULT '0',
  `PregnancyDueDate` datetime DEFAULT NULL,
  `EDC` datetime DEFAULT NULL,
  `NumberOfChildren` int(11) DEFAULT NULL,
  `NumberOfPregnancies` int(11) DEFAULT NULL,
  `LMPEstMethod` varchar(50) DEFAULT NULL,
  `LMPDateApprox` tinyint(1) DEFAULT '0',
  `MenstrualAmtNormalYes` tinyint(1) DEFAULT '0',
  `MenstrualAmtNormalNo` tinyint(1) DEFAULT '0',
  `MensesMonthlyYes` tinyint(1) DEFAULT '0',
  `MensesMonthlyNo` tinyint(1) DEFAULT '0',
  `MensesPriorDate` datetime DEFAULT NULL,
  `MensesFreq` int(11) DEFAULT NULL,
  `MenarcheAgeOfOnset` int(11) DEFAULT NULL,
  `OnBCPAtConceptionYes` tinyint(1) DEFAULT '0',
  `OnBCPAtConceptionNo` tinyint(1) DEFAULT '0',
  `HospitalOfDelivery` varchar(50) DEFAULT NULL,
  `EGA` double DEFAULT NULL,
  PRIMARY KEY (`GeneralMedicalHistoryID`),
  KEY `GeneralMedHxPatientIDIndex` (`PatientID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generalmedicalhistorytable`
--

LOCK TABLES `generalmedicalhistorytable` WRITE;
/*!40000 ALTER TABLE `generalmedicalhistorytable` DISABLE KEYS */;
INSERT INTO `generalmedicalhistorytable` VALUES (1,1,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,0,NULL,NULL,NULL,NULL,0,NULL,0,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,0,0,0,0,0,NULL,NULL,NULL,0,0,NULL,NULL);
/*!40000 ALTER TABLE `generalmedicalhistorytable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 21:58:38
