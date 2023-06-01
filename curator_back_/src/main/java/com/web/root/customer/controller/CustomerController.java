package com.web.root.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.customer.dto.CustomerDTO;
import com.web.root.customer.service.CustomerService;
import com.web.root.service.dto.ServiceDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	// 구매내역
	@GetMapping(value="purchaseProduct", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<CustomerDTO> purchaseProduct(@RequestBody Map<String, Object> map) {
		return customerService.purchaseProduct(map); 
	}
	
	/*
	 * // 즐겨찾는 작가
	 * 
	 * @PostMapping(value="bookmarkProduct", produces =
	 * "application/json; charset=utf-8")
	 * 
	 * @ResponseBody public
	 */
	
	// 나의문의
	@GetMapping(value="customerHelpList")
	@ResponseBody
	public List<ServiceDTO> customerHelpList(@RequestParam("memberSeq") int memberSeq){
		 return customerService.customerHelpList(memberSeq);
	 }
	

	
}





















