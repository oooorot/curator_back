package com.web.root.mybatis.artist;

import java.util.List;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.post.dto.PostDTO;

public interface ArtistMapper {

	public List<ArtistDTO> artistAllList();
	
	public PostDTO ArtistView(int artistSeq);

	public int artistBookmark(BookmarkDTO dto);

	
}
