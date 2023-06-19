


package com.web.root.reply.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.reply.dto.ReplyDTO;
import com.web.root.reply.service.ReplyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReplyController {
	
	@Autowired
	public ReplyService replyService;

	
	@GetMapping(value = "replyView", produces = "application/json; charset=utf8")
	@ResponseBody
	public ReplyDTO replyView(@RequestParam("helpSeq") int helpSeq) {
		return replyService.ReplyView(helpSeq);
	}
	
	@PostMapping(value = "replyPost", produces = "application/json; charset=utf8")
	@ResponseBody
	public int replyPost(@RequestBody Map<String, String> map) {
		return replyService.ReplyPost(map);
	}
	
	
	
}
