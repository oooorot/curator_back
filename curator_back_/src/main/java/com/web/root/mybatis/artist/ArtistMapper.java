package com.web.root.mybatis.artist;

import java.util.List;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.post.dto.PostDTO;

public interface ArtistMapper {

	public ArtistDTO artistInform(int artistSeq);

	public List<ArtistDTO> artistAllList();
	
	public List<PostDTO> ArtistView(int artistSeq);


	
}
