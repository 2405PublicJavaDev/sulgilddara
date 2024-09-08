package com.makjan.sulgilddara.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.board.model.vo.Board;
import com.makjan.sulgilddara.board.model.vo.BoardFile;
import com.makjan.sulgilddara.board.model.vo.BoardReply;
import com.makjan.sulgilddara.board.model.vo.BoardTag;

public interface BoardService {
	/**
	 * 게시글 상세조회
	 * @param boardNo
	 * @return
	 */
	Board selectOne(Integer boardNo);
	
	/**
	 * 게시글 조회 - 키워드검색
	 * @param currentPage
	 * @param rowBounds
	 * @return
	 */
	Map<String, Object> selectBoardList(Integer currentPage, String searchKeyword, String searchCondition, String orderSelectBox);
	
	/**
	 * 게시글태그 해당 boarNo 조회
	 * @param params
	 * @return
	 */
	List<Integer> selectBoardNoByTags(Map<String, Object> params);
	
	/**
	 * 태그조회로 추출한 boardNos로 조회한 board레코드
	 */
	Map<String, Object> selectBoardsByBoardNos(Integer currentPage, List<Integer> boardNos, String orderSelectBox);
	
//	/**
//	 * 게시글 조회 - 간편(태그)검색
//	 * @param currentPage
//	 * @param rowBounds
//	 * @return
//	 */
//	Map<String, Object> selectBoardList(Integer currentPage, String[] tagList);
	
	/**
	 * 게시글 등록
	 * @param board
	 * @param uploadFile
	 * @return
	 */
	int insertBoard(Board board);
	
	/**
	 * 게시글 수정
	 * @param board
	 * @param uploadFile
	 * @return
	 */
	int updateBoard(Board board);
	
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
	int deleteTag(Integer boardNo);
	
	

	/**
	 * 게시글 파일 업로드
	 * @param boardFile
	 * @return
	 */
	int insertBoardFile(BoardFile boardFile);

	/**
	 * 게시글 태그 전체 조회
	 * @return
	 */
	List<BoardTag> selectBoardTagList();
	
	/**
	 * 게시글 태그 (중복X) 전체 조회
	 * @return
	 */
	List<BoardTag> selectBoardTagListDistinct();

	/**
	 * 파일 전체 조회
	 * @return
	 */
	List<BoardFile> selectBoardFileList();

	/**
	 * 파일 정보 수정
	 * @param boardFile
	 * @return
	 */
	int updateBoardFile(BoardFile boardFile);

	/**
	 * 게시글 댓글 작성
	 * @param boardNo
	 * @param replyAddContent
	 * @return
	 */
	int insertBoardReply(BoardReply boardReply);

	/**
	 * 게시글 댓글 전체 조회
	 * @param boardNo
	 * @return
	 */
	List<BoardReply> selectBoardReplyList(Integer boardNo);
	
	/**
	 * 게시글 댓글 삭제
	 * @param replyNo
	 * @return
	 */
	int deleteReply(Integer replyNo);

	/**
	 * 게시글 댓글 수정
	 * @param replyNo
	 * @return
	 */
	int updateReply(Integer replyNo, String replyContent);

	
}
