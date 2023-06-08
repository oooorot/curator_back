package com.web.root.mybatis.exhibition;

import java.util.List;

import com.web.root.exhibition.dto.ExhibitionDTO;

public interface ExhibitionMapper {
	
	public List<ExhibitionDTO> exhibitionList();
	
	public ExhibitionDTO exhibitionView(int exhibitionSeq);
	
	public int exhibitionWrite(ExhibitionDTO exhibitionDTO);
	
	

}
