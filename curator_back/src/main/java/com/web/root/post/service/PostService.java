


package com.web.root.post.service;


import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;


import com.web.root.post.dto.PostDTO;
import com.web.root.postExhibition.dto.PostExhibitionDTO;
import com.web.root.postauction.dto.PostAuctionDTO;

public interface PostService {
	
	public PostDTO PostView(int postSeq);
	
	public List<PostDTO> postList();
	
	public int postWrite(PostDTO dto, MultipartFile multipartFile);
	
	public int postCart(Map<String, Object> map);
	
	public int postDelete(int postSeq);
	
	public int postUpdate(PostDTO dto, MultipartFile multipartFile);

	public void deleteImage(String originalFileName);
	
	public List<PostExhibitionDTO> postExhibition(int postExhibition);
	
	public List<PostAuctionDTO> postAuction(int postAuction);

	
	

}
