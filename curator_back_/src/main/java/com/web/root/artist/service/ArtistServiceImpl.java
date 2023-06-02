package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.mybatis.artist.ArtistMapper;
import com.web.root.post.dto.PostDTO;

@Service
public class ArtistServiceImpl implements ArtistService{

	@Autowired
	private ArtistMapper mapper;


	@Override
	public List<ArtistDTO> artistAllList() {
		List<ArtistDTO> list = mapper.artistAllList();
		return list;
	}

	@Override
	public PostDTO ArtistView(int artistSeq) {
		PostDTO dto = mapper.ArtistView(artistSeq);		
		return dto;
	}

	@Override
	public int artistBookmark(Map<String, Object> map) { 
		int res = 0;
		try {
			BookmarkDTO dto = new BookmarkDTO();
			dto.setMarkSeq(Integer.parseInt(map.get("setMarkSeq").toString()));
			dto.setMemberSeq(Integer.parseInt(map.get("setMemberSeq").toString()));
			dto.setArtistSeq(Integer.parseInt(map.get("setAritstSeq").toString()));
			res = mapper.artistBookmark(dto);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}	
	
}
