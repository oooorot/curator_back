package com.web.root.commission.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.web.root.commission.dto.CommissionDTO;
import com.web.root.mybatis.commission.CommissionMapper;

@Service
public class CommissionServiceImpl implements CommissionService{

	@Autowired
	private CommissionMapper mapper;
	
	// 의뢰 게시글 목록 불러오기
	@Override
	public List<CommissionDTO> commAllList() {
		try {
			List<CommissionDTO> list = mapper.commAllList();
			return list;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	// 의뢰 게시글 조회
	@Override
	public CommissionDTO commissionView(int commSeq) {
		try {
			CommissionDTO dto = mapper.commissionView(commSeq);
			return dto;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	// 의뢰 게시글 등록
	@Override
	public int commissionWrite(CommissionDTO dto) {
		
		int res = 0;
		try {
			CommissionDTO commDTO = new CommissionDTO();
			commDTO.setArtistSeq(dto.getArtistSeq());
			commDTO.setMemberSeq(dto.getMemberSeq());
			commDTO.setCommTitle(dto.getCommTitle());
			commDTO.setCommContent(dto.getCommContent());			
			res = mapper.commissionWrite(dto);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return res;
	}
	
	
	// 수정 할 글 불러오기
	@Override
	public CommissionDTO updateView(int commSeq) {
		try {
			CommissionDTO dto = mapper.updateView(commSeq);
			return dto;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	

	// 의뢰 게시글 수정
	@Override
	public int commissionUpdate(CommissionDTO dto) {
		CommissionDTO commDTO = new CommissionDTO();
		commDTO = mapper.updateView(dto.getCommSeq());
		try {
			if(dto.getCommTitle()!=null&dto.getCommContent()!=null) {
				commDTO.setCommTitle(dto.getCommTitle());
				commDTO.setCommContent(dto.getCommContent());
				return mapper.commissionUpdate(dto);
			} else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	// 의뢰 게시글 삭제
	@Override
	public int commissionDelete(int commSeq) {
		try {
			int res = mapper.commissionDelete(commSeq);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	


}
