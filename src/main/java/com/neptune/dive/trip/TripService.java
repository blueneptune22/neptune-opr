package com.neptune.dive.trip;

import java.util.List;

import com.neptune.dive.trip.entity.BoatTrip;
import com.neptune.dive.trip.entity.ZTrip;

public interface TripService {
	
	// DB TBL - Trips
	ZTrip getTrip(Long id);
	ZTrip addNewTrip(ZTrip trip);
	ZTrip updateTrip(ZTrip trip, Long id);
	void confirmTrip(ZTrip trip);
	void cancelTrip(ZTrip trip);
	void deletTrip(ZTrip trip);
	
	// DB VIEW - TripsEveryDay
	BoatTrip findTripById(Long id);
	
	List<BoatTrip> listAllTrips();
	List<BoatTrip> getTripsByDate(String zdate);
	
	// DB Action
	void addGuestToTrip(Long gst, Long trp);
}
