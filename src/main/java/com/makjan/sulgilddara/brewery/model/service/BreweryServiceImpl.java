package com.makjan.sulgilddara.brewery.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.makjan.sulgilddara.brewery.model.service.impl.BreweryService;
import com.makjan.sulgilddara.brewery.model.vo.Brewery;
import com.makjan.sulgilddara.liquir.model.vo.Liquir;
import com.makjan.sulgilddara.tour.model.vo.Tour;


public class BreweryServiceImpl implements BreweryService{

	@Override
	public int insertBrewery(Brewery inputBrewery) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBrewery(Brewery Brewery) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBrewery(Integer breweryId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Brewery searchOneById(Integer breweryId) {
		// TODO Auto-generated method stub
		return null;
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
	public Liquir selectLiquirListById(Integer breweryId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
