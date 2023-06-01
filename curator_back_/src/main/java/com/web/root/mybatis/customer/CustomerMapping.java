package com.web.root.mybatis.customer;

import java.util.List;
import java.util.Map;

import com.web.root.customer.dto.CustomerDTO;

public interface CustomerMapping {
	
	public List<CustomerDTO> purchaseProduct(Map<String, Object> map);

}
