package com.web.root.mybatis.service;

import java.util.List;
import java.util.Map;

import com.web.root.service.dto.ServiceDTO;

public interface ServiceMapper {
	
	// 상담 게시글 불러오기
	public List<ServiceDTO> helpAllList();
	
	// 상담 게시글 조회 
	public ServiceDTO helpView(int helpSeq);
	
	// 상담 게시글 등록
	public int helpWrite(Map<String, Object> map);
	
	// 수정할 글 불러오기
	public ServiceDTO updateHelpView(int helpSeq);
	
	//상담 게시글 수정
	public int helpUpdate(Map<String, Object> map);
	
	//상담 게시글 삭제
	public int helpDelete(int helpSeq);

}
