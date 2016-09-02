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
-- Table structure for table `specificmedicalhistorytable`
--

DROP TABLE IF EXISTS `specificmedicalhistorytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specificmedicalhistorytable` (
  `SpecificMedicalHistoryID` int(11) NOT NULL AUTO_INCREMENT,
  `EncounterID` int(11) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `SMHTime` varchar(16) DEFAULT NULL,
  `VisitType` varchar(128) DEFAULT NULL,
  `ChiefComplaint` varchar(2048) DEFAULT NULL,
  `History` varchar(4000) DEFAULT NULL,
  `Injury` tinyint(1) DEFAULT '0',
  `WorkRelated` tinyint(1) DEFAULT '0',
  `EmployerAtTmeOfInjury` varchar(128) DEFAULT NULL,
  `DateOfInjury` datetime DEFAULT NULL,
  `TimeOfInjury` varchar(15) DEFAULT NULL,
  `Location` varchar(50) DEFAULT NULL,
  `Quality` varchar(50) DEFAULT NULL,
  `Severity` varchar(50) DEFAULT NULL,
  `Duration` varchar(50) DEFAULT NULL,
  `Timing` varchar(50) DEFAULT NULL,
  `Context` varchar(50) DEFAULT NULL,
  `ModifyingFactors` varchar(50) DEFAULT NULL,
  `AssociatedSymptoms` varchar(50) DEFAULT NULL,
  `RelatedFunctionStatus` varchar(50) DEFAULT NULL,
  `Constitutional` varchar(254) DEFAULT NULL,
  `Eye` varchar(254) DEFAULT NULL,
  `Eye1` tinyint(1) DEFAULT '0',
  `Eye2` tinyint(1) DEFAULT '0',
  `Eye3` tinyint(1) DEFAULT '0',
  `Eye4` tinyint(1) DEFAULT '0',
  `Eye5` tinyint(1) DEFAULT '0',
  `ENT` varchar(254) DEFAULT NULL,
  `ENT1` tinyint(1) DEFAULT '0',
  `ENT2` tinyint(1) DEFAULT '0',
  `ENT3` tinyint(1) DEFAULT '0',
  `ENT4` tinyint(1) DEFAULT '0',
  `ENT5` tinyint(1) DEFAULT '0',
  `Cardiovascular` varchar(254) DEFAULT NULL,
  `Cardiovascular1` tinyint(1) DEFAULT '0',
  `Cardiovascular2` tinyint(1) DEFAULT '0',
  `Cardiovascular3` tinyint(1) DEFAULT '0',
  `Cardiovascular4` tinyint(1) DEFAULT '0',
  `Cardiovascular5` tinyint(1) DEFAULT '0',
  `Respiratory` varchar(254) DEFAULT NULL,
  `Respiratory1` tinyint(1) DEFAULT '0',
  `Respiratory2` tinyint(1) DEFAULT '0',
  `Respiratory3` tinyint(1) DEFAULT '0',
  `Respiratory4` tinyint(1) DEFAULT '0',
  `Respiratory5` tinyint(1) DEFAULT '0',
  `GastroIntestinal` varchar(254) DEFAULT NULL,
  `GastroIntestinal1` tinyint(1) DEFAULT '0',
  `GastroIntestinal2` tinyint(1) DEFAULT '0',
  `GastroIntestinal3` tinyint(1) DEFAULT '0',
  `GastroIntestinal4` tinyint(1) DEFAULT '0',
  `GastroIntestinal5` tinyint(1) DEFAULT '0',
  `GenitoUrinary` varchar(254) DEFAULT NULL,
  `GenitoUrinary1` tinyint(1) DEFAULT '0',
  `GenitoUrinary2` tinyint(1) DEFAULT '0',
  `GenitoUrinary3` tinyint(1) DEFAULT '0',
  `GenitoUrinary4` tinyint(1) DEFAULT '0',
  `GenitoUrinary5` tinyint(1) DEFAULT '0',
  `MusculoSkeletal` varchar(254) DEFAULT NULL,
  `MusculoSkeletal1` tinyint(1) DEFAULT '0',
  `MusculoSkeletal2` tinyint(1) DEFAULT '0',
  `MusculoSkeletal3` tinyint(1) DEFAULT '0',
  `MusculoSkeletal4` tinyint(1) DEFAULT '0',
  `MusculoSkeletal5` tinyint(1) DEFAULT '0',
  `SkinBreast` varchar(254) DEFAULT NULL,
  `SkinBreast1` tinyint(1) DEFAULT '0',
  `SkinBreast2` tinyint(1) DEFAULT '0',
  `SkinBreast3` tinyint(1) DEFAULT '0',
  `SkinBreast4` tinyint(1) DEFAULT '0',
  `SkinBreast5` tinyint(1) DEFAULT '0',
  `Neurological` varchar(254) DEFAULT NULL,
  `Neurological1` tinyint(1) DEFAULT '0',
  `Neurological2` tinyint(1) DEFAULT '0',
  `Neurological3` tinyint(1) DEFAULT '0',
  `Neurological4` tinyint(1) DEFAULT '0',
  `Neurological5` tinyint(1) DEFAULT '0',
  `Psychiatric` varchar(254) DEFAULT NULL,
  `Psychiatric1` tinyint(1) DEFAULT '0',
  `Psychiatric2` tinyint(1) DEFAULT '0',
  `Psychiatric3` tinyint(1) DEFAULT '0',
  `Psychiatric4` tinyint(1) DEFAULT '0',
  `Psychiatric5` tinyint(1) DEFAULT '0',
  `Endocrine` varchar(254) DEFAULT NULL,
  `Endocrine1` tinyint(1) DEFAULT '0',
  `Endocrine2` tinyint(1) DEFAULT '0',
  `Endocrine3` tinyint(1) DEFAULT '0',
  `Endocrine4` tinyint(1) DEFAULT '0',
  `Endocrine5` tinyint(1) DEFAULT '0',
  `Hematologic/Lymphatic` varchar(254) DEFAULT NULL,
  `Hematologic/Lymphatic1` tinyint(1) DEFAULT '0',
  `Hematologic/Lymphatic2` tinyint(1) DEFAULT '0',
  `Hematologic/Lymphatic3` tinyint(1) DEFAULT '0',
  `Hematologic/Lymphatic4` tinyint(1) DEFAULT '0',
  `Hematologic/Lymphatic5` tinyint(1) DEFAULT '0',
  `Allergic/Immunologic` varchar(254) DEFAULT NULL,
  `Allergic/Immunologic1` tinyint(1) DEFAULT '0',
  `Allergic/Immunologic2` tinyint(1) DEFAULT '0',
  `Allergic/Immunologic3` tinyint(1) DEFAULT '0',
  `Allergic/Immunologic4` tinyint(1) DEFAULT '0',
  `Allergic/Immunologic5` tinyint(1) DEFAULT '0',
  `HxObtainedBy` varchar(128) DEFAULT NULL,
  `UnableToObtainHxReason` varchar(75) DEFAULT NULL,
  `HxConfirmedBy HCP` tinyint(1) DEFAULT '0',
  `HxObtainedFrom` varchar(128) DEFAULT NULL,
  `ReferralRpt` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `OnsetOfSxDate` datetime DEFAULT NULL,
  PRIMARY KEY (`SpecificMedicalHistoryID`),
  KEY `SMHEncounterIDIndex` (`EncounterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specificmedicalhistorytable`
--

LOCK TABLES `specificmedicalhistorytable` WRITE;
/*!40000 ALTER TABLE `specificmedicalhistorytable` DISABLE KEYS */;
/*!40000 ALTER TABLE `specificmedicalhistorytable` ENABLE KEYS */;
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
