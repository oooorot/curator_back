


package com.web.root.post.controller;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping(value = "file", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public String fileTest(@RequestPart(value = "dto") PostDTO dto, @RequestPart(value = "file", required = false) MultipartFile multipartFile) {
		System.out.println(dto.getPostImageName());
		System.out.println(multipartFile.getOriginalFilename());
		service.fileProcess(dto, multipartFile);
		
		return "success";
	}

}
