


package com.web.root.exhibition.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.web.root.exhibition.dto.ExhibitionDTO;


public interface ExhibitionService {
	
	// 전시회 리스트
	public List<ExhibitionDTO> exhibitionList();
	
	// 전시회 조회
	public ExhibitionDTO exhibitionView(int exhibitionSeq) throws IOException;
	   
	// 전시회 등록
	public int exhibitionWrite(ExhibitionDTO exhibitionDTO, MultipartFile multipartFile);
	   
	// 전시회 수정
	public int exhibitionUpdate(ExhibitionDTO exhibitionDTO, MultipartFile multipartFile);

}
