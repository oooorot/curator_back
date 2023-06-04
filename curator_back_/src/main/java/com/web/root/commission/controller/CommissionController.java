package com.web.root.commission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.commission.dto.CommissionDTO;
import com.web.root.commission.service.CommissionService;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class CommissionController {

	@Autowired
	private CommissionService service; 
	
	
	// 의뢰 게시글 목록 불러오기 
	@GetMapping(value = "commAllList",  produces = "application/json; charset=utf8")
	@ResponseBody
	public List<CommissionDTO> commAllList(){
		return service.commAllList();
	}
	
	// 의뢰 게시글 조회
	@GetMapping(value="commissionView", produces = "application/json; charset=utf8")
	@ResponseBody
	public CommissionDTO commissionView(@RequestParam("commSeq") int commSeq) {
		return service.commissionView(commSeq);
	}
	
	
	// 의뢰 게시글 등록
	@PostMapping(value="commissionWrite", produces = "application/json; charset=utf8")
	@ResponseBody
	public int commissionWrite(@RequestBody CommissionDTO dto) {
		return service.commissionWrite(dto);
	}
	
	// 수정 할 글 불러오기
	@GetMapping(value="updateView", produces = "application/json; charset=utf8")
	@ResponseBody
	public CommissionDTO updateView(@RequestParam("commSeq") int commSeq) {
		return service.updateView(commSeq);
	}

	// 의뢰 게시글 수정
	@PutMapping(value="commissionUpdate", produces = "application/json; charset=utf8")
	@ResponseBody
	public int commissionUpdate(@RequestBody CommissionDTO dto) {
		return service.commissionUpdate(dto);
	}
	
	// 의뢰 게시글 삭제
	@GetMapping(value="commissionDelete", produces = "application/json; charset=utf8")
	@ResponseBody
	public int commissionDelete(@RequestParam("commSeq") int commSeq) {
		return service.commissionDelete(commSeq);
	}
	
}
