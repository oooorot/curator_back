package com.web.root.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.admin.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminMapper adminMapper;

	// 회원관리
	@Override
	public List<MemberDTO> AdminCustomerList() {
		return adminMapper.AdminCustomerList();
	}
	
	
	

}
