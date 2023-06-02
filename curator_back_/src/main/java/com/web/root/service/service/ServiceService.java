package com.web.root.service.service;

import java.util.List;
import java.util.Map;

import com.web.root.service.dto.ServiceDTO;

public interface ServiceService {

	public List<ServiceDTO> helpAllList();
	
	public int helpWritre(Map<String, Object> map);
	
	public ServiceDTO helpView(int helpSeq);
	
	public int helpWrite(Map<String, Object> map);
	
	public ServiceDTO updateView(int helpSeq);
	
	public int helpUpdate(Map<String, Object> map);
	
	public int helpDelete(Map<String, Object> map);

}
