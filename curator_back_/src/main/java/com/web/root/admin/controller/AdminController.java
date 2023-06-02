package com.web.root.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.admin.service.AdminService;
import com.web.root.member.dto.MemberDTO;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class AdminController {
	
	@Autowired
	public AdminService adminService;
	
	//회원관리(클릭하면 개개인 상세정보 수정은 x)
	@GetMapping(value="AdminCustomerList")
	@ResponseBody
	public List<MemberDTO> AdminCustomerList(){
		return adminService.AdminCustomerList();
	}
	

}
