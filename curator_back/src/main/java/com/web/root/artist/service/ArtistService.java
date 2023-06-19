package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

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
	
	// 북마크 불러오기
	public int artistBookmarkGet(Map<String, Object> map);
	
    // 북마크 제거
    public int bookmarkDelete(Map<String, String> map);
	   
	
}
