

package com.web.root.post.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.post.dto.PostAuctionDTO;
import com.web.root.post.dto.PostDTO;
import com.web.root.post.dto.PostExhibitionDTO;
import com.web.root.post.service.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	// 그림게시판 조회
	@GetMapping(value = "postView", produces = "application/json; charset=utf8")
	@ResponseBody
	public PostDTO postView(@RequestParam("postSeq") int postSeq) {
		return  postService.postView(postSeq);		 	
	}
	
	//그림게시판 리스트
	@GetMapping(value = "postList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<PostDTO> postList() {
		return postService.postList();
	}
	
	// 그림게시판 경매 조회
	@GetMapping(value = "postAuction", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<PostAuctionDTO> postAuction(@RequestParam("postAuction") int postAuction) {
		return  postService.postAuction(postAuction);		 	
	}
	
	// 그림게시판 전시회 조회
	@GetMapping(value = "postExhibition", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<PostExhibitionDTO> postExhibition(@RequestParam("postExhibition") int postExhibition) {
		return  postService.postExhibition(postExhibition);		 	
	}
		
	// 그림 장바구니
	@PostMapping(value="postCart", produces = "application/json; charset=utf8")
	@ResponseBody
	public int postCart(@RequestBody Map<String, Object> map){
	      return postService.postCart(map);
	   }
	
	
	// 그림 삭제
	@DeleteMapping(value="postDelete", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int postDelete(@RequestParam("postSeq") int postSeq) {
		return postService.postDelete(postSeq);
	}
	
	// 그림 수정
	@PutMapping(value="postUpdate", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int postUpdate(PostDTO postDTO, MultipartFile multipartFile) {
		return postService.postUpdate(postDTO, multipartFile);
	}
	
	
	

}
