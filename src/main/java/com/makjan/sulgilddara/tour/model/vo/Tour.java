package com.makjan.sulgilddara.tour.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tour {
	private Integer tourId;
	private String tourName;
	private String tourContent;
	private String timeTaken;
	private String tourPrice;
	private String fileName;
	private String fileRename;
	private String fileLength;
	private String filePath;
	private Integer breweryId;
}
