package com.neptune.dive.guest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guestlist")
public class GuestCard {
	
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
	

	
	
}
