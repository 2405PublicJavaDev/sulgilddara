package com.makjan.sulgilddara.brewery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brewery")
public class BreweryController {
	@GetMapping("/write")
	public String showWriteForm() {
		return "brewery/breweryWrite";
	}
}
