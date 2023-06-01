package com.web.root.member.service;

import java.util.Map;

import com.web.root.member.dto.LoginDTO;
import com.web.root.member.dto.MemberDTO;

public interface MemberService {
	
	public LoginDTO login(Map<String, Object> map);
	
	public MemberDTO memberInfo(Map<String, Object> map);
	
	public int register(Map<String, Object> map);
	
	public int memberUpdate(Map<String, Object> map);
	
	public int memberDelete(String loginEmail);

}
