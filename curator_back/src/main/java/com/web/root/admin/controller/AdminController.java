package com.web.root.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	

//	@PostMapping(value="adminArtistAdd", produces = "application/json; charset=utf-8")
//	@ResponseBody
//	public int adminArtistAdd(@RequestBody Map<String, Object> map) {
//		return adminService.adminArtistAdd(map);
//	}
	
	// 작가등록
	@PostMapping(value = "adminArtistAdd", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public String fileTest(@RequestPart(value = "dto") ArtistDTO dto, @RequestPart(value = "file", required = false) MultipartFile multipartFile) {
		System.out.println(dto.getArtistName());
		System.out.println(multipartFile.getOriginalFilename());
		adminService.fileProcess(dto, multipartFile);
		
		return "success";
	}
	
	// 작가관리
	@GetMapping(value="adminArtistList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<ArtistDTO> adminArtistList(){
		return adminService.adminArtistList();
	}
	
	// 그림 등급 관리
	@PutMapping(value="adminPostAuction", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int adminPostAuction(@RequestParam("postSeq") int postSeq, @RequestParam("postGrade") int postAuction) {
		return adminService.adminPostAuction(postSeq, postAuction);
	}
	
	// 임의 회원탈퇴
	@DeleteMapping(value="adminMemberDelete", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int adminMemberDelete(@RequestBody Map<String, Object> map) {
		return adminService.adminMemberDelete(map);
	}
}
