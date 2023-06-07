package com.web.root.service.service;

import java.util.List;
import java.util.Map;

import com.web.root.service.dto.ServiceDTO;

public interface ServiceService {

	public List<ServiceDTO> helpAllList();
	
	public int helpWritre(Map<String, Object> map);

}
