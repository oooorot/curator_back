package com.web.root.mybatis.member;

import java.util.Map;

import com.web.root.member.dto.MemberDTO;

public interface MemberMapper {
	
	// 로그인
	public MemberDTO login(MemberDTO memberDTO);
	
	// 이메일 중복체크
	public String emailCheck(String InsertEmail);
	
	// 회원가입
	public int register(Map<String, Object> map);
}
