package com.web.root.commission.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.root.commission.dto.CommissionDTO;

@Service
public interface CommissionService {

	// 의뢰 게시글 목록 불러오기
	public List<CommissionDTO> commAllList();
	
	// 의뢰 게시글 조회
	public CommissionDTO commissionView(int commSeq);
	
	// 의뢰 게시글 등록
	public int commissionWrite(CommissionDTO commissionDTO);
	
	// 수정 할 글 불러오기
	public CommissionDTO updateView(int commSeq);
	
	// 의뢰 게시글 수정
	public int commissionUpdate(CommissionDTO commissionDTO);

	// 의뢰 게시글 삭제
	public int commissionDelete(Map<String, String> map);
	
}
