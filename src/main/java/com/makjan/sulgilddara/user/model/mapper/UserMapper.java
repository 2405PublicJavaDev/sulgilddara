package com.makjan.sulgilddara.user.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.makjan.sulgilddara.user.model.vo.User;
import com.makjan.sulgilddara.user.model.vo.UserFile;

@Mapper
public interface UserMapper {

	/**
	 * 회원가입 Mapper
	 * @param inputUser
	 * @return int
	 */
	int registerUser(User inputUser);
	
	/**
	 * 회원가입 파일 등록 Mapper
	 * @param userFile
	 * @return int
	 */
	int registerUserFile(UserFile userFile);
}
