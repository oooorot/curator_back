package com.web.root.help.controller;

import java.util.List;
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

import com.web.root.help.dto.HelpDTO;
import com.web.root.help.service.HelpService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelpController {

	@Autowired
	private HelpService helpService;
	
	// 상담 게시글 불러오기
	@GetMapping(value = "helpAllList", produces = "application/json; charset=utf8")
	public List<HelpDTO> helpAllList(){
		return helpService.helpAllList();
	}
	
	// 상담 게시글 조회 
	@GetMapping(value="helpView",produces = "application/json; charset=utf8")
	@ResponseBody
	public HelpDTO helpView(@RequestParam("helpSeq") int helpSeq ) {
		return helpService.helpView(helpSeq);
	}
	
	// 상담 게시글 등록
	@PostMapping(value="helpWrite", produces = "application/json; charset=utf8")
	@ResponseBody
	public int helpWrite(@RequestBody Map<String, Object> map) {
		return helpService.helpWrite(map);
	}
	
	// 수정할 글 불러오기
	@GetMapping(value="updateHelpView", produces = "application/json; charset=utf8")
	@ResponseBody
	public HelpDTO updateHelpView(@RequestParam("helpSeq") int helpSeq ) {
		return helpService.updateHelpView(helpSeq);
	}
	
	// 상담 게시글 수정 
	@PutMapping(value ="helpUpdate", produces = "application/json; charset=utf8")
	public int helpUpdate(@RequestBody Map<String, Object> map) {
		return helpService.helpUpdate(map);
		
	}
	
	// 상담 게시글 삭제
	@DeleteMapping(value="helpDelete", produces = "application/json; charset=utf8")
	@ResponseBody
	public int helpDelete(@RequestBody Map<String, Object> map) {
		return helpService.helpDelete(map);
	}
	
}
