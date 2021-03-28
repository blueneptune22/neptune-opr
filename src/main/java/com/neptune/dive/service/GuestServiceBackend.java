package com.neptune.dive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.dive.guest.entity.*;
import com.neptune.dive.errors.*;
import com.neptune.dive.guest.*;

@Service
public class GuestServiceBackend implements GuestService {
	
	
	@Autowired
	GuestRepository repoGuests ;

	@Override
	public List<GuestCard> listAllGuests() {
		
		return (List<GuestCard>) repoGuests.findAll();
	}

	@Override
	public GuestCard findGuestByID(Integer id) {
		Optional<GuestCard> optionalGuest = repoGuests.findById(id);

        if(optionalGuest.isPresent())
            return optionalGuest.get();
        else
            
        	throw new ApplicationNotFoundException("Application Not Found");
	}

	@Override
	public List<GuestCard> getGuestsByHotel(String hotel) {
		return (List<GuestCard>) repoGuests.getByHotelContaining(hotel);		//Like("%"+hotel+"%");		//.findByHotel(hotel);
	}

	@Override
	public List<GuestCard> getGuestsByNationality(String nat) {
		return (List<GuestCard>) repoGuests.findByNatContaining(nat);
	}

	@Override
	public List<GuestCard> getGuestsByStatus(Integer sts) {
		
		return (List<GuestCard>) repoGuests.findBySts(sts);
	}

	@Override
	public List<GuestCard> getGuestsByNameLike(String nam) {
		return (List<GuestCard>) repoGuests.getByNameLike(nam+"%");
	}

	@Override
	public List<GuestCard> listActiveGuests() {
		
		return repoGuests.getActiveGuestsNative() ;
	}

	@Override
	public List<GuestCard> listTripNames(Integer trp) {
		return repoGuests.getTripNames(trp);
	}

}


