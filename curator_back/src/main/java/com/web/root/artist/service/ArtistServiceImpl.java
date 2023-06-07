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
	private ArtistMapper mapper;


	@Override
	public List<ArtistDTO> artistAllList() {
		
		try {
			List<ArtistDTO> list = mapper.artistAllList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArtistDTO artistInform(int artistSeq) {
		
		try {
			ArtistDTO dto = mapper.artistInform(artistSeq);		
		return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int artistBookmark(Map<String, Object> map) { 
		int res= 0;
		try {
			BookmarkDTO dto = new BookmarkDTO();
			dto.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
			dto.setArtistSeq(Integer.parseInt(map.get("artistSeq").toString()));
			res = mapper.artistBookmark(dto);
			updateHit(dto.getArtistSeq());
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return res;
	}	
	
	public void updateHit(int artistSeq) {
		mapper.updateHit(artistSeq); 
	}
	

	
}
