package com.web.root.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.member.dto.LoginDTO;
import com.web.root.member.service.MemberRegisterMail;
import com.web.root.member.service.MemberService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRegisterMail memberRegisterMail;
	
	// 로그인 토큰 반환으로 변경예정
	@PostMapping(value="login", produces = "application/json; charset=utf-8")
	@ResponseBody
	public LoginDTO login(@RequestBody Map<String, Object> map) {
		return memberService.login(map);
	}		
	
	// 인증코드 발송
	@PostMapping(value="registerCode", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String registerCode(@RequestParam String memberEmail) throws Exception {
		return memberRegisterMail.registerCode(memberEmail);
	}
	
	// 인증코드 확인
	@PostMapping(value="registerCodeResult", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int registerCodeResult(@RequestBody Map<String, Object> map) {
		return memberService.registerCodeResult(map);
	}
	
	// 이메일 중복확인
	@GetMapping(value="emailCheck", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int emailCheck(@RequestParam("insertEmail") String insertEmail) throws Exception {
		return memberService.emailCheck(insertEmail);
	}
	
	// 회원가입
	@PostMapping(value="register", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int register(@RequestBody Map<String, Object> map) {
		return memberService.register(map);
	}

}
















