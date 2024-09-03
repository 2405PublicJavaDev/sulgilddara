package com.makjan.sulgilddara.brewery.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.brewery.model.service.impl.BreweryService;
import com.makjan.sulgilddara.brewery.model.vo.Brewery;
import com.makjan.sulgilddara.tour.model.service.TourService;
import com.makjan.sulgilddara.tour.model.vo.Tour;

@Controller
@RequestMapping("/brewery")
public class BreweryController {
	
	private BreweryService bService;
	private TourService tService;
	
	public BreweryController() {}
	
	@Autowired
	public BreweryController(BreweryService bService, TourService tService) {
		this.bService = bService;
		this.tService = tService;
	}
	
	@GetMapping("/write")
	public String showWriteForm() {
		return "brewery/breweryWrite";
	}
	
	@PostMapping("/write")
	public String insertBrewery(Brewery inputBrewery) throws IllegalStateException, IOException {
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
		List<Tour>tList = tService.showTourByBrwNo(breweryNo);
		model.addAttribute("tList", tList);
		model.addAttribute("brewery", brewery);
		return "brewery/breweryUpdate";
	}
	@PostMapping("/update")
	public String updateBrewery(Brewery updateBrewery) throws IllegalStateException, IOException {
//		updateBrewery.setUploadFile(reloadFile);
		int result = bService.updateBrewery(updateBrewery);
		return "redirect:/brewery/list";
	}
	@GetMapping("/delete/{breweryNo}")
	public String deleteBrewery(@PathVariable("breweryNo") Integer breweryNo) {
		int result = bService.deleteBrewery(breweryNo);
		return "redirect:/brewery/list";
	}
	
}
