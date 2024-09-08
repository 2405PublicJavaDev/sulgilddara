package com.makjan.sulgilddara.user.oauth.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.makjan.sulgilddara.user.model.vo.User;
import com.makjan.sulgilddara.user.oauth.model.service.KakaoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class KakaoController {
	
	@Autowired
	private KakaoService kakaoService ;	
	
	@GetMapping("/user/login/kakao")
	public String kakaoConnect() {

		StringBuffer url = new StringBuffer();
		url.append("https://kauth.kakao.com/oauth/authorize?");
		url.append("client_id=" + "de590a7e08c82cba6bdf69f09ca0ab27");
		url.append("&redirect_uri=http://localhost:8888/study/kakao");
		url.append("&response_type=code");

		return "redirect:" + url.toString();
	}
    
    @RequestMapping(value = "/study/kakao")
    public String kakaoLogin(@RequestParam("code") String code,Model model ,HttpSession session) throws Exception {
		
		//code로 토큰 받음
		String access_token = kakaoService.getToken(code);
		session.setAttribute("accessToken", access_token);
		//토큰으로 사용자 정보 담은 list 가져오기
		// ArrayList<Object> list = kakaoService.getUserInfo(access_token);
		kakaoService.handleUserInfo(access_token);
		//list 모델에 담아 view로 넘김
		//model.addAttribute("list", list);
		
		return "redirect:/";
	}

    // 카카오 회원 탈퇴
    @GetMapping("/user/logout/kakao")
    public RedirectView kakaoLogout(HttpSession session) {
String accessToken = (String) session.getAttribute("access_token");
        
        // access_token이 없는 경우 처리
        if (accessToken == null || accessToken.isEmpty()) {
            return new RedirectView("/error");
        }

        try {
            // 카카오 로그아웃 API 호출
            kakaoService.logout(accessToken);
        } catch (Exception e) {
            e.printStackTrace();
            // 에러 페이지로 리다이렉트
            return new RedirectView("/error");
        }

        // 로그아웃 후 카카오 로그인 페이지로 리다이렉트
        String loginUrl = "https://kauth.kakao.com/oauth/authorize?client_id=de590a7e08c82cba6bdf69f09ca0ab27&redirect_uri=http://localhost:8888/study/kakao&response_type=code";
        return new RedirectView(loginUrl);
    }
}
