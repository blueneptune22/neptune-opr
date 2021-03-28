package com.neptune.dive.guest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guests")
public class ZGuest {
	
	@Id
	@Column(name = "gstid")
	private Integer id;
	
	@Column(name = "status")
	private Integer sts;
	
	@Column(name = "gname")
	private String name;
	
	@Column(name = "nationality")
	private String nat;
	
	@Column(name = "hotelname")
	private String hotel;
	
	@Column(name = "cardserial")
	private String card;
	
	@Column(name = "agtname")
	private String agent;
	
	@Column(name = "arrdate")
	private String arrival;
	
	@Column(name = "depdate")
	private String departure;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public Integer getSts() {
		return sts;
	}

	public void setSts(Integer sts) {
		this.sts = sts;
	}

	//Room, , , Voucher, Status, Profile, OffTom, DivTom, PicTom, ResID, ResRef, AgtID, GMID, LocationID, IsSnk, IsGstX, ActX, , IsGrpZ, LName
	
/* 
 * CREATE TABLE `guests` (
  `GstID` int(8) NOT NULL AUTO_INCREMENT,
  `GMID` int(11) DEFAULT NULL,
  `Status` tinyint(4) NOT NULL DEFAULT '0',
  `LocationID` tinyint(4) NOT NULL DEFAULT '1',
  `ResID` int(8) NOT NULL DEFAULT '0',
  `AgentID` smallint(6) NOT NULL DEFAULT '1',
  `PrcLstID` smallint(6) NOT NULL DEFAULT '0',
  `HotelID` smallint(6) NOT NULL DEFAULT '1',
  `NatID` smallint(6) NOT NULL DEFAULT '0',
  `PicTom` smallint(5) unsigned DEFAULT '0',
  `CertID` smallint(6) DEFAULT '0',
  `TankInfo` tinyint(4) DEFAULT NULL,
  `ArrDate` date NOT NULL,
  `DepDate` date DEFAULT NULL,
  `ArcDate` date DEFAULT NULL,
  `CardSerial` varchar(10) DEFAULT NULL,
  `PFCode` varchar(10) DEFAULT NULL,
  `FName` varchar(50) NOT NULL,
  `LName` varchar(50) NOT NULL,
  `Passport` varchar(20) DEFAULT NULL,
  `Room` varchar(10) DEFAULT NULL,
  `DivesNum` varchar(5) DEFAULT NULL,
  `EQBox` varchar(10) DEFAULT NULL,
  `Voucher` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Notes` varchar(255) DEFAULT NULL,
  `RepeatG` tinyint(1) DEFAULT '0',
  `IsXFer` tinyint(1) DEFAULT '0',
  `DivTom` tinyint(1) DEFAULT '0',
  `OffTom` tinyint(1) DEFAULT '0',
  `EANX` tinyint(1) DEFAULT '0',
  `IsGstX` tinyint(1) DEFAULT '0',
  `IsSnk` tinyint(1) DEFAULT '0',
  `IsGrpZ` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`GstID`),
  UNIQUE KEY `GstID` (`GstID`),
  UNIQUE KEY `CardSerial` (`CardSerial`),
  KEY `AgentID` (`AgentID`),
  KEY `FName` (`FName`),
  KEY `HotelID` (`HotelID`),
  KEY `LName` (`LName`),
  KEY `LocationID` (`LocationID`),
  KEY `ResID` (`ResID`),
  KEY `Status` (`Status`),
  KEY `TourOpID` (`PrcLstID`),
  KEY `fk_GMID_idx` (`GMID`),
  CONSTRAINT `fk_GMID` FOREIGN KEY (`GMID`) REFERENCES `guestmaster` (`GMID`) ON DELETE RESTRICT ON UPDATE CASCADE
  
  */

	/* 
	 * DROP PROCEDURE IF EXISTS `AddNewGuest`;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddNewGuest`(OUT newgst INT, INOUT zgmid INT ,IN zsts TINYINT(4),IN zloc TINYINT(4),
	IN zres INT, IN zagt SMALLINT,IN zprl SMALLINT,IN zhot SMALLINT,IN znat SMALLINT, IN zcert SMALLINT(6), IN ztnk TINYINT(4),
	IN zarrd DATE, IN zdepd DATE, IN zbdat DATE ,
	IN zcard VARCHAR(10), INOUT zpfc VARCHAR(10), IN zfnam VARCHAR(50),IN zlnam VARCHAR(50),
	IN zppn VARCHAR(20), IN zroom VARCHAR(5), IN znumd VARCHAR(5) ,
	IN zeqb VARCHAR(10) , IN zvch VARCHAR(20), IN zeml VARCHAR(50), IN znote VARCHAR(255),
	IN zxfr TINYINT(1),IN zsnk TINYINT(1) )
BEGIN
*/


	
}
