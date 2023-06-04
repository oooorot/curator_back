package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import com.web.root.artist.dto.ArtistDTO;

public interface ArtistService {

	public List<ArtistDTO> artistAllList();
	
	public ArtistDTO artistInform(int artistSeq);
	
	public int artistBookmark(Map<String, Object> map);
	
	
}
