


package com.web.root.exhibition.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.exhibition.dto.ExhibitionDTO;


public interface ExhibitionService {
	
	public List<ExhibitionDTO> exhibitionList();
	
	public ExhibitionDTO exhibitionView(int exhibitionSeq);
	
		
	// 전시회내역(DB값)
	public List<ExhibitionDTO> exhibitionBannerList(int exhibitionSeq);
	   
	// 전시회내역(이미지)
	public ResponseEntity<byte[]> exhibitionimage(String exhibitionBanner);
	   
	// 전시회등록
	public int exhibitionWrite(ExhibitionDTO exhibitionDTO, MultipartFile multipartFile);
	   
	// 전시회수정
	public int exhibitionUpdate(ExhibitionDTO exhibitionDTO, MultipartFile multipartFile);

}
