package com.web.root.nonmember.service;

import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.mybatis.nonmember.NonmemberMapper;
import com.web.root.nonmember.dto.NonmemberDTO;

@Service
public class NonmemberServiceImpl implements NonmemberService{

	@Autowired
	private NonmemberMapper mapper;
	

	// 비회원 정보 가져오기
	@Override
	public NonmemberDTO getNonmember(int nonSeq) {
		NonmemberDTO dto = new NonmemberDTO();
		try {
			dto = mapper.getNonmember(nonSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	
	// 비회원 구매시 정보 입력
	@Override
	public int nonmemberInform(Map<String, Object> map) {
		int res = 0;
		try {
			String RevCode = RandomStringUtils.random(8, false, true);
			NonmemberDTO dto = new NonmemberDTO();
			dto.setNonCode(RevCode.toString());
			dto.setNonEmail(map.get("nonEmail").toString());
			dto.setNonName(map.get("nonName").toString());
			dto.setNonPhone(map.get("nonPhone").toString());
			dto.setNonAddr(map.get("nonAddr").toString());
			res = mapper.nonmemberInform(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	
}
