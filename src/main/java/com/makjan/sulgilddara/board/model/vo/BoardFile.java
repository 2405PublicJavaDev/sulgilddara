package com.makjan.sulgilddara.board.model.vo;

//import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardFile {
	private Integer boardFileNo;
	private String boardFileName;
	private String boardFileRename;
	private String boardFilePath;
	private Integer boardNo;
	
	
}
