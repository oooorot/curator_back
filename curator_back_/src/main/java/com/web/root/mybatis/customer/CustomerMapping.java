package com.web.root.mybatis.customer;

import java.util.List;
import java.util.Map;

import com.web.root.customer.dto.CustomerHelpDTO;
import com.web.root.customer.dto.PurchaseDTO;

public interface CustomerMapping {
	
	public List<PurchaseDTO> purchaseProduct(Map<String, Object> map);
	
	public int customerHelpList(int memberSeq);
	
	public List<CustomerHelpDTO> customerReplyList(int memberSeq, int helpSeq);

}
