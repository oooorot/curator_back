package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.BookmarkDTO;
import com.web.root.post.dto.PostDTO;

public interface ArtistService {
	
	public ArtistDTO artistInform(Map<String, Object> map);

	public List<ArtistDTO> artistAllList();
	
	public BookmarkDTO artistBookMark(Map<String, Object> map);
	
	public List<PostDTO> ArtistView(int artistSeq);
}
