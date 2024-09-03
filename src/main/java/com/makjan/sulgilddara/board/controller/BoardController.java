package com.makjan.sulgilddara.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makjan.sulgilddara.board.common.utility.Util;
import com.makjan.sulgilddara.board.model.service.BoardService;
import com.makjan.sulgilddara.board.model.vo.Board;
import com.makjan.sulgilddara.board.model.vo.BoardFile;
import com.makjan.sulgilddara.board.model.vo.BoardTag;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
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
	
	
	
	// 파일 업로드 메소드 (ajax 통신)
	@ResponseBody
	@PostMapping("/board/uploadImage")
	public ResponseEntity<?> boardUploadImage(@RequestParam("file") MultipartFile file){
		
		if(file != null) {
			String fileName = file.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			
			// Web용 경로
			String filePath = "/images/board/"; // 이 경로가 fileConfig에 의해 실제 C드라이브 경로로 매핑됨.
			
			
			try {
				//실제 경로 
				file.transferTo(new File("C:\\uploadFile\\board\\" + fileRename));
				
				// board객체 생성 -> db에 저장하기 위함. 사실 에디터 사용시 에디터가 정보 다갖고있음.
				BoardFile boardFile = new BoardFile();
				boardFile.setFileName(fileName);
				boardFile.setFileRename(fileRename);
				boardFile.setFilePath(filePath); // 경로에 복사
				
//			boardFile에 boardNo 실제 게시글 업로드 시점에서 넣어주기 -> update로 boradNo만 수정해주면 됨.
				int result = bService.insertBoardFile(boardFile);
				// ResponseEntity는 String과 크게 다른점은 없지만 다른 기능들을 사욜할 수 있는 객체형태
				return ResponseEntity.ok(filePath+fileRename); // 경로 전달
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return ResponseEntity.badRequest().body("이미지 업로드 실패");
			}	
		}
		
		return null;
	}
	
	
	
}








