package com.makjan.sulgilddara.brewery.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makjan.sulgilddara.brewery.model.mapper.BreweryMapper;
import com.makjan.sulgilddara.brewery.model.service.impl.BreweryService;
import com.makjan.sulgilddara.brewery.model.vo.Brewery;
import com.makjan.sulgilddara.liquor.model.vo.Liquor;
import com.makjan.sulgilddara.tour.model.vo.Tour;

@Service
public class BreweryServiceImpl implements BreweryService{
	
	private BreweryMapper mapper;
	
	public BreweryServiceImpl() {}
	
	@Autowired
	public BreweryServiceImpl(BreweryMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int insertBrewery(Brewery inputBrewery) {
		int result = mapper.insertBrewery(inputBrewery);
		return result;
	}

	@Override
	public int updateBrewery(Brewery brewery) {
		int result = mapper.updateBrewery(brewery);
		return 0;
	}

	@Override
	public int deleteBrewery(Integer breweryNo) {
		int result = mapper.deleteBrewery(breweryNo);
		return result;
	}

	@Override
	public Brewery searchOneByNo(Integer breweryNo) {
		Brewery brewery = mapper.searchOneByNo(breweryNo);
		return brewery;
	}

	@Override
	public List<Brewery> searchList(Brewery brewery, Integer currentPage, RowBounds rowBoudns) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brewery> selectRandom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour selectTourListById(Integer breweryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Liquor selectLiquirListById(Integer breweryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brewery> selectAllList() {
		List<Brewery> bList = mapper.selectAllList();
		return bList;
	}
	
}
