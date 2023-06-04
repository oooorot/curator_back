


package com.web.root.genre.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
		List<GenreDTO> list = mapper.GenreList();
		return list;
	}
	
	@Override
	public List<PostDTO> GenreView() {
		List<PostDTO> dto = mapper.GenreView();
		return dto;
	}

}
