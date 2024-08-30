package com.makjan.sulgilddara.Reservation.model.VO;

import java.sql.Date;


public class Reservation {
	private String reserveNo;
	private String userId;
	private int memberNum;
	private Date reserveDate;
	private String reserveTime;
	private String tourId;
	private int emergencyPhone;
	
	public Reservation() {
		
	}
	
	public Reservation( Date reserveDate, String reserveTime) {
		super();
		this.reserveDate = reserveDate;
		this.reserveTime = reserveTime;
	}
	public String getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
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
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
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
	
}

