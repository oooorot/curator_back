package com.web.root.member.service;

import java.util.Map;

public interface MemberService {
	
	// 로그인
	public String getAccessToken(Map<String, String> map);
	
	//refreshToken
	public String getRefreshToken(Map<String, String> map);
	
	// 인증코드 확인
	public int registerCodeResult(Map<String, Object> map);
	
	// 이메일 중복 확인
	public int emailCheck(String insertEmail) throws Exception;

	// 회원가입
	public int register(Map<String, Object> map);

	// 로그인 체크
	public String loginCheck(Map<String, String> map);

}
