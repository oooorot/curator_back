package com.web.root.mybatis.commission;

import java.util.List;

import com.web.root.commission.dto.CommissionDTO;

public interface CommissionMapper {

	// 의뢰 게시글 목록 불러오기
	public List<CommissionDTO> commAllList();
	
	// 의뢰 게시글 조회
	public CommissionDTO commissionView(int commSeq);
	
	// 의뢰 게시글 등록
	public int commissionWrite(CommissionDTO CommDTO);
	
	// 수정 할 글 불러오기
	public CommissionDTO updateView(int commSeq);
	
	// 의뢰 게시글 수정
	public int commissionUpdate(CommissionDTO commDTO);
	
	// 의뢰 게시글 삭제
	public int commissionDelete(int commSeq);
	
}
