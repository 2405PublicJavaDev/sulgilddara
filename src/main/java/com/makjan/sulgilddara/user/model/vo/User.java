package com.makjan.sulgilddara.user.model.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Repository
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	// NotBlank : 공백이면 해당 메세지가 뜨는 어노테이션
	@NotBlank(message="아이디는 필수 입력 값입니다.")
	private String userId;
	
	// Pattern : 비밀번호는 8~16글자의 숫자,문자, 특수문자
	@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
	private String userPw;
	private String confirm_userPw;
	@NotBlank(message="이름은 필수 입력 값입니다.")
	private String userName;
	
	// Email : 이메일 형식에 맞게 쓰지 않으면 해당 메세지가 뜨는 어노테이션
	@NotBlank(message="이메일은 필수 입력 값입니다.")
	@Email(message="이메일 형식에 맞지 않습니다.")
	private String email;
	private String isAdmin;
	// 로그인타입 
	private LoginType loginType;
	private String providerId;
	private String gender;
	//@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호 형식은 000-0000-0000 입니다.") 
	private String phone;
	private String address;
	private Timestamp joinDate;
	private Timestamp updateDate;
	// 프로필 사진
	private UserFile userFile;
}
