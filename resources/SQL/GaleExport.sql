CREATE DATABASE  IF NOT EXISTS `gale` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gale`;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-09  8:58:18
