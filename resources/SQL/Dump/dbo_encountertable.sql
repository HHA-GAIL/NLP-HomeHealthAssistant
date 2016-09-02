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
-- Table structure for table `encountertable`
--

DROP TABLE IF EXISTS `encountertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encountertable` (
  `EncounterID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientType` varchar(25) DEFAULT NULL,
  `EncounterCategory` varchar(128) DEFAULT NULL,
  `EncounterType` varchar(128) DEFAULT NULL,
  `EncounterReason` varchar(254) DEFAULT NULL,
  `Admission` tinyint(1) DEFAULT '0',
  `Discharge` tinyint(1) DEFAULT '0',
  `PatientID` int(11) DEFAULT NULL,
  `EncounterDate` datetime DEFAULT NULL,
  `GeneralLocation` int(11) DEFAULT NULL,
  `SpecificLocation` varchar(128) DEFAULT NULL,
  `Room` varchar(50) DEFAULT NULL,
  `ScheduledStartTime` double DEFAULT NULL,
  `ScheduledEndTime` double DEFAULT NULL,
  `ActualStartTime` datetime DEFAULT NULL,
  `ActualEndTime` datetime DEFAULT NULL,
  `PrimaryEncounterHCP` int(11) DEFAULT NULL,
  `AssistantEncounterHCP` int(11) DEFAULT NULL,
  `ReferringHCP` int(11) DEFAULT NULL,
  `SedationLevel` varchar(75) DEFAULT NULL,
  `Tmed` tinyint(1) DEFAULT '0',
  `New` tinyint(1) DEFAULT '0',
  `NoShow` tinyint(1) DEFAULT '0',
  `Canceled` tinyint(1) DEFAULT '0',
  `Transcribed` tinyint(1) DEFAULT '0',
  `TranscriptionDate` datetime DEFAULT NULL,
  `Reported` tinyint(1) DEFAULT '0',
  `ReportedDate` datetime DEFAULT NULL,
  `FUTime` int(11) DEFAULT NULL,
  `FUPeriod` varchar(25) DEFAULT NULL,
  `FUNote` varchar(254) DEFAULT NULL,
  `FUFor` varchar(50) DEFAULT NULL,
  `FUdays` int(11) DEFAULT NULL,
  `FUHCP` int(11) DEFAULT NULL,
  `FULocation` int(11) DEFAULT NULL,
  `ncolor` double DEFAULT NULL,
  `bremindico` tinyint(1) DEFAULT '0',
  `btentative` tinyint(1) DEFAULT '0',
  `bprivateic` tinyint(1) DEFAULT '0',
  `blocateico` varchar(25) DEFAULT NULL,
  `DateScheduled` datetime DEFAULT NULL,
  `TimeScheduled` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updates` varchar(128) DEFAULT NULL,
  `ProcedureType` varchar(128) DEFAULT NULL,
  `ApptID` int(11) DEFAULT NULL,
  `LogbookID` int(11) DEFAULT NULL,
  `EncounterReasonID` int(11) DEFAULT NULL,
  `CasualtyClaim` tinyint(1) DEFAULT '0',
  `CasualtyClaimNumber` int(11) DEFAULT NULL,
  `FacilityCode` varchar(50) DEFAULT NULL,
  `SpecialProgramCode` varchar(50) DEFAULT NULL,
  `Ambulance` tinyint(1) DEFAULT '0',
  `HomeBound` tinyint(1) DEFAULT '0',
  `Urgency` varchar(25) DEFAULT NULL,
  `PeriodicScreening` tinyint(1) DEFAULT '0',
  `FamilyPlanning` tinyint(1) DEFAULT '0',
  `AdmissionDate` datetime DEFAULT NULL,
  `DischargeDate` datetime DEFAULT NULL,
  `InpatientMR#` varchar(50) DEFAULT NULL,
  `RelatedToHospitalization` tinyint(1) DEFAULT '0',
  `DoNotBill` tinyint(1) DEFAULT '0',
  `PROApproval` tinyint(1) DEFAULT '0',
  `PROPriorAuthNum` varchar(50) DEFAULT NULL,
  `ClinicalTrial` tinyint(1) DEFAULT '0',
  `InjuryIllness` tinyint(1) DEFAULT '0',
  `Pregnancy` tinyint(1) DEFAULT '0',
  `PregnancyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`EncounterID`),
  KEY `EncounterPatientID_index` (`PatientID`),
  KEY `I_EncounterDate` (`EncounterDate`),
  KEY `Idx_EncounterType` (`EncounterType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encountertable`
--

LOCK TABLES `encountertable` WRITE;
/*!40000 ALTER TABLE `encountertable` DISABLE KEYS */;
/*!40000 ALTER TABLE `encountertable` ENABLE KEYS */;
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
