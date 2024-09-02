package com.makjan.sulgilddara.Reservation.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.makjan.sulgilddara.Reservation.model.Service.ReservationService;
import com.makjan.sulgilddara.Reservation.model.VO.Reservation;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/Reservation")
public class ReservationController {
	@Autowired
	private ReservationService rService;

	public ReservationController(ReservationService rService) {
		this.rService = rService;
	}
	
@GetMapping("/register")
	public String showRegisterForm() {
		return "reservation/register";
}

@PostMapping("/register")
	public String RegisterInfo(Reservation reservation, Model model, HttpSession session
			) {
//		String userId = (String) session.getAttribute("userId");
		reservation.setUserId("user01");
		LocalTime Time = LocalTime.parse(reservation.getReserveTime());
		int result =rService.RegisterInfo(reservation,Time);
		return "reservation/test"; //결제 페이지 
}

}
