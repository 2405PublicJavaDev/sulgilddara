package com.makjan.sulgilddara.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.makjan.sulgilddara.board.model.vo.Board;
import com.makjan.sulgilddara.board.model.vo.BoardFile;
import com.makjan.sulgilddara.board.model.vo.BoardTag;

@Mapper
public interface BoardMapper {
	/**
	 * 게시글 등록
	 * @param board
	 * @return
	 */
	int insertBoard(Board board);

	/**
	 * 게시글 태그 등록
	 * @param tags
	 * @return
	 */
	int insertTag(BoardTag boardTag);
	
	/**
	 * 게시글 파일 등록
	 * @param boardFile
	 * @return
	 */
	int insertBoardFile(BoardFile boardFile);

}
