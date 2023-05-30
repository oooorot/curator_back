package com.web.root.mybatis.member;

import java.util.ArrayList;
import java.util.Map;


import com.web.root.member.dto.MemberDTO;

public interface MemberMapper {
	
	public MemberDTO userCheck(String memberEmail);
	
	public ArrayList<MemberDTO> memberInfo();
	
	public void register(Map<String, Object> map);
}
