package com.makjan.sulgilddara.brewery.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.makjan.sulgilddara.brewery.common.config.BreweryFileConfig;
import com.makjan.sulgilddara.brewery.model.service.impl.BreweryService;
import com.makjan.sulgilddara.brewery.model.vo.Brewery;
import com.makjan.sulgilddara.brewery.model.vo.BreweryTag;
import com.makjan.sulgilddara.liquor.model.vo.Liquor;
import com.makjan.sulgilddara.liquor.model.vo.LiquorImage;
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

	@GetMapping("/")
	public String showMain(Model model) {
		List<BreweryTag> tList = bService.selectRandomTag();
		model.addAttribute("tList", tList);
		return "brewery/breweryMain";
	}
	
	@GetMapping("/admin/write")
	public String showWriteForm() {
		return "brewery/breweryWrite";
	}
	
	@PostMapping("/admin/write")
	public String insertBrewery(Brewery inputBrewery
			, @ModelAttribute("BreweryTag") BreweryTag breweryTag
			, @RequestParam(value = "facilities", required = false) String[] facilities)  throws IllegalStateException, IOException {
	    if (facilities != null && facilities.length > 0) {
	        String facilitiesJson = new ObjectMapper().writeValueAsString(facilities);
	        inputBrewery.setFacilities(facilitiesJson); 
	    }
	    
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
		return "redirect:/brewery/admin/list";
	}
	
	@GetMapping("/admin/list")
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
		return "/brewery/breweryListAdmin";
	}
	@GetMapping("/admin/update/{breweryNo}")
	public String showUpdateForm(@PathVariable("breweryNo") Integer breweryNo,
			Model model) {
		Brewery brewery = bService.searchOneByNo(breweryNo);
		List<Tour>tourList = tService.showTourByBrwNo(breweryNo);
		List<BreweryTag> tagList = bService.showAllTagByBrwNo(breweryNo);
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
	@PostMapping("/admin/update")
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
	@GetMapping("/admin/delete/{breweryNo}")
	public String deleteBrewery(@PathVariable("breweryNo") Integer breweryNo) {
		int result = bService.deleteBrewery(breweryNo);
		return "redirect:/brewery/list";
	}
	@PostMapping("/admin/search")
	public String searchBrewery(@RequestParam(value="cp", required=false, defaultValue="1") Integer currentPage
			, Model model
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword) {
		System.out.println(searchCondition);
		int totalCount = bService.getTotalCount(searchCondition, searchKeyword);
		Pagination pn = new Pagination(totalCount, currentPage);
		int limit = pn.getBoardLimit();
		int offset = (currentPage - 1) * limit;	
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchKeyword", searchKeyword);
		List<Brewery> searchList = bService.searchBreweryByKeyword(paramMap, rowBounds, currentPage);
		model.addAttribute("sList", searchList);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("searchCondition", searchCondition);
		model.addAttribute("pn", pn);
		return "brewery/brewerySearchListAdmin";
	}
	@GetMapping("/admin/search")
	public String showSearchBrewery(@RequestParam(value="cp", required=false, defaultValue="1") Integer currentPage
			, Model model
			, @RequestParam("searchCondition") String searchCondition
			, @RequestParam("searchKeyword") String searchKeyword) {
		System.out.println(searchCondition);
		int totalCount = bService.getTotalCount(searchCondition, searchKeyword);
		Pagination pn = new Pagination(totalCount, currentPage);
		int limit = pn.getBoardLimit();
		int offset = (currentPage - 1) * limit;	
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchKeyword", searchKeyword);
		List<Brewery> searchList = bService.searchBreweryByKeyword(paramMap, rowBounds, currentPage);
		model.addAttribute("sList", searchList);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("searchCondition", searchCondition);
		model.addAttribute("pn", pn);
		return "brewery/brewerySearchListAdmin";
	}
	@ResponseBody
	@RequestMapping(value="/localList", produces="application/json;charset=UTF-8")
	public List<Brewery> showLocalList(@RequestParam(value="local") String local) {
		List<Brewery> bList = bService.searchBreweryByLocal(local);
//		List<Brewery> bList;
		System.out.println(local);
		if("all".equals(local)) {
			bList = bService.selectThreeBrewery();
		} else {
			bList = bService.searchBreweryByLocal(local);			
		}
		return bList;
	}
	@ResponseBody
	@RequestMapping(value="/taglist", produces="application/json;charset=UTF-8")
	public Map<String, Object> showBreweryList(@RequestParam(value="hashTag", required=false) String hashTag) {
		List<Brewery>sList = bService.searchBreweryByTag(hashTag);
//		if("all".equals(hashTag)) {
//			sList = bService.searchBreweryByTag(hashTag);
//		}
	    List<Map<String, Object>> breweryList = new ArrayList<>();
	    for (Brewery brewery : sList) {
	        Map<String, Object> breweryMap = new HashMap<>();
	        breweryMap.put("brewery", brewery);

	        List<Liquor> lList = bService.selectLiquorByNo(brewery.getBreweryNo());
	        breweryMap.put("liquors", lList);

	        List<BreweryTag> tList = bService.showTagByBrwNo(brewery.getBreweryNo());
	        breweryMap.put("tags", tList);

	        breweryList.add(breweryMap);
	    }
	    Map<String, Object> response = new HashMap<>();
	    response.put("sList", sList);
	    response.put("breweryList", breweryList);
		return response;
	}
//	@ResponseBody
//	@RequestMapping(value="/showByTag", produces="application/json;charset=UTF-8")
//	public List<Brewery> showSearchByHashTag (@RequestParam(value="tagName") String tagName) {
//		List<Brewery> bList = bService.searchBreweryByTag(tagName);
//		return bList;
//	}
	
	@GetMapping("/showByTag")
	public String showSearchByHashTag2 (@RequestParam("tagName") String tagName
			, Model model) {
		List<Brewery> bList = bService.searchFourBreweryByTag(tagName);
		model.addAttribute("bList", bList);
		System.out.println(bList);
		return "brewery/breweryMain::#brewery-list";
	}
	
	@GetMapping("/list")
	public String showBreweryList(Model model) {
		List<BreweryTag>tList = bService.showAllTag();
		model.addAttribute("tList", tList);
		return "brewery/breweryList";
	}

	@GetMapping("/detail/{breweryNo}")
	public String showBreweryDetail(@PathVariable ("breweryNo") Integer breweryNo,
			Model model) {
		Brewery brewery = bService.searchOneByNo(breweryNo);
		String localName = brewery.getBreweryLocal();
		localName = getLocalName(localName);
		brewery.setBreweryLocal(localName);
		model.addAttribute("brewery", brewery);
		
		List<Tour> tList = tService.showTourByBrwNo(breweryNo);
		model.addAttribute("tList", tList);
		
		List<Map<String, Object>> liquorList = new ArrayList<>();
		Map<String, Object> liquorMap = new HashMap<>(); 
		
		List<Liquor> lList = bService.selectLiquorByNo(breweryNo);
		liquorMap.put("lList", lList);
		
		List<LiquorImage> iList = bService.selectLiquorImageByNo(breweryNo);
		liquorMap.put("iList", iList);
		
		model.addAttribute("liquorMap", liquorMap);
		
		return "brewery/breweryDetail";	
		
	}
	public String getLocalName(String local) {
	    switch (local) {
	        case "sudo": return "수도권";
	        case "gang": return "강원";
	        case "chung": return "충청";
	        case "gyeong": return "경상";
	        case "jeoll": return "전라";
	        case "jeju": return "제주";
	        default: return "알 수 없음";
	    }
	}
}
