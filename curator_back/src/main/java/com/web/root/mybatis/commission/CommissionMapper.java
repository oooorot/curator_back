package com.web.root.mybatis.commission;

import java.util.List;

import com.web.root.commission.dto.CommissionDTO;

public interface CommissionMapper {

	public List<CommissionDTO> commAllList();
	
	public int commissionWrite(CommissionDTO dto);
	
	public int saveImageFile(CommissionDTO dto);
	
}
