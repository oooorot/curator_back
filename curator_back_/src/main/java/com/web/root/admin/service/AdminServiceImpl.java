package com.web.root.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.admin.AdminMapper;
import com.web.root.mybatis.artistpage.ArtistPageMapper;
import com.web.root.mybatis.customer.CustomerMapper;
import com.web.root.mybatis.service.ServiceMapper;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminMapper adminMapper;
	
	@Autowired
	public CustomerMapper customerMapper;
	
	@Autowired
	public ArtistPageMapper artistPageMapper;
	
	@Autowired
	public ServiceMapper serviceMapper;

	// 회원관리
	@Override
	public List<MemberDTO> adminCustomerList() {
		return adminMapper.adminCustomerList();
	}

	// 작가관리
	@Override
	public List<ArtistDTO> adminArtistList() {
		return adminMapper.adminArtistList();
	}
	
	// 임의 회원 탈퇴
	@Override
	public int adminMemberDelete(Map<String, Object> map) {
		int memberGrade = Integer.parseInt(map.get("memberGrade").toString());
		int customerDelete = Integer.parseInt(map.get("memberSeq").toString());
		int artistDelete = Integer.parseInt(map.get("artistSeq").toString());
		int commissionDelete = Integer.parseInt(map.get("commSeq").toString());
		int bookmarkDelete = Integer.parseInt(map.get("markSeq").toString());
		int cartDelete = Integer.parseInt(map.get("cartSeq").toString());
		switch(memberGrade) {
		case 1 : 
			customerMapper.memberDelete(customerDelete);
			return 1; 
		case 2 : 
			artistPageMapper.artistMemberDelete(artistDelete); 
			return 1;
		default : return 0;	
		}
	}


}





