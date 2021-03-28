package com.neptune.dive.guest;

import java.util.List;

import com.neptune.dive.guest.entity.GuestCard;

public interface GuestService {

	List<GuestCard> listAllGuests();
	List<GuestCard> getGuestsByHotel(String hotel);
	List<GuestCard> getGuestsByNationality(String nat);
	List<GuestCard> getGuestsByStatus(Integer sts);
	
	List<GuestCard> getGuestsByNameLike(String nam);
	
	List<GuestCard> listActiveGuests();
	List<GuestCard> listTripNames(Integer trp);
	
    GuestCard findGuestByID(Integer id);
	
}
