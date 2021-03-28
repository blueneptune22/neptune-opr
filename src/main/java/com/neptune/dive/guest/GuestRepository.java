package com.neptune.dive.guest;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neptune.dive.guest.entity.GuestCard;

public interface GuestRepository extends CrudRepository<GuestCard, Integer>{

	List<GuestCard> findByNat(String nat);
	List<GuestCard> findByName(String name);
	List<GuestCard> findByHotel(String hotel);
	List<GuestCard> findBySts(Integer sts);
	
	List<GuestCard> getByNameLike(String name);
	List<GuestCard> getByHotelContaining(String hotel);
	List<GuestCard> findByNatContaining(String nat);

	
	// Active Guests JPA
	@Query("SELECT g from GuestCard g where g.sts BETWEEN 1 AND 3")
	List<GuestCard> getActiveGuests();
	
	//	Active Guests MySQL
	@Query(value = "SELECT g.* from guestlist g where g.status BETWEEN 1 AND 3" , nativeQuery = true)
	List<GuestCard> getActiveGuestsNative();
	
	// Trip Names List
	@Query(value = "SELECT GstID, Status, GName, Nationality, CardSerial, HotelName, AgtName, NULL AS ArrDate, DepDate from tripsnamelist WHERE trpid =?1" , nativeQuery = true)
	List<GuestCard> getTripNames(Integer trp);
	
	
	// Room, DepDate, AgtName, Voucher, Status, Profile, OffTom, DivTom, PicTom, ResID, AgtID, GMID, TrpID, LogID, IsSnk, IsGstX, ActX, LogDate, PaxAD, PaxCH, FinChk, IsGrpZ, LName
}
