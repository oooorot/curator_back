


package com.web.root.post.service;


import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.post.dto.PostDTO;

public interface PostService {
	
	public PostDTO PostView(int postSeq);
	
	public int postWrite(PostDTO dto, MultipartFile multipartFile);
	
	public int postCart(Map<String, Object> map);
	
	public int postDelete(int postSeq);
	
	public int postUpdate(PostDTO dto, MultipartFile multipartFile);

	public void deleteImage(String originalFileName);

	

}
