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
-- Temporary view structure for view `decisionsfornodes`
--

DROP TABLE IF EXISTS `decisionsfornodes`;
/*!50001 DROP VIEW IF EXISTS `decisionsfornodes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `decisionsfornodes` AS SELECT 
 1 AS `nodeID`,
 1 AS `DecisionID`,
 1 AS `NodeQuestion`,
 1 AS `Answer`,
 1 AS `NodeEvent`,
 1 AS `DecisionEvent`,
 1 AS `DetermineNode`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `decisionsfornodes`
--

/*!50001 DROP VIEW IF EXISTS `decisionsfornodes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `decisionsfornodes` AS select `n`.`nodeID` AS `nodeID`,`d`.`DecisionID` AS `DecisionID`,`n`.`Question` AS `NodeQuestion`,`d`.`Answer` AS `Answer`,`n`.`Event` AS `NodeEvent`,`d`.`EventCode` AS `DecisionEvent`,`d`.`DetermineNode` AS `DetermineNode` from ((`node` `n` join `node_has_decision` `nhd` on((`n`.`nodeID` = `nhd`.`Node_nodeID`))) join `decision` `d` on((`nhd`.`Decision_DecisionID` = `d`.`DecisionID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 21:58:34
