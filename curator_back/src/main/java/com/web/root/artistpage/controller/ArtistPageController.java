package com.web.root.artistpage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.web.root.artistpage.service.ArtistPageService;
import com.web.root.commission.dto.CommissionDTO;
import com.web.root.post.dto.PostDTO;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class ArtistPageController {
	
	@Autowired
	public ArtistPageService artistPageService;
	
	// 작가회원정보
	@GetMapping(value="artistMemberInfo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ArtistDTO artistMemberInfo(@RequestBody Map<String, Object> map) throws IOException {
		return artistPageService.artistMemberInfo(map);
	}
	
	// 작가회원정보 수정
	@PutMapping(value="artistMemberUpdate", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public int artistMemberUpdate(@RequestPart(value="artistDTO") ArtistDTO artistDTO, @RequestPart(value="artistImageName", required=false) MultipartFile multipartFile) {
		return artistPageService.artistMemberUpdate(artistDTO, multipartFile); 
	}
	
	// 작가회원탈퇴
	@PostMapping(value="artistMemberDelete", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int artistMemberDelete(@RequestBody Map<String, String> map) {
		return artistPageService.artistMemberDelete(map);
	}
	
	// 작품내역(DB값)
	@GetMapping(value="artistPostList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<PostDTO> artistPostList(@RequestParam("artistSeq") int artistSeq){
		return artistPageService.artistPostList(artistSeq);
	}	
	
	// 작품등록
	@PostMapping(value="artistPostWrite", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public int artistPostWrite(@RequestPart(value="postDTO") PostDTO postDTO, @RequestPart(value="artistPostFile", required=false) MultipartFile multipartFile) {
		return artistPageService.artistPostWrite(postDTO, multipartFile);
	}
	
	// 작품수정
	@PutMapping(value="artistPostUpdate", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public int artistPostUpdate(@RequestPart(value="postDTO") PostDTO postDTO,  @RequestPart(value="postUpdateFile", required=false) MultipartFile multipartFile) {
		return artistPageService.artistPostUpdate(postDTO, multipartFile);
	}
	
	// 의뢰내역
	@GetMapping(value="PostCommissionList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<CommissionDTO> PostCommissionList(@RequestParam("artistSeq") int artistSeq){
		return artistPageService.PostCommissionList(artistSeq);
	}

}
