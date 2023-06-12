package com.web.root.mybatis.member;


import java.util.Map;

import com.web.root.member.dto.MemberDTO;

public interface MemberMapper {
	
	// 로그인 체크
	public MemberDTO loginCheck(Map<String, String> map);
	
	// 로그인
	public MemberDTO login(MemberDTO memberDTO);
	
	// 이메일 중복체크
	public String emailCheck(String memberEmail);
	
	public MemberDTO checkEmail(String memberEmail);
	
	// 회원가입
	public int register(MemberDTO memberDTO);
	
	// 인증번호 저장
	public int codeSave(String code);
	
	// 인증번호 확인
	public String codeSelect();
	
	// 인증번호 삭제
	public int codeDelete();
}
