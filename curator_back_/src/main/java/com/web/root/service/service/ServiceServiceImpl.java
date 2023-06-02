package com.web.root.service.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.mybatis.service.ServiceMapper;
import com.web.root.service.dto.ServiceDTO;


@Service
public class ServiceServiceImpl implements ServiceService{

	@Autowired
	private ServiceMapper mapper;
	
	@Override
	public List<ServiceDTO> helpAllList() {
		List<ServiceDTO> list = mapper.helpAllList();
		return list;
	}
	
	

	@Override
	public ServiceDTO helpView(int helpSeq) {
		ServiceDTO dto = mapper.helpView(helpSeq);
		return dto;
	}



	@Override
	public int helpWrite(Map<String, Object> map) {
		int res = 0;
		try {
			ServiceDTO dto = new ServiceDTO();
			dto.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
			dto.setHelpTitle(map.get("helpTitle").toString());
			dto.setHelpContent(map.get("helpContent").toString());
			res = mapper.helpWrite(map);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return res;
	}
	
	@Override
	public ServiceDTO updateView(int helpSeq) {
		ServiceDTO dto = mapper.updateView(helpSeq);
		return dto;
	}


	@Override
	public int helpUpdate(Map<String, Object> map) {
		updateView(Integer.parseInt(map.get("helpSeq").toString()));
		try {
			if(map.get("helpTitle")!=null & map.get("helpContent") != null) {
				return mapper.helpUpdate(map);
			} else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int helpDelete(Map<String, Object> map) {
		try {
			ServiceDTO dto = new ServiceDTO();
			dto.setHelpSeq(Integer.parseInt(map.get("helpSeq").toString()));
			int res = mapper.helpDelete(map);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	
	
}
