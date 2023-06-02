package com.web.root.mybatis.admin;

import java.util.List;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.member.dto.MemberDTO;

public interface AdminMapper {
	
	// 회원관리
	public List<MemberDTO> adminCustomerList();
	
	// 작가관리
	public List<ArtistDTO> adminArtistList();
	

}
