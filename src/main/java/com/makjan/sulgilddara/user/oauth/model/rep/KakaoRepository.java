package com.makjan.sulgilddara.user.oauth.model.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makjan.sulgilddara.user.oauth.model.vo.Kakaouser;

@Repository
public interface KakaoRepository extends JpaRepository<Kakaouser, String>{

}
