package com.makjan.sulgilddara.user.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.user.model.service.UserService;
import com.makjan.sulgilddara.user.model.vo.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uService;
	
	// 회원가입 from 메소드 (GET)
	@GetMapping("/register")
	public String showRegisterForm() {
		return "user/userJoin";
	}
	
	// 회원가입 메소드 (POST)
	@PostMapping("/register")
	public String registerUser(User inputUser
			, @RequestParam("userFile") MultipartFile uploadFile) throws IllegalStateException, IOException {
		int result = uService.registerUser(inputUser, uploadFile);
		return "redirect:/index";
	}
	
	
//	@PostMapping("/login")
//	public String checkLogin(User user) {
//		User user = new User();
//		user.setUserId(userId);
//		user.setUserPw(userPw);
//		user = uService.checkLogin(user);
//		if(user != null) {
//			session.setAttribute("user", user);
//			return "redirect:/";
//		} else {
//			return "redirect:/";
//		}
//	}
}
