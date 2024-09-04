package com.makjan.sulgilddara.liquor.model.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makjan.sulgilddara.liquor.model.mapper.LiquorMapper;
import com.makjan.sulgilddara.liquor.model.service.LiquorService;
import com.makjan.sulgilddara.liquor.model.vo.Liquor;
import com.makjan.sulgilddara.liquor.model.vo.LiquorDetail;
import com.makjan.sulgilddara.liquor.model.vo.LiquorImage;
import com.makjan.sulgilddara.liquor.model.vo.LiquorSearchInfo;

@Service
public class LiquorServiceImpl implements LiquorService{
	
	private LiquorMapper mapper;
	
	public LiquorServiceImpl() {}

	@Autowired
	public LiquorServiceImpl(LiquorMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int addLiquor(Liquor liquor) {
		int result = mapper.addLiquor(liquor);
		return result;
	}

	@Override
	public int updateLiquor(Liquor liquor) {
		int result = mapper.updateLiquor(liquor);
		return result;
	}

	@Override
	public int deleteLiquor(int liquorId) {
		int result = mapper.deleteLiquor(liquorId);
		return result;
	}

	@Override
	public LiquorDetail selectOneById(int liquorId) {
		LiquorDetail liquor = mapper.selectOneById(liquorId);
		return liquor;
	}

	@Override
	public int getTotalCount() {
		int totalCount = mapper.getTotalCount();
		return totalCount;
	}

	@Override
	public int searchTotalCount(LiquorSearchInfo sInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Liquor> selectLiquorList(Integer currentPage, RowBounds rowBounds) {
		List<Liquor> lList = mapper.selectLiquorList(currentPage, rowBounds);
		return lList;
	}

	@Override
	public int insertLiquorImage(LiquorImage image) {
		int result = mapper.insertLiquorImage(image);
		return result;
	}

}
