package com.web.root.member.controller;

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

import com.web.root.member.dto.LoginDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.member.service.MemberRegisterMail;
import com.web.root.member.service.MemberService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRegisterMail memberRegisterMail;
	
	// 로그인
	@PostMapping(value="login", produces = "application/json; charset=utf-8")
	@ResponseBody
	public LoginDTO login(@RequestBody Map<String, Object> map) {
		return memberService.login(map);
	}		
	
	// 회원정보
	@PostMapping(value="memberInfo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public MemberDTO memberInfo(@RequestBody Map<String, Object> map) {
		return memberService.memberInfo(map);
	}
	
	// 회원가입
	@PostMapping(value="registerCode", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String registerCode(@RequestParam String memberEmail) throws Exception {
		return memberRegisterMail.registerCode(memberEmail);
	}
	
	@PostMapping(value="register", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int register(@RequestBody Map<String, Object> map) {
		return memberService.register(map);
	}
	
	// 회원 정보 수정
	@PutMapping(value="memberUpdate", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int memberUpdate(@RequestBody Map<String, Object> map) {
		return memberService.memberUpdate(map);
	}
	
	// 회원 탈퇴
	@DeleteMapping(value="memberDelete", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int memberDelete(@RequestParam("memberEmail") String loginEmail) {
		return memberService.memberDelete(loginEmail);
	}

}
















