


package com.web.root.genre.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.web.root.genre.dto.GenreDTO;
import com.web.root.post.dto.PostDTO;

public interface GenreService {
	
	public List<GenreDTO> genreList();
	
	public List<PostDTO> genreView(int genreSeq);
	
	public ResponseEntity<byte[]> genrePostImageName(String postImageName);



}
