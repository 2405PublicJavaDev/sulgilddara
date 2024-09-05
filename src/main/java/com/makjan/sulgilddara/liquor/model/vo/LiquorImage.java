package com.makjan.sulgilddara.liquor.model.vo;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LiquorImage {

	private Integer imageId;
	private String fileName;
	private String fileRename;
	private String filePath;
	private Integer fileSize;
	private Timestamp uploadTime;
	private Integer liquorId;
	
	private MultipartFile uploadFile;
}
