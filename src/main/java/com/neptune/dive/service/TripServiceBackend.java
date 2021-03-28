package com.neptune.dive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.dive.errors.TripException;
import com.neptune.dive.trip.TripService;
import com.neptune.dive.trip.data.*;
import com.neptune.dive.trip.entity.*;


@Service
public class TripServiceBackend implements TripService {

	@Autowired
	BoatTripRepository repoTripList;
	
	@Autowired
	TripGuestRepository repoGuestList;
	
	@Autowired
	TripsRepository repoTrip;
	
	@Override
	public BoatTrip findTripById(Long id) {

		BoatTrip iTrip; 
		
		 Optional<BoatTrip> zTrip = repoTripList.findById(id);
		 
		 if(zTrip.isPresent()) {
			  iTrip= zTrip.get();
			  for (TripGuest gst : repoGuestList.findByTripID(id)) {
				iTrip.tripGuestList.add(gst);
			  }
			  
			System.out.println("OK TripInfo: "+iTrip.toString());
			
			return iTrip;
		 } else {

	           throw new TripException("Dive Trip Not Found");
		 }
	}

	@Override
	public ZTrip getTrip(Long id) {
		Optional<ZTrip> zTrip = repoTrip.findById(id);
		if(zTrip.isPresent()) {
			  
			System.out.println("OK Trip Data: "+zTrip.get().toString());
			return zTrip.get() ;
		 } else {

	           throw new TripException("Dive Trip Not Found");
		 }
		
	}
		
	
	@Override
	public ZTrip addNewTrip(ZTrip trip) {
		
		trip.setTripDate(trip.getTripDate());
		
		try {
			ZTrip newTrp = repoTrip.save(trip);
			System.out.println("New Trip: [ "+newTrp.getId()+" ]");
			return newTrp;	 //repoTrip.save(trip);
		} catch (Exception e) {
			
			//e.printStackTrace();
			throw new TripException("Dive Trip Add Failed!\n"+e.getMessage());
		}
		
		
	}

	@Override
	public ZTrip updateTrip(ZTrip trip, Long id) {
	    
	   try {
		   return repoTrip.findById(id)
		    		.map(oTrip ->{
		    			oTrip.setBoatID(trip.getBoatID());
		    			oTrip.setTripTypeID(trip.getTripTypeID());		    			
		    			oTrip.setTripDate(trip.getTripDate());
		    			oTrip.setPax(trip.getPax());
		    			oTrip.setTimeSlot(trip.getTimeSlot());
		    			oTrip.setTripStatus(trip.getTripStatus());
		    			
		    			System.out.println("Trip Update : [ "+id+" ]");
		    			return repoTrip.save(oTrip);
		    		})
		    		.orElseGet(() -> {
		    			trip.setId(id);
		    			return repoTrip.save(trip);
		    		}) ;
		} catch (Exception e) {
			throw new TripException("Dive Trip Update Failed!\n"+e.getMessage());
		}
	    		
	}

	@Override
	public void confirmTrip(ZTrip trip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelTrip(ZTrip trip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletTrip(ZTrip trip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoatTrip> listAllTrips() {

		return (List<BoatTrip>) repoTripList.findAll();
	}

	@Override
	public List<BoatTrip> getTripsByDate(String zdate) {
		return (List<BoatTrip>) repoTripList.findByTdate(zdate);
	}

	@Override
	public void addGuestToTrip(Long gst, Long trp) {

		repoTripList.addGuestToTrip(gst, trp);
		
	}




	

}
