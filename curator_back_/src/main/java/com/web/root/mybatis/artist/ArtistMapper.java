package com.web.root.mybatis.artist;

import java.util.List;

import com.web.root.artist.dto.ArtistDTO;

public interface ArtistMapper {

	public ArtistDTO artistInform(int artistSeq);

	public List<ArtistDTO> artistAllList();

	
}
