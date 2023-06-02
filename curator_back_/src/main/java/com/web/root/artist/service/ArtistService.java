package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.post.dto.PostDTO;

public interface ArtistService {

	public List<ArtistDTO> artistAllList();
	
	public PostDTO ArtistView(int artistSeq);
	
	public int artistBookmark(Map<String, Object> map);
	
	
}
