


package com.web.root.exhibition.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.web.root.exhibition.dto.ExhibitionDTO;


public interface ExhibitionService {
	
	public List<ExhibitionDTO> ExhibitionList();
	
	public ExhibitionDTO ExhibitionView(int exhibitionSeq);
	
	public String fileProcess(ExhibitionDTO dto, MultipartFile multipartFile);

}
