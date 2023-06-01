package com.web.root.mybatis.exhibition;

import java.util.List;

import com.web.root.exhibition.dto.ExhibitionDTO;

public interface ExhibitionMapper {
	
	public List<ExhibitionDTO> ExhibitionList();
	
	
	public ExhibitionDTO ExhibitionView(int exhibitionSeq);
	
	public int saveData(ExhibitionDTO dto);

}
