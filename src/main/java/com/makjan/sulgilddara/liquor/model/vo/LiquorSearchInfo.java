package com.makjan.sulgilddara.liquor.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LiquorSearchInfo {
	private String keyword;
	private String keywordType;
	private String region;
	private String liquorType;
	private List<String> tags;
}
