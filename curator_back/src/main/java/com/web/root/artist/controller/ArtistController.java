package com.web.root.artist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.artist.service.ArtistService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ArtistController {

	@Autowired
	private ArtistService service;
	
	// 작가 리스트 불러오기
	@GetMapping(value="artistAllList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<ArtistDTO> artistAllList(){
		return service.artistAllList();
	}
	
	// 작가 조회  
	@GetMapping(value = "artistInform", produces = "application/json; charset=utf8")
	@ResponseBody
	public ArtistDTO artistInform(@RequestParam("artistSeq") int artistSeq) {
		return service.artistInform(artistSeq);
	}
	
	
	// 북마크 등록
	@PostMapping(value="artistBookmark", produces = "application/json; charset=utf8")
	@ResponseBody
	public int artistBookmark(@RequestBody Map<String, Object> map){
		return service.artistBookmark(map);
	}
	
	

}
