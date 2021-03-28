package com.neptune.dive.trip.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "trips")
public class ZTrip {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trpid")
	private  Long id;
	
	@Column(name = "trptypid")
	private Short tripTypeID;
	
	@Column(name = "tslot")
	private Short timeSlot;
	
	@Column(name = "trpstatus")
	private Short tripStatus;
	  
	
	@Column(name = "boatid")
	private Integer boatID;
	
	@Column(name = "trpdate")
	private String tripDate;
	
	@Column(name = "trpstart")
	private String tripStart;
	
	@Column(name = "trpend")
	private String tripEnd;
	
	@Column(name = "trppax")
	private Integer pax ;

	/*
	 *	Transient Fields 
	 */
	@Transient
	private String boat;
	
	@Transient
	private String site;

	/*
	 * Constructors
	 */
	public ZTrip() {
		// TODO Auto-generated constructor stub
	}
	
	public ZTrip(Short ttid, Integer bid, String tdat) {
		this.tripTypeID = ttid;
		this.boatID = bid;
		this.setTripDate(tdat);
		this.pax=0;
		this.timeSlot=0;
		this.tripStatus=1;
				
		
	}
	
	/*
	 * Methods
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getTripTypeID() {
		return tripTypeID;
	}

	public void setTripTypeID(Short tripTypeID) {
		this.tripTypeID = tripTypeID;
	}

	public Short getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(Short timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Short getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(Short tripStatus) {
		this.tripStatus = tripStatus;
	}

	public Integer getBoatID() {
		return boatID;
	}

	public void setBoatID(Integer boatID) {
		this.boatID = boatID;
	}



	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
		this.tripStart = tripDate+" 08:00:00";
		this.tripEnd = tripDate+" 16:00:00";
	}

	public String getTripStart() {
		return tripStart;
	}

	public void setTripStart(String tripStart) {
		this.tripStart = tripStart;
	}

	public String getTripEnd() {
		return tripEnd;
	}

	public void setTripEnd(String tripEnd) {
		this.tripEnd = tripEnd;
	}

	public Integer getPax() {
		return pax;
	}

	public void setPax(Integer pax) {
		this.pax = pax;
	}



	
}


/*
CREATE TABLE `trips` (
  `TrpID` int(8) NOT NULL AUTO_INCREMENT,
  `TrpTypID` tinyint(4) NOT NULL,
  `TSlot` tinyint(4) NOT NULL,
  `TrpStatus` tinyint(4) NOT NULL DEFAULT '0',
  `BoatID` int(8) NOT NULL,
  `TrpDate` date NOT NULL,
  `TrpStart` datetime NOT NULL,
  `TrpEnd` datetime NOT NULL,
  `TrpExpense` decimal(8,2) NOT NULL DEFAULT '0.00',
  `TrpExtra` decimal(8,2) NOT NULL DEFAULT '0.00',
  `TrpPax` smallint(6) NOT NULL DEFAULT '0',
  `XBox` tinyint(1) NOT NULL DEFAULT '0',
  `IsPrivate` tinyint(1) NOT NULL DEFAULT '0',
  `IsSafari` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`TrpID`),
  UNIQUE KEY `TrpID` (`TrpID`),
  UNIQUE KEY `TRPX` (`BoatID`,`TrpDate`,`TSlot`),
  KEY `TrpDate` (`TrpDate`),
  KEY `BoatID` (`BoatID`),
  KEY `fk_Trp_TypID_idx` (`TrpTypID`),
  CONSTRAINT `fk_Trip_TypID` FOREIGN KEY (`TrpTypID`) REFERENCES `triptypes` (`TripTypID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;
*/

/* 
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `AddNewTrip`(OUT ztrp INT, 
	IN ztyp tinyINT, IN zslt tinyint, IN zbot INT,IN zdat date,
	IN zstrt datetime, IN zend datetime, IN zprv BIT(1), IN zsaf BIT(1))
	BEGIN
	
	DECLARE zRNT, zEXT DECIMAL(8,2) DEFAULT 0;
	
	SELECT PerDay FROM Boats WHERE BoatID = zbot INTO zRNT;
	SELECT BoatExpense FROM TripTypes WHERE TripTypID = ztyp INTO zEXT;
	IF zRNT IS NULL THEN SET zRNT=0; END IF;
	IF zEXT IS NULL THEN SET zEXT=0; END IF;
	
	INSERT INTO `neptune`.`trips`
	(`TrpTypID`,`TSlot`,`BoatID`,`TrpDate`,`TrpStart`,`TrpEnd`,`IsPrivate`, `IsSafari`, `TrpExpense`,`TrpExtra`)
	VALUES(ztyp,zslt,zbot,zdat,zstrt,zend,zprv,zsaf,zRNT,zEXT ) ;
	
	SET ztrp = LAST_INSERT_ID();
	
	END

*/