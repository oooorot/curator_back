package com.web.root.commission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.root.commission.dto.CommissionDTO;

@Service
public interface CommissionService {

	public List<CommissionDTO> commAllList();
	
	public CommissionDTO commissionView(int commSeq);
	
	public int commissionWrite(CommissionDTO dto);
	
	public CommissionDTO updateView(int commSeq);
	
	public int commissionUpdate(CommissionDTO dto);
	
	public int commissionDelete(int commSeq);
	
}
