package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.BookmarkDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.artist.ArtistMapper;

@Service
public class ArtistServiceImpl implements ArtistService{

	@Autowired
	private ArtistMapper mapper;

	@Override
	public ArtistDTO artistInform(Map<String, Object> map) {
		ArtistDTO dto = mapper.artistInform(Integer.parseInt(map.get("artistSeq").toString()));
		return dto;
	}

	@Override
	public List<ArtistDTO> artistAllList() {
		List<ArtistDTO> list = mapper.artistAllList();
		return list;
	}


	@Override
	public BookmarkDTO artistBookMark(Map<String, Object> map) { 
		MemberDTO memDTO = new MemberDTO();
		ArtistDTO artDTO = new ArtistDTO();
		memDTO.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
		artDTO.setArtistSeq(Integer.parseInt(map.get("artistSeq").toString()));
		
		
		return null;
	}
	
	
	
}
