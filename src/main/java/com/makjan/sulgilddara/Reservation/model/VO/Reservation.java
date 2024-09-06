package com.makjan.sulgilddara.Reservation.model.VO;

import java.sql.Timestamp;


public class Reservation {
//	private Date reserveDate;
	private String reserveNo;
	private String userId;
	private int visitorNum;
	private String reserveDate;
	private String reserveTime;
	private String tourName;
	private int emergencyPhone;
	private String breweryName;
	private String reserveCompleteTime;
	private String totalPrice;
	// User
	private String email;
	private String address;
	private Timestamp joinDate;
	private String phone;
	// Brewery
	private String fileRename;
	private int tourPrice;

	
	public Reservation() {
	}

	public String getReserveCompleteTime() {
		return reserveCompleteTime;
	}

	public void setReserveCompleteTime(String reserveCompleteTime) {
		this.reserveCompleteTime = reserveCompleteTime;
	}


	

	public String getFileRename() {
		return fileRename;
	}

	public void setFileRename(String fileRename) {
		this.fileRename = fileRename;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(int tourPrice) {
		this.tourPrice = tourPrice;
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

	// public User getPhone() {
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
		this.reserveNo = reserveNo;
		this.joinDate = joinDate;
		this.email = email;
		this.phone = phone;
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



	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
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
				+ ", reserveDate=" + reserveDate + ", reserveTime=" + reserveTime + ", tourName=" + tourName
				+ ", emergencyPhone=" + emergencyPhone + ", breweryName=" + breweryName + ", reserveCompleteTime="
				+ reserveCompleteTime + ", totalPrice=" + totalPrice + ", email=" + email + ", address=" + address
				+ ", joinDate=" + joinDate + ", phone=" + phone + ", fileRename=" + fileRename + ", tourPrice="
				+ tourPrice + "]";
	}

}
