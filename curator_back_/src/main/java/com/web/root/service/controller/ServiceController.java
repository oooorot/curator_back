package com.web.root.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.service.dto.ServiceDTO;
import com.web.root.service.service.ServiceService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceController {

	@Autowired
	private ServiceService service;
	
	// 상담 게시글 불러오기
	@GetMapping(value = "helpAllList", produces = "application/json; charset=utf8")
	public List<ServiceDTO> helpAllList(){
		return service.helpAllList();
	}
	
	
	// 상담 게시글 조회 
	@GetMapping(value="helpView",produces = "application/json; charset=utf8")
	@ResponseBody
	public ServiceDTO helpView(@RequestParam("helpSeq") int helpSeq ) {
		return service.helpView(helpSeq);
	}
	
	@PostMapping(value="helpWrite", produces = "application/json; charset=utf8")
	@ResponseBody
	public int helpWrite(@RequestBody Map<String, Object> map) {
		return service.helpWrite(map);
	}
	
	// 수정할 글 불러오기 // helpSeq로 dto 요청
	@GetMapping(value="updateHelpView", produces = "application/json; charset=utf8")
	@ResponseBody
	public ServiceDTO updateView(@RequestParam("helpSeq") int helpSeq ) {
		return service.updateView(helpSeq);
	}
	
	//상담 게시글 수정 
	@PutMapping(value ="helpUpdate", produces = "application/json; charset=utf8")
	public int helpUpdate(@RequestBody Map<String, Object> map) {
		return service.helpUpdate(map);
		
	}
	
	//상담 게시글 삭제
	@DeleteMapping(value="helpDelete", produces = "application/json; charset=utf8")
	@ResponseBody
	public int helpDelete(@RequestBody Map<String, Object> map) {
		return service.helpDelete(map);
	}
	
}
