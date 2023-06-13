package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.artist.dto.ArtistProfileDTO;

public interface ArtistService {

	// 작가 리스트 불러오기
	public List<ArtistProfileDTO> artistAllList();
	
	// 작가 조회
	public ArtistDTO artistInform(int artistSeq);
	
    // 작가 탑레이팅 불러오기
    public List<ArtistDTO> artistTop();
	
	// 북마크 등록
	public int artistBookmark(Map<String, Object> map);
	
	// 작가 이미지 등록
	public ResponseEntity<byte[]> artistImage(String artistImage);
	
}
