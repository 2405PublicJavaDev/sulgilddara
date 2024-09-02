package com.makjan.sulgilddara.liquor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.makjan.sulgilddara.liquor.model.service.LiquorService;
import com.makjan.sulgilddara.liquor.model.vo.Liquor;


@Controller
@RequestMapping("/liquor")
public class LiquorController {

	private LiquorService lService;

	public LiquorController() {}

	@Autowired
	public LiquorController(LiquorService lService) {
		this.lService = lService;
	}
	
	@GetMapping("/liquorAdd")
	public String showLiquorAddForm() {
		return "liquor/liquorAdd";
	}
	
	@PostMapping("/liquorAdd")
	public String liquorAdd(Model model, @ModelAttribute Liquor liquor) {
		return "liquor/liquorList";
	}
	
	@GetMapping("/liquorUpdate")
	public String showLiquorUpdateForm() {
		return "liquor/liquorUpdate";
	}
	
	@PostMapping("/liquorUpdate")
	public String updateLiquor() {
		return "liquor/liquorDetail";
	}
	
	@GetMapping("/liquorDelete")
	public String deleteLiquor() {
		return "liquor/liquorList";
	}
	
	@GetMapping("/liquorDetail")
	public String liquorDetail(@RequestParam String param) {
		return "";
	}
	
	@GetMapping("/liquorList")
	public String showLiquorList(@RequestParam String param) {
		return new String();
	}
	
	
}
