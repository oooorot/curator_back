


package com.web.root.exhibition.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.exhibition.dto.ExhibitionDTO;
import com.web.root.exhibition.service.ExhibitionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService exhibitionService;
	
	@GetMapping(value = "exhibitionList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<ExhibitionDTO> exhibitionList() {
		return exhibitionService.exhibitionList();
	}
	
	@GetMapping(value = "exhibitionView", produces = "application/json; charset=utf8")
	@ResponseBody
	public ExhibitionDTO exhibitionView(@RequestParam("exhibitionSeq") int exhibitionSeq) {
		return exhibitionService.exhibitionView(exhibitionSeq);
	}
	
//	@PostMapping(value = "ExhibitionWrite", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//	@ResponseBody
//	public String exhibitionWrite(@RequestPart(value = "dto") ExhibitionDTO dto, @RequestPart(value = "file", required = false) MultipartFile multipartFile) {
//		service.exhibitionWrite(dto, multipartFile);
//		return "success";
//	}

}
