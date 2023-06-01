package com.web.root.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
