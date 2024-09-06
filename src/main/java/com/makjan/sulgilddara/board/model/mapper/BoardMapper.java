package com.makjan.sulgilddara.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

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
	
	/**
	 * 게시글 조회 - 키워드검색
	 * @return
	 */
	List<Board> selectBoardList(
			@Param("searchCondition") String searchCondition, 
			@Param("searchKeyword")String searchKeyword, RowBounds rowBounds);
	
	/**
	 * 게시글 조회 - 태그 검색
	 * @return
	 */
	List<Board> selectBoardListTag(
			@Param("tagList") String[] tagList, RowBounds rowBounds);
	

	/**
	 * 게시글 개수 조회 - 키워드 검색
	 * @return
	 */
	int getTotalCount(@Param("searchCondition") String searchCondition, @Param("searchKeyword") String searchKeyword);

	/**
	 * 게시글 개수 조회 - 간편(태그) 검색
	 * @return
	 */
	int getTotalCountTag(@Param("tagList") String[] tagList);
	
	/**
	 * 게시글 태그 전체 조회
	 * @return
	 */
	List<BoardTag> selectBoardTagList();

	/**
	 * 게시글 파일 전체 조회
	 * @return
	 */
	List<BoardFile> selectBoardFileList();

	

}
