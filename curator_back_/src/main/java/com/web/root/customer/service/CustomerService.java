package com.web.root.customer.service;

import java.util.List;
import java.util.Map;

import com.web.root.customer.dto.CustomerHelpDTO;
import com.web.root.customer.dto.PurchaseDTO;

public interface CustomerService {

	public List<PurchaseDTO> purchaseProduct(Map<String, Object> map);
	
	public List<CustomerHelpDTO> customerHelpList(int memberSeq);
	
}
