package com.web.root.artistpage.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.commission.dto.CommissionDTO;
import com.web.root.post.dto.PostDTO;

public interface ArtistPageService {
	
	// 작가회원정보
	public ArtistDTO artistMemberInfo(Map<String, Object> map);
	
	// 작가회원정보 수정
	public int artistMemberUpdate(Map<String, Object> map);
	
	// 작가회원탈퇴
	public int artistMemberDelete(int MemberSeq);
	
	// 작품내역
	public List<CommissionDTO> artistPostList(int artistSeq, HttpServletResponse response);
	
	// 작품등록
	public int artistPostUpdate(PostDTO postDTO, MultipartFile multipartFile);
	
	// 의뢰내역
	public List<CommissionDTO> PostCommissionList(int artistSeq);
	
}
