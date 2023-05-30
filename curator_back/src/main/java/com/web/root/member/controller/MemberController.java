package com.web.root.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.member.dto.MemberDTO;
import com.web.root.member.service.MemberService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping(value="userCheck", produces = "application/json; charset=utf-8")
	@ResponseBody
	public MemberDTO userCheck(@RequestBody MemberDTO memberDTO) {
		return memberService.userCheck(memberDTO);
	}
	
	/*
	 * @PostMapping(value="successLogin", produces =
	 * "application/json; charset=utf-8")
	 * 
	 * @ResponseBody public void successLogin(@RequestBody MemberDTO memberDTO,
	 * HttpSession session){ session.setAttribute("loginSeq",
	 * memberDTO.getMemberSeq()); session.setAttribute("loginEmail",
	 * memberDTO.getMemberEmail()); session.setAttribute("loginPw",
	 * memberDTO.getMemberPw()); session.setAttribute("loginNickname",
	 * memberDTO.getMemberNickname()); // DTO 파라미터명들과 구분되게 login + "" }
	 */
	
	@GetMapping(value="logout", produces = "application/json; charset=utf-8")
	@ResponseBody
	public void logout(HttpSession session) {
		if(session.getAttribute("loginSeq") != null) {
			session.invalidate();
		}
	}
	
	@GetMapping(value="memberInfo", produces = "application/json; charset=utf-8")
	public List<MemberDTO> memberInfo(HttpSession session) {
		return memberService.memberInfo(session);
	}
	
	/*
	 * @GetMapping(value="info", produces = "application/json; charset=utf-8")
	 * public
	 */
	
	@PostMapping(value="register", produces = "application/json; charset=utf-8")
	public void register(@RequestBody Map<String, Object> map) {
		memberService.register(map);
	}

}
















