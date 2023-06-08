


package com.web.root.genre.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.genre.dto.GenreDTO;
import com.web.root.mybatis.genre.GenreMapper;
import com.web.root.post.dto.PostDTO;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private GenreMapper GenreMapper;
	
	@Override
	public List<GenreDTO> genreList() {
		try {
			List<GenreDTO> GenreList = GenreMapper.genreList();
			return GenreList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PostDTO> genreView(int genreSeq) {
		try {
			List<PostDTO> postDTO = GenreMapper.genreView(genreSeq);
			return postDTO;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
