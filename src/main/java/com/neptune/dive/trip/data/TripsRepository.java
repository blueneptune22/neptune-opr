package com.neptune.dive.trip.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.neptune.dive.trip.entity.ZTrip;

public interface TripsRepository extends CrudRepository<ZTrip, Long> {
	
	List<ZTrip> findByTripDate(String trpDate);
	
	
}
