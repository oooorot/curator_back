package com.web.root.artist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.artist.service.ArtistService;
import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.post.dto.PostDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ArtistController {

	@Autowired
	private ArtistService service;
	
	
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
	
		
	@PutMapping(value = "ArtistUpdate", produces = "application/json; charset=utf8")
	@ResponseBody
	public int artistUpdate(ArtistDTO dto, MultipartFile multipartFile) {
		return service.artistUpdate(dto, multipartFile);
	}
	
//	@PostMapping(value = "ArtistWrite", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//	@ResponseBody
//	public String ArtistWrite(@RequestPart(value = "dto") ArtistDTO dto, @RequestPart(value = "file", required = false) MultipartFile multipartFile) {
//		service.ArtistWrite(dto, multipartFile);
//		
//		return "success";
//	}
}
