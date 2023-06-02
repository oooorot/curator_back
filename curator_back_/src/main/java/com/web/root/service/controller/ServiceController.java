package com.web.root.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.service.dto.ServiceDTO;
import com.web.root.service.service.ServiceService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceController {

	@Autowired
	private ServiceService service;
	
	@GetMapping(value = "helpAllList", produces = "application/json; charset=utf8")
	public List<ServiceDTO> helpAllList(){
		return service.helpAllList();
	}
	
	@PostMapping(value = "HelpWrite", produces = "application/json; charset=utf8")
	@ResponseBody
	public int helpWrite(@RequestBody Map<String, Object> map) {
		return service.helpWritre(map);
	}
	
	
	
}
