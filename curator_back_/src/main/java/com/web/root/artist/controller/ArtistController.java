package com.web.root.artist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.artist.service.ArtistService;
import com.web.root.bookmark.BookmarkDTO;
import com.web.root.post.dto.PostDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ArtistController {

	@Autowired
	private ArtistService service;
	
	@GetMapping(value="artistInform", produces="application/json; charset=utf8")
	@ResponseBody
	public ArtistDTO artistInform(@RequestParam Map<String, Object> map) {
		return service.artistInform(map);
	}
	
	@GetMapping(value="artistAllList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<ArtistDTO> artistAllList(){
		return service.artistAllList();
	}
	
	@GetMapping(value="artistList", produces = "application/json; charset=utf8")
	@ResponseBody
	public BookmarkDTO artistBookMark(@RequestParam Map<String, Object> map){
		return service.artistBookMark(map);
	}
	
	@GetMapping(value = "ArtistView", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<PostDTO> PostView(@RequestParam("artistSeq") int artistSeq) {
		return service.ArtistView(artistSeq);
	}
}
