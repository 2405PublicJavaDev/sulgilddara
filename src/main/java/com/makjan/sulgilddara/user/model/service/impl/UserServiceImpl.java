package com.makjan.sulgilddara.user.model.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.common.utility.Util;
import com.makjan.sulgilddara.user.model.mapper.UserMapper;
import com.makjan.sulgilddara.user.model.service.UserService;
import com.makjan.sulgilddara.user.model.vo.User;
import com.makjan.sulgilddara.user.model.vo.UserFile;

@Service
public class UserServiceImpl implements UserService {
	
	private UserMapper mapper;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(UserMapper mapper) {
		this.mapper = mapper;
	}

	// 회원가입 Service
	@Override
	public int registerUser(User inputUser, MultipartFile uploadFile) throws IllegalStateException, IOException {
		int result = mapper.registerUser(inputUser);
		if(uploadFile != null && !uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			String filePath="/images/user/";
			uploadFile.transferTo(new File("C:/uploadFile/user/"+ fileRename));
			UserFile userFile = new UserFile();
			userFile.setFileName(fileName);
			userFile.setFileRename(fileRename);
			userFile.setFilePath(filePath);
			userFile.setUserId(inputUser.getUserId());
			result = mapper.registerUserFile(userFile);
		}
		return result;
	}

	@Override
	public User selectOne(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
