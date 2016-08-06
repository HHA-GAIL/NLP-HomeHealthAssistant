-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gale
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Current Database: `gale`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `gale` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gale`;

--
-- Table structure for table `decision`
--

DROP TABLE IF EXISTS `decision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `decision` (
  `DecisionID` int(11) NOT NULL AUTO_INCREMENT,
  `Answer` text,
  `EventCode` text,
  `DetermineNode` int(11) DEFAULT NULL,
  `Deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`DecisionID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decision`
--

LOCK TABLES `decision` WRITE;
/*!40000 ALTER TABLE `decision` DISABLE KEYS */;
INSERT INTO `decision` VALUES (1,'Reset','0,0',1,0),(2,'Begin Family Interview','0,1',2,0);
/*!40000 ALTER TABLE `decision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `node` (
  `NodeID` int(11) NOT NULL AUTO_INCREMENT,
  `Question` text,
  `deleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`NodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node`
--

LOCK TABLES `node` WRITE;
/*!40000 ALTER TABLE `node` DISABLE KEYS */;
INSERT INTO `node` VALUES (1,'Hello, what can I do for you?',0),(2,'May I interview you for your family history',0);
/*!40000 ALTER TABLE `node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `node_has_decision`
--

DROP TABLE IF EXISTS `node_has_decision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `node_has_decision` (
  `node_NodeID` int(11) NOT NULL,
  `Decision_DecisionID` int(11) NOT NULL,
  PRIMARY KEY (`node_NodeID`,`Decision_DecisionID`),
  KEY `fk_node_has_Decision_Decision1_idx` (`Decision_DecisionID`),
  KEY `fk_node_has_Decision_node1_idx` (`node_NodeID`),
  CONSTRAINT `fk_node_has_Decision_Decision1` FOREIGN KEY (`Decision_DecisionID`) REFERENCES `decision` (`DecisionID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_node_has_Decision_node1` FOREIGN KEY (`node_NodeID`) REFERENCES `node` (`NodeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node_has_decision`
--

LOCK TABLES `node_has_decision` WRITE;
/*!40000 ALTER TABLE `node_has_decision` DISABLE KEYS */;
INSERT INTO `node_has_decision` VALUES (1,1),(2,1),(1,2);
/*!40000 ALTER TABLE `node_has_decision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gale'
--

--
-- Dumping routines for database 'gale'
--

--
-- Current Database: `dbo`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `dbo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dbo`;

--
-- Table structure for table `allergyhistorytable`
--

DROP TABLE IF EXISTS `allergyhistorytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allergyhistorytable` (
  `AllergyID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `Allergen` varchar(254) DEFAULT NULL,
  `AllergyStartDate` varchar(25) DEFAULT NULL,
  `AllergyEndDate` varchar(25) DEFAULT NULL,
  `AllergyDescription` varchar(254) DEFAULT NULL,
  `AllergyHRF` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`AllergyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allergyhistorytable`
--

LOCK TABLES `allergyhistorytable` WRITE;
/*!40000 ALTER TABLE `allergyhistorytable` DISABLE KEYS */;
/*!40000 ALTER TABLE `allergyhistorytable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessmentanddecisiontable`
--

DROP TABLE IF EXISTS `assessmentanddecisiontable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessmentanddecisiontable` (
  `AssessmentID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `AssessmentTime` varchar(16) DEFAULT NULL,
  `OutcomeImproved` varchar(75) DEFAULT NULL,
  `ImprovedText` varchar(254) DEFAULT NULL,
  `OutcomeControlled` varchar(75) DEFAULT NULL,
  `ControlledText` varchar(254) DEFAULT NULL,
  `OutcomeResolved` varchar(75) DEFAULT NULL,
  `ResolvedText` varchar(254) DEFAULT NULL,
  `DiagnosticTestReview` varchar(2048) DEFAULT NULL,
  `RecordsReview` varchar(2048) DEFAULT NULL,
  `MedicationReview` varchar(2048) DEFAULT NULL,
  `TherapyReview` varchar(2048) DEFAULT NULL,
  `InstructionsReview` varchar(2048) DEFAULT NULL,
  `ComorbidityReview` varchar(2048) DEFAULT NULL,
  `RisksReview` varchar(2048) DEFAULT NULL,
  `Careplan` varchar(2048) DEFAULT NULL,
  `Comments1` varchar(1024) DEFAULT NULL,
  `Assessment` varchar(2048) DEFAULT NULL,
  `H&P time` int(11) DEFAULT NULL,
  `Planning time` int(11) DEFAULT NULL,
  `Complexity` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `FutureWU?` tinyint(1) DEFAULT '0',
  `DisabilityStartDate` datetime DEFAULT NULL,
  `DisabilityEndDate` datetime DEFAULT NULL,
  `ReturnToWorkDate` datetime DEFAULT NULL,
  PRIMARY KEY (`AssessmentID`),
  KEY `AssessmentEncounterIDIndex` (`EncounterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessmentanddecisiontable`
--

LOCK TABLES `assessmentanddecisiontable` WRITE;
/*!40000 ALTER TABLE `assessmentanddecisiontable` DISABLE KEYS */;
/*!40000 ALTER TABLE `assessmentanddecisiontable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit`
--

DROP TABLE IF EXISTS `audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit` (
  `AuditID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(128) DEFAULT NULL,
  `DigitalSignature` binary(130) DEFAULT NULL,
  `FormName` varchar(128) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `PatientName` varchar(128) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `TransactionDate` datetime DEFAULT NULL,
  `Operation` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AuditID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit`
--

LOCK TABLES `audit` WRITE;
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinicalvaluestable`
--

DROP TABLE IF EXISTS `clinicalvaluestable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinicalvaluestable` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Topic` varchar(50) NOT NULL,
  `Scope` char(1) NOT NULL,
  `Username` varchar(128) DEFAULT NULL,
  `Value` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `I_Scope` (`Scope`),
  KEY `I_Topic` (`Topic`),
  KEY `I_Username` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinicalvaluestable`
--

LOCK TABLES `clinicalvaluestable` WRITE;
/*!40000 ALTER TABLE `clinicalvaluestable` DISABLE KEYS */;
/*!40000 ALTER TABLE `clinicalvaluestable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `completephysical`
--

DROP TABLE IF EXISTS `completephysical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `completephysical` (
  `CompleteGeneralSpecialistClinicID` int(11) NOT NULL AUTO_INCREMENT,
  `EncounterID` int(11) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `PETime` varchar(16) DEFAULT NULL,
  `Ht` float(24,0) DEFAULT NULL,
  `Ht Unit of Measurement` varchar(2) DEFAULT NULL,
  `Wt` float(24,0) DEFAULT NULL,
  `Wt Unit of Measurement` varchar(3) DEFAULT NULL,
  `HR` smallint(6) DEFAULT NULL,
  `RR` smallint(6) DEFAULT NULL,
  `HeadCircumference` double DEFAULT NULL,
  `Head Unit of Measurement` varchar(3) DEFAULT NULL,
  `BodyMassIndex` double DEFAULT NULL,
  `BPSYS1` smallint(6) DEFAULT NULL,
  `BPDIAS1` smallint(6) DEFAULT NULL,
  `BP1Position` varchar(25) DEFAULT NULL,
  `BP1Location` varchar(50) DEFAULT NULL,
  `BPSYS2` smallint(6) DEFAULT NULL,
  `BPDIAS2` smallint(6) DEFAULT NULL,
  `BP2Position` varchar(25) DEFAULT NULL,
  `BP2Location` varchar(50) DEFAULT NULL,
  `BPSYS3` smallint(6) DEFAULT NULL,
  `BPDIAS3` smallint(6) DEFAULT NULL,
  `BP3Position` varchar(25) DEFAULT NULL,
  `BP3Location` varchar(50) DEFAULT NULL,
  `Temperature` double DEFAULT NULL,
  `Temperature unit` varchar(50) DEFAULT NULL,
  `GeneralAppearance` varchar(50) DEFAULT NULL,
  `GeneralAbilityToCommunicate` varchar(50) DEFAULT NULL,
  `HFInspection` varchar(50) DEFAULT NULL,
  `HFPalpation` varchar(50) DEFAULT NULL,
  `HFSalivaryGlands` varchar(50) DEFAULT NULL,
  `HFFacialStrength` varchar(50) DEFAULT NULL,
  `EConjunctiva` varchar(50) DEFAULT NULL,
  `EPupils` varchar(50) DEFAULT NULL,
  `EOpticDisks` varchar(50) DEFAULT NULL,
  `ERetina` varchar(50) DEFAULT NULL,
  `EMacula` varchar(50) DEFAULT NULL,
  `EVisualAcuity` varchar(50) DEFAULT NULL,
  `EVisualFields` varchar(50) DEFAULT NULL,
  `EOccularMotility` varchar(50) DEFAULT NULL,
  `ECornea` varchar(50) DEFAULT NULL,
  `EAnteriorChamber` varchar(50) DEFAULT NULL,
  `EPosteriorChamber` varchar(50) DEFAULT NULL,
  `ELenses` varchar(50) DEFAULT NULL,
  `EIntraocularPressure` varchar(50) DEFAULT NULL,
  `EOcularAdnexa` varchar(50) DEFAULT NULL,
  `ELConjunctiva` varchar(50) DEFAULT NULL,
  `ELPupils` varchar(50) DEFAULT NULL,
  `ELOpticDisks` varchar(50) DEFAULT NULL,
  `ELRetina` varchar(50) DEFAULT NULL,
  `ELMacula` varchar(50) DEFAULT NULL,
  `ELVisualAcuity` varchar(50) DEFAULT NULL,
  `ELVisualFields` varchar(50) DEFAULT NULL,
  `ELOccularMotility` varchar(50) DEFAULT NULL,
  `ELCornea` varchar(50) DEFAULT NULL,
  `ELAnteriorChamber` varchar(50) DEFAULT NULL,
  `ELPosteriorChamber` varchar(50) DEFAULT NULL,
  `ELLenses` varchar(50) DEFAULT NULL,
  `ELIntraocularPressure` varchar(50) DEFAULT NULL,
  `ELOcularAdnexa` varchar(50) DEFAULT NULL,
  `ENExternal` varchar(50) DEFAULT NULL,
  `ENAuditoryCanal` varchar(50) DEFAULT NULL,
  `ENHearing` varchar(50) DEFAULT NULL,
  `ENLExternal` varchar(50) DEFAULT NULL,
  `ENLAuditoryCanal` varchar(50) DEFAULT NULL,
  `ENLHearing` varchar(50) DEFAULT NULL,
  `ENNasopharynx` varchar(50) DEFAULT NULL,
  `ENOralCavity` varchar(50) DEFAULT NULL,
  `ENOropharynx` varchar(50) DEFAULT NULL,
  `ENPharyngealWall` varchar(50) DEFAULT NULL,
  `ENLarynxWithMirror` varchar(50) DEFAULT NULL,
  `ENNasopharynxWithMirror` varchar(50) DEFAULT NULL,
  `ENAtraumatic` tinyint(1) DEFAULT '0',
  `NGeneral` varchar(50) DEFAULT NULL,
  `NThyroid` varchar(50) DEFAULT NULL,
  `NJugularVeins` varchar(50) DEFAULT NULL,
  `RChestSymmetry` varchar(50) DEFAULT NULL,
  `REffort` varchar(50) DEFAULT NULL,
  `RRespiratoryEffort` varchar(50) DEFAULT NULL,
  `RPercussion` varchar(50) DEFAULT NULL,
  `RPalpitation` varchar(50) DEFAULT NULL,
  `RAuscultation` varchar(50) DEFAULT NULL,
  `CPalpationOfHeart` varchar(50) DEFAULT NULL,
  `CAuscultationHtSounds` varchar(50) DEFAULT NULL,
  `CAuscultationMurmurs` varchar(50) DEFAULT NULL,
  `CCarotidArteries` varchar(50) DEFAULT NULL,
  `CLCarotidArteries` varchar(50) DEFAULT NULL,
  `CAbdominalAorta` varchar(50) DEFAULT NULL,
  `CFemoralArteries` varchar(50) DEFAULT NULL,
  `CLFemoralArteries` varchar(50) DEFAULT NULL,
  `CPedalPulses` varchar(50) DEFAULT NULL,
  `CLPedalPulses` varchar(50) DEFAULT NULL,
  `CExtremities` varchar(50) DEFAULT NULL,
  `CLExtremities` varchar(50) DEFAULT NULL,
  `CClick` varchar(50) DEFAULT NULL,
  `CPrecordium` varchar(50) DEFAULT NULL,
  `CRythm` varchar(50) DEFAULT NULL,
  `CS1` varchar(50) DEFAULT NULL,
  `CS2` varchar(50) DEFAULT NULL,
  `CS3` varchar(50) DEFAULT NULL,
  `CThrills` varchar(50) DEFAULT NULL,
  `BInspection` varchar(50) DEFAULT NULL,
  `BPalpation` varchar(50) DEFAULT NULL,
  `APalpation` varchar(50) DEFAULT NULL,
  `ALiverAndSpleen` varchar(50) DEFAULT NULL,
  `ACheckForHernia` varchar(50) DEFAULT NULL,
  `AExamOfAnusPerineumRectum` varchar(50) DEFAULT NULL,
  `GMaleScrotalContents` varchar(50) DEFAULT NULL,
  `GMalePenis` varchar(50) DEFAULT NULL,
  `GMaleProstate` varchar(50) DEFAULT NULL,
  `GMaleEpididymides` varchar(50) DEFAULT NULL,
  `GMaleUrethralMeatus` varchar(50) DEFAULT NULL,
  `GFemaleExternalGenitalia` varchar(50) DEFAULT NULL,
  `GFemaleUrethra` varchar(50) DEFAULT NULL,
  `GFemaleUrethraMeatus` varchar(50) DEFAULT NULL,
  `GFemaleBladder` varchar(50) DEFAULT NULL,
  `GFemaleVagina` varchar(50) DEFAULT NULL,
  `GFemaleCervix` varchar(50) DEFAULT NULL,
  `GFemaleUterus` varchar(50) DEFAULT NULL,
  `GFemaleAdnexa` varchar(50) DEFAULT NULL,
  `LNodesNeck` varchar(50) DEFAULT NULL,
  `LNodesAxillae` varchar(50) DEFAULT NULL,
  `LNodesGroin` varchar(50) DEFAULT NULL,
  `MGaitAndStation` varchar(50) DEFAULT NULL,
  `MDigitsAndNails` varchar(50) DEFAULT NULL,
  `MHeadAndNeck` varchar(50) DEFAULT NULL,
  `MSpineRibsPelvis` varchar(50) DEFAULT NULL,
  `MArms` varchar(50) DEFAULT NULL,
  `MLegs` varchar(50) DEFAULT NULL,
  `MStrength` varchar(50) DEFAULT NULL,
  `MSensation` varchar(50) DEFAULT NULL,
  `SGeneralInspection` varchar(50) DEFAULT NULL,
  `SGeneralPalpation` varchar(50) DEFAULT NULL,
  `SInspectionAndPalpationHair` varchar(50) DEFAULT NULL,
  `SInspectionAndPalpationHead` varchar(50) DEFAULT NULL,
  `SInspectionAndPalpationScalp` varchar(50) DEFAULT NULL,
  `SInspectionAndPalpationChest` varchar(50) DEFAULT NULL,
  `SInspectionAndPalpationAbdomen` varchar(50) DEFAULT NULL,
  `SInspectionAndPalpationGenitalia` varchar(50) DEFAULT NULL,
  `SInspectionAndPalpationExtremities` varchar(50) DEFAULT NULL,
  `SInspectEccrineAndApocrine` varchar(50) DEFAULT NULL,
  `CranialNerves` varchar(50) DEFAULT NULL,
  `NeuCranial2nd` varchar(50) DEFAULT NULL,
  `NeuCranial3rd` varchar(50) DEFAULT NULL,
  `NeuCranial4th` varchar(50) DEFAULT NULL,
  `NeuCranial6th` varchar(50) DEFAULT NULL,
  `NeuCranial7th` varchar(50) DEFAULT NULL,
  `NeuCranial8th` varchar(50) DEFAULT NULL,
  `NeuCranial9th` varchar(50) DEFAULT NULL,
  `NeuCranial11th` varchar(50) DEFAULT NULL,
  `NeuCranial12th` varchar(50) DEFAULT NULL,
  `NeuReflexes` varchar(50) DEFAULT NULL,
  `NeuSensation` varchar(50) DEFAULT NULL,
  `NeuCoordination` varchar(50) DEFAULT NULL,
  `NeuSpeechDeficits` varchar(50) DEFAULT NULL,
  `NeuSpeechNormalRepetition` varchar(50) DEFAULT NULL,
  `NeuOriented` varchar(50) DEFAULT NULL,
  `NeuAffect` varchar(50) DEFAULT NULL,
  `NeuRD` tinyint(1) DEFAULT '0',
  `NeuRB` tinyint(1) DEFAULT '0',
  `NeuRT` tinyint(1) DEFAULT '0',
  `NeuRG` tinyint(1) DEFAULT '0',
  `NeuRWF` tinyint(1) DEFAULT '0',
  `NeuRWE` tinyint(1) DEFAULT '0',
  `NeuRIO` tinyint(1) DEFAULT '0',
  `NeuRHF` tinyint(1) DEFAULT '0',
  `NeuRKE` tinyint(1) DEFAULT '0',
  `NeuRKF` tinyint(1) DEFAULT '0',
  `NeuRDF` tinyint(1) DEFAULT '0',
  `NeuRPF` tinyint(1) DEFAULT '0',
  `NeuREHL` tinyint(1) DEFAULT '0',
  `NeuLD` tinyint(1) DEFAULT '0',
  `NeuLB` tinyint(1) DEFAULT '0',
  `NeuLT` tinyint(1) DEFAULT '0',
  `NeuLG` tinyint(1) DEFAULT '0',
  `NeuLWF` tinyint(1) DEFAULT '0',
  `NeuLWE` tinyint(1) DEFAULT '0',
  `NeuLIO` tinyint(1) DEFAULT '0',
  `NeuLHF` tinyint(1) DEFAULT '0',
  `NeuLKE` tinyint(1) DEFAULT '0',
  `NeuLKF` tinyint(1) DEFAULT '0',
  `NeuLDF` tinyint(1) DEFAULT '0',
  `NeuLPF` tinyint(1) DEFAULT '0',
  `NeuLEHL` tinyint(1) DEFAULT '0',
  `PsyJudgementInsight` varchar(50) DEFAULT NULL,
  `PsyJudgementOrientation` varchar(50) DEFAULT NULL,
  `PsyJudgementMemoryRecent` varchar(50) DEFAULT NULL,
  `PsyJudgementMemoryRemote` varchar(50) DEFAULT NULL,
  `PsyJudgementMoodAffect` varchar(50) DEFAULT NULL,
  `PsyJudgementAttentionSpanConcentration` varchar(50) DEFAULT NULL,
  `PsyJudgementLanguage` varchar(50) DEFAULT NULL,
  `PsyJudgementKnowledge` varchar(50) DEFAULT NULL,
  `PsyJudgementSpeech` varchar(50) DEFAULT NULL,
  `PsyJudgementThoughtProcess` varchar(50) DEFAULT NULL,
  `PsyJudgementAssociations` varchar(50) DEFAULT NULL,
  `PsyJudgementAbnormalThought` varchar(50) DEFAULT NULL,
  `ReferralRpt` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`CompleteGeneralSpecialistClinicID`),
  KEY `CompletePhysicalEncounterIDIndex` (`EncounterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `completephysical`
--

LOCK TABLES `completephysical` WRITE;
/*!40000 ALTER TABLE `completephysical` DISABLE KEYS */;
/*!40000 ALTER TABLE `completephysical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulttable`
--

DROP TABLE IF EXISTS `consulttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulttable` (
  `ConsultID` int(11) NOT NULL AUTO_INCREMENT,
  `EncounterID` int(11) DEFAULT NULL,
  `ConsultNote` varchar(7778) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `EntryDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ConsultID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulttable`
--

LOCK TABLES `consulttable` WRITE;
/*!40000 ALTER TABLE `consulttable` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulttable` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `diabeticlog`
--

DROP TABLE IF EXISTS `diabeticlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diabeticlog` (
  `DiabeticLogID` int(11) NOT NULL AUTO_INCREMENT,
  `DiabeticInfoID` int(11) DEFAULT NULL,
  `DiabeticLogEntryDate` datetime DEFAULT NULL,
  `BeforeBreakfast` int(11) DEFAULT NULL,
  `TwoHoursAfterBreakfast` int(11) DEFAULT NULL,
  `TwoHoursAfterLunch` int(11) DEFAULT NULL,
  `TwoHoursAfterDinner` int(11) DEFAULT NULL,
  `Comments` varchar(2048) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `PregnancyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DiabeticLogID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diabeticlog`
--

LOCK TABLES `diabeticlog` WRITE;
/*!40000 ALTER TABLE `diabeticlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `diabeticlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employertable`
--

DROP TABLE IF EXISTS `employertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employertable` (
  `EmployerID` int(11) NOT NULL AUTO_INCREMENT,
  `EmployerName` varchar(128) DEFAULT NULL,
  `EmployerAddress1` varchar(128) DEFAULT NULL,
  `EmployerAddress2` varchar(128) DEFAULT NULL,
  `EmployerCity` varchar(75) DEFAULT NULL,
  `EmployerState/Province/Region` varchar(50) DEFAULT NULL,
  `EmployerCountry` varchar(75) DEFAULT NULL,
  `EmployerZipCode` varchar(15) DEFAULT NULL,
  `EmployerPhone` varchar(14) DEFAULT NULL,
  `EmployerFAX` varchar(14) DEFAULT NULL,
  `EmployerComments` varchar(254) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `EmployerFirstName` varchar(50) DEFAULT NULL,
  `EmployerMiddleName` varchar(50) DEFAULT NULL,
  `EmployerPrefix` varchar(10) DEFAULT NULL,
  `EmployerSuffix` varchar(10) DEFAULT NULL,
  `CreditCardHolderID` varchar(50) DEFAULT NULL,
  `CreditCardNumber` varchar(50) DEFAULT NULL,
  `CreditCardExpiration` varchar(10) DEFAULT NULL,
  `CreditCardType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`EmployerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employertable`
--

LOCK TABLES `employertable` WRITE;
/*!40000 ALTER TABLE `employertable` DISABLE KEYS */;
/*!40000 ALTER TABLE `employertable` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `eyeprescription`
--

DROP TABLE IF EXISTS `eyeprescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eyeprescription` (
  `EyePrescriptionID` int(11) NOT NULL AUTO_INCREMENT,
  `EncounterID` int(11) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `EyePrescriptionDate` datetime DEFAULT NULL,
  `PrescriptionHCP` int(11) DEFAULT NULL,
  `ODSphere` varchar(10) DEFAULT NULL,
  `ODCylinder` varchar(10) DEFAULT NULL,
  `ODAxis` varchar(10) DEFAULT NULL,
  `ODPrism` varchar(10) DEFAULT NULL,
  `ODAdd` varchar(25) DEFAULT NULL,
  `OSSphere` varchar(10) DEFAULT NULL,
  `OSCylinder` varchar(10) DEFAULT NULL,
  `OSAxis` varchar(10) DEFAULT NULL,
  `OSPrism` varchar(10) DEFAULT NULL,
  `OSAdd` varchar(25) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `ConditionCode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`EyePrescriptionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eyeprescription`
--

LOCK TABLES `eyeprescription` WRITE;
/*!40000 ALTER TABLE `eyeprescription` DISABLE KEYS */;
/*!40000 ALTER TABLE `eyeprescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familyhistorytable`
--

DROP TABLE IF EXISTS `familyhistorytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familyhistorytable` (
  `FamilyID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Relation` varchar(50) DEFAULT NULL,
  `Alive` tinyint(1) DEFAULT '0',
  `Lives with patient` tinyint(1) DEFAULT '0',
  `MajorDisorder` varchar(254) DEFAULT NULL,
  `SpecificTypeDisorder` varchar(254) DEFAULT NULL,
  `DisorderHRF` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`FamilyID`),
  KEY `I_PatientID` (`PatientID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familyhistorytable`
--

LOCK TABLES `familyhistorytable` WRITE;
/*!40000 ALTER TABLE `familyhistorytable` DISABLE KEYS */;
INSERT INTO `familyhistorytable` VALUES (1,1,'Jon','Dad',1,0,'N/A','',0,1),(2,1,'Joyce','Mother',1,1,'Cancer','',0,0),(3,1,'Katies','Sister',1,0,'Autsim','',0,0),(4,1,'Sarah','Wife',1,1,'','',0,0),(5,1,'Brain','Self',1,1,'PITA','',0,0);
/*!40000 ALTER TABLE `familyhistorytable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fequencytable`
--

DROP TABLE IF EXISTS `fequencytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fequencytable` (
  `fequencyID` int(11) NOT NULL,
  `TimesPerDay` int(11) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fequencyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fequencytable`
--

LOCK TABLES `fequencytable` WRITE;
/*!40000 ALTER TABLE `fequencytable` DISABLE KEYS */;
INSERT INTO `fequencytable` VALUES (1,1,'Before Bed'),(2,1,'Morning'),(3,3,'Before Meals');
/*!40000 ALTER TABLE `fequencytable` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `geneticscreening`
--

DROP TABLE IF EXISTS `geneticscreening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geneticscreening` (
  `GeneticScreeningID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `HCPID` int(11) DEFAULT NULL,
  `RecordCreateDate` datetime DEFAULT NULL,
  `PatientAgeGreaterThan35` tinyint(1) DEFAULT '0',
  `Thalassemia` tinyint(1) DEFAULT '0',
  `NeuralTubeDefect` tinyint(1) DEFAULT '0',
  `CongenitalHeartDefect` tinyint(1) DEFAULT '0',
  `DownSyndrome` tinyint(1) DEFAULT '0',
  `TaySachs` tinyint(1) DEFAULT '0',
  `CanavanDisease` tinyint(1) DEFAULT '0',
  `SickleCellDisease` tinyint(1) DEFAULT '0',
  `Hemophilia` tinyint(1) DEFAULT '0',
  `MuscularDystrophy` tinyint(1) DEFAULT '0',
  `CysticFibrosis` tinyint(1) DEFAULT '0',
  `HuntingtonsChorea` tinyint(1) DEFAULT '0',
  `MentalRetardation` tinyint(1) DEFAULT '0',
  `TestedForFragileX` tinyint(1) DEFAULT '0',
  `OtherChromosomalDisorder` tinyint(1) DEFAULT '0',
  `MaternalMetabolicDisorder` tinyint(1) DEFAULT '0',
  `MotherOrFatherHadChildWithBirthDefect` tinyint(1) DEFAULT '0',
  `RecurrentPregnancyLoss` tinyint(1) DEFAULT '0',
  `MedicationsSinceLMP` tinyint(1) DEFAULT '0',
  `MedicationListSinceLastLMP` varchar(254) DEFAULT NULL,
  `AnyOther` tinyint(1) DEFAULT '0',
  `Comments` varchar(2048) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`GeneticScreeningID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geneticscreening`
--

LOCK TABLES `geneticscreening` WRITE;
/*!40000 ALTER TABLE `geneticscreening` DISABLE KEYS */;
/*!40000 ALTER TABLE `geneticscreening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gmhreviewdates`
--

DROP TABLE IF EXISTS `gmhreviewdates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gmhreviewdates` (
  `ReviewID` int(11) NOT NULL AUTO_INCREMENT,
  `SpecificMedicalHistoryID` int(11) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `GenMedHxArea` varchar(128) DEFAULT NULL,
  `ReviewDate` datetime DEFAULT NULL,
  `ReviewedBy` varchar(75) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ReviewID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gmhreviewdates`
--

LOCK TABLES `gmhreviewdates` WRITE;
/*!40000 ALTER TABLE `gmhreviewdates` DISABLE KEYS */;
/*!40000 ALTER TABLE `gmhreviewdates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `healthcareprovider`
--

DROP TABLE IF EXISTS `healthcareprovider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `healthcareprovider` (
  `HealthCareProviderID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Address1` varchar(45) DEFAULT NULL,
  `Address2` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` varchar(45) DEFAULT NULL,
  `Zip` varchar(45) DEFAULT NULL,
  `Country` varchar(45) DEFAULT 'USA',
  `EmailAddress` varchar(45) DEFAULT NULL,
  `PhoneNumber` varchar(45) DEFAULT NULL,
  `Primary` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`HealthCareProviderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `healthcareprovider`
--

LOCK TABLES `healthcareprovider` WRITE;
/*!40000 ALTER TABLE `healthcareprovider` DISABLE KEYS */;
/*!40000 ALTER TABLE `healthcareprovider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homehealthcare`
--

DROP TABLE IF EXISTS `homehealthcare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homehealthcare` (
  `HomeHealthCareID` int(11) NOT NULL AUTO_INCREMENT,
  `EncounterID` int(11) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `DisciplineTypeCode` varchar(50) DEFAULT NULL,
  `VisitsRendered` varchar(50) DEFAULT NULL,
  `VisitsProjected` varchar(50) DEFAULT NULL,
  `HomeHealthPlanID` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `VisitDate` datetime DEFAULT NULL,
  PRIMARY KEY (`HomeHealthCareID`),
  KEY `I_EncounterID` (`EncounterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homehealthcare`
--

LOCK TABLES `homehealthcare` WRITE;
/*!40000 ALTER TABLE `homehealthcare` DISABLE KEYS */;
/*!40000 ALTER TABLE `homehealthcare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homehealthplan`
--

DROP TABLE IF EXISTS `homehealthplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homehealthplan` (
  `HomeHealthPlanID` int(11) NOT NULL AUTO_INCREMENT,
  `NumberOfVisits` varchar(25) DEFAULT NULL,
  `FrequencyPeriod` varchar(25) DEFAULT NULL,
  `FrequencyCount` varchar(25) DEFAULT NULL,
  `TimePeriodQualifier` varchar(25) DEFAULT NULL,
  `NumberOfPeriods` varchar(25) DEFAULT NULL,
  `PatternCode` varchar(25) DEFAULT NULL,
  `PatternTimeCode` varchar(25) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `PlanDescription` varchar(1024) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `HomeHealthPlanDate` datetime DEFAULT NULL,
  PRIMARY KEY (`HomeHealthPlanID`),
  KEY `I_EncounterID` (`EncounterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homehealthplan`
--

LOCK TABLES `homehealthplan` WRITE;
/*!40000 ALTER TABLE `homehealthplan` DISABLE KEYS */;
/*!40000 ALTER TABLE `homehealthplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icd9codestable`
--

DROP TABLE IF EXISTS `icd9codestable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `icd9codestable` (
  `ICD9CodeID` int(11) NOT NULL AUTO_INCREMENT,
  `ICD9Code` varchar(50) DEFAULT NULL,
  `ICD9Description` varchar(512) DEFAULT NULL,
  `ICD9CategoryDescription` varchar(254) DEFAULT NULL,
  `ICD9SubCategoryDescription` varchar(254) DEFAULT NULL,
  `ICD9CombinedDesc` varchar(512) DEFAULT NULL,
  `PracticeCode` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `ICD9DescriptionExtended` varchar(254) DEFAULT NULL,
  `UserDefined` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ICD9CodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icd9codestable`
--

LOCK TABLES `icd9codestable` WRITE;
/*!40000 ALTER TABLE `icd9codestable` DISABLE KEYS */;
/*!40000 ALTER TABLE `icd9codestable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `illnesshistorytable`
--

DROP TABLE IF EXISTS `illnesshistorytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `illnesshistorytable` (
  `IllnessID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `IllnessDate` varchar(25) DEFAULT NULL,
  `Illness` varchar(254) DEFAULT NULL,
  `Resolution` varchar(254) DEFAULT NULL,
  `IllnessHRF` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`IllnessID`),
  KEY `I_PatientID` (`PatientID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `illnesshistorytable`
--

LOCK TABLES `illnesshistorytable` WRITE;
/*!40000 ALTER TABLE `illnesshistorytable` DISABLE KEYS */;
INSERT INTO `illnesshistorytable` VALUES (1,1,'2017-08-06','test2','test',0,0),(2,1,'2017-06-08','test','test',0,0),(3,1,'2017-08-06','test3','test',0,0),(4,1,'2017-08-06','Polio','test',0,0),(5,1,'2017-06-08','Flue','test',1,0),(6,1,'2018-05-31','why','test',0,0),(7,1,'2018-06-08','why2','test',0,0),(8,1,'2018-06-04','why4','test',0,0);
/*!40000 ALTER TABLE `illnesshistorytable` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immunizationshistorytable`
--

LOCK TABLES `immunizationshistorytable` WRITE;
/*!40000 ALTER TABLE `immunizationshistorytable` DISABLE KEYS */;
INSERT INTO `immunizationshistorytable` VALUES (1,1,'Flue','2017-05-30','2017-06-02','shot','',1,0),(2,1,'Polio','2016-08-16','2017-08-16','Shot','Hello World!',1,0),(3,1,'Rabies','2016-06-02','2020-06-03','Shot','Ouch!',1,0),(4,1,'Distempor','2015-02-14','2017-06-04','Shot','Bark!',1,0),(5,1,'Flue','2017-05-30','2017-06-02','shot','',1,0);
/*!40000 ALTER TABLE `immunizationshistorytable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linkedfiles`
--

DROP TABLE IF EXISTS `linkedfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linkedfiles` (
  `LinkedFileID` int(11) NOT NULL AUTO_INCREMENT,
  `EncounterID` int(11) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `LinkDate` datetime DEFAULT NULL,
  `FileName` varchar(254) DEFAULT NULL,
  `FileDate` datetime DEFAULT NULL,
  `FileDescription` varchar(254) DEFAULT NULL,
  `Comments` varchar(512) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `DocumentType` varchar(50) DEFAULT NULL,
  `PregnancyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LinkedFileID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linkedfiles`
--

LOCK TABLES `linkedfiles` WRITE;
/*!40000 ALTER TABLE `linkedfiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `linkedfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicationtable`
--

DROP TABLE IF EXISTS `medicationtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicationtable` (
  `MedicationDescription` varchar(254) NOT NULL,
  `PracticeMedication` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `NDCode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MedicationDescription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicationtable`
--

LOCK TABLES `medicationtable` WRITE;
/*!40000 ALTER TABLE `medicationtable` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicationtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `msreplication_options`
--

DROP TABLE IF EXISTS `msreplication_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `msreplication_options` (
  `optname` varchar(160) NOT NULL,
  `value` tinyint(1) NOT NULL,
  `major_version` int(11) NOT NULL,
  `minor_version` int(11) NOT NULL,
  `revision` int(11) NOT NULL,
  `install_failures` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msreplication_options`
--

LOCK TABLES `msreplication_options` WRITE;
/*!40000 ALTER TABLE `msreplication_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `msreplication_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `occupationalhistorytable`
--

DROP TABLE IF EXISTS `occupationalhistorytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `occupationalhistorytable` (
  `OccupationalID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `Description` varchar(254) DEFAULT NULL,
  `Current` tinyint(1) DEFAULT '0',
  `Disability` tinyint(1) DEFAULT '0',
  `Causeofdisability` varchar(254) DEFAULT NULL,
  `OccupationalHRF` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `LastWorkDate` date DEFAULT NULL,
  PRIMARY KEY (`OccupationalID`),
  KEY `I_PatientID` (`PatientID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `occupationalhistorytable`
--

LOCK TABLES `occupationalhistorytable` WRITE;
/*!40000 ALTER TABLE `occupationalhistorytable` DISABLE KEYS */;
INSERT INTO `occupationalhistorytable` VALUES (1,1,'2016-06-04',NULL,'Testing',1,0,'',0,0,NULL),(2,1,'2016-07-08',NULL,'Hello',1,1,'pain',0,0,'2016-07-09');
/*!40000 ALTER TABLE `occupationalhistorytable` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `patientdiagnosistable`
--

DROP TABLE IF EXISTS `patientdiagnosistable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientdiagnosistable` (
  `DiagnosisID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `ICD9Code` varchar(50) DEFAULT NULL,
  `ICD9Description` varchar(254) DEFAULT NULL,
  `DiagnosisDate` datetime DEFAULT NULL,
  `EndDiagnosisDate` datetime DEFAULT NULL,
  `FinalDiagnosis` tinyint(1) DEFAULT '0',
  `ICD9CodeCategory` varchar(100) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `ICD9Comments` varchar(254) DEFAULT NULL,
  `ICD9CodeID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DiagnosisID`),
  KEY `I_PatientID` (`PatientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientdiagnosistable`
--

LOCK TABLES `patientdiagnosistable` WRITE;
/*!40000 ALTER TABLE `patientdiagnosistable` DISABLE KEYS */;
/*!40000 ALTER TABLE `patientdiagnosistable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patientdiagnosticteststable`
--

DROP TABLE IF EXISTS `patientdiagnosticteststable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientdiagnosticteststable` (
  `DiagnosticTestID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `DiagnosticTestCategory` varchar(254) DEFAULT NULL,
  `DiagnosticTestType` varchar(128) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `DateOrdered` datetime DEFAULT NULL,
  `DatePerformed` datetime DEFAULT NULL,
  `SiteID` int(11) DEFAULT NULL,
  `Reason` varchar(254) DEFAULT NULL,
  `Results` varchar(254) DEFAULT NULL,
  `Value` double DEFAULT NULL,
  `Units` char(50) DEFAULT NULL,
  `Range` char(128) DEFAULT NULL,
  `HealthRiskFactor` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  `OrderedBy` int(11) DEFAULT NULL,
  `DateSubmitted` datetime DEFAULT NULL,
  `Medication` varchar(250) DEFAULT NULL,
  `TestConditions` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`DiagnosticTestID`),
  KEY `I_EncounterID` (`EncounterID`),
  KEY `I_PatientID` (`PatientID`),
  KEY `I_TestCategory` (`DiagnosticTestType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientdiagnosticteststable`
--

LOCK TABLES `patientdiagnosticteststable` WRITE;
/*!40000 ALTER TABLE `patientdiagnosticteststable` DISABLE KEYS */;
/*!40000 ALTER TABLE `patientdiagnosticteststable` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `patientinstructionstable`
--

DROP TABLE IF EXISTS `patientinstructionstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientinstructionstable` (
  `InstructionsID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `Instruction` varchar(250) DEFAULT NULL,
  `DateGiven` date DEFAULT NULL,
  `CompletionDate` date DEFAULT NULL,
  `FrequencyID` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`InstructionsID`),
  KEY `I_EncounterID` (`EncounterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientinstructionstable`
--

LOCK TABLES `patientinstructionstable` WRITE;
/*!40000 ALTER TABLE `patientinstructionstable` DISABLE KEYS */;
/*!40000 ALTER TABLE `patientinstructionstable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patientpharmacyinformation`
--

DROP TABLE IF EXISTS `patientpharmacyinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientpharmacyinformation` (
  `PatientPharmacyID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `PharmacyID` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`PatientPharmacyID`),
  KEY `I_PatientID` (`PatientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientpharmacyinformation`
--

LOCK TABLES `patientpharmacyinformation` WRITE;
/*!40000 ALTER TABLE `patientpharmacyinformation` DISABLE KEYS */;
/*!40000 ALTER TABLE `patientpharmacyinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patientprescriptiontable`
--

DROP TABLE IF EXISTS `patientprescriptiontable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientprescriptiontable` (
  `PrescriptionID` int(11) NOT NULL AUTO_INCREMENT,
  `CurrentMedicationID` int(11) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `Medication` varchar(254) DEFAULT NULL,
  `PrescriptionQuantity` varchar(50) DEFAULT NULL,
  `PrescriptionQuantityUnits` varchar(50) DEFAULT NULL,
  `Refills` int(11) DEFAULT NULL,
  `RefillPeriod` varchar(50) DEFAULT NULL,
  `Generic` tinyint(1) DEFAULT '0',
  `PrescriptionHCP` int(11) DEFAULT NULL,
  `PrescriptionDate` datetime DEFAULT NULL,
  `PharmacyID` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `Instructions` varchar(1024) DEFAULT NULL,
  `PrescriptionMedsAmt` varchar(50) DEFAULT NULL,
  `PrescriptionMedsUnit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PrescriptionID`),
  KEY `I_PatientID` (`PatientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientprescriptiontable`
--

LOCK TABLES `patientprescriptiontable` WRITE;
/*!40000 ALTER TABLE `patientprescriptiontable` DISABLE KEYS */;
/*!40000 ALTER TABLE `patientprescriptiontable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patientproblemstable`
--

DROP TABLE IF EXISTS `patientproblemstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientproblemstable` (
  `CurrentProblemID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `CurrentProblemDescription` varchar(2048) DEFAULT NULL,
  `ProblemResolution` varchar(2048) DEFAULT NULL,
  `ProblemStartDate` datetime DEFAULT NULL,
  `ProblemEndDate` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `DiagnosisID` int(11) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CurrentProblemID`),
  KEY `I_PatientID` (`PatientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientproblemstable`
--

LOCK TABLES `patientproblemstable` WRITE;
/*!40000 ALTER TABLE `patientproblemstable` DISABLE KEYS */;
/*!40000 ALTER TABLE `patientproblemstable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patientprocedures`
--

DROP TABLE IF EXISTS `patientprocedures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patientprocedures` (
  `PatientProcedureID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `ProcedureName` varchar(254) DEFAULT NULL,
  `DateOrdered` datetime DEFAULT NULL,
  `DatePerformed` datetime DEFAULT NULL,
  `SiteID` int(11) DEFAULT NULL,
  `Reason` varchar(254) DEFAULT NULL,
  `Results` varchar(254) DEFAULT NULL,
  `HRF` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`PatientProcedureID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientprocedures`
--

LOCK TABLES `patientprocedures` WRITE;
/*!40000 ALTER TABLE `patientprocedures` DISABLE KEYS */;
/*!40000 ALTER TABLE `patientprocedures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patienttable`
--

DROP TABLE IF EXISTS `patienttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patienttable` (
  `PatientID` int(11) NOT NULL AUTO_INCREMENT,
  `OldID` varchar(50) DEFAULT NULL,
  `PtLastName` varchar(128) DEFAULT NULL,
  `PtPreviousLastName` varchar(128) DEFAULT NULL,
  `PtFirstName` varchar(128) DEFAULT NULL,
  `HomeAddress1` varchar(128) DEFAULT NULL,
  `HomeAddress2` varchar(128) DEFAULT NULL,
  `HomeCity` varchar(128) DEFAULT NULL,
  `HomeState/Province/Region` varchar(50) DEFAULT NULL,
  `HomeZip` varchar(15) DEFAULT NULL,
  `Country` varchar(75) DEFAULT NULL,
  `Citizenship` varchar(75) DEFAULT NULL,
  `PtHomePhone` varchar(14) DEFAULT NULL,
  `EmergencyPhoneNumber` varchar(14) DEFAULT NULL,
  `PtHomeFax` varchar(14) DEFAULT NULL,
  `Pager` varchar(14) DEFAULT NULL,
  `EmailAddress` varchar(128) DEFAULT NULL,
  `PtSS#` varchar(12) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL COMMENT 'Changed from Varchar 1 to allow for other charactertics than male and female.',
  `EthnicAssociation` varchar(75) DEFAULT NULL,
  `Religion` varchar(75) DEFAULT NULL,
  `MaritalStatus` varchar(25) DEFAULT NULL,
  `EmploymentStatus` varchar(50) DEFAULT NULL,
  `HospitalMR#` varchar(50) DEFAULT NULL,
  `DateofExpire` datetime DEFAULT NULL,
  `Referral` int(11) DEFAULT NULL,
  `CurrentPrimaryHCPId` int(11) DEFAULT NULL,
  `Specialist1` int(11) DEFAULT NULL,
  `Specialist2` int(11) DEFAULT NULL,
  `Specialist3` int(11) DEFAULT NULL,
  `Specialist4` int(11) DEFAULT NULL,
  `OriginalStaffHCP` int(11) DEFAULT NULL,
  `CurrentStaffHCP` int(11) DEFAULT NULL,
  `Active` tinyint(1) DEFAULT '1',
  `Comments` varchar(254) DEFAULT NULL,
  `DateEntered` datetime DEFAULT NULL,
  `BusinessPhone` varchar(14) DEFAULT NULL,
  `BusinessFax` varchar(14) DEFAULT NULL,
  `BillingAcctNumber` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `updates` varchar(50) DEFAULT NULL,
  `GroupName` varchar(128) DEFAULT NULL,
  `SubscriberRelationship` varchar(10) DEFAULT NULL,
  `EmployerID` int(11) DEFAULT NULL,
  `NextOfKinID` int(11) DEFAULT NULL,
  `UPID` varchar(50) DEFAULT NULL,
  `PtMiddleInitial` varchar(4) DEFAULT NULL,
  `NextOfKinRelationshipToPatient` varchar(50) DEFAULT NULL,
  `NoticeOfPracticePrivacy` tinyint(1) DEFAULT '0',
  `NPPDate` datetime DEFAULT NULL,
  `Suffix` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`PatientID`),
  KEY `I_PtLastFirstName` (`PtLastName`,`PtFirstName`),
  KEY `I_HomePhone` (`PtHomePhone`),
  KEY `I_MR#` (`HospitalMR#`),
  KEY `I_SSN` (`PtSS#`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patienttable`
--

LOCK TABLES `patienttable` WRITE;
/*!40000 ALTER TABLE `patienttable` DISABLE KEYS */;
INSERT INTO `patienttable` VALUES (1,NULL,'Miller',NULL,'Brian','','','','','46304','',NULL,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,0,0,0,0,0,1,'',NULL,NULL,NULL,0,0,NULL,NULL,NULL,0,0,NULL,NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `patienttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patienttherapiestable`
--

DROP TABLE IF EXISTS `patienttherapiestable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patienttherapiestable` (
  `TherapyID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `TherapyDescription` varchar(254) DEFAULT NULL,
  `StartDate` varchar(25) DEFAULT NULL,
  `EndDate` varchar(25) DEFAULT NULL,
  `Outcome` varchar(254) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `CertificationType` varchar(50) DEFAULT NULL,
  `Duration` varchar(50) DEFAULT NULL,
  `OrderDate` varchar(25) DEFAULT NULL,
  `O2FlowRate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TherapyID`),
  KEY `I_EncounterID` (`EncounterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patienttherapiestable`
--

LOCK TABLES `patienttherapiestable` WRITE;
/*!40000 ALTER TABLE `patienttherapiestable` DISABLE KEYS */;
/*!40000 ALTER TABLE `patienttherapiestable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persontable`
--

DROP TABLE IF EXISTS `persontable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persontable` (
  `PersonId` int(11) NOT NULL AUTO_INCREMENT,
  `OldID` varchar(50) DEFAULT NULL,
  `Active` tinyint(1) DEFAULT '0',
  `PersonFirstName` varchar(128) DEFAULT NULL,
  `PersonLastName` varchar(128) DEFAULT NULL,
  `PersonMiddleName` varchar(50) DEFAULT NULL,
  `PersonInitials` varchar(7) DEFAULT NULL,
  `Title` varchar(20) DEFAULT NULL,
  `Address1` varchar(128) DEFAULT NULL,
  `Address2` varchar(128) DEFAULT NULL,
  `GroupName` varchar(128) DEFAULT NULL,
  `City` varchar(128) DEFAULT NULL,
  `State/Province/Region` varchar(50) DEFAULT NULL,
  `ZipCode` varchar(11) DEFAULT NULL,
  `Country` varchar(50) DEFAULT NULL,
  `Citizenship` varchar(50) DEFAULT NULL,
  `SpecialtyDescription` varchar(128) DEFAULT NULL,
  `OtherSpecialty` varchar(128) DEFAULT NULL,
  `OfficePhone` varchar(14) DEFAULT NULL,
  `OfficeFAX` varchar(14) DEFAULT NULL,
  `HomePhone` varchar(14) DEFAULT NULL,
  `CarPhone` varchar(14) DEFAULT NULL,
  `FaxNumber` varchar(14) DEFAULT NULL,
  `Pager` varchar(14) DEFAULT NULL,
  `EmailAddress` varchar(128) DEFAULT NULL,
  `InternetPassword` varchar(50) DEFAULT NULL,
  `Type` varchar(50) DEFAULT NULL,
  `Position` varchar(128) DEFAULT NULL,
  `SocialSecurity` varchar(12) DEFAULT NULL,
  `StateLicenseNumber` varchar(30) DEFAULT NULL,
  `LicenseExpiration` datetime DEFAULT NULL,
  `Medicaid` varchar(25) DEFAULT NULL,
  `MedicareUPIN` varchar(25) DEFAULT NULL,
  `MedicarePIN` varchar(25) DEFAULT NULL,
  `HospitalPIN` varchar(25) DEFAULT NULL,
  `DEARegNumber` varchar(25) DEFAULT NULL,
  `DEAExpiration` datetime DEFAULT NULL,
  `ControlledSubstanceExpiration` datetime DEFAULT NULL,
  `MalpracticePol#` varchar(25) DEFAULT NULL,
  `ProviderOrganizationID` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `SpecialtyID` int(11) DEFAULT NULL,
  `StaffID` int(11) DEFAULT NULL,
  `SignatureImage` longblob,
  `Username` varchar(128) DEFAULT NULL,
  `NameSuffix` varchar(10) DEFAULT NULL,
  `PrimaryEmployerID` int(11) DEFAULT NULL,
  `SecondaryEmployerID` int(11) DEFAULT NULL,
  `CreditCardIDInfo` varchar(50) DEFAULT NULL,
  `RelationshipToPatient` varchar(25) DEFAULT NULL,
  `NationalProviderID` varchar(25) DEFAULT NULL,
  `EmployerIDNumber` varchar(26) DEFAULT NULL,
  `HospiceEmployee` tinyint(1) DEFAULT '0',
  `Gender` varchar(1) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `StateControlledSubstanceNumber` varchar(50) DEFAULT NULL,
  `OrganizationID` int(11) DEFAULT NULL,
  `Comments` varchar(254) DEFAULT NULL,
  `ClaimSignatureAuth` tinyint(1) DEFAULT '0',
  `Suffix` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`PersonId`),
  KEY `PersonLastName_Index` (`PersonLastName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persontable`
--

LOCK TABLES `persontable` WRITE;
/*!40000 ALTER TABLE `persontable` DISABLE KEYS */;
/*!40000 ALTER TABLE `persontable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacyinformation`
--

DROP TABLE IF EXISTS `pharmacyinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pharmacyinformation` (
  `PharmacyID` int(11) NOT NULL AUTO_INCREMENT,
  `PharmacyName` varchar(128) DEFAULT NULL,
  `PharmacyAddress` varchar(128) DEFAULT NULL,
  `PharmacyCity` varchar(128) DEFAULT NULL,
  `PharmacyState` varchar(50) DEFAULT NULL,
  `PharmacyZIP` varchar(15) DEFAULT NULL,
  `PharmacyPhone` varchar(18) DEFAULT NULL,
  `PharmacyFAX` varchar(18) DEFAULT NULL,
  `PharmacyEmail` varchar(128) DEFAULT NULL,
  `PharmacyTCPIPAddress` varchar(50) DEFAULT NULL,
  `PharmacyWebSite` varchar(128) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`PharmacyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacyinformation`
--

LOCK TABLES `pharmacyinformation` WRITE;
/*!40000 ALTER TABLE `pharmacyinformation` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacyinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physicalexamfetus`
--

DROP TABLE IF EXISTS `physicalexamfetus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physicalexamfetus` (
  `FetusID` int(11) NOT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `EncounterID` int(11) DEFAULT NULL,
  `FetusName` varchar(128) DEFAULT NULL,
  `HR` int(11) DEFAULT NULL,
  `Presentation` varchar(50) DEFAULT NULL,
  `FetalMovement` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`FetusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physicalexamfetus`
--

LOCK TABLES `physicalexamfetus` WRITE;
/*!40000 ALTER TABLE `physicalexamfetus` DISABLE KEYS */;
/*!40000 ALTER TABLE `physicalexamfetus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physicalexamnotes`
--

DROP TABLE IF EXISTS `physicalexamnotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physicalexamnotes` (
  `PhysicalExamNotesID` int(11) NOT NULL AUTO_INCREMENT,
  `EncounterID` int(11) DEFAULT NULL,
  `PatientID` int(11) DEFAULT NULL,
  `PhysicalExamNotes` varchar(4000) DEFAULT NULL,
  `PENotesTime` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`PhysicalExamNotesID`),
  KEY `I_EncounterID` (`EncounterID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physicalexamnotes`
--

LOCK TABLES `physicalexamnotes` WRITE;
/*!40000 ALTER TABLE `physicalexamnotes` DISABLE KEYS */;
/*!40000 ALTER TABLE `physicalexamnotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physicalexamobstetrics`
--

DROP TABLE IF EXISTS `physicalexamobstetrics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physicalexamobstetrics` (
  `PhysicalExamObstetricsID` int(11) NOT NULL AUTO_INCREMENT,
  `CompleteGeneralSpecialistClinicID` int(11) DEFAULT NULL,
  `WeeksGestation` double DEFAULT NULL,
  `FundalHeight` double DEFAULT NULL,
  `Presentation` varchar(10) DEFAULT NULL,
  `FHR` double DEFAULT NULL,
  `FetalMovement` int(11) DEFAULT NULL,
  `PretermLaborSigns` varchar(5) DEFAULT NULL,
  `CervixDilationLength` double DEFAULT NULL,
  `Comments` varchar(7098) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  `EDD` datetime DEFAULT NULL,
  `EDDEstMethod` varchar(50) DEFAULT NULL,
  `LMP` datetime DEFAULT NULL,
  `LMPStatus` varchar(128) DEFAULT NULL,
  `PregnancyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PhysicalExamObstetricsID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physicalexamobstetrics`
--

LOCK TABLES `physicalexamobstetrics` WRITE;
/*!40000 ALTER TABLE `physicalexamobstetrics` DISABLE KEYS */;
/*!40000 ALTER TABLE `physicalexamobstetrics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialtytable`
--

DROP TABLE IF EXISTS `specialtytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialtytable` (
  `SpecialtyDescription` varchar(128) NOT NULL,
  PRIMARY KEY (`SpecialtyDescription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialtytable`
--

LOCK TABLES `specialtytable` WRITE;
/*!40000 ALTER TABLE `specialtytable` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialtytable` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `specificmedicalhistorytemplate`
--

DROP TABLE IF EXISTS `specificmedicalhistorytemplate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specificmedicalhistorytemplate` (
  `SpecificMedicalHistoryID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(128) DEFAULT NULL,
  `ICDCode` varchar(50) DEFAULT NULL,
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
  `ReferralRpt` tinyint(1) DEFAULT '0',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`SpecificMedicalHistoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specificmedicalhistorytemplate`
--

LOCK TABLES `specificmedicalhistorytemplate` WRITE;
/*!40000 ALTER TABLE `specificmedicalhistorytemplate` DISABLE KEYS */;
/*!40000 ALTER TABLE `specificmedicalhistorytemplate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `values`
--

DROP TABLE IF EXISTS `values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `values` (
  `Value` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `values`
--

LOCK TABLES `values` WRITE;
/*!40000 ALTER TABLE `values` DISABLE KEYS */;
/*!40000 ALTER TABLE `values` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vitalsigns`
--

DROP TABLE IF EXISTS `vitalsigns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vitalsigns` (
  `VitalSignID` int(11) NOT NULL AUTO_INCREMENT,
  `CompleteGeneralSpecialistClinicID` int(11) DEFAULT NULL,
  `WeeksGestation` double DEFAULT NULL,
  `FundalHeight` double DEFAULT NULL,
  `Presentation` varchar(10) DEFAULT NULL,
  `FHR` double DEFAULT NULL,
  `FetalMovement` int(11) DEFAULT NULL,
  `PretermLaborSigns` varchar(5) DEFAULT NULL,
  `CervixDilationLength` double DEFAULT NULL,
  `Comments` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`VitalSignID`),
  KEY `I_CompleteGeneralSpecialistClinicID` (`CompleteGeneralSpecialistClinicID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vitalsigns`
--

LOCK TABLES `vitalsigns` WRITE;
/*!40000 ALTER TABLE `vitalsigns` DISABLE KEYS */;
/*!40000 ALTER TABLE `vitalsigns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weightbyage`
--

DROP TABLE IF EXISTS `weightbyage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weightbyage` (
  `Sex` varchar(255) DEFAULT NULL,
  `AgeMons` double DEFAULT NULL,
  `P5` double DEFAULT NULL,
  `P10` double DEFAULT NULL,
  `P25` double DEFAULT NULL,
  `P50` double DEFAULT NULL,
  `P75` double DEFAULT NULL,
  `P90` double DEFAULT NULL,
  `P95` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weightbyage`
--

LOCK TABLES `weightbyage` WRITE;
/*!40000 ALTER TABLE `weightbyage` DISABLE KEYS */;
/*!40000 ALTER TABLE `weightbyage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbo'
--

--
-- Dumping routines for database 'dbo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-09 10:58:33
