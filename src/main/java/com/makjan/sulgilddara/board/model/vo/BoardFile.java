package com.makjan.sulgilddara.board.model.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardFile {
	private Integer fileNo;
	private String fileName;
	private String fileRename;
	private String filePath;
	private Integer boardNo;
	
	private MultipartFile uploadFile;
	
}
