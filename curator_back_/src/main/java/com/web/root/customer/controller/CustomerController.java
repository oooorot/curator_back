package com.web.root.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.customer.dto.PurchaseDTO;
import com.web.root.customer.service.CustomerService;
import com.web.root.member.dto.MemberDTO;
import com.web.root.service.dto.ServiceDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;

	// 회원정보
	@PostMapping(value="memberInfo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public MemberDTO memberInfo(@RequestBody Map<String, Object> map) {
		return customerService.memberInfo(map);
	}
	
	// 회원정보 수정
	@PutMapping(value="memberUpdate", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int memberUpdate(@RequestBody Map<String, Object> map) {
		return customerService.memberUpdate(map);
	}
	
	// 회원 탈퇴
	@DeleteMapping(value="memberDelete", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int memberDelete(@RequestParam("MemberSeq") int MemberSeq) {
		return customerService.memberDelete(MemberSeq);
	}
	
	// 구매내역
	@GetMapping(value="purchaseProduct", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<PurchaseDTO> purchaseProduct(@RequestBody Map<String, Object> map) {
		return customerService.purchaseProduct(map); 
	}

//	// 즐겨찾는 작가
//	@PostMapping(value="bookmarkProduct", produces = "application/json; charset=utf-8")
//	@ResponseBody 
//	public 
	
	// 나의문의
	@GetMapping(value="customerHelpList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<ServiceDTO> customerHelpList(@RequestParam("memberSeq") int memberSeq){
		 return customerService.customerHelpList(memberSeq);
	 }
	
	// 답변
	@PutMapping(value="cutomerReply", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int customerReply(@RequestBody Map<String, Object> map){
		return customerService.customerReply(map);
	}
}





















