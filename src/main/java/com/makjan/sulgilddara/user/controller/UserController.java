package com.makjan.sulgilddara.user.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uService;
	
	// 회원가입 form 
	@GetMapping("/register")
	public String showRegisterForm(@ModelAttribute User user) {
		return "user/userJoin";
	}
	
	// 회원가입 메소드 (POST)
	@PostMapping("/register")
	public String registerUser(@Validated @ModelAttribute User inputUser
			, BindingResult bindingResult
			, @RequestParam("uploadFile") MultipartFile uploadFile) throws IllegalStateException, IOException {

		// userPw와 confirm_userPw가 일치하지 않을 때 해당 메시지 출력되게
        if (!inputUser.getUserPw().equals(inputUser.getConfirm_userPw())) {
        	bindingResult.rejectValue("confirm_userPw", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
        }		
		// 오류가 있다면 해당 페이지로 이동
		if (bindingResult.hasErrors()) {
            return "user/userJoin";
        }
        int result = uService.registerUser(inputUser, uploadFile);
        if (result > 0) {
            return "redirect:/user/login";
        } else {
            return "user/userJoin";
        }
	}
	
	// 회원정보 수정 form  (GET)
	@GetMapping("/update")
	public String showUpdateForm(HttpSession session, Model model) {
		// session에 담긴 userId로 해당 user 찾음
		String userId = (String)session.getAttribute("userId");
		User user = uService.selectOneById(userId);
		if (user != null) {
			// 성공하면 본인의 수정 페이지로 이동
			model.addAttribute("user", user);
			return "user/userModify";
		} else {
			return "user/userLogin";
		}
	}
	
	// 회원정보 수정 메소드 (POST)
	@PostMapping("/update")
	public String updateUser(@Validated @ModelAttribute User modifyUser
			, BindingResult bindingResult
			, @RequestParam("reloadFile") MultipartFile reloadFile) throws IllegalStateException, IOException {
		
		// userPw와 confirm_userPw가 일치하지 않을 때 해당 메시지 출력되게
        if (!modifyUser.getUserPw().equals(modifyUser.getConfirm_userPw())) {
        	bindingResult.rejectValue("confirm_userPw", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
        }
		if (bindingResult.hasErrors()) {
            return "user/userModify";
        }
        int result = uService.updateUser(modifyUser, reloadFile);
        if (result > 0) {
            return "redirect:/";
        } else {
            return "user/userModify";
        }		
	}
	
	// 로그인 form 
	@GetMapping("/login")
	public String showLoginForm(@ModelAttribute User user) {
		return "user/userLogin";
	}
	
	// 로그인 메소드
	@PostMapping("/login")
	public String checkLogin(@RequestParam("userId") String userId,
			@RequestParam("userPw") String userPw, HttpSession session) {
		User user = new User();
		user.setUserId(userId);
		user.setUserPw(userPw);
		user = uService.checkLogin(user);
		if(user != null) {
			// 로그인 성공 시 userId 세션에 저장
			session.setAttribute("userId", userId);
			return "redirect:/";
		} else {
			return "user/userJoin";
		}		
	}
}
