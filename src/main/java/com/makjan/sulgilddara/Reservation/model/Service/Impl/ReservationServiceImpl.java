package com.makjan.sulgilddara.Reservation.model.Service.Impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makjan.sulgilddara.Reservation.model.Mapper.ReservationMapper;
import com.makjan.sulgilddara.Reservation.model.Service.ReservationService;
import com.makjan.sulgilddara.Reservation.model.VO.Reservation;
import com.makjan.sulgilddara.model.vo.Pagination;

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
	public List<Reservation> SearchAllInfo(String userId, String breweryName, RowBounds rowBounds) {
		
		Map<String,String>param = new HashMap<String,String>();
		param.put("userId",userId);
		param.put("breweryName",breweryName);
		List<Reservation> rList = rmapper.SearchAllInfo(param,rowBounds);
		return rList;
	}

	@Override
	public List<Reservation> SearchreserveNo(Reservation reservation) {
		List<Reservation> rList = rmapper.SearchreserveNo(reservation);
		return rList;
	}

	@Override
	public List<Reservation> SearchInfo(Map<String, String> param) {
		List<Reservation> rList = rmapper.SearchInfo(param);
		return rList;
	}

	@Override
	public int getTotalCount(String breweryName,String userId) {
		Map<String,String>param = new HashMap<String,String>();
		param.put("userId",userId);
		param.put("breweryName",breweryName);
		int result = rmapper.getTotalCount();
		return result;
	}

}
