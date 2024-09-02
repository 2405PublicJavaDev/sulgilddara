package com.makjan.sulgilddara.Reservation.model.Mapper;

import java.time.LocalTime;

import org.apache.ibatis.annotations.Mapper;

import com.makjan.sulgilddara.Reservation.model.VO.Reservation;

@Mapper
public interface ReservationMapper {

	int RegisterInfo(Reservation reservation);

}
