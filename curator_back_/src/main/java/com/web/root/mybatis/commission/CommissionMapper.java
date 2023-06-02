package com.web.root.mybatis.commission;

import java.util.List;

import com.web.root.commission.dto.CommissionDTO;

public interface CommissionMapper {

	public List<CommissionDTO> commAllList();
	
	public CommissionDTO commissionView(int commSeq);
	
	public int commissionWrite(CommissionDTO CommDTO);
	
	public CommissionDTO updateView(int commSeq);
	
	public int commissionUpdate(CommissionDTO dto);
	
	public int commissionDelete(int commSeq);
	
}
