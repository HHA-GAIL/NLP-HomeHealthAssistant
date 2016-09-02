CREATE DATABASE  IF NOT EXISTS `gale` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gale`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: gale
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
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `node` (
  `nodeID` int(11) NOT NULL AUTO_INCREMENT,
  `Question` varchar(45) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `clusterID` int(11) NOT NULL,
  `listeningFor` varchar(45) DEFAULT NULL,
  `Event` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nodeID`),
  KEY `fk_Node_Cluster_idx` (`clusterID`),
  CONSTRAINT `fk_Node_Cluster` FOREIGN KEY (`clusterID`) REFERENCES `cluster` (`clusterID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node`
--

LOCK TABLES `node` WRITE;
/*!40000 ALTER TABLE `node` DISABLE KEYS */;
INSERT INTO `node` VALUES (1,'What would you like to do',0,1,'ANSWER','0'),(2,'What is your family members name?',0,2,'PERSON','1'),(3,'What is your relation to them?',0,2,'FAMILY','2'),(4,'Do they have any major disorders?',0,2,'BINARY','3'),(5,'What Major disorders do they have?',0,2,'FAMILY','4'),(6,'Do they have any more major disorders?',0,2,'BINARY','5'),(7,'Do they have any minor disorders?',0,2,'BINARY','6'),(8,'What specific disorders do they have?',0,2,'FAMILY','7'),(9,'Do they have any more specific disorders?',0,2,'BINARY','8'),(10,'Do they live with you?',0,2,'BOOLEAN','9'),(11,'Are they Alive?',0,2,'BOOLEAN','10'),(12,'Would you like to add another family member?',0,2,'BINARY','11');
/*!40000 ALTER TABLE `node` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 21:58:34
