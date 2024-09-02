package com.makjan.sulgilddara.liquor.model.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makjan.sulgilddara.liquor.model.mapper.LiquorMapper;
import com.makjan.sulgilddara.liquor.model.service.LiquorService;
import com.makjan.sulgilddara.liquor.model.vo.Liquor;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLiquor(int liquorId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Liquor selectOneById(int liquorId) {
		// TODO Auto-generated method stub
		return null;
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

}
