package com.web.root.artist.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.web.root.artist.dto.ArtistDTO;

public interface ArtistService {
	
	public ArtistDTO artistInform(Map<String, Object> map);

	public List<ArtistDTO> artistAllList();
}
