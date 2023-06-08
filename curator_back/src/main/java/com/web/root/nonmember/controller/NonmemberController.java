package com.web.root.nonmember.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.nonmember.dto.NonmemberDTO;
import com.web.root.nonmember.service.NonmemberService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class NonmemberController {

	@Autowired
	private NonmemberService NonmemberService;
	
	// 비회원 정보 가져오기 
	@GetMapping(value="getNonmember", produces = "application/json; charset=utf8")
	@ResponseBody
	public NonmemberDTO getNonmember(@RequestParam("nonSeq") int nonSeq) {
		return NonmemberService.getNonmember(nonSeq);
	}
	
	// 비회원 구매시 정보 입력 
	@PostMapping(value="nonmemberInform", produces = "application/json; charset=utf8")
	@ResponseBody
	public int nonmemberInform(@RequestBody Map<String, Object> map) {
		return NonmemberService.nonmemberInform(map);
	}
	
	
	
	
}
