package com.web.root.mybatis.exhibition;

import java.util.List;

import com.web.root.exhibition.dto.ExhibitionDTO;

public interface ExhibitionMapper {
	
	public List<ExhibitionDTO> exhibitionList();
	
	public ExhibitionDTO exhibitionView(int exhibitionSeq);
	
	// 작품내역(DB값)
	public List<ExhibitionDTO> exhibitionBannerList(int exhibitionSeq);
	   
	// 작품등록
	public int exhibitionWrite(ExhibitionDTO exhibitionDTO);
	
	// 작품수정(exhibitionUpdate : DB수정)
	public int exhibitionUpdate(ExhibitionDTO exhibitionDTO);
	
	

}
