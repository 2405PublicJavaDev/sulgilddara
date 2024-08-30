package com.makjan.sulgilddara.brewery.model.vo;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Brewery {
	private Integer breweryId;
	private String breweryName;
	private String breweryLocal;
	private String breweryAddr;
	private String breweryTime;
	private String breweryPhone;
	private String breweryUrl;
	private Timestamp bCreateDate;
	private Timestamp bUpdateDate;
	
//	private String fileNo;
//	private String fileName;
//	private String fileRename;
//	private String filePath;
//	private Integer fileLength;
//	
//	private MultipartFile uploadFile;
}
