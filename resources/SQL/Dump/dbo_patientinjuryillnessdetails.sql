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
-- Table structure for table `patientinjuryillnessdetails`
--

DROP TABLE IF EXISTS `patientinjuryillnessdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientinjuryillnessdetails` (
  `EncounterID` int(11) NOT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `Injury?` tinyint(1) DEFAULT '0',
  `Illness?` tinyint(1) DEFAULT '0',
  `Pregnancy?` tinyint(1) DEFAULT '0',
  `DateOfProblem` datetime DEFAULT NULL,
  `TimeOfProblem` varchar(20) DEFAULT NULL,
  `DateOfSimilarProblem` datetime DEFAULT NULL,
  `WorkRelated?` tinyint(1) DEFAULT '0',
  `Employer` varchar(128) DEFAULT NULL,
  `JobTitle` varchar(50) DEFAULT NULL,
  `PresentlyWorking?` tinyint(1) DEFAULT '0',
  `DateLastWorked` datetime DEFAULT NULL,
  `WorkCapacity` varchar(50) DEFAULT NULL,
  `AutoAccident?` tinyint(1) DEFAULT '0',
  `StateOfAccident` varchar(10) DEFAULT NULL,
  `OtherAccident?` tinyint(1) DEFAULT '0',
  `StartDateUnableToWork` datetime DEFAULT NULL,
  `EndDateUnableToWork` datetime DEFAULT NULL,
  `PlanToConsultLawyer` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `StateOfInjury` varchar(10) DEFAULT NULL,
  `CountryOfInjury` varchar(50) DEFAULT NULL,
  `CountryOfAccident` varchar(50) DEFAULT NULL,
  `EmployerID` int(11) DEFAULT NULL,
  `Comments` varchar(1024) DEFAULT NULL,
  `ReturnToWorkDate` datetime DEFAULT NULL,
  `CasualtyClaimNumber` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`EncounterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientinjuryillnessdetails`
--

LOCK TABLES `patientinjuryillnessdetails` WRITE;
/*!40000 ALTER TABLE `patientinjuryillnessdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `patientinjuryillnessdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 21:58:39
