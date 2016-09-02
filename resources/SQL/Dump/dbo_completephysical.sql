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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 21:58:37
