package com.makjan.sulgilddara.Reservation.model.VO;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.makjan.sulgilddara.user.model.vo.User;

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
	private String email;
	private String address;
	private Timestamp joinDate;
	private String phone;
//	private User email;
//	private User address;
//	private User joinDate;
//	private User phone;
//	private LocalDate startDate;
//	private LocalDate endDate;
	

	public Reservation() {
	}




public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Timestamp getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//	public User getPhone() {
//		return phone;
//	}
//	public void setPhone(User phone) {
//		this.phone = phone;
//	}
//	public User getEmail() {
//		return email;
//	}
//	public void setEmail(User email) {
//		this.email = email;
//	}
//	public User getAddress() {
//		return address;
//	}
//	public void setAddress(User address) {
//		this.address = address;
//	}
//	public User getJoinDate() {
//		return joinDate;
//	}
//	public void setJoinDate(User joinDate) {
//		this.joinDate = joinDate;
//	}
	public Reservation(String userId) {
	super();
	this.userId = userId;
}

	public Reservation(String reserveNo, Timestamp joinDate, String email, String phone) {
		this.reserveNo=reserveNo;
		this.joinDate=joinDate;
		this.email=email;
		this.phone=phone;
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
				+ ", emergencyPhone=" + emergencyPhone + ", breweryName=" + breweryName + ", email=" + email
				+ ", address=" + address + ", joinDate=" + joinDate + ", phone=" + phone + "]";
	}




	
}

