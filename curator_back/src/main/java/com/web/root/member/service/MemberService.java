package com.web.root.member.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import com.web.root.member.dto.MemberDTO;

public interface MemberService {
	
	public MemberDTO userCheck(MemberDTO memberDTO);
	
	public List<MemberDTO> memberInfo(HttpSession session);
	
	public void register(Map<String, Object> map);

}
