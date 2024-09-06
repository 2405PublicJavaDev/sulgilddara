package com.makjan.sulgilddara.Reservation.model.Mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.makjan.sulgilddara.Reservation.model.VO.Reservation;
import com.makjan.sulgilddara.tour.model.vo.Tour;
import com.makjan.sulgilddara.user.model.vo.User;

@Mapper
public interface ReservationMapper {

	List<Reservation> SearchInfo(Map<String, String> param);

	List<Reservation> SearchAllInfo(Map<String, String> param,RowBounds rowbounds);

	List<Reservation> SearchreserveNo(Reservation reservation);

	int getTotalCount();

	int getTotalCountWithConditiion(Map<String, String> param);

	List<Reservation> selectOne(@Param("reserveNo") String reserveNo);

	int RegisterInfo(Reservation reservation, Integer breweryNo);

	List<User> selectInfo(User user);

	List<Reservation> selectTourInfo(String tourNo);

	int getListTotalCount(String tourName);

	List<Tour> selectSearchList(Integer currentPage, Map<String, String> param, RowBounds rowBounds);



}
