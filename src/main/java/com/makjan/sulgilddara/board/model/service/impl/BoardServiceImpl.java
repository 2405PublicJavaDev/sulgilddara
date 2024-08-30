package com.makjan.sulgilddara.board.model.service.impl;

import org.springframework.stereotype.Service;

import com.makjan.sulgilddara.board.model.mapper.BoardMapper;
import com.makjan.sulgilddara.board.model.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
	private BoardMapper bMapper;
	
	public BoardServiceImpl(BoardMapper bMapper) {
		this.bMapper = bMapper;
	}
	
	
	
}
