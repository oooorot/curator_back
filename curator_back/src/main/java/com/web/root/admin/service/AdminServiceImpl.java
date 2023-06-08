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
import com.web.root.mybatis.help.HelpMapper;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminMapper adminMapper;
	
	@Autowired
	public CustomerMapper customerMapper;
	
	@Autowired
	public ArtistPageMapper artistPageMapper;
	
	@Autowired
	public HelpMapper serviceMapper;

	// 회원관리
	@Override
	public List<MemberDTO> adminCustomerList() {
		return adminMapper.adminCustomerList();
	}
	
	// 작가등록
	@Override
	public int adminArtistAdd(Map<String, Object> map) {
		ArtistDTO artistDTO = new ArtistDTO();
		artistDTO.setArtistSeq(Integer.parseInt(map.get("artistSeq").toString()));
		artistDTO.setArtistName(map.get("artistName").toString());
		artistDTO.setArtistProfile(map.get("artistProfile").toString());
		artistDTO.setArtistSns(map.get("artistSns").toString());
		artistDTO.setArtistImage(map.get("artistImage").toString());
		return adminMapper.adminArtistAdd(artistDTO);
	}

	// 작가관리
	@Override
	public List<ArtistDTO> adminArtistList() {
		return adminMapper.adminArtistList();
	}
	
	// 그림 등급 관리
	@Override
	public int adminPostAuction(int postSeq, int postAuction) {
		return adminMapper.adminPostAuction(postSeq, postAuction);
	}

	// 임의 회원 탈퇴
	@Override
	public int adminMemberDelete(Map<String, Object> map) {
		int memberGrade = Integer.parseInt(map.get("memberGrade").toString());
		int customerDelete = Integer.parseInt(map.get("memberSeq").toString());
		int artistDelete = Integer.parseInt(map.get("artistSeq").toString());
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





