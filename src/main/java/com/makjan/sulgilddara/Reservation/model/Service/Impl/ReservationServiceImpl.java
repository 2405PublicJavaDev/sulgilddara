package com.makjan.sulgilddara.Reservation.model.Service.Impl;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makjan.sulgilddara.Reservation.model.Mapper.ReservationMapper;
import com.makjan.sulgilddara.Reservation.model.Service.ReservationService;
import com.makjan.sulgilddara.Reservation.model.VO.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService{
@Autowired
	ReservationMapper rmapper;

	@Override
	public int RegisterInfo(Reservation reservation, LocalTime Time) {
		int result = rmapper.RegisterInfo(reservation,Time); 
		return result;
	}

}