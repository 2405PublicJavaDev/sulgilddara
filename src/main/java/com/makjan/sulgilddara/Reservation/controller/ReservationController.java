package com.makjan.sulgilddara.Reservation.controller;

import java.security.SecureRandom;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.makjan.sulgilddara.Reservation.model.Service.ReservationService;
import com.makjan.sulgilddara.Reservation.model.VO.Reservation;

import jakarta.servlet.http.HttpSession;

@Controller

public class ReservationController {
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static SecureRandom random = new SecureRandom();

	private ReservationService rService;

	@Autowired
	public ReservationController(ReservationService rService) {
		this.rService = rService;
	}

@GetMapping("/reservation/register")
	public String showRegisterForm() {
		return "reservation/registerPage";
}
private static String generateRandomString(int length) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++) {
        int character = random.nextInt(ALPHA_NUMERIC_STRING.length());
        builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }
    return builder.toString();
}
@PostMapping("/reservation/register")
	public String RegisterInfo(@ModelAttribute Reservation reservation, Model model, HttpSession session
	) {
//		String userId = (String) session.getAttribute("userId");
//		LocalTime Time = LocalTime.parse(reservation.getReserveTime());
	String randomString = generateRandomString(10);
		reservation.setReserveNo(randomString);
		reservation.setUserId("user2");
		int result =rService.RegisterInfo(reservation);
		return "reservation/test"; //결제 페이지 
}
}