


package com.web.root.post.service;


import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.web.root.post.dto.PostAuctionDTO;
import com.web.root.post.dto.PostDTO;
import com.web.root.post.dto.PostExhibitionDTO;

public interface PostService {
	
	// 그림게시판 조회
	public PostDTO postView(int postSeq);
	
	//그림게시판 리스트
	public List<PostDTO> postList();

	// 그림게시판 경매 조회
	public List<PostAuctionDTO> postAuction(int postAuction);
	
	// 그림게시판 전시회 조회
	public List<PostExhibitionDTO> postExhibition(int postExhibition);
	
	// 그림 장바구니
	public int postCart(Map<String, Object> map);
	
	// 그림 삭제
	public int postDelete(int postSeq);
	
	// 그림 수정
	public int postUpdate(PostDTO postDTO, MultipartFile multipartFile);

	public void deleteImage(String originalFileName);
	
	
	
}
