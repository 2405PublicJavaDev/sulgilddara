package com.makjan.sulgilddara.Reservation.controller;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.makjan.sulgilddara.Reservation.model.Service.ReservationService;
import com.makjan.sulgilddara.Reservation.model.VO.Reservation;
import com.makjan.sulgilddara.kakao.model.Service.KakaoPayService;
import com.makjan.sulgilddara.model.vo.Pagination;
import com.makjan.sulgilddara.user.model.vo.User;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class ReservationController {
    @Setter(onMethod_ = @Autowired)
    private KakaoPayService kakaoPay;
    
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
		String userId = (String) session.getAttribute("userId");
//		LocalTime Time = LocalTime.parse(reservation.getReserveTime());
		String randomString = generateRandomString(10);
		reservation.setUserId(userId);
		reservation.setReserveNo(randomString);
	//	reservation.setUserId("user3");
		int result =rService.RegisterInfo(reservation);
		return "redirect:"+kakaoPay.kakaoPayReady(); //결제 페이지 
}
@GetMapping("/reservation/search")
public String showListForm() {
	return "reservation/reservationlookup";
}
@PostMapping("/reservation/search")
	public String SearchInfo(@RequestParam("reserveNo")String reserveNo,
			Model model
			) {
	Map<String,String> param = new HashMap<String,String>();
	param.put("reserveNo", reserveNo);
	List<Reservation>rList = rService.SearchInfo(param);
	model.addAttribute("rList",rList);
	model.addAttribute("reserveNo",reserveNo);
	return "reservation/reservationlookup";
}

@GetMapping("/reservation/searchResultAdmin")
public String SearchAllInfo3(Model model
		,@RequestParam(value="userId",required=false)String userId
		,@RequestParam(value="breweryName",required=false)String breweryName
		,@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage
		) {
int totalCount= rService.getTotalCountWithConditiion(userId,breweryName);
System.out.println(currentPage);
Pagination pn = new Pagination(totalCount,currentPage);
int limit = pn.getBoardLimit();
int offset=(currentPage-1)*limit;
RowBounds rowBounds =new RowBounds(offset,limit);
List<Reservation>rList = rService.SearchAllInfo(userId,breweryName,rowBounds);	
model.addAttribute("rList",rList);
model.addAttribute("currentPage", currentPage);
model.addAttribute("pn",pn);
model.addAttribute("breweryName",breweryName);
model.addAttribute("userId",userId);

return "reservation/reservationSearchResultAdmin";
}

@PostMapping("/reservation/searchResultAdmin")
public String SearchAllInfo2(Model model
		,@RequestParam(value="userId",required=false)String userId
		,@RequestParam(value="breweryName",required=false)String breweryName
		,@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage
		) {
int totalCount= rService.getTotalCountWithConditiion(userId,breweryName);
System.out.println(currentPage);
Pagination pn = new Pagination(totalCount,currentPage);
int limit = pn.getBoardLimit();
int offset=(currentPage-1)*limit;
RowBounds rowBounds =new RowBounds(offset,limit);
List<Reservation>rList = rService.SearchAllInfo(userId,breweryName,rowBounds);	
model.addAttribute("rList",rList);
model.addAttribute("currentPage", currentPage);
model.addAttribute("pn",pn);
model.addAttribute("breweryName",breweryName);
model.addAttribute("userId",userId);

return "reservation/reservationSearchResultAdmin";
}

@GetMapping("/reservation/searchListAdmin")
	public String SearchAllInfo(Model model
			,@RequestParam(value="userId",required=false)String userId
			,@RequestParam(value="breweryName",required=false)String breweryName
			,@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage
			) {
	int totalCount= rService.getTotalCount(userId,breweryName);
	System.out.println(currentPage);
	Pagination pn = new Pagination(totalCount,currentPage);
	int limit = pn.getBoardLimit();
	int offset=(currentPage-1)*limit;
	System.out.println(limit);
	System.out.println(offset);
	RowBounds rowBounds =new RowBounds(offset,limit);
	List<Reservation>rList = rService.SearchAllInfo(userId,breweryName,rowBounds);	
	model.addAttribute("rList",rList);
	model.addAttribute("currentPage", currentPage);
	model.addAttribute("pn",pn);
	model.addAttribute("breweryName",breweryName);
	model.addAttribute("userId",userId);
	return "reservation/reservationlookupadmin";
}
@GetMapping("/reservation/reservationsuccess")
public String SuccessInfo() {
	return "reservation/reservationsuccess";
}
@PostMapping("/reservation/reservationsuccess")
public String reserveSuccess(Reservation reservation, Model model) {
	List<Reservation>rList = rService.SearchreserveNo(reservation);
	System.out.println(reservation);
	model.addAttribute("rList",rList);
	return "reservation/reservationsuccess";
}
@GetMapping("reservation/detail/{reserveNo}")
	public String showReservationDetail(@PathVariable("reserveNo")String reserveNo
			,HttpSession session
			,Model model
			) {
	List<Reservation>rList = rService.selectOne(reserveNo);
	model.addAttribute("rList",rList);
	System.out.println(rList);
	return "reservation/reservationlookupdetail";
}
}
