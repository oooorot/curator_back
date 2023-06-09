


package com.web.root.exhibition.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.exhibition.dto.ExhibitionDTO;
import com.web.root.exhibition.service.ExhibitionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService exhibitionService;
	
	// 전시회 리스트
	@GetMapping(value = "exhibitionList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<ExhibitionDTO> exhibitionList() {
		return exhibitionService.exhibitionList();
	}
	
	// 전시회 조회
	@GetMapping(value = "exhibitionView", produces = "application/json; charset=utf8")
	@ResponseBody
	public ExhibitionDTO exhibitionView(@RequestParam("exhibitionSeq") int exhibitionSeq) throws IOException {
		return exhibitionService.exhibitionView(exhibitionSeq);
	} 
	   
	// 전시회 등록
	@PostMapping(value="exhibitionWrite", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public int exhibitionWrite(@RequestPart(value="exhibitionDTO") ExhibitionDTO exhibitionDTO, @RequestPart(value="exhibitionBanner", required=false) MultipartFile multipartFile) {
	    return exhibitionService.exhibitionWrite(exhibitionDTO, multipartFile);
	}
	   
	// 전시회 수정
	@PutMapping(value="exhibitionUpdate", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public int exhibitionUpdate(@RequestPart(value="exhibitionDTO") ExhibitionDTO exhibitionDTO,  @RequestPart(value="exhibitionUpdateFile", required=false) MultipartFile multipartFile) {
	    return exhibitionService.exhibitionUpdate(exhibitionDTO, multipartFile);
	}

}
