package com.web.root.artistpage.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.commission.dto.CommissionDTO;
import com.web.root.post.dto.PostDTO;

public interface ArtistPageService {
	
	// 작가회원정보
	public ArtistDTO artistMemberInfo(Map<String, Object> map) throws IOException;
	
	// 작가회원정보 수정
	public int artistMemberUpdate(ArtistDTO artistDTO, MultipartFile multipartFile);
	
	// 작가회원탈퇴
	public int artistMemberDelete(Map<String, String> map);
	
	// 작품내역
	public List<PostDTO> artistPostList(int artistSeq);

	// 작품등록
	public int artistPostWrite(PostDTO postDTO, MultipartFile multipartFile);
	
	// 작품수정
	public int artistPostUpdate(PostDTO postDTO, MultipartFile multipartFile);
	
	// 의뢰내역
	public List<CommissionDTO> PostCommissionList(int artistSeq);
	
}
