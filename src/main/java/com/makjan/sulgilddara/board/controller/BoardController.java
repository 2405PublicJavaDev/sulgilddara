package com.makjan.sulgilddara.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.makjan.sulgilddara.board.model.service.BoardService;
import com.makjan.sulgilddara.board.model.service.impl.BoardServiceImpl;
import com.makjan.sulgilddara.board.model.vo.Board;

import lombok.NoArgsConstructor;
import oracle.jdbc.Const;

@NoArgsConstructor
@Controller
public class BoardController {
	
	private BoardService bService;
	
	@Autowired
	public BoardController(BoardService bService) {
		this.bService = bService;
	}
	
	// 페이지 이동(폼) 메소드
	
	@GetMapping("/board/listCard")
	public String showBoardListCard() {
		
		return "board/boardList_card";
	}
	
	@GetMapping("/board/listTable")
	public String showBoardListTable() {
		return "board/boardList_table";
	}
	
	@GetMapping("/board/detailPage")
	public String showBoardOne() {
		return "board/boardDetail";
	}
	
	@GetMapping("/board/writePage")
	public String showWriteBoardForm() {
		return "board/boardWrite";
	}
	
	@GetMapping("/board/modifyPage")
	public String showModifyForm() {
		return "board/boardModify";
	}
	
	
//	@ModelAttribute() 안에 들어가는 이름은 내가 정해주면 됨. 단, 지어준 이름으로 뷰에서 접근가능함!
	@PostMapping("/board/write")
	public String boardWrite(@ModelAttribute("Board") Board board) { 
		
		
		return "board/boardList_card";
	}
	
	@PostMapping("/board/modify")
	public String boardModify(){
		return "board/boardDetail";
	}
	
	@PostMapping("/board/delete")
	public String boardDelete() {
		return "board/boardList_card";
	}
	
	
}
