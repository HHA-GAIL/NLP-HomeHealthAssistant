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
-- Table structure for table `node_has_decision`
--

DROP TABLE IF EXISTS `node_has_decision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `node_has_decision` (
  `Node_nodeID` int(11) NOT NULL,
  `Decision_DecisionID` int(11) NOT NULL,
  PRIMARY KEY (`Node_nodeID`,`Decision_DecisionID`),
  KEY `fk_Node_has_Decision_Decision1_idx` (`Decision_DecisionID`),
  KEY `fk_Node_has_Decision_Node1_idx` (`Node_nodeID`),
  CONSTRAINT `fk_Node_has_Decision_Decision1` FOREIGN KEY (`Decision_DecisionID`) REFERENCES `decision` (`DecisionID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Node_has_Decision_Node1` FOREIGN KEY (`Node_nodeID`) REFERENCES `node` (`nodeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node_has_decision`
--

LOCK TABLES `node_has_decision` WRITE;
/*!40000 ALTER TABLE `node_has_decision` DISABLE KEYS */;
INSERT INTO `node_has_decision` VALUES (1,1),(1,2),(2,3),(3,4),(4,5),(6,5),(4,6),(6,6),(5,7),(7,8),(9,8),(7,9),(9,9),(8,10),(10,11),(11,12),(12,13),(12,14);
/*!40000 ALTER TABLE `node_has_decision` ENABLE KEYS */;
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
