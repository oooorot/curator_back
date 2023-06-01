


package com.web.root.exhibition.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.exhibition.dto.ExhibitionDTO;
import com.web.root.exhibition.service.ExhibitionService;
import com.web.root.post.dto.PostDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService service;
	
	@GetMapping(value = "ExhibitionList", produces = "application/json; charset=utf8")
	@ResponseBody
	public List<ExhibitionDTO> ExhibitionList() {
		return service.ExhibitionList();
	}
	
	@GetMapping(value = "ExhibitionView", produces = "application/json; charset=utf8")
	@ResponseBody
	public ExhibitionDTO ExhibitionView(@RequestParam Map<String, Object> map) {
		return service.ExhibitionView(map);
	}
	
	@PostMapping(value = "file", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseBody
	public String fileTest(@RequestPart(value = "dto") ExhibitionDTO dto, @RequestPart(value = "file", required = false) MultipartFile multipartFile) {
		System.out.println(dto.getExhibitionBanner());
		System.out.println(multipartFile.getOriginalFilename());
		service.fileProcess(dto, multipartFile);
		
		return "success";
	}

}
