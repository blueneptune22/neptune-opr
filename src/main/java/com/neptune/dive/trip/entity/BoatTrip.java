package com.neptune.dive.trip.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "tripseveryday")
public class BoatTrip {
	
	@Id
	@Column(name = "trpid")
	private Long id;
	
	@Column(name = "boatid")
	private Integer bid;
	
	@Column(name = "boatname")
	private String boat;
	
	@Column(name = "dive_site")
	private String site;
	
	@Column(name = "trpdate")
	private String tdate;
	
	@Column(name = "trppax")
	private Integer pax ;

	@Transient
	public List<Object> tripGuestList = new ArrayList<Object>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBoat() {
		return boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String date) {
		this.tdate = date;
	}

	public Integer getPax() {
		return pax;
	}

	public void setPax(Integer pax) {
		this.pax = pax;
	}
	
	
	public String toString() {
		return "["+this.id+" : "+this.boat+" / "+this.site+" / "+this.tdate+"]" ;
	}

	
}
