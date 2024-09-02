package com.makjan.sulgilddara.liquor.model.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Liquor {
	
	private Integer liquorId;
	private String liquorName;
	private float alcholContent;
	private String liquorType ;
	private Integer piquorPrice ;
	private Timestamp lCreateDate;
	private Timestamp lUpdateDate;
	private Integer bruaryId;
}
