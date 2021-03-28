package com.neptune.dive.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.neptune.dive.errors.*;
import com.neptune.dive.guest.entity.GuestCard;
import com.neptune.dive.guest.GuestService;

import java.util.List;

@RestController
@RequestMapping(path="/guests") 
public class GuestsController {
	
	private GuestService svcGuests;
	
	@Autowired
    public void setGuestService(GuestService GuestService) {
        this.svcGuests = GuestService;
    }
	
	// ALL Guests
	@GetMapping(path = "/all")
	public ResponseEntity<List<GuestCard>> getAllGuests() {
        List<GuestCard> list = svcGuests.listAllGuests() ;
        return new ResponseEntity<List<GuestCard>>(list, HttpStatus.OK);
    }

	// ONE Guest
	@GetMapping(path = "/guest/{id}")
	public ResponseEntity<GuestCard> getGuestCard(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<GuestCard>(svcGuests.findGuestByID(id), HttpStatus.OK);
        } catch (ApplicationNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest Not Found");
        }
    }
	
	//	Guests List By Status
	@GetMapping(path = "/active/{sts}")
	public ResponseEntity<List<GuestCard>> getActiveGuests(@PathVariable("sts") Integer sts) {
		List<GuestCard> list = svcGuests.getGuestsByStatus(sts) ;
        return new ResponseEntity<List<GuestCard>>(list, HttpStatus.OK);
    }
	
	//	ACTIVE Guests
	@GetMapping(path = "/active/all")
	public ResponseEntity<List<GuestCard>> getAllActiveGuests() {
		List<GuestCard> list = svcGuests.listActiveGuests() ;
        return new ResponseEntity<List<GuestCard>>(list, HttpStatus.OK);
    }
	
	//	Guests List By Hotel
	@GetMapping(path = "/hotel/{hot}")
	public ResponseEntity<List<GuestCard>> getGuestsByHotel(@PathVariable("hot") String hot) {
		List<GuestCard> list = svcGuests.getGuestsByHotel(hot);
        return new ResponseEntity<List<GuestCard>>(list, HttpStatus.OK);
    }
	
	//	Guests List By Nationality
	@GetMapping(path = "/nato/{nat}")
	public ResponseEntity<List<GuestCard>> getGuestsByNationality(@PathVariable("nat") String nat) {
		List<GuestCard> list = svcGuests.getGuestsByNationality(nat);
        return new ResponseEntity<List<GuestCard>>(list, HttpStatus.OK);
    }
	
	
	//	Guests List By Name
	@GetMapping(path = "/name/{nam}")
	public ResponseEntity<List<GuestCard>> getGuestsByNameLike(@PathVariable("nam") String nam) {
		List<GuestCard> list = svcGuests.getGuestsByNameLike(nam);
        return new ResponseEntity<List<GuestCard>>(list, HttpStatus.OK);
    }
	
	//	Trip Names List By TripID
	@GetMapping(path = "/trip/{trp}")
	public ResponseEntity<List<GuestCard>> getTripNames(@PathVariable("trp") Integer trp) {
		List<GuestCard> list = svcGuests.listTripNames(trp);
        return new ResponseEntity<List<GuestCard>>(list, HttpStatus.OK);
    }
	
}
