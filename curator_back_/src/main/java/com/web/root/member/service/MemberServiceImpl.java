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
			loginDTO.setMemberPw(memberDTO.getMemberPw());
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

	// 회원정보
	@Override
	public MemberDTO memberInfo(Map<String, Object> map) {
		MemberDTO memberDTO = memberMapper.memberInfo(map.get("memberEmail").toString());
		return memberDTO;
	}
	
	// 회원등록
	@Override
	public int register(Map<String, Object> map) {
		String insertCode = map.get("insertCode").toString(); 
		String registerCode = map.get("registerCode").toString();
		try {
			if(insertCode.equals(registerCode)) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMemberEmail(map.get("memberEmail").toString());
				memberDTO.setMemberPw(map.get("memberPw").toString());
				memberDTO.setMemberNickname(map.get("memberNickname").toString());
				memberDTO.setMemberName(map.get("memberName").toString());
				memberDTO.setMemberPhone(map.get("memberPhone").toString());
				memberDTO.setMemberAddr(map.get("memberAddr").toString());
				memberDTO.setMemberGrade(Integer.parseInt(map.get("memberGrade").toString()));
				return memberMapper.register(map);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	// 회원정보 수정
	@Override
	public int memberUpdate(Map<String, Object> map) {
		try {
			if(map.get("memberPw")!=null&map.get("memberNickname")!=null&map.get("memberName")!=null&map.get("memberPhone")!=null&map.get("memberAddr")!=null) {
				return memberMapper.memberUpdate(map);
			} else return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// 회원탈퇴
	@Override
	public int memberDelete(String loginEmail) {
		try {
			return memberMapper.memberDelete(loginEmail);
		} catch (Exception e) {
			return 0;
		}
		
	}

	
	
	
	
}
