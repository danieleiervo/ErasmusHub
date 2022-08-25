CREATE DATABASE  IF NOT EXISTS `erasmushub` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `erasmushub`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: erasmushub
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `associazione`
--

DROP TABLE IF EXISTS `associazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `associazione` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(128) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nome` varchar(128) DEFAULT NULL,
  `dipartimento` varchar(128) DEFAULT NULL,
  `risposte` int DEFAULT '0',
  `punteggio` int DEFAULT '0',
  `foto` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `associazione`
--

LOCK TABLES `associazione` WRITE;
/*!40000 ALTER TABLE `associazione` DISABLE KEYS */;
INSERT INTO `associazione` VALUES (1,'coscienze@gmail.com','password','CoScienze','Matematica e Fisica',0,0,NULL),(2,'iperuranio@gmail.com','password','Iperuranio','Farmacia',0,0,NULL);
/*!40000 ALTER TABLE `associazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_associazione` int NOT NULL,
  `img` varchar(100) DEFAULT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `descrizione` varchar(1000) DEFAULT NULL,
  `data_pubblicazione` date DEFAULT NULL,
  `data_evento` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`id_associazione`),
  CONSTRAINT `id_associazione` FOREIGN KEY (`id_associazione`) REFERENCES `associazione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,1,NULL,'Scientific library new opening hours','From today, May 23, the Scientific and Technological library will close at 5pm!','2022-05-23','2022-05-23'),(2,1,NULL,'Humanistic library new opening hours','From today, May 23, the Scientific and Technological library will close at 5pm!','2022-05-23','2022-05-23'),(3,2,NULL,'Summer party','Join us at the summer party in Piazza del Sapere this night','2022-06-21','2022-06-21');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poststudente`
--

DROP TABLE IF EXISTS `poststudente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poststudente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mat_studente` varchar(32) NOT NULL,
  `id_post` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mat_studente_idx` (`mat_studente`),
  KEY `id_post_idx` (`id_post`),
  CONSTRAINT `id_post` FOREIGN KEY (`id_post`) REFERENCES `post` (`id`),
  CONSTRAINT `mat_studente` FOREIGN KEY (`mat_studente`) REFERENCES `studente` (`matricola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poststudente`
--

LOCK TABLES `poststudente` WRITE;
/*!40000 ALTER TABLE `poststudente` DISABLE KEYS */;
/*!40000 ALTER TABLE `poststudente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studente`
--

DROP TABLE IF EXISTS `studente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studente` (
  `matricola` varchar(32) NOT NULL,
  `email` varchar(128) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nome` varchar(64) DEFAULT NULL,
  `cognome` varchar(64) DEFAULT NULL,
  `paese` varchar(64) DEFAULT NULL,
  `facolta` varchar(128) DEFAULT NULL,
  `foto` varchar(128) DEFAULT NULL,
  `bus_tickets` int DEFAULT NULL,
  PRIMARY KEY (`matricola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studente`
--

LOCK TABLES `studente` WRITE;
/*!40000 ALTER TABLE `studente` DISABLE KEYS */;
INSERT INTO `studente` VALUES ('1000000000','daniele@gmail.com','password','Daniel','Esimo','Portugal','Informatica','',0),('1000000001','berk@gmail.com','password','Berk','Asif','Turkey','Informatica','',3);
/*!40000 ALTER TABLE `studente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mat_studente` varchar(32) NOT NULL,
  `id_associazione_best` int NOT NULL,
  `titolo` varchar(100) DEFAULT NULL,
  `testo` varchar(3000) DEFAULT NULL,
  `data_apertura` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mat_studente_idx` (`mat_studente`),
  KEY `id_associazione_best_idx` (`id_associazione_best`),
  CONSTRAINT `id_associazione_best` FOREIGN KEY (`id_associazione_best`) REFERENCES `associazione` (`id`),
  CONSTRAINT `mat_studente_ticket` FOREIGN KEY (`mat_studente`) REFERENCES `studente` (`matricola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketassociazione`
--

DROP TABLE IF EXISTS `ticketassociazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticketassociazione` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_associazione` int NOT NULL,
  `id_ticket` int NOT NULL,
  `risposta` varchar(3000) DEFAULT NULL,
  `data_risposta` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_associazione_idx` (`id_associazione`),
  KEY `id_ticket_idx` (`id_ticket`),
  CONSTRAINT `id_associazione_ticket` FOREIGN KEY (`id_associazione`) REFERENCES `associazione` (`id`),
  CONSTRAINT `id_ticket` FOREIGN KEY (`id_ticket`) REFERENCES `ticket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketassociazione`
--

LOCK TABLES `ticketassociazione` WRITE;
/*!40000 ALTER TABLE `ticketassociazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticketassociazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-25 15:33:35
