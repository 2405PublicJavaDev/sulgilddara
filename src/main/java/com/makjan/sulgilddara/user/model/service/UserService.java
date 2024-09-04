package com.makjan.sulgilddara.user.model.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.user.model.vo.User;
public interface UserService {

	/**
	 * 회원가입 등록 Service
	 * @param inputUser
	 * @param uploadFile
	 * @return int
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	int registerUser(User inputUser, MultipartFile uploadFile) throws IllegalStateException, IOException;

	/**
	 * 회원 정보 수정 Service
	 * @param modifyUser
	 * @param uploadFile
	 * @return int
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int updateUser(User modifyUser, MultipartFile reloadFile) throws IllegalStateException, IOException;
	
	/**
	 * 회원 로그인 Service
	 * @param user
	 * @return user
	 */
	User checkLogin(User user);

	/**
	 * 아이디로 회원 찾기 Service
	 * @param userId
	 * @return user
	 */
	User selectOneById(String userId);
}
