package com.makjan.sulgilddara.brewery.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BreweryFileConfig implements WebMvcConfigurer {
	private String webPath = "/brewery-images/**";
//	private String realPath = "file:C:/uploadFile/brewery/";
	private String realPath = "file:/Users/eom-eunji/Downloads/uploadFile/brewery/";
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(webPath)
			.addResourceLocations(realPath);
	}
}
