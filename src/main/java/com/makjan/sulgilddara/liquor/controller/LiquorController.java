package com.makjan.sulgilddara.liquor.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
import com.makjan.sulgilddara.liquor.model.vo.LiquorPagination;


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
		lService.addLiquor(liquor);
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
	public String showLiquorList(@RequestParam(value="cp", required=false, defaultValue="1") Integer currentPage, Model model) {
		int totalCount = lService.getTotalCount();
		LiquorPagination pn = new LiquorPagination(totalCount, currentPage);
		int limit = pn.getBoardLimit();
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Liquor> lList = lService.selectLiquorList(currentPage, rowBounds);
		model.addAttribute("lList", lList);
		model.addAttribute("pn", pn);
		return "liquor/liquorList";
	}
	
	
}
