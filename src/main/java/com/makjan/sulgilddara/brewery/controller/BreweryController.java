package com.makjan.sulgilddara.brewery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.makjan.sulgilddara.brewery.model.service.impl.BreweryService;
import com.makjan.sulgilddara.brewery.model.vo.Brewery;

@Controller
@RequestMapping("/brewery")
public class BreweryController {
	
	private BreweryService bService;
	
	public BreweryController() {}
	
	@Autowired
	public BreweryController(BreweryService bService) {
		this.bService = bService;
	}
	
	@GetMapping("/write")
	public String showWriteForm() {
		return "brewery/breweryWrite";
	}
	
	@PostMapping("/write")
	public String insertBrewery(Brewery inputBrewery) {
		int result = bService.insertBrewery(inputBrewery);
		return "redirect:/brewery/list";
	}
	
	@GetMapping("/list")
	public String showBreweryList(Model model) {
		List<Brewery>bList = bService.selectAllList();
		model.addAttribute("bList", bList);
		return "/brewery/breweryList";
	}
	@GetMapping("/update/{breweryNo}")
	public String showUpdateForm(@PathVariable("breweryNo") Integer breweryNo,
			Model model) {
		Brewery brewery = bService.searchOneByNo(breweryNo);
		model.addAttribute("brewery", brewery);
		return "brewery/breweryUpdate";
	}
	@PostMapping("/update")
	public String updateBrewery(Brewery brewery) {
		int result = bService.updateBrewery(brewery);
		return "redirect:/brewery/list";
	}
	@GetMapping("/delete/{breweryNo}")
	public String deleteBrewery(@PathVariable("breweryNo") Integer breweryNo) {
		int result = bService.deleteBrewery(breweryNo);
		return "redirect:/brewery/list";
	}
	
}
