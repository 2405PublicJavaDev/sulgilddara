package com.makjan.sulgilddara.user.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.user.model.service.UserService;
import com.makjan.sulgilddara.user.model.vo.User;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uService;
	
	// 회원가입 form 메소드 (GET)
	@GetMapping("/register")
	public String showRegisterForm(@ModelAttribute("user") User user) {
		return "user/userJoin";
	}
	
	// 회원가입 메소드 (POST)
	@PostMapping("/register")
	public String registerUser(@Validated @ModelAttribute("user") User inputUser
			, BindingResult bindingResult
			, @RequestParam("uploadFile") MultipartFile uploadFile) throws IllegalStateException, IOException {
        if (bindingResult.hasErrors()) {
            return "user/userJoin";
        }
        
        if (!inputUser.getUserPw().equals(inputUser.getConfirm_userPW())) {
        	bindingResult.rejectValue("userPw", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
        }
        
        int result = uService.registerUser(inputUser, uploadFile);
        if (result > 0) {
            return "redirect:/user/register";
        } else {
            return "user/userJoin";
        }
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
