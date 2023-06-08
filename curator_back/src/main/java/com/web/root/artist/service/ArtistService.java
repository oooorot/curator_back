package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import com.web.root.artist.dto.ArtistDTO;

public interface ArtistService {

	// 작가 리스트 불러오기
	public List<ArtistDTO> artistAllList();
	
	// 작가 조회
	public ArtistDTO artistInform(int artistSeq);
	
	// 북마크 등록
	public int artistBookmark(Map<String, Object> map);
	
	
}
