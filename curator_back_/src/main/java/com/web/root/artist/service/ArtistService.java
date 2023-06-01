package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;

public interface ArtistService {
	
	public ArtistDTO artistInform(Map<String, Object> map);

	public List<ArtistDTO> artistAllList();
	
	public BookmarkDTO artistBookMark(Map<String, Object> map);
	
	public void artistUpdate(Map<String, Object> map);
}
