package com.makjan.sulgilddara.user.oauth.model.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.makjan.sulgilddara.user.model.mapper.UserMapper;
import com.makjan.sulgilddara.user.model.vo.User;
import com.makjan.sulgilddara.user.oauth.model.rep.KakaoRepository;
import com.makjan.sulgilddara.user.oauth.model.service.KakaoService;
import com.makjan.sulgilddara.user.oauth.model.vo.Kakaouser;

@Service
public class KakaoServiceImpl implements KakaoService {

    @Autowired
    // KakaoRepository kakaoRepository;
    private UserMapper mapper;

    @Override
    public String getToken(String code) throws Exception {
        String access_Token = "";

        final String requestUrl = "https://kauth.kakao.com/oauth/token";

        URL url = new URL(requestUrl);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
        StringBuilder sb = new StringBuilder();
        sb.append("grant_type=authorization_code");
        sb.append("&client_id=de590a7e08c82cba6bdf69f09ca0ab27");
        sb.append("&redirect_uri=http://localhost:8888/study/kakao");
        sb.append("&code=" + code);
        bw.write(sb.toString());
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        String result = "";

        while ((line = br.readLine()) != null) {
            result += line;
        }

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(result);

        access_Token = element.getAsJsonObject().has("access_token") ? element.getAsJsonObject().get("access_token").getAsString() : null;

        br.close();
        bw.close();

        return access_Token;
    }
    
    @Override
    public void handleUserInfo(String access_token) throws Exception {
        final String requestUrl = "https://kapi.kakao.com/v2/user/me";

        URL url = new URL(requestUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Bearer " + access_token);

        BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = "";
        String result = "";

        while ((line = bf.readLine()) != null) {
            result += line;
        }

        bf.close();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(result);

        JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

        String name = kakao_account.getAsJsonObject().get("name").getAsString();
        String account_email = kakao_account.getAsJsonObject().get("email").getAsString();
        //String gender = kakao_account.getAsJsonObject().get("gender").getAsString();
        String phone_number = kakao_account.getAsJsonObject().get("phone_number").getAsString();

        // User 객체 생성
        User user = new User();
        user.setUserId(String.valueOf(element.getAsJsonObject().get("id").getAsLong())); // userId 설정
        user.setUserPw("kakaouser!1234"); // 비밀번호는 기본값 설정, 필요시 추가 처리
        user.setUserName(name);
        user.setEmail(account_email);
        //user.setGender(gender);
        user.setPhone(phone_number);
        user.setAddress("제주특별자치도 제주시 첨단로 242"); // 필요시 주소를 추가하세요
        
     // 값을 로그로 출력하여 확인
        System.out.println("UserId: " + user.getUserId());
        System.out.println("UserPw: " + user.getUserPw());
        System.out.println("UserName: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Gender: " + user.getGender());
        System.out.println("Phone: " + user.getPhone());
        System.out.println("Address: " + user.getAddress());

        
        // USER_TBL에 저장
        mapper.registerUser(user);
        
    }

    public void logout(String accessToken) throws Exception {
        String url = "https://kapi.kakao.com/v1/user/logout";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new Exception("Failed to log out from Kakao");
        }
    }

	
    
//    @Override
//    public ArrayList<Object> getUserInfo(String access_token) throws Exception {
//        ArrayList<Object> list = new ArrayList<>();
//
//        final String requestUrl = "https://kapi.kakao.com/v2/user/me";
//
//        URL url = new URL(requestUrl);
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("Authorization", "Bearer " + access_token);
//
//        BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String line;
//        String result = "";
//
//        while ((line = bf.readLine()) != null) {
//            result += line;
//        }
//
//        System.out.println("카카오 유저 정보 응답: " + result);
//
//        JsonParser parser = new JsonParser();
//        JsonElement element = parser.parse(result);
//
//        JsonObject jsonObject = element.getAsJsonObject();
//        JsonObject properties = jsonObject.has("properties") ? jsonObject.get("properties").getAsJsonObject() : new JsonObject();
//        JsonObject kakao_account = jsonObject.has("kakao_account") ? jsonObject.get("kakao_account").getAsJsonObject() : new JsonObject();
//
//        System.out.println("----------properties" + properties);
//        System.out.println("----------kakao_account" + kakao_account);
//
//        String profile_image = properties.has("profile_image") ? properties.get("profile_image").getAsString() : "";
//        String name = kakao_account.has("name") ? kakao_account.get("name").getAsString() : "";
//        String account_email = kakao_account.has("email") ? kakao_account.get("email").getAsString() : "";
//        String gender = kakao_account.has("gender") ? kakao_account.get("gender").getAsString() : "";
//        String phone_number = kakao_account.has("phone_number") ? kakao_account.get("phone_number").getAsString() : "";
//
////        list.add(profile_image);
////        list.add(name);
////        list.add(account_email);
////        list.add(gender);
////        list.add(phone_number);
////
////        Kakaouser kakaouser = new Kakaouser(name, "1234", name, account_email, gender, phone_number);
////        kakaoRepository.save(kakaouser);
//
//        return list;
//    }
}
