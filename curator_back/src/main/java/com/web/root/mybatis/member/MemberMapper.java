package com.web.root.mybatis.member;


import com.web.root.member.dto.MemberDTO;

public interface MemberMapper {
	
	// 로그인 체크
	public MemberDTO loginCheck(String memberEmail, String memberPw);
	
	// 로그인
	public MemberDTO login(MemberDTO memberDTO);
	
	// 이메일 중복체크
	public String emailCheck(String memberEmail);
	
	public MemberDTO checkEmail(String memberEmail);
	
	// 회원가입
	public int register(MemberDTO memberDTO);
}
