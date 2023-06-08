package com.web.root.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.web.root.customer.dto.BookmarkDTO;
import com.web.root.customer.dto.CartDTO;
import com.web.root.customer.dto.CustomerHelpReplyDTO;
import com.web.root.customer.dto.PurchaseDTO;
import com.web.root.member.dto.MemberDTO;

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
	
	// 나의문의 및 답변
	public List<CustomerHelpReplyDTO> customerHelpReplyList(@RequestBody Map<String, Object> map);
	
}
