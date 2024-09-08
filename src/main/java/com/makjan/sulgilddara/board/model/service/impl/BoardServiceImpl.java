package com.makjan.sulgilddara.board.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.board.model.mapper.BoardMapper;
import com.makjan.sulgilddara.board.model.service.BoardService;
import com.makjan.sulgilddara.board.model.vo.Board;
import com.makjan.sulgilddara.board.model.vo.BoardFile;
import com.makjan.sulgilddara.board.model.vo.BoardReply;
import com.makjan.sulgilddara.board.model.vo.BoardTag;
import com.makjan.sulgilddara.model.vo.Pagination;

@Service
public class BoardServiceImpl implements BoardService{
	private BoardMapper bMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper bMapper) {
		this.bMapper = bMapper;
	}

	@Override
	public Board selectOne(Integer boardNo) {
		Board board = bMapper.selectBoardOne(boardNo);
		return board;
	}
	
	// selectBoardList 오버로딩 - 키워드검색
	@Override
	public Map<String, Object> selectBoardList(Integer currentPage, String searchKeyword, String searchCondition, String orderSelectBox) {
		
		System.out.println("seacrhCondition : "+searchCondition);
		System.out.println("searchKeyword : "+searchKeyword);
		
		int totalCount = bMapper.getTotalCount(searchCondition, searchKeyword);
		Pagination pn = new Pagination(totalCount, currentPage);
		int limit = pn.getBoardLimit();
		int offset = (currentPage-1) * limit ;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> bList = bMapper.selectBoardList(searchCondition, searchKeyword, orderSelectBox ,rowBounds);
		Map<String, Object> map = new HashMap<>();
		map.put("bList", bList);
		map.put("pn", pn);
		return map;
	}
	
	// selectBoardList 오버로딩 - 간편(태그)검색
//	@Override
//	public Map<String, Object> selectBoardList(Integer currentPage, String[] tagList) {
//		
//		int totalCount = bMapper.getTotalCountTag(tagList);
//		Pagination pn = new Pagination(totalCount, currentPage);
//		int limit = pn.getBoardLimit();
//		int offset = (currentPage-1) * limit ;
//		RowBounds rowBounds = new RowBounds(offset, limit);
//		List<Board> bList = bMapper.selectBoardListTag(tagList, rowBounds);
//		Map<String, Object> map = new HashMap<>();
//		map.put("bList", bList);
//		System.out.println(bList);
//		map.put("pn", pn);
//		return map;
//	}

	@Override
	public int insertBoard(Board board) {
		int result = bMapper.insertBoard(board);
		return result;
	}

	@Override
	public int updateBoard(Board board) {
		int result = bMapper.updateBoard(board);
		return result;
	}

	@Override
	public int deleteBoard(Integer boardNo) {
		int result = bMapper.deleteBoard(boardNo);
		return result;
	}

	@Override
	public int insertTag(BoardTag boardTag) {
		int result = bMapper.insertTag(boardTag);
		return result;
	}

	@Override
	public int updateTag(List<String> tags) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTag(Integer boardNo) {
		int result = bMapper.deleteTag(boardNo);
		return result;
	}


	@Override
	public int insertBoardFile(BoardFile boardFile) {
		int result = bMapper.insertBoardFile(boardFile);
		return result;
	}

	
	@Override
	public List<BoardTag> selectBoardTagList() {
		List<BoardTag> bTagList = bMapper.selectBoardTagList();
		return bTagList;
	}

	@Override
	public List<BoardFile> selectBoardFileList() {
		List<BoardFile> bFileList = bMapper.selectBoardFileList();
		return bFileList;
	}

	
	// 게시글 NO 조회 - 태그 선택 ( 간편 검색 )
	@Override
	public List<Integer> selectBoardNoByTags(Map<String, Object> params) {
		List<Integer> boardNos = bMapper.selectBoardByTags(params);
		return boardNos;
	}

	// 태그선택 - No조회 후 No로 board검색 ( 간편 검색)
	@Override
	public Map<String, Object> selectBoardsByBoardNos(Integer currentPage, List<Integer> boardNos, String orderSelectBox) {
		int totalCount = boardNos.size();
		Pagination pn = new Pagination(totalCount, currentPage);
		int limit = pn.getBoardLimit();
		int offset = (currentPage-1) * limit ;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Board> bList = bMapper.selectBoardsByBoardNos(boardNos, rowBounds, orderSelectBox);
		Map<String, Object> map = new HashMap<>();
		map.put("bList", bList);
		map.put("pn", pn);
		return map;
		
	}

	// 태그 중복 X 전체 조회
	@Override
	public List<BoardTag> selectBoardTagListDistinct() {
		List<BoardTag> bTagList = bMapper.selectBoardTagListDistinct();
		return bTagList;
	}

	@Override
	public int updateBoardFile(BoardFile boardFile) {
		int result = bMapper.updateBoardFile(boardFile);
		return result;
	}

	
	@Override
	public int insertBoardReply(BoardReply boardReply) {
		int result = bMapper.insertBoardReply(boardReply);
		return result;
	}

	@Override
	public List<BoardReply> selectBoardReplyList(Integer boardNo) {
		List<BoardReply> replyList = bMapper.selectBoardReplyList(boardNo);
		return replyList;
	}

	@Override
	public int deleteReply(Integer replyNo) {
		int result = bMapper.deleteReply(replyNo);
		return result;
	}

	@Override
	public int updateReply(Integer replyNo, String replyContent) {
		int result = bMapper.updateReply(replyNo, replyContent);
		return result;
	}

	
	
	
	
}
