package com.web.root.artist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.artist.dto.ArtistProfileDTO;
import com.web.root.artist.service.ArtistService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	
	// 작가 리스트 불러오기
	@GetMapping(value="artistAllList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<ArtistProfileDTO> artistAllList(){
		return artistService.artistAllList();
	}
	
	// 작가 즐겨찾기 불러오기
	@GetMapping(value="artistTop", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<ArtistDTO> artistTop(){
		return artistService.artistTop();
	}
	
	
	// 작가 조회  
	@GetMapping(value = "artistInform", produces = "application/json; charset=utf8")
	@ResponseBody
	public ArtistDTO artistInform(@RequestParam("artistSeq") int artistSeq) {
		return artistService.artistInform(artistSeq);
	}
	
	
	// 북마크 등록
	@PostMapping(value="artistBookmark", produces = "application/json; charset=utf8")
	@ResponseBody
	public int artistBookmark(@RequestBody Map<String, Object> map){
		return artistService.artistBookmark(map);
	}
	
	
	// 작가 이미지 불러오기
	@GetMapping(value="artistImage", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<byte[]> artistImage(@RequestPart(value="artistImage") String artistImage) {
	    return artistService.artistImage(artistImage);
	}  

}
