package com.makjan.sulgilddara.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makjan.sulgilddara.board.model.service.BoardService;
import com.makjan.sulgilddara.board.model.vo.Board;
import com.makjan.sulgilddara.board.model.vo.BoardFile;
import com.makjan.sulgilddara.board.model.vo.BoardReply;
import com.makjan.sulgilddara.board.model.vo.BoardReplyUser;
import com.makjan.sulgilddara.board.model.vo.BoardTag;
import com.makjan.sulgilddara.board.model.vo.SearchLiquor;
import com.makjan.sulgilddara.common.utility.Util;

import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


@NoArgsConstructor
@Controller
public class BoardController {
	
	private BoardService bService;
	
	@Autowired
	public BoardController(BoardService bService) {
		this.bService = bService;
	}
	
	// 카드 - 목록 이동 (get)
	@GetMapping("/board/listCard")
	public String showBoardListCard(@RequestParam(name = "searchMethod", required = false, defaultValue = "keywordSearch") String searchMethod,
			@RequestParam(name="searchKeyword", required = false ) String searchKeyword,
			@RequestParam(name="searchCondition", required = false, defaultValue = "all") String searchCondition,
			@RequestParam(name="orderSelectBox", required = false, defaultValue = "latest") String orderSelectBox,
			@RequestParam(value = "cp", required = false, defaultValue = "1") Integer currentPage,
			Model model) {
		
		// 서비스에서 Pagination 객체, 조회된 bList 객체 매핑해서 반환
		Map<String, Object> map = bService.selectBoardList(currentPage, searchKeyword, searchCondition, orderSelectBox);
		
		// 태그 전체 리스트 조회
		List<BoardTag> bTagList = bService.selectBoardTagList();
		// 태그 중복X 리스트 조회 - 상위 30개
		List<BoardTag> bTagListDistinct = bService.selectBoardTagListDistinct();
		bTagListDistinct = bTagListDistinct.size() > 30 ? bTagListDistinct.subList(0, 30) : bTagListDistinct;
		// 파일 전체 리스트 조회
		List<BoardFile> bFileList = bService.selectBoardFileList(); 
		
		model.addAttribute("bList", map.get("bList"));
		model.addAttribute("pn", map.get("pn"));
		model.addAttribute("bFileList", bFileList);
		model.addAttribute("bTagList", bTagList);
		model.addAttribute("bTagListDistinct", bTagListDistinct);
		
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("searchCondition", searchCondition);
		model.addAttribute("orderSelectBox", orderSelectBox);
		model.addAttribute("searchMethod", searchMethod);
		
		return "board/boardList_card";
	}

	// 테이블 - 목록 이동
	@GetMapping("/board/listTable")
	public String showBoardListTable() {
		return "board/boardList_table";
	}

	// 카드 - 목록 이동 (post)
	@PostMapping("/board/listCard")
	public String searchBoardListCard(@RequestParam(name = "searchMethod", required = false, defaultValue = "keywordSearch") String searchMethod,
			@RequestParam(name="searchKeyword", required = false) String searchKeyword,
			@RequestParam(name="searchCondition", required = false,  defaultValue = "all") String searchCondition,
			@RequestParam(name="orderSelectBox", required = false, defaultValue = "latest") String orderSelectBox,
			@RequestParam(value = "cp", required = false, defaultValue = "1") Integer currentPage,
			Model model) {
		
		// 서비스에서 Pagination 객체, 조회된 bList 객체 매핑해서 반환
		Map<String, Object> map = bService.selectBoardList(currentPage, searchKeyword, searchCondition, orderSelectBox);
		// 태그 전체 리스트 조회
		List<BoardTag> bTagList = bService.selectBoardTagList();
		// 태그 중복X 리스트 조회
		List<BoardTag> bTagListDistinct = bService.selectBoardTagListDistinct();
		bTagListDistinct = bTagListDistinct.size() > 30 ? bTagListDistinct.subList(0, 30) : bTagListDistinct;
		// 파일 전체 리스트 조회
		List<BoardFile> bFileList = bService.selectBoardFileList(); 
		
		model.addAttribute("bList", map.get("bList"));
		model.addAttribute("pn", map.get("pn"));
		model.addAttribute("bFileList", bFileList);
		model.addAttribute("bTagList", bTagList);
		model.addAttribute("bTagListDistinct", bTagListDistinct);
		
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("searchCondition", searchCondition);
		model.addAttribute("orderSelectBox", orderSelectBox);
		model.addAttribute("searchMethod", searchMethod);
		
		return "board/boardList_card";
	}

	
	// 상세페이지 이동 - viewStatus는 a태그로 이동 시 조회수 증가할 수 있도록 하는 기준
	@GetMapping("/board/detailPage/{boardNo}/{viewStatus}")
	public String showBoardOne(@PathVariable("boardNo") Integer boardNo,
			@PathVariable(name = "viewStatus") String viewStatus,
			Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/user/login";
		}
		
