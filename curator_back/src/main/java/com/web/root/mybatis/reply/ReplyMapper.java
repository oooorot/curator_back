


package com.web.root.mybatis.reply;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.root.reply.dto.ReplyDTO;

public interface ReplyMapper {

	public List<ReplyDTO> ReplyView(int helpSeq);
	
	public int ReplyPost(@Param("helpSeq") int helpSeq, @Param("memberSeq") int memberSeq, @Param("replyContent") String replyContent);

}
