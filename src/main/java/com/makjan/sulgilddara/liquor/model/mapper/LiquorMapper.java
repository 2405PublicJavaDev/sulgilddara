package com.makjan.sulgilddara.liquor.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.makjan.sulgilddara.liquor.model.vo.Liquor;
import com.makjan.sulgilddara.liquor.model.vo.LiquorDetail;
import com.makjan.sulgilddara.liquor.model.vo.LiquorImage;
import com.makjan.sulgilddara.liquor.model.vo.LiquorSearchInfo;

@Mapper
public interface LiquorMapper {

	/**
	 * 주류정보 추가 Mapper
	 * @param liquor
	 * @return int
	 */
	int addLiquor(Liquor liquor);
	
	/**
	 * 주류정보 변경 Mapper
	 * @param liquor
	 * @return int
	 */
	int updateLiquor(Liquor liquor);
	
	/**
	 * 주류정보 삭제 Mapper
	 * @param liquorId
	 * @return int
	 */
	int deleteLiquor(int liquorId);
	
	/**
	 * 주류 상세정보 Mapper
	 * @param liquorId
	 * @return int
	 */
	LiquorDetail selectOneById(int liquorId);

	/**
	 * 전체 주류 수 Mapper
	 * @return int
	 */
	int getTotalCount();
	
	/**
	 * 검색 주류 수 Mapper
	 * @param sinfo
	 * @return int
	 */
	int searchTotalCount(LiquorSearchInfo sinfo);

	/**
	 * 주류 목록조회 Mapper
	 * @param currentPage
	 * @param rowBounds
	 * @return int
	 */
	List<Liquor> selectLiquorList(Integer currentPage, RowBounds rowBounds);

	/**
	 * 주류 이미지등록 Mapper
	 * @param image
	 * @return int
	 */
	int insertLiquorImage(LiquorImage image);
	
	/**
	 * 주류 검색 Mapper
	 * @param sInfo
	 * @param tags
	 * @return List<Liquor>
	 */
	List<Liquor> liquorSearch(Map<String, Object> searchMap);
}
