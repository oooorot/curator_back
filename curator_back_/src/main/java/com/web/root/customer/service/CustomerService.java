package com.web.root.customer.service;

import java.util.List;
import java.util.Map;

import com.web.root.customer.dto.CustomerDTO;

public interface CustomerService {

	public List<CustomerDTO> purchaseProduct(Map<String, Object> map);
	
}
