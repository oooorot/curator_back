package com.web.root.commission.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.commission.dto.CommissionDTO;

@Service
public interface CommissionService {

	public List<CommissionDTO> commAllList();
	
	public int commissionWrite(CommissionDTO dto, MultipartFile multipartFile);
	
//	public String saveImageFile(CommissionDTO dto, MultipartFile multipartFile);
	
	public void commissionUpdate(Map<String, Object> map);
}
