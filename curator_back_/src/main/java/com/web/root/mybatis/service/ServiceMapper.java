package com.web.root.mybatis.service;

import java.util.List;
import java.util.Map;

import com.web.root.service.dto.ServiceDTO;

public interface ServiceMapper {
	
	public List<ServiceDTO> helpAllList();
	
	public int helpWrite(Map<String, Object> map);

}
