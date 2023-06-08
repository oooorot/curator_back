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
		try {
			List<ServiceDTO> list = mapper.helpAllList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int helpWritre(Map<String, Object> map) {
		
		try {
			int res = mapper.helpWrite(map);
			return res;
		}catch (Exception e) {
			return 0;
		}
		
	}
	
	
}
