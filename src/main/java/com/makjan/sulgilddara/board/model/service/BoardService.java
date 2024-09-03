package com.makjan.sulgilddara.board.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.board.model.vo.Board;
import com.makjan.sulgilddara.board.model.vo.BoardFile;
import com.makjan.sulgilddara.board.model.vo.BoardTag;

public interface BoardService {
	/**
	 * 게시글 상세조회
	 * @param boardNo
	 * @return
	 */
	Board selectOne(Integer boardNo);
	
	/**
	 * 게시글 전체조회
	 * @param currentPage
	 * @param rowBounds
	 * @return
	 */
	List<Board> selectList(Integer currentPage, RowBounds rowBounds);
	
	/**
	 * 게시글 등록
	 * @param board
	 * @param uploadFile
	 * @return
	 */
	int insertBoard(Board board, MultipartFile uploadFile);
	
	/**
	 * 게시글 수정
	 * @param board
	 * @param uploadFile
	 * @return
	 */
	int updateBoard(Board board, MultipartFile uploadFile);
	
	/**
	 * 게시글 삭제
	 * @param boardNo
	 * @return
	 */
	int deleteBoard(Integer boardNo);
	
	/**
	 * 게시글 태그 등록
	 * @param tags
	 * @return
	 */
	int insertTag(BoardTag boardTag);
	
	/**
	 * 게시글 태그 수정
	 * @param tags
	 * @return
	 */
	int updateTag(List<String> tags);
	
	/**
	 * 게시글 태그 삭제
	 * @param tags
	 * @return
	 */
	int deleteTag(List<String> tags);
	
	/**
	 * 게시글 전체 개수 조회
	 * @return
	 */
	int getTotalCount();

	/**
	 * 게시글 파일 업로드
	 * @param boardFile
	 * @return
	 */
	int insertBoardFile(BoardFile boardFile);
}
