


package com.web.root.exhibition.service;

import java.util.List;


import com.web.root.exhibition.dto.ExhibitionDTO;


public interface ExhibitionService {
	
	public List<ExhibitionDTO> ExhibitionList();
	
	public ExhibitionDTO ExhibitionView(int exhibitionSeq);
		
//	public int exhibitionWrite(ExhibitionDTO dto, MultipartFile multipartFile);

}
