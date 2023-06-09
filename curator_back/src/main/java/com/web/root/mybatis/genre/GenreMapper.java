package com.web.root.mybatis.genre;

import java.util.List;

import com.web.root.genre.dto.GenreDTO;
import com.web.root.post.dto.PostDTO;

public interface GenreMapper {
	
	public List<GenreDTO> genreList();
	
	public List<PostDTO> genreView(int genreSeq);
	


}
