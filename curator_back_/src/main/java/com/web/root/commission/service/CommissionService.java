package com.web.root.commission.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.web.root.commission.dto.CommissionDTO;

public interface CommissionService {

	public List<CommissionDTO> commAllList();
	
	public int commissionWrite(Map<String, Object> map);
	
	public String saveImageFile(CommissionDTO dto, MultipartFile multipartFile);
	
}
