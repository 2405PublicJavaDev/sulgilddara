package com.makjan.sulgilddara.brewery.model.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.makjan.sulgilddara.brewery.model.vo.Brewery;
import com.makjan.sulgilddara.brewery.model.vo.Pagination;
import com.makjan.sulgilddara.liquir.model.vo.Liquir;
import com.makjan.sulgilddara.tour.model.vo.Tour;

public interface BreweryService {
	/**
	 * 양조장 정보 입력
	 * @param inputBrewery
	 * @return int
	 */
	int insertBrewery(Brewery inputBrewery);
	
	/**
	 * 양조장 정보 수정
	 * @param Brewery
	 * @return int
	 */
	int updateBrewery(Brewery Brewery);
	
	/**
	 * 양조장 정보 삭제
	 * @param breweryId
	 * @return int
	 */
	int deleteBrewery(Integer breweryId);
	
	/**
	 * 양조장 한개 조회
	 * @param breweryId
	 * @return Brewery
	 */
	Brewery searchOneById(Integer breweryId);
	
	/**
	 * 양조장 리스트 조회
	 * @param brewery
	 * @return  List<Brewery>
	 */
	List<Brewery> searchList(Brewery brewery, Integer currentPage, RowBounds rowBoudns);
	
	/**
	 * 양조장 랜덤 조회
	 * @return List<Brewery>
	 */
	List<Brewery> selectRandom();
	
	/**
	 * 양조장 별 주류리스트 조회
	 * @param breweryId
	 * @return Liquir
	 */
	Liquir selectLiquirListById(Integer breweryId);
	
	/**
	 * 양조장 별 투어리스트 조회
	 * @param breweryId
	 * @return Tour
	 */
	Tour selectTourListById(Integer breweryId);
}
