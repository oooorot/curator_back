package com.web.root.mybatis.customer;

import java.util.List;
import java.util.Map;

import com.web.root.customer.dto.PurchaseDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.reply.dto.ReplyDTO;
import com.web.root.service.dto.ServiceDTO;

public interface CustomerMapper {
	
	// 회원정보
	public MemberDTO memberInfo(int MemberSeq);
	
	// 회원정보 수정
	public int memberUpdate(Map<String, Object> map);
	
	// 회원탈퇴
	public int memberDelete(int MemberSeq);

	// 구매내역
	public List<PurchaseDTO> purchaseProduct(Map<String, Object> map);
	
	// 나의문의
	public List<ServiceDTO> customerHelpList(int memberSeq);
	
	// 답변
	public List<ReplyDTO> customerReplyList(int helpSeq, int memberSeq);

}
