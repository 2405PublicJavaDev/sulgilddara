package com.makjan.sulgilddara.liquor.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.makjan.sulgilddara.liquor.model.vo.Liquor;

@Mapper
public interface LiquorMapper {

	/**
	 * 주류정보 추가 Mapper
	 * @param liquor
	 * @return int
	 */
	int addLiquir(Liquor liquor);
	
	/**
	 * 주류정보 변경 Mapper
	 * @param liquor
	 * @return int
	 */
	int updateLiquor(Liquor liquor);
	
	/**
	 * 주류정보 삭제 Mapper
	 * @param liquorId
	 * @return
	 */
	int deleteLiquor(int liquorId);
	
	/**
	 * 주류 상세정보 Mapper
	 * @param liquorId
	 * @return
	 */
	Liquor selectOneById(int liquorId);
}
