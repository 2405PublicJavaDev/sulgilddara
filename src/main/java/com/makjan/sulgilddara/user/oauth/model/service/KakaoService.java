package com.makjan.sulgilddara.user.oauth.model.service;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.makjan.sulgilddara.user.model.vo.User;

@Service
public interface KakaoService {
	
	public String getToken(String code) throws Exception ;
	public void handleUserInfo(String access_token) throws Exception;
	public void logout(String accessToken) throws Exception;
}