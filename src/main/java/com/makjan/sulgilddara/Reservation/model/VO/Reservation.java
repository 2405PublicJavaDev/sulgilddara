package com.makjan.sulgilddara.Reservation.model.VO;

import java.sql.Timestamp;

import lombok.extern.java.Log;

@Log
public class Reservation {
//	private Date reserveDate;
	private String reserveNo;
	private String userId;
	private int visitorNum;
	private String reserveDate;
	private String reserveTime;
	private int emergencyPhone;
	private String reserveCompleteTime;
	private String totalPrice;
	// User
	private String email;
	private String address;
	private Timestamp joinDate;
	private String phone;
	// Brewery
	private String filePath;
	private String fileRename;
	private String breweryName;
	private Integer breweryNo;
	//tour
	private Integer tourNo;	
	private String tourName;
	private String tourContent;
	private String timeTaken;
	private Integer tourPrice;
	
	
	public Reservation(String reserveNo, Timestamp joinDate, String email, String phone) {
		this.reserveNo = reserveNo;
		this.joinDate = joinDate;
		this.email = email;
		this.phone = phone;
	}
	public String getTourContent() {
		return tourContent;
	}


	public void setTourContent(String tourContent) {
		this.tourContent = tourContent;
	}


	public String getTimeTaken() {
		return timeTaken;
	}


	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}


	 public void setTourPrice(String tourPrice) {
         this.tourPrice = Integer.parseInt(tourPrice);
}

	
	public Integer getBreweryNo() {
		return breweryNo;
	}

	public void setBreweryNo(Integer breweryNo) {
		this.breweryNo = breweryNo;
	}

	public Integer getTourNo() {
		return tourNo;
	}

	public void setTourNo(Integer tourNo) {
		this.tourNo = tourNo;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

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

	public Reservation(String userId) {
		super();
		this.userId = userId;
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
				+ ", reserveDate=" + reserveDate + ", reserveTime=" + reserveTime + ", emergencyPhone=" + emergencyPhone
				+ ", reserveCompleteTime=" + reserveCompleteTime + ", totalPrice=" + totalPrice + ", email=" + email
				+ ", address=" + address + ", joinDate=" + joinDate + ", phone=" + phone + ", filePath=" + filePath
				+ ", fileRename=" + fileRename + ", breweryName=" + breweryName + ", breweryNo=" + breweryNo
				+ ", tourNo=" + tourNo + ", tourName=" + tourName + ", tourContent=" + tourContent + ", timeTaken="
				+ timeTaken + ", tourPrice=" + tourPrice + "]";
	}

}
