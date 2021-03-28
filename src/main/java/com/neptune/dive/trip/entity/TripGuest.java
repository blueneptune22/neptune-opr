package com.neptune.dive.trip.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tripsnamelist")
public class TripGuest {
	@Id
	@Column(name = "gstid")
	private Long id;
	
	@Column(name = "status")
	private Short sts;
	
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
	
	@Transient
	private String arrival;
	
	@Column(name = "depdate")
	private String departure;

	@Column(name = "trpid")
	private Long tripID;
	
	@Column(name = "logid")
	private Long logID;
	
	@Column(name = "logdate")
	private String logdate;
	
	@Column(name = "issnk")
	private Boolean isSnork;
	
	@Column(name = "isgstx")
	private Boolean isGstX;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Short getSts() {
		return sts;
	}

	public void setSts(Short sts) {
		this.sts = sts;
	}

	public Long getTripID() {
		return tripID;
	}

	public void setTripID(Long trpid) {
		this.tripID = trpid;
	}

	public Long getLogID() {
		return logID;
	}

	public void setLogID(Long logid) {
		this.logID = logid;
	}

	public String getLogdate() {
		return logdate;
	}

	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}

	public Boolean getIsSnork() {
		return isSnork;
	}

	public void setIsSnork(Boolean isSnork) {
		this.isSnork = isSnork;
	}

	public Boolean getIsGstX() {
		return isGstX;
	}

	public void setIsGstX(Boolean isGstX) {
		this.isGstX = isGstX;
	}

	
	//Room, , , Voucher, Status, Profile, OffTom, DivTom, PicTom, ResID, ResRef, AgtID, GMID, LocationID, IsSnk, IsGstX, ActX, , IsGrpZ, LName
	

}
