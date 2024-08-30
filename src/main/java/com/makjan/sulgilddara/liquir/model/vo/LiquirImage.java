package com.makjan.sulgilddara.liquir.model.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiquirImage {

	private Integer imageId;
	private String fileName;
	private String fileRename;
	private String filePath;
	private Integer fileSize;
	private Timestamp uploadTime;
	private Integer liquirId;
}
