package com.neptune.dive.web;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.neptune.dive.errors.TripException;
import com.neptune.dive.trip.entity.*;
import com.neptune.dive.trip.TripService;


@RestController
@RequestMapping(path="/trips") 
public class TripController {
	
	private TripService svcTrips;
	
	@Autowired
	public void setTripService(TripService svc) {
		this.svcTrips = svc;
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<BoatTrip>> getAllTrips() {
        List<BoatTrip> list = svcTrips.listAllTrips() ;
        return new ResponseEntity<List<BoatTrip>>(list, HttpStatus.OK);
    }
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<BoatTrip> getZeeTrip(@PathVariable("id") Long id) {
        try {
        	//logger.info("OK Trip: "+id);
        	      	
            return new ResponseEntity<BoatTrip>(svcTrips.findTripById(id), HttpStatus.OK);
                
        } catch (TripException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip Not Found");
        }
    }
	 
	@GetMapping(path = "/{trp}/gst/{gst}")
	public ResponseEntity<String> addTripGuest(@PathVariable("trp") Long trp, 
			@PathVariable("gst") Long gst) {
        try {
        	
        	svcTrips.addGuestToTrip(gst, trp);
        	      	
            return new ResponseEntity<String>("GST:"+gst+" --> TRP:"+trp, HttpStatus.OK);
                
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip Not Found");
        }
    }
	
//	@PostMapping("/api/foos")
//	@ResponseBody
//	public String addFoo(@RequestParam(name = "id") String fooId, @RequestParam String name) { 
//	    return "ID: " + fooId + " Name: " + name;
//	}
	
//	@GetMapping(path = "/boat/{bid}")
//	public ResponseEntity<List<BoatTrip>> getTripsByBoat(@PathVariable("bid") Integer bid)  {
//        List<BoatTrip> list = svcTrips.getTripsByBoatID(bid) ;
//        return new ResponseEntity<List<BoatTrip>>(list, HttpStatus.OK);
//    }
	
	@GetMapping(path = "/day/{dat}")
	public ResponseEntity<List<BoatTrip>> getTripsByDate(@PathVariable("dat") String dat)  {
        List<BoatTrip> list = svcTrips.getTripsByDate(dat) ;
        return new ResponseEntity<List<BoatTrip>>(list, HttpStatus.OK);
    }
	
	@PostMapping(path = "/new")
	public ResponseEntity<ZTrip> addNewTrip(@RequestBody ZTrip trip){

		try {
			return new ResponseEntity<ZTrip>(svcTrips.addNewTrip(trip), HttpStatus.OK);
		 } catch (TripException exception) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip Not Found");
	     }

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ZTrip> updateZTrip(@RequestBody ZTrip trip, @PathVariable Long id) {

		return new ResponseEntity<ZTrip>(svcTrips.updateTrip(trip,id), HttpStatus.OK);

	  }

}
