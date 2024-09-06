package com.makjan.sulgilddara.user.oauth.model.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Kakaouser {
	
	@Id
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private String gender;
	private String phone;

}
