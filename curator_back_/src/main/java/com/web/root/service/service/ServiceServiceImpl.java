package com.web.root.service.service;

import java.util.List;

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

	
	
}