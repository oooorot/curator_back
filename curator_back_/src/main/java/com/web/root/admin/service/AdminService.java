package com.web.root.admin.service;

import java.util.List;
import java.util.Map;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.member.dto.MemberDTO;

public interface AdminService {
	
	// 회원관리
	public List<MemberDTO> adminCustomerList();
	
	// 작가관리
	public List<ArtistDTO> adminArtistList();
	
	// 회원 임의 탈퇴
	public int adminMemberDelete(Map<String, Object> map);

}
