package com.web.root.mybatis.member;

import java.util.Map;

import com.web.root.member.dto.MemberDTO;

public interface MemberMapper {
	
	public MemberDTO login(MemberDTO memberDTO);
	
	public MemberDTO memberInfo(String email);
	
	public int register(Map<String, Object> map);
	
	public int memberUpdate(Map<String, Object> map);
	
	public int memberDelete(String loginEmail);
}
