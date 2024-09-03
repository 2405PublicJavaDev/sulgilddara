package com.makjan.sulgilddara.board.common.utility;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Util {
	public static String fileRename(String origianlFileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new Date(System.currentTimeMillis()));
		String ext = origianlFileName.substring(origianlFileName.lastIndexOf("."));
		String fileRename = date + ext;
		return fileRename;
	}
}
