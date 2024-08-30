package com.makjan.sulgilddara.liquir.model.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Liquir {
	
	private Integer liquirId;
	private String liquirName;
	private float alcholContent;
	private String liquirType ;
	private Integer piquirPrice ;
	private Timestamp lCreateDate;
	private Timestamp lUpdateDate;
	private Integer bruaryId;
}
