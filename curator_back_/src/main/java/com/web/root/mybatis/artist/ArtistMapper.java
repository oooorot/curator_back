package com.web.root.mybatis.artist;

import java.util.List;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.post.dto.PostDTO;

public interface ArtistMapper {

	public ArtistDTO artistInform(int artistSeq);

	public List<ArtistDTO> artistAllList();
	
	public List<PostDTO> ArtistView(int artistSeq);

	public BookmarkDTO bookmark(MemberDTO memDTO, ArtistDTO artDTO);
	
	public int artistUpdate(ArtistDTO dto);
	
	public int ArtistWrite(ArtistDTO dto);
	
	public int saveData(ArtistDTO dto);


	
}
