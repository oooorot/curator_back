package com.web.root.mybatis.artist;

import java.util.List;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.member.dto.MemberDTO;

public interface ArtistMapper {

	public ArtistDTO artistInform(int artistSeq);

	public List<ArtistDTO> artistAllList();
	
	public BookmarkDTO bookmark(MemberDTO memDTO, ArtistDTO artDTO);

	
}
