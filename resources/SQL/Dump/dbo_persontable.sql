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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 21:58:36
