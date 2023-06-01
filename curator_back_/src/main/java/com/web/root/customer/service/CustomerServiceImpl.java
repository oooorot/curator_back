package com.web.root.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.customer.dto.CustomerHelpDTO;
import com.web.root.customer.dto.PurchaseDTO;
import com.web.root.mybatis.customer.CustomerMapping;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapping customerMapper;
	
	@Override
	public List<PurchaseDTO> purchaseProduct(Map<String, Object> map) {
		List<PurchaseDTO> purchaseList = customerMapper.purchaseProduct(map);
		return purchaseList;
	}

	@Override
	public List<CustomerHelpDTO> customerHelpList(int memberSeq) {
		int helpSeq = customerMapper.customerHelpList(memberSeq);
		return customerMapper.customerReplyList(memberSeq, helpSeq);
	}
	
	
	
}















