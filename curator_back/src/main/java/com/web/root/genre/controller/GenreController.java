


package com.web.root.genre.controller;

import java.util.List;


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
	private GenreService GenreService;
	
	//장르 리스트
	@GetMapping(value = "genreList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<GenreDTO> genreList() {
		return GenreService.genreList();
	}
	
	
	// 장르 조회
	@GetMapping(value = "genreView", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<PostDTO> postView(@RequestParam("genreSeq") int genreSeq) {
		return GenreService.genreView(genreSeq);
	}

}
