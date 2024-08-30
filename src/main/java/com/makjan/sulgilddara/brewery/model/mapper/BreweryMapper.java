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
}
