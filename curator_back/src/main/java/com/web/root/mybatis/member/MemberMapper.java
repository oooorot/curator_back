package com.web.root.mybatis.member;

import com.web.root.member.dto.MemberDTO;

public interface MemberMapper {
	
	// 로그인
	public MemberDTO login(MemberDTO memberDTO);
	
	// 이메일 중복체크
	public String emailCheck(String insertEmail);
	
	// 회원가입
	public int register(MemberDTO memberDTO);
}
