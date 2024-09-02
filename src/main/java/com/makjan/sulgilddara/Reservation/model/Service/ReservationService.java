package com.makjan.sulgilddara.Reservation.model.Service;

import java.time.LocalTime;

import com.makjan.sulgilddara.Reservation.model.VO.Reservation;

public interface ReservationService {
/**
 * 예약 정보 등록하기 Service
 * @param reservation
 * @return Int
 */
	int RegisterInfo(Reservation reservation);

}
