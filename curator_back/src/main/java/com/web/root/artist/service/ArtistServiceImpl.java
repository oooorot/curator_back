package com.web.root.artist.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.mybatis.artist.ArtistMapper;

@Service
public class ArtistServiceImpl implements ArtistService{

	@Autowired
	private ArtistMapper artistMapper;


	// 작가 리스트 불러오기
	@Override
	public List<ArtistDTO> artistAllList() {
<<<<<<< HEAD
		try {
			List<ArtistDTO> list = artistMapper.artistAllList();
			return list;		
=======
		
		try {
			List<ArtistDTO> list = mapper.artistAllList();
			return list;
>>>>>>> branch 'main' of https://github.com/leejunsam/curator_back-1.git
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	// 작가 조회
	@Override
	public ArtistDTO artistInform(int artistSeq) {
<<<<<<< HEAD
		try {
			ArtistDTO artistDTO = artistMapper.artistInform(artistSeq);		
			return artistDTO;	
=======
		
		try {
			ArtistDTO dto = mapper.artistInform(artistSeq);		
		return dto;
>>>>>>> branch 'main' of https://github.com/leejunsam/curator_back-1.git
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	// 북마크 등록
	@Override
	public int artistBookmark(Map<String, Object> map) { 
		int res= 0;
		try {
<<<<<<< HEAD
			BookmarkDTO bookmarkDTO = new BookmarkDTO();
			bookmarkDTO.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
			bookmarkDTO.setArtistSeq(Integer.parseInt(map.get("artistSeq").toString()));
			res = artistMapper.artistBookmark(bookmarkDTO);		
=======
			BookmarkDTO dto = new BookmarkDTO();
			dto.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
			dto.setArtistSeq(Integer.parseInt(map.get("artistSeq").toString()));
			res = mapper.artistBookmark(dto);
			updateHit(dto.getArtistSeq());
			
>>>>>>> branch 'main' of https://github.com/leejunsam/curator_back-1.git
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return res;
	}	
	
	public void updateHit(int artistSeq) {
		mapper.updateHit(artistSeq); 
	}
	

	
}