		if("yes".equals(viewStatus)) {
			// 조회수 증가
			int result = bService.increaseViewCount(boardNo);
			return "redirect:/board/detailPage/"+boardNo+"/no";
		}
		
		// board 
		Board board = bService.selectOne(boardNo);
		Board prevBoard = null;
		Board nextBoard = null;
		
		// 최소 boardNo, 최대 boardNo 찾기
		int minBoardNo = bService.getMinBoardNo();
		int maxBoardNo = bService.getMaxBoardNo();
		
		// 이전글 찾기
		int prevBoardNo = boardNo;
		int nextBoardNo = boardNo;
		
		while(prevBoardNo > minBoardNo) {
			prevBoardNo--;
			prevBoard = bService.selectOne(prevBoardNo);
			if(prevBoard != null) break;
		}
		// 다음글 찾기
		while(nextBoardNo < maxBoardNo) {
			nextBoardNo++;
			nextBoard = bService.selectOne(nextBoardNo);
			if(nextBoard != null) break;
		}
		
		// board_file
		List<BoardFile> bFileList = bService.selectBoardFileList();
		
		// board_tag
		List<BoardTag> bTagList = bService.selectBoardTagList();
		
		model.addAttribute("board", board);
		model.addAttribute("prevBoard", prevBoard);
		model.addAttribute("nextBoard", nextBoard);
		
