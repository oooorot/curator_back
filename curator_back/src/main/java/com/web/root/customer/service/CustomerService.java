package com.web.root.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.cart.dto.CartDTO;
import com.web.root.customer.dto.PurchaseDTO;
import com.web.root.help.dto.HelpDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.reply.dto.ReplyDTO;

public interface CustomerService {
	
	// 회원정보
	public MemberDTO memberInfo(Map<String, Object> map);
	
	// 회원정보수정
	public int memberUpdate(Map<String, Object> map);
	
	// 회원탈퇴
	public int memberDelete(int MemberSeq);
	
	// 장바구니
	public List<CartDTO> cartList(int memberSeq);
	
	// 장바구니 삭제
	public int cartDelect(int carSeq);
	
	// 구매내역
	public List<PurchaseDTO> purchaseProduct(Map<String, Object> map);
	
	// 즐겨찾기
	public List<BookmarkDTO> bookmarkArtistList(Map<String, Object> map);
	
	// 나의문의
	public List<HelpDTO> customerHelpList(int memberSeq);
	
	// 답변보기
	public List<ReplyDTO> customerReply(@RequestBody Map<String, Object> map);
	
}
