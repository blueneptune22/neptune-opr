package com.neptune.dive.trip.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.neptune.dive.trip.entity.TripGuest;

public interface TripGuestRepository extends CrudRepository<TripGuest, Long> {

	List<TripGuest> findByTripID(Long trpId);
	
}
