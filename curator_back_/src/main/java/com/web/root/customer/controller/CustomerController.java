package com.web.root.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.customer.dto.CustomerDTO;
import com.web.root.customer.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	// 구매내역
	@PostMapping(value="purchaseProduct", produces = "application/json; charset=utf-8")
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
	
}





















