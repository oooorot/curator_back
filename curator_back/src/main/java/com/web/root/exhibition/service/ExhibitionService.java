


package com.web.root.exhibition.service;

import java.util.List;


import com.web.root.exhibition.dto.ExhibitionDTO;


public interface ExhibitionService {
	
	public List<ExhibitionDTO> exhibitionList();
	
	public ExhibitionDTO exhibitionView(int exhibitionSeq);
		
//	public int exhibitionWrite(ExhibitionDTO dto, MultipartFile multipartFile);

}
