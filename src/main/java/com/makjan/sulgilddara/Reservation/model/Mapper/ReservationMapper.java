package com.makjan.sulgilddara.Reservation.model.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.makjan.sulgilddara.Reservation.model.VO.Reservation;

@Mapper
public interface ReservationMapper {

	int RegisterInfo(Reservation reservation, String reserveTime);

}
