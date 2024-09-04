package com.makjan.sulgilddara.board.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer{
	private String webPath = "/board-images/**";
	private String realPath = "file:C:/uploadFile/board/";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(webPath)
				.addResourceLocations(realPath);
	}
}
