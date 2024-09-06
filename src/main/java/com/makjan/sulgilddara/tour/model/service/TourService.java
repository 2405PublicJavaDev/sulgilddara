package com.makjan.sulgilddara.tour.model.service;

import java.io.IOException;
import java.util.List;

import com.makjan.sulgilddara.tour.model.vo.Tour;

public interface TourService {
	/**
	 * 체험 정보 입력
	 * @param inputTour
	 * @return int
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int insertTour(Tour inputTour) throws IllegalStateException, IOException;
	
	/**
	 * 체험 정보 변경
	 * @param Tour
	 * @return int
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	int updateTour(Tour tour) throws IllegalStateException, IOException;
	
	/**
	 * 체험 정보 삭제
	 * @param tourNo
	 * @return int
	 */
	int deleteTour(Integer tourNo);
	
	/**
	 * 각 양조장 별 체험 정보 출력
	 * @return List<Tour>
	 */
	List<Tour> showTourByBrwNo(Integer breweryNo);
	
	/**
	 * 체험 번호 별 체험 정보 출력
	 * @return
	 */
	Tour searchOneByNo(Integer tourNo);
}
