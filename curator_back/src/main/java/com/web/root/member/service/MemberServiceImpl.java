package com.web.root.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	public MemberMapper memberMapper;

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		memberDTO = memberMapper.userCheck(memberDTO.getMemberEmail());
		if(memberDTO != null) {
			if(memberDTO.getMemberPw().equals(memberDTO.getMemberPw())) {
				return memberDTO;
			}
		}
		return memberDTO;
	}

	@Override
	public List<MemberDTO> memberInfo(HttpSession session) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		if(Integer.parseInt((String)session.getAttribute("loginSeq")) == 1) {
			list = memberMapper.memberInfo();
			return list;
		}
		return list;
	}

	@Override
	public void register(Map<String, Object> map) {
		try {
			memberMapper.register(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
}
