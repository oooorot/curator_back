package com.web.root.customer.service;

import java.util.List;
import java.util.Map;

import com.web.root.customer.dto.CustomerDTO;
import com.web.root.service.dto.ServiceDTO;

public interface CustomerService {

	public List<CustomerDTO> purchaseProduct(Map<String, Object> map);
	
	public List<ServiceDTO> customerHelpList(int memberSeq);
	
}
