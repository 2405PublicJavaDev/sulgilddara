package com.makjan.sulgilddara.Reservation.model.VO;

import java.sql.Date;


public class Reservation {
	private String reserveNo;
	private String userId;
	private int memberNum;
	private Date reserveDate;
	private String reserveTime;
//	private String tourId;
	private int emergencyPhone;
	
	public Reservation() {
		
	}

	public Reservation(String userId, String reserveTime) {
		super();
		this.userId = userId;
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
//	public String getTourId() {
//		return tourId;
//	}
//	public void setTourId(String tourId) {
//		this.tourId = tourId;
//	}
	public int getEmergencyPhone() {
		return emergencyPhone;
	}
	public void setEmergencyPhone(int emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	@Override
	public String toString() {
		return "Reservation [reserveNo=" + reserveNo + ", userId=" + userId + ", memberNum=" + memberNum
				+ ", reserveDate=" + reserveDate + ", reserveTime=" + reserveTime 
				+ ", emergencyPhone=" + emergencyPhone + "]";
	}
	
}

