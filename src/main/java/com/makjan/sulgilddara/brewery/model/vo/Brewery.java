package com.makjan.sulgilddara.brewery.model.vo;

import java.sql.Timestamp;

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
	private String breweryAddr;
	private String breweryPhone;
	private String breweryUrl;
	private Timestamp bCreateDate;
	private Timestamp bUpdateDate;
	private String fileName;
	private String fileRename;
	private String filePath;
	private Integer fileLength;
}
