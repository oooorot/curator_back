package com.web.root.commission.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.commission.dto.CommissionDTO;
import com.web.root.commission.service.CommissionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CommissionController {

	@Autowired
	private CommissionService service; 
	
	@GetMapping(value = "commAllList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<CommissionDTO> commAllList(){
		return service.commAllList();
	}
	
	// 게시글 불러오기
	@GetMapping(value="commGetList/{commSeq}")
	
	@PostMapping(value="commissionWrite", produces="application/json; charset=utf8", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public void commissionWrite(@RequestBody Map<String, Object> map, @RequestPart(value = "file", required = false) MultipartFile multipartFile) {
		service.commissionWrite(map, multipartFile);
	}
	
//	@PostMapping(value = "commImage", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//	@ResponseBody
//	public String fileTest(@RequestPart(value = "dto") CommissionDTO dto, @RequestPart(value = "file", required = false) MultipartFile multipartFile) {
//		service.saveImageFile(dto, multipartFile);
//		return "success";
//	}
	
	@PutMapping(value = "test2", produces = "application/json; charset=utf8")
	@ResponseBody
	public void commissionUpdate(@RequestBody Map<String, Object> map) {
		service.commissionUpdate(map);
	}
	
	
}
