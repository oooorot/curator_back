

package com.web.root.reply.service;

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

}
