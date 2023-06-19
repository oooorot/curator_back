

package com.web.root.reply.service;

import java.util.List;
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
	public List<ReplyDTO> ReplyView(int helpSeq) {
		
		List<ReplyDTO> replyDTO = replyMapper.ReplyView(helpSeq);
		return replyDTO;

	}
	
	@Override
	public int ReplyPost(Map<String, String> map) {
		int helpSeq = Integer.parseInt(map.get("helpSeq"));
		int memberSeq = Integer.parseInt(map.get("memberSeq"));
		String replyContent = map.get("replyContent");
		
		System.out.println(helpSeq);
		System.out.println(memberSeq);
		System.out.println(replyContent);
		
		int res = replyMapper.ReplyPost(helpSeq, memberSeq, replyContent);
				
		return res;
	}

}
