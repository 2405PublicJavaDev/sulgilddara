package com.makjan.sulgilddara.kakao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.makjan.sulgilddara.kakao.model.Service.KakaoPayService;
import com.makjan.sulgilddara.reservation.model.VO.Reservation;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@RequiredArgsConstructor
@Log
public class KakaoPayController {

	@Setter(onMethod_ = @Autowired)
	private KakaoPayService kakaoPay;

	@PostMapping("/kakaoPay")
	public String kakaoPay(@ModelAttribute Reservation reservation, HttpSession session) {
		log.info("kakaoPay post.....................");
		log.info("Controller reservation {} " + reservation);
		System.out.println("Controller reservation: " + reservation);
		session.setAttribute("reservation", reservation);
		return "redirect:/kakao/ready";
	}

	@GetMapping("/kakao/ready")
	public String kakaoPayReady(HttpSession session) {
		Reservation reservation = (Reservation) session.getAttribute("reservation");
		System.out.println("ready: " + reservation);
		log.info("Controller reservatoin {} " + reservation);
		return "redirect:" + kakaoPay.kakaoPayReady(session);
	}

	@GetMapping("/success")
	public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model, HttpSession session) {
		Reservation reservation = (Reservation) session.getAttribute("reservation");
		System.out.println("reservation 나오나: " + session);
		model.addAttribute("Reservation", reservation);
		return "kakaoPaySuccess";
	}
}
