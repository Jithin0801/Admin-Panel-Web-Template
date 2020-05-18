-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: master
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adminlogin`
--

DROP TABLE IF EXISTS `adminlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `adminlogin` (
  `id` int(11) NOT NULL,
  `adminmailid` varchar(100) DEFAULT NULL,
  `adminpassword` varchar(45) DEFAULT NULL,
  `sessionid` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminlogin`
--

LOCK TABLES `adminlogin` WRITE;
/*!40000 ALTER TABLE `adminlogin` DISABLE KEYS */;
INSERT INTO `adminlogin` VALUES (1,'srinithibabu002@gmail.com','srinithi','Srinithi Babu'),(2,'jithin.jithin0801@gmail.com','jithu','Jithin');
/*!40000 ALTER TABLE `adminlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `announcements`
--

DROP TABLE IF EXISTS `announcements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `announcements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `announcementtitle` varchar(500) DEFAULT NULL,
  `announcementbody` varchar(5000) DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `createdat` date DEFAULT NULL,
  `announcementstatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcements`
--

LOCK TABLES `announcements` WRITE;
/*!40000 ALTER TABLE `announcements` DISABLE KEYS */;
INSERT INTO `announcements` VALUES (46,'gdfjglkfjlgdfjgl','jiithin joseph','Jithin','2019-10-07','Draft'),(47,'jithin joseph from dashboard','this dashboard looks great','Jithin','2019-10-07','Draft'),(48,'jtihtihthekljklj','lkjdlkfhjdklhjdkfhj','Jithin','2019-10-17','Draft'),(50,'Jithin Joseph','Android is a mobile operating system developed by Google. It is based on a modified version of the Linux kernel and other open source software, and is designed primarily for touchscreen mobile devices such as smartphones and tablets. In addition, Google has developed Android TV for televisions, Android Auto for cars, and Wear OS for wearables, each with a specialized user interface. Variants of Android are also used on game consoles, digital cameras, PCs and other electronics.\n\nInitially developed by Android Inc., which Google bought in 2005, Android was unveiled in 2007, with the first commercial Android device launched in September 2008. The current stable version is Android 10, released on September 3, 2019. The core Android source code is known as Android Open Source Project (AOSP), which is primarily licensed under the Apache License.\n\n','Jithin','2019-10-06','Post'),(51,'jithin joseph from dashboard','Hello how are you!','Jithin','2019-10-17','Post');
/*!40000 ALTER TABLE `announcements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employeeid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `checkintime` time DEFAULT NULL,
  `lat` varchar(50) DEFAULT NULL,
  `lng` varchar(50) DEFAULT NULL,
  `attendancestatus` varchar(15) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attendampforeign_idx` (`employeeid`),
  CONSTRAINT `attendampforeign` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(30) NOT NULL,
  `categorycode` varchar(10) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `divisionid` int(11) NOT NULL,
  `maindivision` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categorydivfoerign_idx` (`divisionid`),
  KEY `categorymaindivfoerign_idx` (`maindivision`),
  CONSTRAINT `categorydivfoerign` FOREIGN KEY (`divisionid`) REFERENCES `division` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `categorymaindivfoerign` FOREIGN KEY (`maindivision`) REFERENCES `maindivision` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'OIL','OIL',_binary '',1,1),(2,'Battery','BT',_binary '',1,1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cityname` varchar(30) NOT NULL,
  `citycode` varchar(10) NOT NULL,
  `status` bit(1) NOT NULL,
  `staedid` int(11) NOT NULL,
  `countryid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `citysateforeign_idx` (`staedid`),
  KEY `citycountryforeign_idx` (`countryid`),
  CONSTRAINT `citycountryforeign` FOREIGN KEY (`countryid`) REFERENCES `country` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `citysateforeign` FOREIGN KEY (`staedid`) REFERENCES `state` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'CHENNAI','CHN',_binary '',1,1);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryname` varchar(30) NOT NULL,
  `countrycode` varchar(10) NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'INDIA','IND',_binary '');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerfirstname` varchar(50) DEFAULT NULL,
  `customerlastname` varchar(50) DEFAULT NULL,
  `customercontactnumber` varchar(20) DEFAULT NULL,
  `customeremailid` varchar(250) DEFAULT NULL,
  `customeraddress1` varchar(500) DEFAULT NULL,
  `customeraddress2` varchar(500) DEFAULT NULL,
  `customercityid` int(11) NOT NULL,
  `customerstateid` int(11) NOT NULL,
  `customercountryid` int(11) NOT NULL,
  `customerlandmark` varchar(200) NOT NULL,
  `contactpersonname` varchar(50) DEFAULT NULL,
  `companyname` varchar(100) DEFAULT NULL,
  `companyphonenumber` varchar(20) DEFAULT NULL,
  `companyaddress1` varchar(500) DEFAULT NULL,
  `companyaddress2` varchar(500) DEFAULT NULL,
  `companycityid` int(11) NOT NULL,
  `companystateid` int(11) NOT NULL,
  `companycountryid` int(11) NOT NULL,
  `gstnumber` varchar(45) DEFAULT NULL,
  `website` varchar(500) DEFAULT NULL,
  `maindivisionid` int(11) NOT NULL,
  `divisionid` int(11) NOT NULL,
  `createdby` varchar(50) NOT NULL,
  `createdat` date NOT NULL,
  `modifiedby` varchar(50) NOT NULL,
  `modifiedat` date NOT NULL,
  `statusid` int(11) NOT NULL,
  `employeeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`customercityid`,`customerstateid`,`customercountryid`,`companystateid`,`companycountryid`,`maindivisionid`,`divisionid`,`customerlandmark`),
  KEY `cuscityforeign_idx` (`customercityid`),
  KEY `cusstateforeign_idx` (`customerstateid`),
  KEY `cuscountryforeign_idx` (`customercountryid`),
  KEY `comopcityforeign_idx` (`companycityid`),
  KEY `comstateforeign_idx` (`companystateid`),
  KEY `comcountryforeign_idx` (`companycountryid`),
  CONSTRAINT `comcityforeign` FOREIGN KEY (`companycityid`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comcountryforeign` FOREIGN KEY (`companycountryid`) REFERENCES `country` (`id`),
  CONSTRAINT `comstateforeign` FOREIGN KEY (`companystateid`) REFERENCES `state` (`id`),
  CONSTRAINT `cuscityforeign` FOREIGN KEY (`customercityid`) REFERENCES `city` (`id`),
  CONSTRAINT `cusstateforeign` FOREIGN KEY (`customerstateid`) REFERENCES `state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Srinithi ','babu','9876543120','srinithi@gmail.com','Salem','Salem',1,1,1,'Bus Stand','Babu','BTT','7785423690','Salem','Salem',1,1,1,'QQW85D4F8TT9G50','www.btt.com',1,1,'','2019-10-15','','2019-10-15',1,NULL),(13,'Jennifer','Cyril','1234567890','jenny@gmail.com','Kottampatti','Pollachi',1,1,1,'LMHSS School','Cyril','JJCM','+919486263298','4, Sri Raja Rajeswari Nagar, 4th Extension, T Kottampatti. Pollachi','Pollachi',1,1,1,'QQW85D4F8TT9G50','www.jjcm.com',1,1,'','2019-10-17','','2019-10-17',1,NULL),(14,'Jithin','Joseph','+919486263298','jithin.jithin0801@gmail.com','4, Sri Raja Rajeswari Nagar, 4th Extension, T Kottampatti. Pollachi','Pollachi',1,1,1,'LMHSS School','Cyril','JJCM','+919486263298','4, Sri Raja Rajeswari Nagar, 4th Extension, T Kottampatti. Pollachi','Pollachi',1,1,1,'123654789ASDFGH','www.jjcm.com',1,1,'Jithin','2019-10-17','Jithin','2019-10-17',1,NULL),(15,'Rhythin','Peter','7708753432','rhythin@gmail.com','Coimbatore','Coimbatore',1,1,1,'Bus Stand','Peter','BTT','+919486263298','Coimbatore','Coimbatore',1,1,1,'123654789ASDFGH','www.btt.com',1,1,'Jithin','2019-10-16','Jithin','2019-10-18',1,NULL),(16,'Jobin','Nelson','+919486263298','jobin@gmail.com','pollachi','pollachi',1,1,1,'LMHSS School','Nelson','BTT','7785423690','pollachi','Pollachi',1,1,1,'QQW85D4F8TT9G50','www.btt.com',1,1,'Jithin','2019-10-17','Jithin','2019-10-17',1,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `designation`
--

DROP TABLE IF EXISTS `designation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `designation` (
  `id` int(11) NOT NULL,
  `designationname` varchar(30) NOT NULL,
  `designationcode` varchar(15) NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `designation`
--

LOCK TABLES `designation` WRITE;
/*!40000 ALTER TABLE `designation` DISABLE KEYS */;
INSERT INTO `designation` VALUES (1,'Managing Director','MD',_binary ''),(2,'General Manager','GM',_binary ''),(3,'Team Manager','TM',_binary ''),(4,'Marketing Executive','ME',_binary '');
/*!40000 ALTER TABLE `designation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `division` (
  `id` int(11) NOT NULL,
  `divisionname` varchar(50) NOT NULL,
  `divisioncode` varchar(15) NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `divmainforeign_idx` (`divisionname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'Automobile Division','AD',_binary ''),(2,'Infrastructure','INF',_binary ''),(3,'Battery','BT',_binary ''),(4,'Environmental Division','ED',_binary ''),(5,'General Industry','GI',_binary ''),(6,'Textile Industry','TI',_binary '');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employeename` varchar(50) DEFAULT NULL,
  `employeedob` date DEFAULT NULL,
  `employeegenderid` int(11) DEFAULT NULL,
  `employeecontactnumber` varchar(20) DEFAULT NULL,
  `employeeemail` varchar(100) DEFAULT NULL,
  `employeeaddress1` varchar(500) DEFAULT NULL,
  `employeeaddress2` varchar(500) DEFAULT NULL,
  `employeecityid` int(11) NOT NULL,
  `employeestateid` int(11) NOT NULL,
  `employeelandmark` varchar(200) DEFAULT NULL,
  `employeedoj` date DEFAULT NULL,
  `designationid` int(11) NOT NULL,
  `maindivisionid` int(11) NOT NULL,
  `divisionid` int(11) NOT NULL,
  `createdby` varchar(50) NOT NULL,
  `createdat` date NOT NULL,
  `modifiedby` varchar(50) NOT NULL,
  `modifiedat` date NOT NULL,
  `statusid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `empsexforerign_idx` (`employeegenderid`),
  KEY `empcityforeign_idx` (`employeecityid`),
  KEY `empstateforeign_idx` (`employeestateid`),
  KEY `empdesgforeign_idx` (`designationid`),
  KEY `empmaindivforeign_idx` (`maindivisionid`),
  KEY `empdivforeign_idx` (`divisionid`),
  CONSTRAINT `empcityforeign` FOREIGN KEY (`employeecityid`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `empdesgforeign` FOREIGN KEY (`designationid`) REFERENCES `designation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `empdivforeign` FOREIGN KEY (`divisionid`) REFERENCES `division` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `empgenderforerign` FOREIGN KEY (`employeegenderid`) REFERENCES `gender` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `empmaindivforeign` FOREIGN KEY (`maindivisionid`) REFERENCES `maindivision` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `empstateforeign` FOREIGN KEY (`employeestateid`) REFERENCES `state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Jithin Joseph','1999-01-06',1,'+919486263298','jithin.jithin0801@gmail.com','4, Sri Raja Rajeswari Nagar, 4th Extension, T Kottampatti. Pollachi','Pollachi',1,1,'LMHSS School','2019-10-14',1,1,2,'Jithin','2019-10-14','Jithin','2019-10-17',1),(23,'Mobin Peter','1998-06-22',1,'+919486263298','mobin@gmail.com','Pollachi','Pollachi',1,1,'LMHSS School','2019-08-20',2,1,1,'Jithin','2019-10-15','Jithin','2019-10-17',1),(24,'Reshma Boban','1999-01-04',2,'+919486263298','reshma@gmail.com','Coimbatore','Coimbatore',1,1,'Nero Hospital','2019-04-24',3,1,1,'Jithin','2019-10-15','Jithin','2019-10-17',1),(25,'Abijith','1998-06-23',1,'+919486263298','abi@gmail.com',' Pollachi','Pollachi',1,1,'Nero Hospital','2019-02-25',4,1,1,'Jithin','2019-10-16','Jithin','2019-10-17',1),(26,'Vignesh','1998-06-23',1,'+919486263298','vicky@gmail.com','Coimbatore','Coimbatore',1,1,'Nero Hospital','2019-01-25',3,1,1,'Jithin','2019-10-16','Jithin','2019-10-17',1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gender` (
  `id` int(11) NOT NULL,
  `gendername` varchar(10) NOT NULL,
  `gendercode` varchar(5) NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'MALE','M',_binary ''),(2,'FEMALE','F',_binary '');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maindivision`
--

DROP TABLE IF EXISTS `maindivision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `maindivision` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maindivisionname` varchar(15) DEFAULT NULL,
  `maindivisioncode` varchar(10) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maindivision`
--

LOCK TABLES `maindivision` WRITE;
/*!40000 ALTER TABLE `maindivision` DISABLE KEYS */;
INSERT INTO `maindivision` VALUES (1,'BTA-Infra','BTAI',_binary ''),(2,'BTB','BTB',_binary ''),(3,'BTA','BTA',_binary ''),(4,'BTL','BTL',_binary '');
/*!40000 ALTER TABLE `maindivision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myprofile`
--

DROP TABLE IF EXISTS `myprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `myprofile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `phonenumber` varchar(45) DEFAULT NULL,
  `sessionid` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myprofile`
--

LOCK TABLES `myprofile` WRITE;
/*!40000 ALTER TABLE `myprofile` DISABLE KEYS */;
INSERT INTO `myprofile` VALUES (1,'Srinithi Babu','srinithibabu002@gmail.com',25,'Female','1234567899','Srinithi Babu'),(3,'Jithin ','jithin.jithin0801@gmail.com',21,'Male','9486263298','Jithin');
/*!40000 ALTER TABLE `myprofile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `employeeid` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `uom` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `ordervalue` varchar(25) DEFAULT NULL,
  `productprice` varchar(25) DEFAULT NULL,
  `creditdays` int(11) DEFAULT NULL,
  `creditlimit` varchar(25) DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `createdat` date DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  `modifiedat` date DEFAULT NULL,
  `statusid` int(11) DEFAULT NULL,
  `ordersstatus` varchar(30) DEFAULT NULL,
  `quantitypending` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderempforeign_idx` (`employeeid`),
  KEY `ordercustforeign_idx` (`customerid`),
  CONSTRAINT `ordercustforeign` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderempforeign` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,1,1,'Volt',15000,'1000000','50000',90,'50000','Jithin','2019-10-11','Jithin','2019-10-17',1,'Ongoing',15000);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productname` varchar(200) DEFAULT NULL,
  `productcode` varchar(200) DEFAULT NULL,
  `maindivisionid` int(11) NOT NULL,
  `divisionid` int(11) NOT NULL,
  `categoryid` int(11) NOT NULL,
  `productapplicationarea` varchar(500) DEFAULT NULL,
  `productspecification` varchar(500) DEFAULT NULL,
  `productvideourl` varchar(500) DEFAULT NULL,
  `productfileurl` varchar(500) DEFAULT NULL,
  `createdby` varchar(50) NOT NULL,
  `createdat` date NOT NULL,
  `modifiedby` varchar(50) NOT NULL,
  `modifiedat` date NOT NULL,
  `statusid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `proddivforeign_idx` (`divisionid`),
  KEY `prodcategoryforeign_idx` (`categoryid`),
  CONSTRAINT `prodcategoryforeign` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `proddivforeign` FOREIGN KEY (`divisionid`) REFERENCES `division` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Battery','BT',1,1,1,'Car','5V','http://video.com','http://file.com','Jithin','2019-10-15','Jithin','2019-10-15',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT NULL,
  `employeeid` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `todaydate` date DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `nextfollow` date DEFAULT NULL,
  `contactno` varchar(50) DEFAULT NULL,
  `collectionvalue` varchar(50) DEFAULT NULL,
  `da` varchar(45) DEFAULT NULL,
  `quantitydelivered` int(11) DEFAULT NULL,
  `uom` varchar(45) DEFAULT NULL,
  `orderid` int(11) DEFAULT NULL,
  `statusid` int(11) DEFAULT NULL,
  `quantitypending` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (1,1,1,1,'2019-10-18','pollachi','2019-09-14','1234567890','5000','250',5000,'Volt',1,1,NULL),(2,1,1,1,'2019-10-18','pollachi','2019-10-16','1234567890','10000','250',10000,'Volt',1,1,NULL);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `state` (
  `id` int(11) NOT NULL,
  `statename` varchar(30) NOT NULL,
  `statecode` varchar(15) NOT NULL,
  `status` bit(1) NOT NULL,
  `countryid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `statecountryforeign_idx` (`countryid`),
  CONSTRAINT `statecountryforeign` FOREIGN KEY (`countryid`) REFERENCES `country` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'TAMIL NADU','TN',_binary '',1);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `statusname` varchar(15) DEFAULT NULL,
  `statuscode` varchar(10) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unitofmeasurement`
--

DROP TABLE IF EXISTS `unitofmeasurement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `unitofmeasurement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uomname` varchar(60) DEFAULT NULL,
  `uomcode` varchar(10) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unitofmeasurement`
--

LOCK TABLES `unitofmeasurement` WRITE;
/*!40000 ALTER TABLE `unitofmeasurement` DISABLE KEYS */;
INSERT INTO `unitofmeasurement` VALUES (1,'KILO GRAM','KG',_binary '');
/*!40000 ALTER TABLE `unitofmeasurement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'master'
--
/*!50003 DROP PROCEDURE IF EXISTS `deleteAnnouncementById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `deleteAnnouncementById`(p_id int)
delete from announcements where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteCustomerById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `deleteCustomerById`(p_id int)
delete from customer where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteCustomerByStatusId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `deleteCustomerByStatusId`(p_statusid int)
delete from customerrequest where statusid = p_statusid ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteCustomerVisitHistoryById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `deleteCustomerVisitHistoryById`(p_id int)
delete from customervisithistory  where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteEmployeeById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `deleteEmployeeById`(d_id int)
delete from employee where id = d_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteMarketVisitById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `deleteMarketVisitById`()
delete from marketvisit where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteOrderById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `deleteOrderById`(p_id int)
delete from orders where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteProductById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `deleteProductById`(p_id int)
delete from product where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllAttendance` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getAllAttendance`()
SELECT * FROM attendance ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllCustomers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getAllCustomers`()
SELECT * FROM customer ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllCustomerVisitHistories` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getAllCustomerVisitHistories`()
select * from customervisithistory ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllEmployees` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getAllEmployees`()
select *from employee ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllMarketVisits` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getAllMarketVisits`()
BEGIN

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllOrders` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getAllOrders`()
SELECT * FROM orders ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllProducts` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getAllProducts`()
SELECT * FROM product ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllReport` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getAllReport`()
select *from report ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAnnouncementById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getAnnouncementById`(p_id int)
select *from announcements where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAnnouncementByStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getAnnouncementByStatus`(p_announcementstatus varchar(15))
select *from announcements where announcementstatus = p_announcementstatus ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAttendanceByAttendanceStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getAttendanceByAttendanceStatus`(p_attendancestatus varchar(15))
select *from attendance where attendancestatus = p_attendancestatus ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAttendanceById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getAttendanceById`(p_id int)
select *from attendance where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCustomerById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getCustomerById`(p_id int)
select *from customer where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCustomerByStatusId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getCustomerByStatusId`(p_statusid int)
select *from customer where statusid = p_statusid ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCustomerVisitHistoryById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getCustomerVisitHistoryById`(p_id int)
delete from customervisithistory  where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getEmployeeById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getEmployeeById`(p_id int)
select *from employee where id=p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getLoginByEmailAndPassword` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getLoginByEmailAndPassword`(p_email varchar(100), p_password varchar(45))
SELECT * FROM adminlogin where adminmailid = p_email and adminpassword= p_password ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getMarketVisitById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getMarketVisitById`()
BEGIN

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getMyProfileById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getMyProfileById`(p_id int)
select *from myprofile where id=p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getMyProfileBySessionId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getMyProfileBySessionId`(p_sessionid varchar(15))
select *from myprofile where sessionid=p_sessionid ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getOrdersById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getOrdersById`(p_id int)
select *from orders where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getOrdersByStatusId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getOrdersByStatusId`(p_statusid int)
select *from orders where statusid = p_statusid ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getProductById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `getProductById`(p_id int)
select *from product where id=p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getReportById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `getReportById`(p_id int)
select *from report where id = p_id ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pInsertCustomer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `pInsertCustomer`(
p_customerfirstname varchar(50),
p_customerlastname varchar(50),
p_customercontactnumber varchar(20),
p_customeremailid varchar(250),
p_customeraddress1 varchar(500),
p_customeraddress2 varchar(500),
p_customercityid int,
p_customerstateid int,
p_customercountryid int,
p_customerlandmark varchar(200),
p_contactpersonname varchar(50),
p_companyname varchar(100),
p_companyphonenumber varchar(20),
p_companyaddress1 varchar(500),
p_companyaddress2 varchar(500),
p_companycityid int,
p_companystateid int,
p_companycountryid int,
p_gstnumber varchar(45),
p_website varchar(500),
p_maindivisionid int,
p_divisionid int,
p_createdby varchar(50),
p_createdat Date,
p_modifiedby varchar(50),
p_modifiedat Date,
p_statusid bit
)
BEGIN
INSERT INTO customer(
customerfirstname, 
customerlastname, 
customercontactnumber, 
customeremailid, 
customeraddress1,
customeraddress2, 
customercityid, 
customerstateid, 
customercountryid, 
customerlandmark, 
contactpersonname, 
companyname, 
companyphonenumber,
companyaddress1,
companyaddress2, 
companycityid, 
companystateid, 
companycountryid, 
gstnumber, 
website, 
maindivisionid, 
divisionid, 
createdby, 
createdat,
modifiedby,
modifiedat, 
statusid
) values(
p_customerfirstname,
p_customerlastname,
p_customercontactnumber,
p_customeremailid,
p_customeraddress1,
p_customeraddress2,
p_customercityid,
p_customerstateid,
p_customercountryid,
p_customerlandmark,
p_contactpersonname,
p_companyname,
p_companyphonenumber,
p_companyaddress1,
p_companyaddress2,
p_companycityid,
p_companystateid,
p_companycountryid,
p_gstnumber,
p_website,
p_maindivisionid,
p_divisionid,
p_createdby,
p_createdat,
p_modifiedby,
p_modifiedat,
p_statusid
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pInsertCustomerVisitHistory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `pInsertCustomerVisitHistory`(
			p_customerid int,
			 p_employeeid int,
			 p_productid int,
			p_productname varchar(100),
			p_custresponseid int,
			p_leadstatusid int,
			p_lastvisitdate date,
			p_createdby int,
			p_createdat date,
			p_modifiedby varchar(100),
			p_modifiedat date,
			p_status int)
begin 
   Insert into   customervisithistory
   (
			customerid,
			 employeeid,
			 productid,
			productname,
			custresponseid,
			leadstatusid,
			lastvisitdate,
			createdby,
			createdat,
			modifiedby,
			modifiedat,
			status)
            values(p_customerid ,
			 p_employeeid ,
			 p_productid ,
			p_productname ,
			p_custresponseid ,
			p_leadstatusid ,
			p_lastvisitdate ,
			p_createdby ,
			p_createdat ,
			p_modifiedby ,
			p_modifiedat ,
			p_status);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pInsertEmployee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `pInsertEmployee`(
p_employeename varchar(50), 
p_employeedob date, 
p_employeegenderid int, 
p_employeecontactnumber varchar(20), 
p_employeeemail varchar(100), 
p_employeeaddress1 varchar(500), 
p_employeeaddress2 varchar(500), 
p_employeecityid int, 
p_employeestateid int, 
p_employeelandmark varchar(200), 
p_employeedoj date, 
p_designationid int, 
p_maindivisionid int, 
p_divisionid int,
p_createdby varchar(50),
p_createdat date,
p_modifiedby varchar(50),
p_modifiedat date,
p_statusid int
)
begin
Insert into employee(
employeename,
employeedob,
employeegenderid,
employeecontactnumber,
employeeemail,
employeeaddress1,
employeeaddress2,
employeecityid,
employeestateid,
employeelandmark,
employeedoj,
designationid,
maindivisionid,
divisionid,
createdby,
createdat,
modifiedby,
modifiedat,
statusid
)
values (
p_employeename,
p_employeedob,
p_employeegenderid,
p_employeecontactnumber,
p_employeeemail,
p_employeeaddress1,
p_employeeaddress2,
p_employeecityid,
p_employeestateid,
p_employeelandmark,
p_employeedoj,
p_designationid,
p_maindivisionid,
p_divisionid,
p_createdby,
p_createdat,
p_modifiedby,
p_modifiedat,
p_statusid
);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pInsertMarketVisit` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `pInsertMarketVisit`()
BEGIN

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pInsertOrder` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `pInsertOrder`(
				p_customerid int,
                p_employeeid int,
                p_productid int,
                p_uom  varchar(45),
                p_quantity int,
                p_ordervalue varchar(25),
                p_productprice varchar(25),
                p_creditdays int,
                p_creditlimit varchar(25),
                p_createdby varchar(100),
                p_createdat date,
                p_modifiedby varchar(100),
                p_modifiedat date,
                p_statusid int
)
BEGIN
insert into orders(
            customerid,
            employeeid,
            productid,
            uom,
			quantity,
            ordervalue,
            productprice,
            creditdays,
            creditlimit,
            createdby,
            createdat,
            modifiedby,
            modifiedat,
            statusid
)values
			(
            p_customerid,
            p_employeeid,
            p_productid,
			p_uom,
            p_quantity,
            p_ordervalue,
            p_productprice,
            p_creditdays,
            p_creditlimit,
            p_createdby,
            p_createdat,
            p_modifiedby,
            p_modifiedat,
            p_statusid
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pInsertProduct` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `pInsertProduct`(
				p_productname varchar(200),
				p_productcode varchar(200),
				p_maindivisionid int,
				p_divisionid int,
				p_categoryid int,
				p_productapplicationarea varchar(500),
				p_productspecification varchar(500),
				p_productvideourl varchar(500),
				p_productfileurl varchar(500),
				p_createdby varchar(50),
				p_createdat date,
                p_modifiedby varchar(50),
                p_modifiedat date,
                p_statusid int
                )
begin
Insert into product(
				productname,
				productcode,
				maindivisionid,
				divisionid,
				categoryid,
				productapplicationarea,
				productspecification,
				productvideourl,
				productfileurl,
				createdby,
				createdat,
                modifiedby,
                modifiedat,
                statusid
                )
values (
				p_productname,
				p_productcode,
				p_maindivisionid,
				p_divisionid,
				p_categoryid,
				p_productapplicationarea,
				p_productspecification,
				p_productvideourl,
				p_productfileurl,
				p_createdby,
				p_createdat,
                p_modifiedby,
                p_modifiedat,
                p_statusid
                );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `postAnnouncement` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `postAnnouncement`(
				p_announcementtitle varchar(500),
                p_announcementbody varchar(1000),
                p_createdat date,
                p_createdby varchar(50),
                p_announcementstatus varchar(15)
)
BEGIN
insert into announcements(
			 announcementtitle,
             announcementbody,
             createdat,
             createdby,
             announcementstatus
)values
(
			 p_announcementtitle,
             p_announcementbody,
             p_createdat,
             p_createdby,
             p_announcementstatus
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `postDraft` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `postDraft`(
				p_accouncementtitile varchar(500),
                p_announcementbody varchar(1000),
                p_createdat int,
                p_createdby varchar(50),
                p_announcementstatus varchar(15)
)
BEGIN
insert into announcements(
			 accouncementtitile,
             announcementbody,
             createdat,
             createdby,
             announcementstatus
)values
(
           p_accouncementtitile,
             p_announcementbody,
             p_createdat,
             p_createdby,
             p_announcementstatus
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `postMyProfile` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `postMyProfile`(
				p_name varchar(45),
                p_email varchar(100),
                p_age int,
                p_gender varchar(10),
				p_phonenumber varchar(10),
                p_sessionid varchar(15)
)
BEGIN
insert into myprofile(
				name,
                email,
                age,
                gender,
				phonenumber,
                sessionid
)values
(
				p_name,
                p_email,
                p_age,
                p_gender,
				p_phonenumber,
                p_sessionid
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pUpdateCustomer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `pUpdateCustomer`(
p_id int,
p_customerfirstname varchar(50),
p_customerlastname varchar(50),
p_customercontactnumber varchar(20),
p_customeremailid varchar(250),
p_customeraddress1 varchar(500),
p_customeraddress2 varchar(500),
p_customercityid int,
p_customerstateid int,
p_customercountryid int,
p_customerlandmark varchar(200),
p_contactpersonname varchar(50),
p_companyname varchar(100),
p_companyphonenumber varchar(20),
p_companyaddress1 varchar(500),
p_companyaddress2 varchar(500),
p_companycityid int,
p_companystateid int,
p_companycountryid int,
p_gstnumber varchar(45),
p_website varchar(500),
p_maindivisionid int,
p_divisionid int,
p_createdby varchar(50),
p_createdat Date,
p_modifiedby varchar(50),
p_modifiedat Date,
p_statusid bit)
BEGIN
update customer set
id = p_id,
customerfirstname = p_customerfirstname,
customerlastname = p_customerlastname,
customercontactnumber = p_customercontactnumber, 
customeremailid = p_customeremailid, 
customeraddress1 = p_customeraddress1, 
customeraddress2 = p_customeraddress2, 
customercityid = p_customercityid, 
customerstateid = p_customerstateid, 
customercountryid = p_customercountryid, 
customerlandmark = p_customerlandmark, 
contactpersonname = p_contactpersonname, 
companyname = p_companyname, 
companyphonenumber = p_companyphonenumber,
companyaddress1 = p_companyaddress1, 
companyaddress2 = p_companyaddress2, 
companycityid = p_companycityid, 
companystateid = p_companystateid, 
companycountryid = p_companycountryid, 
gstnumber = p_gstnumber, 
website = p_website, 
maindivisionid = p_maindivisionid, 
divisionid = p_divisionid, 
createdby = p_createdby, 
createdat = p_createdat, 
modifiedby = p_modifiedby,
modifiedat = p_modifiedat,
statusid = p_statusid
where
id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pUpdateCustomerVisitHistory` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `pUpdateCustomerVisitHistory`(
p_id int,
p_customerid int,
			 p_employeeid int,
			 p_productid int,
			p_productname varchar(100),
			p_custresponseid int,
			p_leadstatusid int,
			p_lastvisitdate date,
			p_createdby int,
			p_createdat date,
			p_modifiedby varchar(100),
			p_modifiedat date,
			p_status int)
BEGIN
UPDATE customervisithistory SET 
id = p_id,
			customerid=p_customerid,
			 employeeid=p_employeeid,
			 productid=p_productid,
			productname=p_productname,
			custresponseid=p_custresponseid,
			leadstatusid=p_leadstatusid,
			lastvisitdate=p_lastvisitdate,
			createdby=p_createdby,
			createdat=p_createdat,
			modifiedby=p_modifiedby,
			modifiedat=p_modifiedat,
			status=p_status
   WHERE id =p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pUpdateEmployee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `pUpdateEmployee`(
p_id int,
p_employeename varchar(50), 
p_employeedob date, 
p_employeegenderid int, 
p_employeecontactnumber varchar(15), 
p_employeeemail varchar(100), 
p_employeeaddress1 varchar(500), 
p_employeeaddress2 varchar(500), 
p_employeecityid int, 
p_employeestateid int, 
p_employeelandmark varchar(200), 
p_employeedoj date, 
p_designationid int, 
p_maindivisionid int, 
p_divisionid int,
p_createdby varchar(50),
p_createdat date,
p_modifiedby varchar(50),
p_modifiedat date,
p_statusid int
)
BEGIN
UPDATE employee SET 
id = p_id,
employeename= p_employeename,
employeedob=p_employeedob,
employeegenderid=p_employeegenderid,
employeecontactnumber=p_employeecontactnumber,
employeeemail=p_employeeemail,
employeeaddress1=p_employeeaddress1,
employeeaddress2=p_employeeaddress2,
employeecityid=p_employeecityid,
employeestateid=p_employeestateid,
employeelandmark=p_employeelandmark,
employeedoj=p_employeedoj,
designationid=p_designationid,
maindivisionid=p_maindivisionid,
divisionid=p_divisionid,
createdby=p_createdby,
createdat=p_createdat,
modifiedby=p_modifiedby,
modifiedat=p_modifiedat,
statusid=p_statusid
WHERE id =p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pUpdateMarketVisit` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `pUpdateMarketVisit`(
p_id int,
 p_customerid int,
                                         p_employeeid int,
										 p_companyname varchar(100),
                                         p_custaddress varchar(100),
                                         p_custphno varchar(100),
                                         p_decisionauth varchar(100),
                                         p_proid int,
                                         p_custresponseid int,
                                         p_leadstatusid int,
                                         p_followupon date,
                                         p_orderid int,
                                         p_createdby varchar(100),
                                         p_createdat date,
                                         p_modifiedby varchar(100),
                                         p_modifiedat date,
                                         p_statusid int)
BEGIN
update marketvisit set
id=p_id,
customerid=p_customerid,
employeeid=p_employeeid,
companyname=p_companyname,
custaddress=p_custaddress,
custphno=p_custphno,
decisionauth=p_decisionauth,
proid=p_proid,
custresponseid=p_custresponseid,
leadstatusid=p_leadstatusid,
followupon=p_followupon,
orderid=p_orderid,
createdby=p_createdby,
createdat=p_createdat,
modifiedby=p_modifiedby,
modifiedat=p_modifiedat,
statusid=p_statusid
where
id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pUpdateOrder` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `pUpdateOrder`(
				p_id int,
				p_customerid int,
                p_employeeid int,
                p_productid int,
                p_uom varchar(45),
                p_quantity int,
                p_ordervalue varchar(25),
                p_productprice varchar(25),
                p_creditdays int,
                p_creditlimit varchar(25),
                p_createdby varchar(100),
                p_createdat date,
                p_modifiedby varchar(100),
                p_modifiedat date,
                p_statusid int,
                p_quantitypending int
                )
BEGIN
update orders set 
id = p_id,
customerid = p_customerid,
employeeid=p_employeeid,
productid=p_productid,
quantity=p_quantity,
uom=p_uom,
ordervalue=p_ordervalue,
productprice=p_productprice,
creditdays=p_creditdays,
creditlimit=p_creditlimit,
createdby=p_createdby,
createdat=p_createdat,
modifiedby=p_modifiedby,
modifiedat=p_modifiedat,
statusid=p_statusid,
quantitypending = p_quantitypending
where
id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pUpdateProduct` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `pUpdateProduct`(
				p_id int,
				p_productname varchar(200),
				p_productcode varchar(200),
				p_maindivisionid int,
				p_divisionid int,
				p_categoryid int,
				p_productapplicationarea varchar(500),
				p_productspecification varchar(500),
				p_productvideourl varchar(500),
				p_productfileurl varchar(500),
				p_createdby varchar(50),
				p_createdat date,
                p_modifiedby varchar(50),
                p_modifiedat date,
                p_statusid int
                )
BEGIN
UPDATE product SET 
				id = p_id,
				productname=p_productname,
				productcode=p_productcode,
				maindivisionid=p_maindivisionid,
				divisionid=p_divisionid,
				categoryid =p_categoryid,
				productapplicationarea=p_productapplicationarea,
				productspecification=p_productspecification,
				productvideourl=p_productvideourl,
				productfileurl=p_productfileurl,
				createdby=p_createdby,
				createdat=p_createdat,
                modifiedby=p_modifiedby,
                modifiedat=p_modifiedat,
                statusid=p_statusid
WHERE id =p_id;

	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateMyProfile` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `updateMyProfile`(
				p_id int,
				p_name varchar(45),
                p_email varchar(100),
                p_age int,
                p_gender varchar(10),
				p_phonenumber varchar(10),
                p_sessionid varchar(15)
)
BEGIN
UPDATE myprofile SET 
				id = p_id,
				name = p_name,
                email = p_email,
                age =p_age,
                gender = p_gender,
				phonenumber = p_phonenumber,
                sessionid = p_sessionid
WHERE id =p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updatePassword` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`localhost` PROCEDURE `updatePassword`(
p_id int,
p_email varchar(100),
p_password varchar(45),
p_sessionid varchar(45)
)
BEGIN
update adminlogin set
id = p_id,
adminmailid = p_email,
adminpassword = p_password,
sessionid = p_sessionid
where
id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateReport` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Jithin`@`%` PROCEDURE `updateReport`(
				p_id int,
				p_customerid int,
                p_employeeid int,
                p_productid int,
                p_todaydate date,
                p_address varchar(500),
                p_nextfollow date,
                p_contactno varchar(45),
                p_collectionvalue varchar(50),
                p_da varchar(50),
                p_quantitydelivered int,
                p_uom varchar(45),
                p_orderid int,
                p_statusid int,
                p_quantitypending int
                )
BEGIN
update report set 
id = p_id,
customerid = p_customerid,
employeeid=p_employeeid,
productid=p_productid,
todaydate=p_todaydate,
address=p_address,
nextfollow=p_nextfollow,
contactno=p_contactno,
collectionvalue=p_collectionvalue,
da=p_da,
quantitydelivered=p_quantitydelivered,
uom=p_uom,
orderid=p_orderid,
statusid=p_statusid,
quantitypending = p_quantitypending
where
id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-11 23:02:58
