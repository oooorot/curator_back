package com.web.root.nonmember.service;

import java.util.Map;

import com.web.root.nonmember.dto.NonmemberDTO;

public interface NonmemberService {

	// 비회원 정보 가져오기
	public NonmemberDTO getNonmember(int nonSeq);
	
	// 비회원 구매시 정보 입력
	public int nonmemberInform(Map<String, Object> map);
	
}
