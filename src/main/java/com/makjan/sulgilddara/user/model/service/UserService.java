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

	User selectOne(String userId);

}
