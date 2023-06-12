


package com.web.root.post.service;


import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.post.dto.PostAuctionDTO;
import com.web.root.post.dto.PostDTO;
import com.web.root.post.dto.PostExhibitionDTO;

public interface PostService {
	
	public PostDTO postView(int postSeq);
	
	public List<PostDTO> postList();
	
	public int postWrite(PostDTO postDTO, MultipartFile multipartFile);
	
	public int postCart(Map<String, Object> map);
	
	public int postDelete(int postSeq);
	
	public int postUpdate(PostDTO postDTO, MultipartFile multipartFile);

	public void deleteImage(String originalFileName);
	
	public List<PostExhibitionDTO> postExhibition(int postExhibition);
	
	public List<PostAuctionDTO> postAuction(int postAuction);
	
	public ResponseEntity<byte[]> postImageName(String postImageName);

	
	

}
