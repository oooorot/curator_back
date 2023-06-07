package com.web.root.member.service;

import java.util.Map;

import com.web.root.member.dto.LoginDTO;

public interface MemberService {
	
	// 로그인
	public LoginDTO login(Map<String, Object> map);
	
	// 인증코드 확인
	public int registerCodeResult(Map<String, Object> map);
	
	// 이메일 중복 확인
	public int emailCheck(String InsertEmail) throws Exception;
	
	// 회원가입
	public int register(Map<String, Object> map);


}
