package com.makjan.sulgilddara.Reservation.model.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.makjan.sulgilddara.Reservation.model.VO.Reservation;
import com.makjan.sulgilddara.user.model.vo.User;

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

/**
 * 예약 정보 조회 리스트 Service
 * @param rowBounds 
 * @param param 
 * @param rowBounds 
 * @return List<Reservation>
 */
List<Reservation> SearchAllInfo(String userId, String breweryName, RowBounds rowBounds);


/**
 * 예약 번호 조회 Service
 * @param reservation
 * @return List<Reservation>
 */
List<Reservation> SearchreserveNo(Reservation reservation);

/**
 * 예약 조회 개수 Service
 * @param breweryName 
 * @param userId 
 * @return int
 */
int getTotalCount(String userId, String breweryName);

/**
 * 예약 조회 조건 전체 리스트
 * @param userId
 * @param breweryName
 * @return int
 */
int getTotalCountWithConditiion(String userId, String breweryName);

/**
 * 예약 조회 세부 사항 
 * @param userId
 * @return Reservation
 */
List<Reservation> selectOne(String userId);
/**
 * 유저 정보 가져오기
 * @param user
 * @return List<User>
 */
List<User> selectInfo(User user);


}
