package com.makjan.sulgilddara.Reservation.model.Service.Impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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
	public int RegisterInfo(Reservation reservation) {
		System.out.println(reservation);
		int result = rmapper.RegisterInfo(reservation); 
		return result;
	}


	@Override
	public List<Reservation> SearchAllInfo(Reservation reservation) {
		List<Reservation> rList = rmapper.SearchAllInfo(reservation);
		return rList;
	}

	@Override
	public List<Reservation> SearchreserveNo(Reservation reservation) {
		List<Reservation> rList = rmapper.SearchreserveNo(reservation);
		return rList;
	}

	@Override
	public List<Reservation> SearchInfo(Map<String, String> param, RowBounds rowBounds) {
		List<Reservation> rList = rmapper.SearchInfo(param,rowBounds);
		return rList;
	}

	@Override
	public int getTotalCount() {
		int result = rmapper.getTotalCount();
		return result;
	}
}
