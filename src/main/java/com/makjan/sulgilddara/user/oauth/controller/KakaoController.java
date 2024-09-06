package com.makjan.sulgilddara.user.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class KakaoController {
	
	@GetMapping("/login/kakao")
	public String kakaoConnect() {

		StringBuffer url = new StringBuffer();
		url.append("https://kauth.kakao.com/oauth/authorize?");
		url.append("client_id=" + "de590a7e08c82cba6bdf69f09ca0ab27");
		url.append("&redirect_uri=http://localhost:8888/study/kakao");
		url.append("&response_type=code");

		return "redirect:" + url.toString();
	}

}
