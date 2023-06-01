package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.artist.ArtistMapper;
import com.web.root.post.dto.PostDTO;

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
		BookmarkDTO dto = mapper.bookmark(memDTO, artDTO);
		return dto;	
	}

	@Override
	public void artistUpdate(Map<String, Object> map) {
		ArtistDTO artDTO = new ArtistDTO();
		
		
	}
	
	
	
	@Override
	public List<PostDTO> ArtistView(int artistSeq) {
		List<PostDTO> list = mapper.ArtistView(artistSeq);		
		System.out.println(list);
		System.out.println(artistSeq);
		return list;
	}
	
	
	
}
