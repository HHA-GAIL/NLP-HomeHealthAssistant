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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 21:58:35
