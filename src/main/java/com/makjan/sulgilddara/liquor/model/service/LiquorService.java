package com.makjan.sulgilddara.liquor.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.makjan.sulgilddara.brewery.model.vo.Brewery;
import com.makjan.sulgilddara.liquor.model.vo.Liquor;
import com.makjan.sulgilddara.liquor.model.vo.LiquorDetail;
import com.makjan.sulgilddara.liquor.model.vo.LiquorImage;
import com.makjan.sulgilddara.liquor.model.vo.LiquorSearchInfo;

public interface LiquorService {

	/**
	 * 주류정보 추가 Service
	 * @param liquor
	 * @return int
	 */
	int addLiquor(Liquor liquor);
	
	/**
	 * 주류정보 변경 Service
	 * @param liquor
	 * @return int
	 */
	int updateLiquor(Liquor liquor);
	
	/**
	 * 주류정보 삭제 Service
	 * @param liquorId
	 * @return int
	 */
	int deleteLiquor(int liquorId);
	
	/**
	 * 주류 상세정보 Service
	 * @param liquorId
	 * @return int
	 */
	LiquorDetail selectOneById(int liquorId);

	/**
	 * 전체 주류 수 Service
	 * @return int
	 */
	int getTotalCount();
	
	/**
	 * 검색 주류 수 Service
	 * @param sInfo
	 * @return int
	 */
	int searchTotalCount(LiquorSearchInfo sInfo);

	/**
	 * 주류 목록조회 Service
	 * @param currentPage
	 * @param rowBounds
	 * @return int
	 */
	List<Liquor> selectLiquorList(Integer currentPage, RowBounds rowBounds);
	
	/**
	 * 주류 이미지 등록 Service
	 * @param image
	 * @return int
	 */
	int insertLiquorImage(LiquorImage image);
	
}
