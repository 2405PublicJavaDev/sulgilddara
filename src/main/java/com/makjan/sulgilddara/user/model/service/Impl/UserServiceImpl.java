package com.makjan.sulgilddara.user.model.service.Impl;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.user.model.service.UserService;
import com.makjan.sulgilddara.user.model.vo.User;

public class UserServiceImpl implements UserService {

	// 회원가입 Service
	@Override
	public int registerUser(User inputUser, MultipartFile uploadFile) throws IllegalStateException, IOException {
		int result = 0;
		return result;
	}

}
