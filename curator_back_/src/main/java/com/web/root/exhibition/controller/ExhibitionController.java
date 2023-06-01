


package com.web.root.exhibition.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.exhibition.dto.ExhibitionDTO;
import com.web.root.exhibition.service.ExhibitionService;

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

}
