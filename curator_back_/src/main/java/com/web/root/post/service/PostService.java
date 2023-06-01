


package com.web.root.post.service;


import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.web.root.post.dto.PostDTO;

public interface PostService {
	
	public PostDTO PostView(int postSeq);
	
	public String fileProcess(PostDTO dto, MultipartFile multipartFile);

	

}
