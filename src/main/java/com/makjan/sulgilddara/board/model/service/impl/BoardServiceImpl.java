package com.makjan.sulgilddara.board.model.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.board.model.mapper.BoardMapper;
import com.makjan.sulgilddara.board.model.service.BoardService;
import com.makjan.sulgilddara.board.model.vo.Board;
import com.makjan.sulgilddara.board.model.vo.BoardTag;

@Service
public class BoardServiceImpl implements BoardService{
	private BoardMapper bMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper bMapper) {
		this.bMapper = bMapper;
	}

	@Override
	public Board selectOne(Integer boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectList(Integer currentPage, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoard(Board board, MultipartFile uploadFile) {
		int result = bMapper.insertBoard(board);
		return result;
	}

	@Override
	public int updateBoard(Board board, MultipartFile uploadFile) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(Integer boardNo) {
		// TODO Auto-generated method stub
		return 0;
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
	public int deleteTag(List<String> tags) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
