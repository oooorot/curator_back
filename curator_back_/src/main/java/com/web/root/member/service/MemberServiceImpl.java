package com.web.root.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.member.dto.LoginDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	public MemberMapper memberMapper;
	
	// 로그인
	@Override
	public LoginDTO login(Map<String, Object> map) {
		MemberDTO memberDTO = new MemberDTO();
		LoginDTO loginDTO = new LoginDTO();
		memberDTO.setMemberEmail(map.get("memberEmail").toString());
		memberDTO.setMemberPw(map.get("memberPw").toString());
		memberDTO = memberMapper.login(memberDTO);
		if(memberDTO != null) {
			loginDTO.setMemberSeq(memberDTO.getMemberSeq());
			loginDTO.setMemberEmail(memberDTO.getMemberEmail());
			loginDTO.setMemberNickname(memberDTO.getMemberNickname());
			loginDTO.setMemberGrade(memberDTO.getMemberGrade());
			String message = loginDTO.getMemberNickname() + " 님 로그인"; 
			loginDTO.setLoginMessage(message);
		} else {
			String message = "아이디 또는 비밀번호가 맞는지 확인하세요";
			loginDTO.setLoginMessage(message);
		}
		return loginDTO;
	}
	
	// 인증코드 확인
	@Override
	public int registerCodeResult(Map<String, Object> map) {
		String insertCode = map.get("insertCode").toString(); 
		String registerCode = map.get("registerCode").toString();
		if(insertCode.equals(registerCode)) {
			return 1;
		} else return 0;
	}
	
	// 이메일 중복 확인
	@Override
	public int emailCheck(String InsertEmail) {
		if(memberMapper.emailCheck(InsertEmail).equals(InsertEmail)) {
			return 1;
		}
		return 0;
	}

	// 회원가입
	@Override
	public int register(Map<String, Object> map) {
		try {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setMemberEmail(map.get("memberEmail").toString());
			memberDTO.setMemberPw(map.get("memberPw").toString());
			memberDTO.setMemberNickname(map.get("memberNickname").toString());
			memberDTO.setMemberName(map.get("memberName").toString());
			memberDTO.setMemberPhone(map.get("memberPhone").toString());
			memberDTO.setMemberAddr(map.get("memberAddr").toString());
			memberDTO.setMemberGrade(Integer.parseInt(map.get("memberGrade").toString()));
			return memberMapper.register(map);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}



	
	
	
	
}
