package com.makjan.sulgilddara.Reservation.model.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.makjan.sulgilddara.Reservation.model.VO.Reservation;

public interface ReservationService {
/**
 * 예약 정보 등록하기 Service
 * @param reservation
 * @return Int
 */
	int RegisterInfo(Reservation reservation);

/**
 * 예약 정보 조회하기 Service
 * @param param
 * @return List<Reservation>
 */
List<Reservation> SearchInfo(Map<String, String> param);

}
