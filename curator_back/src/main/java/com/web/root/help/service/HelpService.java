package com.web.root.help.service;

import java.util.List;
import java.util.Map;

import com.web.root.help.dto.HelpDTO;

public interface HelpService {

	// 상담 게시글 불러오기
	public List<HelpDTO> helpAllList();
	
	// 상담 게시글 조회
	public HelpDTO helpView(int helpSeq);
	
	// 상담 게시글 등록
	public int helpWrite(Map<String, Object> map);
	
	// 수정할 글 불러오기
	public HelpDTO updateHelpView(int helpSeq);
	
	// 상담 게시글 수정 
	public int helpUpdate(Map<String, Object> map);
	
	// 상담 게시글 삭제
	public int helpDelete(Map<String, Object> map);

}
