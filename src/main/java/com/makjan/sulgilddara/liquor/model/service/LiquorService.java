package com.makjan.sulgilddara.liquor.model.service;

import org.springframework.stereotype.Service;

import com.makjan.sulgilddara.liquor.model.vo.Liquor;

@Service
public interface LiquorService {

	/**
	 * 주류정보 추가 Service
	 * @param liquor
	 * @return int
	 */
	int addLiquir(Liquor liquor);
	
	/**
	 * 주류정보 변경 Service
	 * @param liquor
	 * @return int
	 */
	int updateLiquor(Liquor liquor);
	
	/**
	 * 주류정보 삭제 Service
	 * @param liquorId
	 * @return
	 */
	int deleteLiquor(int liquorId);
	
	/**
	 * 주류 상세정보 Service
	 * @param liquorId
	 * @return
	 */
	Liquor selectOneById(int liquorId);
	
}
