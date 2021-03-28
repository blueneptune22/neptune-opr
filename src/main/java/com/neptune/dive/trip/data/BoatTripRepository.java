package com.neptune.dive.trip.data;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.neptune.dive.trip.entity.BoatTrip;


public interface BoatTripRepository  extends CrudRepository<BoatTrip, Long> {

	List<BoatTrip> findByBid(Integer bid);
	List<BoatTrip> findByBoat(String boat);
	List<BoatTrip> findByTdate(String date);
	//List<BoatTrip> findBySite(String site);
	
	// Stored Procedure
	@Procedure(procedureName = "AddGuestToTrip")
	void addGuestToTrip(Long gst, Long trp);
}
