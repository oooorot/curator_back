

package com.web.root.reply.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.mybatis.reply.ReplyMapper;
import com.web.root.reply.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	public ReplyMapper replyMapper;
	
	@Override
	public ReplyDTO ReplyView(int helpSeq) {
		
		ReplyDTO replyDTO = replyMapper.ReplyView(helpSeq);
		return replyDTO;

	}
	
	@Override
	public int ReplyPost(Map<String, String> map) {
		int helpSeq = Integer.parseInt(map.get("helpSeq").toString());
		int memberSeq = Integer.parseInt(map.get("memberSeq").toString());
		String replyContent = map.get("replyContent");
		
		replyMapper.ReplyPost(helpSeq, memberSeq, replyContent);
				
		return 0;
	}

}
