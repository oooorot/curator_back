


package com.web.root.reply.service;

import java.util.Map;

import com.web.root.reply.dto.ReplyDTO;

public interface ReplyService {
	
	public ReplyDTO ReplyView(int helpSeq);
	
	public int ReplyPost(Map<String, String> map);

}
