


package com.web.root.mybatis.reply;

import com.web.root.reply.dto.ReplyDTO;

public interface ReplyMapper {

	public ReplyDTO ReplyView(int helpSeq);
	
	public int ReplyPost(int helpSeq, int memberSeq, String replyContent);

}
