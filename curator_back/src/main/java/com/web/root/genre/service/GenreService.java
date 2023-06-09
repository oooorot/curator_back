


package com.web.root.genre.service;

import java.util.List;

import com.web.root.genre.dto.GenreDTO;
import com.web.root.post.dto.PostDTO;

public interface GenreService {
	
	public List<GenreDTO> genreList();
	
	public List<PostDTO> genreView(int genreSeq);

}
