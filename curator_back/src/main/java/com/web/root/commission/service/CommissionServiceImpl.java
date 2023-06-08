package com.web.root.commission.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.web.root.commission.dto.CommissionDTO;
import com.web.root.mybatis.commission.CommissionMapper;

@Service
public class CommissionServiceImpl implements CommissionService{

	@Autowired
	private CommissionMapper commissionMapper;
	
	// 의뢰 게시글 목록 불러오기
	@Override
	public List<CommissionDTO> commAllList() {
		try {
			List<CommissionDTO> list = commissionMapper.commAllList();
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
			CommissionDTO commissionDTO = commissionMapper.commissionView(commSeq);
			return commissionDTO;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	// 의뢰 게시글 등록
	@Override
	public int commissionWrite(CommissionDTO commissionDTO) {
		
		int res = 0;
		try {
			CommissionDTO commDTO = new CommissionDTO();
			commDTO.setArtistSeq(commissionDTO.getArtistSeq());
			commDTO.setMemberSeq(commissionDTO.getMemberSeq());
			commDTO.setCommTitle(commissionDTO.getCommTitle());
			commDTO.setCommContent(commissionDTO.getCommContent());			
			res = commissionMapper.commissionWrite(commissionDTO);
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
			CommissionDTO commissionDTO = commissionMapper.updateView(commSeq);
			return commissionDTO;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	

	// 의뢰 게시글 수정
	@Override
	public int commissionUpdate(CommissionDTO commissionDTO) {
		CommissionDTO commDTO = new CommissionDTO();
		commDTO = commissionMapper.updateView(commissionDTO.getCommSeq());
		try {
			if(commissionDTO.getCommTitle()!=null&commissionDTO.getCommContent()!=null) {
				commDTO.setCommTitle(commissionDTO.getCommTitle());
				commDTO.setCommContent(commissionDTO.getCommContent());
				return commissionMapper.commissionUpdate(commissionDTO);
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
			int res = commissionMapper.commissionDelete(commSeq);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	


}