		model.addAttribute("bFileList", bFileList);
		model.addAttribute("bTagList", bTagList);
		return "board/boardDetail";
	}
	
	// 글 작성 페이지 이동
	@GetMapping("/board/writePage")
	public String showWriteBoardForm(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/user/login";
		}
		
		return "board/boardWrite";
	}
	
	// 글작성 - post
	//	@ModelAttribute() 안에 들어가는 이름은 내가 정해주면 됨. 단, 지어준 이름으로 뷰에서 접근가능함!
		@PostMapping("/board/write")
		public String boardWrite(
				@ModelAttribute("Board") Board board,
				@ModelAttribute("BoardTag") BoardTag boardTag,
				@RequestParam(name="uploadFile", required = false) MultipartFile uploadFile,
				Model model, HttpSession session) throws IllegalStateException, IOException {
				
				String userId = null;
				
				if(session.getAttribute("userId") == null) {
					return "redirect:/user/login";
				}else {
					userId = (String)session.getAttribute("userId");
				}
				
				board.setBoardWriter(userId);
				board.setUserId(userId);
				int boardResult = bService.insertBoard(board);
				
				if(uploadFile != null && !"".equals(uploadFile.getOriginalFilename())) { // null체크시 실제 저장된 이름이 있는지도 체크해줘야 함.
					String fileName = uploadFile.getOriginalFilename();
					String fileRename = Util.fileRename(fileName);
					
					// Web용 경로
					String filePath = "/board-images/"; // 이 경로가 fileConfig에 의해 실제 C드라이브 경로로 매핑됨.
					
					uploadFile.transferTo(new File("C:\\uploadFile\\board\\" + fileRename));
					
					BoardFile boardFile = new BoardFile();
					boardFile.setBoardFileName(fileName);
					boardFile.setBoardFileRename(fileRename);
					boardFile.setBoardFilePath(filePath); // 경로에 복사
					
					boardFile.setBoardNo(board.getBoardNo());
					
					int boardFileResult = bService.insertBoardFile(boardFile);	
			}
			
			// boardTagName엔 배열 문자열이 저장이 된다.
			// json형식의 문자열을 파싱해주고 배열에 저장
			
			if(!boardTag.getBoardTagName().equals("")) {
				List<String> tagNameArr = new ArrayList<String>();
				
				String tagNameJson = boardTag.getBoardTagName();
				// jackson 객체
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
			}
			
			return "redirect:/board/listCard";
		}

	// 글 수정 페이지 이동
	@GetMapping("/board/modifyPage/{boardNo}")
	public String showModifyForm(@PathVariable("boardNo") Integer boardNo, Model model) {
		// board 
		Board board = bService.selectOne(boardNo);
		// board_file
		List<BoardFile> bFileList = bService.selectBoardFileList();
		
		// board_tag
		List<BoardTag> bTagList = bService.selectBoardTagList();
			
			
		model.addAttribute("board", board);
		model.addAttribute("bFileList", bFileList);
		model.addAttribute("bTagList", bTagList);
		
		return "board/boardModify";
	}
	
	
	// 글 삭제
	@GetMapping("/board/delete")
	public String boardDelete(@RequestParam("boardNo") Integer boardNo,
			@RequestParam(name="uploadFileRename", required = false) String uploadFileRename,
			Model model) throws IOException {
		
		int result = bService.deleteBoard(boardNo);
		
		// 실제 파일 삭제
		if(uploadFileRename != null) {
			Path uploadFilePath = Paths.get("C:\\uploadFile\\board\\", uploadFileRename);
			Files.deleteIfExists(uploadFilePath);			
		}
		
		return "redirect:/board/listCard";
	}
	
	
	
	// 글 수정
	@PostMapping("/board/modify")
	public String boardModify(@ModelAttribute("Board") Board board,
			@ModelAttribute("BoardTag") BoardTag boardTag,
			@RequestParam(name="reloadFile", required = false) MultipartFile reloadFile,
			@RequestParam(name="uploadFileRename", required = false) String uploadFileRename,
			Model model, HttpSession session) throws IllegalStateException, IOException {
		
		String userId = null;
		if(session.getAttribute("userId") == null) {
			return "redirect:/user/login";
		}else {
			userId = (String)session.getAttribute("userId");
		}
		
		board.setBoardWriter(userId);
		board.setUserId(userId);
		int boardResult = bService.updateBoard(board);
		
		if(reloadFile != null && !"".equals(reloadFile.getOriginalFilename())) { // null체크시 실제 저장된 이름이 있는지도 체크해줘야 함.
			
			String fileName = reloadFile.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			
			// Web용 경로
			String filePath = "/board-images/"; // 이 경로가 fileConfig에 의해 실제 C드라이브 경로로 매핑됨.
			
			reloadFile.transferTo(new File("C:\\uploadFile\\board\\" + fileRename));
			
			BoardFile boardFile = new BoardFile();
			boardFile.setBoardFileName(fileName);
			boardFile.setBoardFileRename(fileRename);
			boardFile.setBoardFilePath(filePath); // 경로에 복사
			
			boardFile.setBoardNo(board.getBoardNo());
			
			int boardFileResult = bService.updateBoardFile(boardFile);	
			
			// 실제 파일 삭제
			Path uploadFilePath = Paths.get("C:\\uploadFile\\board\\", uploadFileRename);
			Files.deleteIfExists(uploadFilePath);
		}
		
		// boardTagName엔 배열 문자열이 저장이 된다.
		// json형식의 문자열을 파싱해주고 배열에 저장
		
		if(!boardTag.getBoardTagName().equals("")) {
			List<String> tagNameArr = new ArrayList<String>();
			
			String tagNameJson = boardTag.getBoardTagName();
			// jackson 객체
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
			
			int dResult = bService.deleteTag(board.getBoardNo());
			// 각 배열의 값을 하나씩 table에 insert 시켜주기
			for(String tagName : tagNameArr) {
				boardTag.setBoardTagName(tagName);
				boardTag.setBoardNo(board.getBoardNo());
				int iResult = bService.insertTag(boardTag);			
			}
		}
		
		return "redirect:/board/detailPage/"+board.getBoardNo()+"/no";
	}
	

	
	// 파일 업로드 메소드 (ajax 통신)
	@ResponseBody
	@PostMapping("/board/uploadImage")
	public ResponseEntity<?> boardUploadImage(@RequestParam("file") MultipartFile file){
		
		if(file != null) {
			String fileName = file.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			
			// Web용 경로
			String filePath = "/board-images/"; // 이 경로가 fileConfig에 의해 실제 C드라이브 경로로 매핑됨.
			
			try {
				//실제 경로 
				file.transferTo(new File("C:\\uploadFile\\board\\" + fileRename));
				
				// board객체 생성 -> db에 저장하기 위함. 사실 에디터 사용시 에디터가 정보 다갖고있음. -> 따라서 db에 저장할 필요 없음! 
//				BoardFile boardFile = new BoardFile();
//				boardFile.setFileName(fileName);
//				boardFile.setFileRename(fileRename);
//				boardFile.setFilePath(filePath); // 경로에 복사
				
//			boardFile에 boardNo 실제 게시글 업로드 시점에서 넣어주기 -> update로 boradNo만 수정해주면 됨.  실패!!!
//				int result = bService.insertBoardFile(boardFile);
				
				// ResponseEntity는 String과 크게 다른점은 없지만 다른 기능들을 사욜할 수 있는 객체형태
				return ResponseEntity.ok(filePath+fileRename); // 경로 전달
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return ResponseEntity.badRequest().body("이미지 업로드 실패");
			}	
		}
		return null;
	}
	
	// 간편 검색 - post
	@PostMapping("/board/searchTag_listCard")
	public String postSearchTagListCard(@RequestParam(name = "searchMethod", required = false, defaultValue = "tagSearch") String searchMethod,
			@RequestParam(name = "orderSelectBox", required = false, defaultValue = "latest") String orderSelectBox, 
			@RequestParam("tagName") String tags,
			@RequestParam(value = "cp", required = false, defaultValue = "1") Integer currentPage,
			
			Model model) {
			
				
				String[] tagList = tags.split(",");
				
				// 서비스에서 Pagination 객체, 조회된 bList 객체 매핑해서 반환
				Map<String, Object> params = new HashMap<>();
				params.put("tags", tagList);
				params.put("tagCount", tagList.length);
				List<Integer> boardNos = bService.selectBoardNoByTags(params); // 해당 태그 boarNo -> 검색된 board 객체
				
				Map<String, Object> map = null;
				if(!boardNos.isEmpty()) {
					// 최종 간편 검색 결과 pn, bList 매핑
					map = bService.selectBoardsByBoardNos(currentPage, boardNos, orderSelectBox);
				}
				
				// 태그 전체 리스트 조회
				List<BoardTag> bTagList = bService.selectBoardTagList();
				// 태그 중복X 리스트 조회
				List<BoardTag> bTagListDistinct = bService.selectBoardTagListDistinct();
				bTagListDistinct = bTagListDistinct.size() > 30 ? bTagListDistinct.subList(0, 30) : bTagListDistinct;
				// 파일 전체 리스트 조회
				List<BoardFile> bFileList = bService.selectBoardFileList(); 
				if(map != null) {
					model.addAttribute("bList", map.get("bList"));
					model.addAttribute("pn", map.get("pn"));					
				}
				model.addAttribute("bFileList", bFileList);
				model.addAttribute("bTagList", bTagList);
				model.addAttribute("bTagListDistinct", bTagListDistinct);
				
				// tagList는 배열이므로 List로 변환 -> html에서 contains 메소드 쓰기위함
				List<String> selectedTags = Arrays.asList(tagList);
				model.addAttribute("selectedTags", selectedTags);
				model.addAttribute("orderSelectBox", orderSelectBox);
				model.addAttribute("searchMethod", searchMethod);
				
				return "board/boardList_card";
	}
	
	
	// 간편 검색 - a태그 페이지 이동 (페이지네이션)
	@GetMapping("/board/searchTag_listCard")
	public String getSearchTagListCard(@RequestParam(name = "searchMethod", required = false, defaultValue = "tagSearch") String searchMethod,
			@RequestParam(name = "orderSelectBox", required = false, defaultValue = "latest") String orderSelectBox, 
			@RequestParam("tagName") String tags,
			@RequestParam(value = "cp", required = false, defaultValue = "1") Integer currentPage,
			Model model) {
				
				String[] tagList = tags.split(",");
				
				// 서비스에서 Pagination 객체, 조회된 bList 객체 매핑해서 반환
				Map<String, Object> params = new HashMap<>();
				params.put("tags", tagList);
				params.put("tagCount", tagList.length);
				List<Integer> boardNos = bService.selectBoardNoByTags(params); // 해당 태그 boarNo -> 검색된 board 객체
				
				Map<String, Object> map = null;
				if(!boardNos.isEmpty()) {
					// 최종 간편 검색 결과 pn, bList 매핑
					map = bService.selectBoardsByBoardNos(currentPage, boardNos, orderSelectBox);
				}

				// 태그 전체 리스트 조회
				List<BoardTag> bTagList = bService.selectBoardTagList();
				// 태그 중복X 리스트 조회
				List<BoardTag> bTagListDistinct = bService.selectBoardTagListDistinct();
				bTagListDistinct = bTagListDistinct.size() > 30 ? bTagListDistinct.subList(0, 30) : bTagListDistinct;
				// 파일 전체 리스트 조회
				List<BoardFile> bFileList = bService.selectBoardFileList(); 
				if(map != null) {
					model.addAttribute("bList", map.get("bList"));
					model.addAttribute("pn", map.get("pn"));					
				}
				model.addAttribute("bFileList", bFileList);
				model.addAttribute("bTagList", bTagList);
				model.addAttribute("bTagListDistinct", bTagListDistinct);
				
				// tagList는 배열이므로 List로 변환 -> html에서 contains 메소드 쓰기위함
				List<String> selectedTags = Arrays.asList(tagList);
				model.addAttribute("selectedTags", selectedTags);
				model.addAttribute("orderSelectBox", orderSelectBox);
				model.addAttribute("searchMethod", searchMethod);
				
				return "board/boardList_card";
	}	
	
	
	
	
	
