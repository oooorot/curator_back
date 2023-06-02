package com.web.root.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.root.customer.dto.PurchaseDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.customer.CustomerMapper;
import com.web.root.service.dto.ServiceDTO;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	public CustomerMapper customerMapper;
	
	// 회원정보
	@Override
	public MemberDTO memberInfo(Map<String, Object> map) {
		MemberDTO memberDTO = customerMapper.memberInfo(Integer.parseInt(map.get("MemberSeq").toString()));
		return memberDTO; 
	}

	// 회원정보 수정
	@Override
	public int memberUpdate(Map<String, Object> map) {
		try {
			if(map.get("memberPw")!=null&map.get("memberNickname")!=null&map.get("memberName")!=null&map.get("memberPhone")!=null&map.get("memberAddr")!=null) {
				return customerMapper.memberUpdate(map);
			} else return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// 회원탈퇴
	@Override
	public int memberDelete(int MemberSeq) {
		try {
			return customerMapper.memberDelete(MemberSeq);
		} catch (Exception e) {
			return 0;
		}
		
	}

	// 구매내역
	@Override
	public List<PurchaseDTO> purchaseProduct(Map<String, Object> map) {
		List<PurchaseDTO> purchaseList = customerMapper.purchaseProduct(map);
		return purchaseList;
	}

	// 나의문의
	@Override
	public List<ServiceDTO> customerHelpList(int memberSeq) { 
		return customerMapper.customerHelpList(memberSeq);
	}
	
	// 답변
	@Override
	public int customerReply(@RequestBody Map<String, Object> map) {
		return customerMapper.customerReply(map);
	}
	
}















