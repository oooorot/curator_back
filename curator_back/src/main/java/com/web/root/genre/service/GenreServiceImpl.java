


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
	private GenreMapper mapper;
	
	@Override
	public List<GenreDTO> GenreList() {
		try {
			List<GenreDTO> list = mapper.GenreList();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PostDTO> GenreView() {
		try {
			List<PostDTO> dto = mapper.GenreView();
			return dto;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
