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
	
	@Override
	public List<CommissionDTO> commAllList() {
		List<CommissionDTO> list = mapper.commAllList();
		return list;
	}

	@Override
	public CommissionDTO commissionView(int commSeq) {
		CommissionDTO dto = mapper.commissionView(commSeq);
		return dto;
	}


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
	
	
	@Override
	public CommissionDTO updateView(int commSeq) {
		CommissionDTO dto = mapper.updateView(commSeq);
		return dto;
	}
	

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
