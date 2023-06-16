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
	private NonmemberMapper nonmemberMapper;
	
	// 비회원 정보 가져오기
	@Override
	public NonmemberDTO getNonmember(int nonSeq) {
		NonmemberDTO nonmemberDTO = new NonmemberDTO();
		try {
			nonmemberDTO = nonmemberMapper.getNonmember(nonSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nonmemberDTO;
	}		
	
	// 비회원 구매시 정보 입력
		@Override
		public int nonmemberInform(Map<String, Object> map) {
		    NonmemberDTO nonmemberDTO = new NonmemberDTO();

		    String nonCode = RandomStringUtils.randomNumeric(8);

		    nonmemberDTO.setNonCode(nonCode);
		    nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
		    nonmemberDTO.setNonName(map.get("nonName").toString());
		    nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
		    nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
		    nonmemberDTO.setNonCompany(map.get("nonCompany").toString());
		    nonmemberDTO.setNonDscode(map.get("nonDscode").toString());

		    return nonmemberMapper.nonmemberInform(nonmemberDTO);
		}			
}
