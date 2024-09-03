package com.makjan.sulgilddara.liquor.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * 주류정보 추가를 위한 정보 입력 페이지로 이동
	 * @return liquorAdd.html로 이동
	 */
	@GetMapping("/add")
	public String showLiquorAddForm() {
		return "liquor/liquorAdd";
	}
	
	/**
	 * liquorAdd.html에서 입력한 값을 Liquor 형식으로 받아와서 DB 등록하는 비즈니스로직 시작
	 * @param model
	 * @param liquor
	 * @return liquorList.html로 이동
	 */
	@PostMapping("/add")
	public String liquorAdd(Model model, @ModelAttribute Liquor liquor) {
		lService.addLiquor(liquor);
		return "liquor/liquorList";
	}
	
	@GetMapping("/update/{liquorId}")
	public String showLiquorUpdateForm(@PathVariable("liquorId") Integer liquorId,
			Model model) {
		Liquor liquor = lService.selectOneById(liquorId);
		model.addAttribute("liquor", liquor);
		return "liquor/liquorUpdate";
	}
	
	@PostMapping("/update")
	public String updateLiquor(Liquor liquor) {
		int result = lService.updateLiquor(liquor);
		return "liquor/liquorDetail";
	}
	
	@GetMapping("/delete")
	public String deleteLiquor() {
		return "liquor/liquorList";
	}
	
	@GetMapping("/detail")
	public String liquorDetail(@RequestParam String param) {
		return "liquor/liquorDetail";
	}
	
	/**
	 * DB의 전체 주류 정보를 조회하는 메서드이다.
	 * currentPage를 기준으로 10페이지씩 페이징을 한다.
	 * currentPage값이 주어지지 않은 경우 기본값인 1로 동작한다.
	 * @param currentPage
	 * @param model
	 * @return liquorList.html로 이동
	 */
	@GetMapping("/list")
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
