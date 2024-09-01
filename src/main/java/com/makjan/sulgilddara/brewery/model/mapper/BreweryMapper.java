package com.makjan.sulgilddara.brewery.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.makjan.sulgilddara.brewery.model.vo.Brewery;

@Mapper
public interface BreweryMapper {

	/**
	 * 양조장 정보 등록
	 * @param inputBrewery
	 * @return int
	 */
	int insertBrewery(Brewery inputBrewery);
	
	/**
	 * 양조장 리스트 전체 조회
	 * @return List<Brewery>
	 */
	List<Brewery> selectAllList();
	
	/**
	 * 양조장 리스트 한개 조회
	 * @param breweryNo
	 * @return Brewery
	 */
	Brewery searchOneByNo(Integer breweryNo);
	
	/**
	 * 양조장 정보 변경
	 * @param brewery
	 * @return int
	 */
	int updateBrewery(Brewery brewery);
	
	/**
	 * 양조장 정보 삭제
	 * @param breweryNo
	 * @return int
	 */
	int deleteBrewery(Integer breweryNo);
}
