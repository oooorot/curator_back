package com.web.root.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.customer.dto.CustomerDTO;
import com.web.root.mybatis.customer.CustomerMapping;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapping customerMapper;
	
	@Override
	public List<CustomerDTO> purchaseProduct(Map<String, Object> map) {
		List<CustomerDTO> purchaseList = customerMapper.purchaseProduct(map);
		return purchaseList;
	}
	
	
	
}















