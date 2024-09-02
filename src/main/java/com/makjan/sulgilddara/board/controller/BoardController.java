package com.makjan.sulgilddara.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makjan.sulgilddara.board.model.service.BoardService;
import com.makjan.sulgilddara.board.model.vo.Board;
import com.makjan.sulgilddara.board.model.vo.BoardTag;

import lombok.NoArgsConstructor;

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
	public String boardWrite(
			@ModelAttribute("Board") Board board,
			@ModelAttribute("BoardTag") BoardTag boardTag,
			Model model) {
		board.setBoardWriter("임시작성자이름");
		int boardResult = bService.insertBoard(board, null); // null 자리에 uploadfile 보내줘야 함.
		
		
		
		// boardTagName엔 배열 문자열이 저장이 된다.
		// json형식의 문자열을 파싱해주고 배열에 저장
		
		List<String> tagNameArr = new ArrayList<String>();
		
		String tagNameJson = boardTag.getBoardTagName();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// JSON 문자열을 List<Map<String, String>> 형태로 변환
			List<Map<String, String>> list = objectMapper.readValue(tagNameJson, new TypeReference<List<Map<String, String>>>(){});
			
			 // value 필드만 추출하여 List로 변환
            tagNameArr = list.stream().map(map -> map.get("value"))
                    .toList();
                                        
		} catch(Exception e){
			e.printStackTrace();
		}
		
		// 각 배열의 값을 하나씩 table에 insert 시켜주기
		for(String tagName : tagNameArr) {
			boardTag.setBoardTagName(tagName);
			boardTag.setBoardNo(board.getBoardNo());
			int tagResult = bService.insertTag(boardTag);			
		}
		
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








