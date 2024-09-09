package com.makjan.sulgilddara.user.model.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.common.utility.Util;
import com.makjan.sulgilddara.user.common.mail.SendEmailService;
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
	
	@Autowired
    private SendEmailService sendEmailService;
	
	// 회원가입 Service
	@Override
	public int registerUser(User inputUser, MultipartFile uploadFile) throws IllegalStateException, IOException {
		int result = mapper.registerUser(inputUser);
		if(uploadFile != null && !uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			String filePath="/user-images/";
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

	// 로그인 Service
	@Override
	public User checkLogin(User user) {
		User result = mapper.checkLogin(user);
		return result;
	}

	// 아이디로 회원 찾기 Service
	@Override
	public User selectOneById(String userId) {
		User user = mapper.selectOneById(userId);
//		System.out.println("userFile: " + user.getUserFile());
		return user;
	}

	// 회원 정보 수정 Service
	@Override
	public int updateUser(User modifyUser, MultipartFile reloadFile) throws IllegalStateException, IOException {
		int result = mapper.updateUser(modifyUser);
		if(reloadFile != null && !reloadFile.isEmpty()) {
			// reloadFile이 list 형식이기 때문에 !.isEmpty() 도 적어줘야 기존에 파일이 없을때도 새로 등록하여 수정이 가능하다.
			String fileName = reloadFile.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			String filePath = "/user-images/";
			UserFile userFile = new UserFile();
			userFile.setFileName(fileName);
			userFile.setFileRename(fileRename);
			userFile.setFilePath(filePath);
			userFile.setUserId(modifyUser.getUserId());;
			reloadFile.transferTo(new File("C:/uploadFile/user/"+ fileRename));	//파일이 실제로 저장되는 코드			
			UserFile nFileOne = mapper.selectUserFile(modifyUser.getUserId()); 	//userId로 조회해서 해당 멤버의 프로필사진이 있는지 체크
			// 만약 파일이 null 이 아니면 update
			if(nFileOne != null) {
				// 기존에 있던 file도 삭제해야함 (폴더 안에 있는 file)
				File nFile = new File("C:/uploadFile/user/"+nFileOne.getFileRename());
				nFile.delete(); // file의 메소드 delete를 이용하여 파일을 삭제한다. -> 해당 경로의 기존 file은 삭제됨
				result = mapper.updateUserFile(userFile);
			} else {
			// 파일이 null 이면 insert 
				result = mapper.registerUserFile(userFile);
			}
		}
		return result;
	}

	// 회원 탈퇴 Service
	@Override
	public int deleteUser(String userId) {
		int result = mapper.deleteUser(userId);
		UserFile userFile = mapper.selectUserFile(userId);
		if(userFile != null) {
			File nFile = new File("C:/uploadFile/user/"+userFile.getFileRename());	// 해당경로의 해당file을 File객체 nFile에 넣음
			nFile.delete();	// file의 메소드 delete를 이용하여 파일을 삭제한다. -> 해당 경로의 file은 삭제됨
			result = mapper.deleteUserFile(userId);
		}
		return result;
	}

	// 아이디 찾기 Service
	@Override
	public String searchId(String userName, String email) {
		String findId = mapper.searchId(userName, email);
		return findId;
	}

	// 입력한 아이디와 이메일 check Service
	@Override
    public boolean checkEmail(String userId, String email) {
        User user = mapper.selectOneById(userId);
        // 해당 id의 user이 있고, 그 user의 email과 입력한 email이 동일하면 true 아니면 false
        if (user != null && user.getEmail().equals(email)) {
            return true;
        } else {
            return false;
        }
    }

	// 비밀번호 이메일로 전송 Service
	// SendEmailService 클래스 이용
	// 이메일 전송 시간 단축 시키기 위해 비동기 어노테이션 사용
	@Async
    @Override
    public void sendTemporaryPassword(String userId, String email) {
    	sendEmailService.sendTemporaryPassword(userId, email);
    }
}
