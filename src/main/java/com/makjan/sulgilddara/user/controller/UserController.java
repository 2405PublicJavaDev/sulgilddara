package com.makjan.sulgilddara.user.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	// ModelAttribute 어노테이션 사용하는것이 더 권장된다고 해서 적긴 했어요 
	@GetMapping("/register")
	public String showRegisterForm(@ModelAttribute("user") User user) {
		return "user/userJoin";
	}
	
	// 회원가입 메소드 (POST)
	@PostMapping("/register")
	public String registerUser(@Validated @ModelAttribute("user") User inputUser
			, BindingResult bindingResult
			, @RequestParam("uploadFile") MultipartFile uploadFile) throws IllegalStateException, IOException {
		// 오류가 있다면 해당 페이지로 이동
		if (bindingResult.hasErrors()) {
            return "user/userJoin";
        }
		// userPw와 confirm_userPw가 일치하지 않을 때 해당 메시지 출력되게
        if (!inputUser.getUserPw().equals(inputUser.getConfirm_userPw())) {
        	bindingResult.rejectValue("confirm_userPw", "passwordInCorrect", "비밀번호가 일치하지 않습니다.");
        }

        int result = uService.registerUser(inputUser, uploadFile);
        if (result > 0) {
            return "redirect:/user/register";
        } else {
            return "user/userJoin";
        }
	}
	
	@PostMapping("/login")
	public String checkLogin(User user
			, HttpSession session) {
		User dbUser = uService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (dbUser != null) {
            session.setAttribute("user", dbUser);
            return "redirect:/tour";
        } else {
            return "redirect:/login?error";
        }
	}
	
	// 회원정보 수정 form  (GET)
	@GetMapping("/update/{userId}")
	public String showUpdateForm(Model model
			, HttpSession session) {
		return "";
	}
}
