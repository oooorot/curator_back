package com.web.root.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.admin.service.AdminService;
import com.web.root.artist.dto.ArtistDTO;
import com.web.root.member.dto.MemberDTO;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class AdminController {
	
	@Autowired
	public AdminService adminService;
	
	// 회원관리
	@GetMapping(value="adminCustomerList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<MemberDTO> adminCustomerList(){
		return adminService.adminCustomerList();
	}
	
	// 작가관리
	@GetMapping(value="adminArtistList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<ArtistDTO> adminArtistList(){
		return adminService.adminArtistList();
	}
	
	// 임의 회원탈퇴
	@DeleteMapping(value="adminMemberDelete", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int adminMemberDelete(@RequestBody Map<String, Object> map) {
		return adminService.adminMemberDelete(map);
	}
}





