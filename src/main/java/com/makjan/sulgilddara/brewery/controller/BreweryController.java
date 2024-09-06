package com.makjan.sulgilddara.brewery.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.makjan.sulgilddara.brewery.model.service.impl.BreweryService;
import com.makjan.sulgilddara.brewery.model.vo.Brewery;
import com.makjan.sulgilddara.brewery.model.vo.BreweryTag;
import com.makjan.sulgilddara.model.vo.Pagination;
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
	public String insertBrewery(Brewery inputBrewery
<<<<<<< HEAD
			, @ModelAttribute("BreweryTag") BreweryTag breweryTag
			, @RequestParam(value = "facilities", required = false) String[] facilities)  throws IllegalStateException, IOException {
	    if (facilities != null && facilities.length > 0) {
	        String facilitiesJson = new ObjectMapper().writeValueAsString(facilities);
	        inputBrewery.setFacilities(facilitiesJson); 
	    }
=======
			, @ModelAttribute("BreweryTag") BreweryTag breweryTag ) throws IllegalStateException, IOException {
>>>>>>> yehong
		int result = bService.insertBrewery(inputBrewery);
		if(breweryTag != null && breweryTag.getBreweryTagName() != null && !breweryTag.getBreweryTagName().isEmpty()) {
			List<String> tagNameArr = new ArrayList<String>();
			String tagNameJson = breweryTag.getBreweryTagName();
			ObjectMapper objectMapper = new ObjectMapper();
			 try {
	            List<Map<String, String>> list = objectMapper.readValue(tagNameJson, new TypeReference<List<Map<String, String>>>(){});
	            tagNameArr = list.stream().map(map -> map.get("value")).toList();
	            
	            for (String tagName : tagNameArr) {
	                breweryTag.setBreweryNo(inputBrewery.getBreweryNo());
	                breweryTag.setBreweryTagName(tagName);
	                int tagResult = bService.insertTag(breweryTag);
	            }
	        } catch (MismatchedInputException e) {
	            System.out.println("No tags to process: " + e.getMessage());
	        }
	    }
		return "redirect:/brewery/list";
	}
	
	@GetMapping("/list")
	public String showBreweryList(@RequestParam(value="cp", required=false, defaultValue="1") Integer currentPage
			, Model model) {
		int totalCount = bService.getTotalCount();
		Pagination pn = new Pagination(totalCount, currentPage);
		int limit = pn.getBoardLimit();
		int offset = (currentPage - 1) * limit;	
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Brewery>bList = bService.selectAllList(currentPage, rowBounds);
		model.addAttribute("bList", bList);
		model.addAttribute("pn", pn);
		return "/brewery/breweryList";
	}
	@GetMapping("/update/{breweryNo}")
	public String showUpdateForm(@PathVariable("breweryNo") Integer breweryNo,
			Model model) {
		Brewery brewery = bService.searchOneByNo(breweryNo);
		List<Tour>tourList = tService.showTourByBrwNo(breweryNo);
		List<BreweryTag> tagList = bService.showTagByBrwNo(breweryNo);
		String tagString = tagList.stream()
                .map(BreweryTag::getBreweryTagName)
                .collect(Collectors.joining(","));
//	    if (brewery.getFacilities() != null && !brewery.getFacilities().isEmpty()) {
//	        String[] facilitiesArray = brewery.getFacilities().replaceAll("[\\[\\] ]", "").split(",");
//	        List<String> facilitiesList = Arrays.asList(facilitiesArray);
//	        model.addAttribute("facilitiesList", facilitiesList);
//	        System.out.println(facilitiesList);
//	    } else {
//	        model.addAttribute("facilitiesList", Collections.emptyList());
//	    }
		model.addAttribute("tourList", tourList);
		model.addAttribute("tagString", tagString);
		model.addAttribute("brewery", brewery);
		return "brewery/breweryUpdate";
	}
	@PostMapping("/update")
	public String updateBrewery(Brewery updateBrewery
			, @ModelAttribute("BreweryTag") BreweryTag breweryTag
			, @RequestParam(value = "facilities", required = false) String[] facilities
			, @RequestParam Map<String, String> params) throws IllegalStateException, IOException {
		    if (facilities != null && facilities.length > 0) {
		        String facilitiesJson = new ObjectMapper().writeValueAsString(facilities);
		        updateBrewery.setFacilities(facilitiesJson);
		    }
		int result = bService.updateBrewery(updateBrewery);
		int tagResult = bService.deleteTag(breweryTag);
		if(breweryTag != null && breweryTag.getBreweryTagName() != null && !breweryTag.getBreweryTagName().isEmpty()) {
			List<String> tagNameArr = new ArrayList<String>();
			String tagNameJson = breweryTag.getBreweryTagName();
			ObjectMapper objectMapper = new ObjectMapper();
			 try {
	            List<Map<String, String>> list = objectMapper.readValue(tagNameJson, new TypeReference<List<Map<String, String>>>(){});
	            tagNameArr = list.stream().map(map -> map.get("value")).toList();
	            
	            for (String tagName : tagNameArr) {
	                breweryTag.setBreweryNo(updateBrewery.getBreweryNo());
	                breweryTag.setBreweryTagName(tagName);
	                int tagUpdateresult = bService.insertTag(breweryTag);
	            }
	        } catch (MismatchedInputException e) {
	            System.out.println("No tags to process: " + e.getMessage());
	        }
	    }
		return "redirect:/brewery/list";
	}
	@GetMapping("/delete/{breweryNo}")
	public String deleteBrewery(@PathVariable("breweryNo") Integer breweryNo) {
		int result = bService.deleteBrewery(breweryNo);
		return "redirect:/brewery/list";
	}
	@PostMapping("/search")
	public String showSearchBrewery(@RequestParam(value="cp", required=false, defaultValue="1") Integer currentPage
			, Model model
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword) {
		int totalCount = bService.getTotalCount();
		Pagination pn = new Pagination(totalCount, currentPage);
		int limit = pn.getBoardLimit();
		int offset = (currentPage - 1) * limit;	
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchKeyword", searchKeyword);
		List<Brewery> searchList = bService.searchBreweryByKeyword(paramMap, rowBounds);
		model.addAttribute("sList", searchList);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("searchCondition", searchCondition);
		model.addAttribute("pn", pn);
		return "brewery/brewerySearchList";
	}
}
