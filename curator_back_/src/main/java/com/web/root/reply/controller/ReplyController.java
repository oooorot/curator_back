


package com.web.root.reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.reply.dto.ReplyDTO;
import com.web.root.reply.service.ReplyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReplyController {
	
	@Autowired
	public ReplyService service;
	
	
	@GetMapping(value = "replyView", produces = "application/json; charset=utf8")
	@ResponseBody
	public ReplyDTO replyView(@RequestParam("helpSeq") int helpSeq) {
		return service.ReplyView(helpSeq);
	}
	

}
