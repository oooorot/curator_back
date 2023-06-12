package com.web.root.mybatis.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.member.dto.MemberDTO;

public interface AdminMapper {
	
	// 회원관리
	public List<MemberDTO> adminCustomerList();
	
	// 작가등록
	public int adminArtistAdd(ArtistDTO artistDTO);
	
	// 작가관리
	public List<ArtistDTO> adminArtistList();
	
	// 그림 등급 관리
	public int adminPostAuction(@Param(value = "postSeq") int postSeq,@Param(value = "postAuction") int postAuction);

}
