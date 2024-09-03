package com.makjan.sulgilddara.Reservation.model.VO;

import java.sql.Date;
import java.time.LocalDate;

import lombok.NoArgsConstructor;


public class Reservation {
//	private Date reserveDate;
	private String reserveNo;
	private String userId;
	private int visitorNum;
	private String reserveDate;
	private String reserveTime;
	private String tourId;
	private int emergencyPhone;
	private String breweryName;
//	private LocalDate startDate;
//	private LocalDate endDate;
	
	
//	public LocalDate getStartDate() {
//		return startDate;
//	}
//	public void setStartDate(LocalDate startDate) {
//		this.startDate = startDate;
//	}
//	public LocalDate getEndDate() {
//		return endDate;
//	}
//	public void setEndDate(LocalDate endDate) {
//		this.endDate = endDate;
//	}
	public Reservation() {
	}
	public String getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(String reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getVisitorNum() {
		return visitorNum;
	}
	public void setVisitorNum(int visitorNum) {
		this.visitorNum = visitorNum;
	}
	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	public String getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}
	public String getTourId() {
		return tourId;
	}
	public void setTourId(String tourId) {
		this.tourId = tourId;
	}
	public int getEmergencyPhone() {
		return emergencyPhone;
	}
	public void setEmergencyPhone(int emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}
	public String getBreweryName() {
		return breweryName;
	}
	public void setBreweryName(String breweryName) {
		this.breweryName = breweryName;
	}
	@Override
	public String toString() {
		return "Reservation [reserveNo=" + reserveNo + ", userId=" + userId + ", visitorNum=" + visitorNum
				+ ", reserveDate=" + reserveDate + ", reserveTime=" + reserveTime + ", tourId=" + tourId
				+ ", emergencyPhone=" + emergencyPhone + ", breweryName=" + breweryName + "]";
	}




	
}

