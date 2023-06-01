


package com.web.root.genre.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.genre.dto.GenreDTO;
import com.web.root.genre.service.GenreService;
import com.web.root.post.dto.PostDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GenreController {
	
	@Autowired
	private GenreService service;
	
	@GetMapping(value = "GenreList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<GenreDTO> GenreList() {
		return service.GenreList();
	}
	
	@GetMapping(value = "GenreView", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<PostDTO> PostView(@RequestParam("genreSeq") int genreSeq ) {
		return service.GenreView(genreSeq);
	}

}