//		 ajax 통신
	
	// 댓글 등록 메소드
	@ResponseBody
	@PostMapping("/board/replyAdd")
	public String addBoardReply(@ModelAttribute BoardReply boardReply,
			HttpSession session) {
		
		String userId = (String) session.getAttribute("userId");
		
		if("".equals(boardReply.getReplyContent())) {
			return "fail";
		}
		
		// userId, replyWriter,  =-> session으로 가져오기
		boardReply.setUserId(userId);
		boardReply.setReplyWriter(userId);
		
		int result = bService.insertBoardReply(boardReply);
		
		return "success";
	}
	
	
	// 댓글 리스트 조회
	
//	@ResponseBody		-> 단순 json을 전달하는 방식이 아니기 때문에 어노테이션 사용 X
	@PostMapping("/board/replyList")
	public String getReplyList(@RequestParam("boardNo") Integer boardNo, Model model,
			HttpSession session) {
//		List<BoardReply> replyList = bService.selectBoardReplyList(boardNo);
		
		// userId는 타임리프에서 자신의 댓글인지 확인하기 위한 기준이 됨.
		// session으로 전달해야함
		
		String userId = (String) session.getAttribute("userId");
		
		List<BoardReplyUser> boardReplyUserList = bService.selectBoardReplyUser(boardNo);
		
		
		int replyTotalCount = boardReplyUserList.size();
		
		model.addAttribute("boardReplyUserList", boardReplyUserList);
//		model.addAttribute("replyList", replyList);
		model.addAttribute("loginUserId", userId);
		model.addAttribute("replyTotalCount", replyTotalCount);
	
		
		return "board/boardDetail::#replyListContainer";
	}
	

	
	// 댓글 삭제
	@ResponseBody
	@PostMapping("/board/replyDelete")
	public String deleteReply(@RequestParam("replyNo") Integer replyNo) {
		int result = bService.deleteReply(replyNo);
		
		return "success";
	}
	
	
	
	// 댓글 수정
	@ResponseBody
	@PostMapping("/board/replyUpdate")
	public String updateReply(@RequestParam("replyNo") Integer replyNo, @RequestParam("replyContent") String replyContent) {
		
		int result = bService.updateReply(replyNo, replyContent);
		return "success";
	}
	
	
	// 술 검색 리스트
	@PostMapping("/board/searchLiquor")
	public String searchLiquorList(@RequestParam("liquorName") String liquorName, Model model) {
		List<SearchLiquor> searchLiquorResult = bService.searchLiquorList(liquorName);
		
		model.addAttribute("searchLiquorResult", searchLiquorResult);
		return "board/boardWrite::#searchResultList";
	}
	

}








