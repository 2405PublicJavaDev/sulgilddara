package com.makjan.sulgilddara.brewery.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.makjan.sulgilddara.brewery.model.mapper.BreweryMapper;
import com.makjan.sulgilddara.brewery.model.service.impl.BreweryService;
import com.makjan.sulgilddara.brewery.model.vo.Brewery;
import com.makjan.sulgilddara.common.utility.Util;
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
	public int insertBrewery(Brewery inputBrewery) throws IllegalStateException, IOException {
		MultipartFile uploadFile = inputBrewery.getUploadFile();
		if(uploadFile != null) {
			String fileName = uploadFile.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			String filePath = "/brewery-images";
			uploadFile.transferTo(new File("C:/uploadFile/brewery/"+fileRename));
			inputBrewery.setFileName(fileName);
			inputBrewery.setFileRename(fileRename);
			inputBrewery.setFilePath(filePath);
		}
		int result = mapper.insertBrewery(inputBrewery);
		return result;
	}

	@Override
	public int updateBrewery(Brewery brewery) throws IllegalStateException, IOException {
		MultipartFile newFile = brewery.getUploadFile();
		
		if(newFile != null && !newFile.isEmpty()) {
			String fileName = newFile.getOriginalFilename();
			String fileRename = Util.fileRename(fileName);
			String filePath = "/brewery-images";
			
			newFile.transferTo(new File("C:/uploadFile/brewery/"+fileRename));
			
			brewery.setFileName(fileName);
			brewery.setFileRename(fileRename); 
			brewery.setFilePath(filePath);
		}
		int result = mapper.updateBrewery(brewery);
		return result;
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

	@Override
	public List<Brewery> searchBreweryByKeyword(Map<String, String> paramMap) {
		List<Brewery> searchList = mapper.selectSearchList(paramMap);
		if(searchList.size() == 0) {
			searchList = null;
		}
		return searchList;
	}
	
}
