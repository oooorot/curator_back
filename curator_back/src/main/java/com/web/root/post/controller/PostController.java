


package com.web.root.post.controller;

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
import com.web.root.post.dto.PostDTO;
import com.web.root.post.service.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "PostView", produces = "application/json; charset=utf8")
	@ResponseBody
	public PostDTO PostView(@RequestParam("postSeq") int postSeq) {
		return service.PostView(postSeq);	
	}
	
	@PostMapping(value="postCart", produces = "application/json; charset=utf8")
	@ResponseBody
	public int postCart(@RequestBody Map<String, Object> map){
	      return service.postCart(map);
	   }
	
	
	@DeleteMapping(value="postDelete", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int postDelete(@RequestParam("postSeq") int postSeq) {
		return service.postDelete(postSeq);
	}
	
	@PutMapping(value="postUpdate", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int postUpdate(PostDTO dto, MultipartFile multipartFile) {
		return service.postUpdate(dto, multipartFile);
	}
	


}
