package com.makjan.sulgilddara.user.model.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
@Repository
@Getter
@Setter
public class User {
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private String isAdmin;
	private LoginType loginType;
	private String providerId;
	private String address;
	private Timestamp joinDate;
	
	private UserFile userFile;
}
