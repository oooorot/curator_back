package com.web.root.mybatis.artist;

import java.util.List;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;

public interface ArtistMapper {

	public List<ArtistDTO> artistAllList();
	
	public ArtistDTO artistInform(int artistSeq);

	public int artistBookmark(BookmarkDTO dto);

	
}
