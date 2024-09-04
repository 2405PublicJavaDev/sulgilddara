package com.makjan.sulgilddara.liquor.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.common.utility.Util;
import com.makjan.sulgilddara.liquor.model.service.LiquorService;
import com.makjan.sulgilddara.liquor.model.vo.Liquor;
import com.makjan.sulgilddara.liquor.model.vo.LiquorDetail;
import com.makjan.sulgilddara.liquor.model.vo.LiquorImage;
import com.makjan.sulgilddara.liquor.model.vo.LiquorPagination;


@Controller
@RequestMapping("/liquor")
public class LiquorController {

	private LiquorService lService;
	private String UPLOAD_DIR;
	
	public LiquorController() {}

	@Autowired
	public LiquorController(LiquorService lService) {
		this.lService = lService;
		this.UPLOAD_DIR = "C:/uploadFile/liquor/";
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
	@PostMapping("/liquorAdd")
	public String liquorAdd(Model model, @ModelAttribute Liquor liquor) {
		lService.addLiquor(liquor);
		return "redirect:/liquor/list";
	}
	
	@GetMapping("/update/{liquorId}")
	public String showLiquorUpdateForm(@PathVariable("liquorId") Integer liquorId,
			Model model) {
		LiquorDetail liquor = lService.selectOneById(liquorId);
		model.addAttribute("liquor", liquor);
		return "liquor/liquorUpdate";
	}
	
	@PostMapping("/update")
	public String updateLiquor(Liquor liquor, @RequestParam("files") List<MultipartFile> files) {
		int result = lService.updateLiquor(liquor);
		System.out.println(files.size());
		if(!files.isEmpty()){
			System.out.println("ck01");
			for(MultipartFile file : files) {
				System.out.println("ck02");
				try {
					// 절대경로로 실제 파일 저장
					String fileName = file.getOriginalFilename();
					System.out.println(fileName);
					String fileRename = Util.fileRename(fileName);
					System.out.println(fileRename);
					// web용 경로
					String filePath = "/liquor-images/";
					// 절대경로로 실제 파일 저장, 저장할때는 Rename파일명으로 저장
					file.transferTo(new File(UPLOAD_DIR+fileRename));
					LiquorImage image = new LiquorImage();
					image.setFileName(fileName);
					image.setFileRename(fileRename);
					image.setFilePath(filePath);
					image.setLiquirId(liquor.getLiquorId());
					result = lService.insertLiquorImage(image);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/liquor/list";
	}
	
	@GetMapping("/delete/{liquorId}")
	public String deleteLiquor(@PathVariable("liquorId") Integer liquorId) {
		int result = lService.deleteLiquor(liquorId);
		return "redirect:/liquor/list";
	}
	
	@GetMapping("/detail/{liquorId}")
	public String liquorDetail(@PathVariable("liquorId") Integer liquorId, Model model) {
		LiquorDetail liquor = lService.selectOneById(liquorId);
		model.addAttribute("liquor", liquor);
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
