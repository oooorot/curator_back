package com.web.root.mybatis.customer;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PatchMapping;

import com.web.root.customer.dto.BookmarkDTO;
import com.web.root.customer.dto.CartDTO;
import com.web.root.customer.dto.CustomerHelpReplyDTO;
import com.web.root.customer.dto.PurchaseDTO;
import com.web.root.member.dto.MemberDTO;

public interface CustomerMapper {
	
	// 회원정보
	public MemberDTO memberInfo(int MemberSeq);
	
	// 회원정보 수정
	public int memberUpdate(Map<String, Object> map);
	
	// 회원탈퇴
	public int memberDelete(int MemberSeq);
	
	// 장바구니
	public List<CartDTO> cartList(int memberSeq);
	
	// 장바구니 삭제
	public int cartDelect(@Param("memberSeq") int memberSeq, @Param("postSeq") int postSeq);

	// 구매내역
	public List<PurchaseDTO> purchaseProduct(int memberSeq);
	
	// 배송조회
	public PurchaseDTO parcelSelect(int purSeq);
	
	// 즐겨찾기
	public List<BookmarkDTO> bookmarkArtistList(int memberSeq);
	
	// 나의문의 및 답변
	public List<CustomerHelpReplyDTO> customerHelpReplyList(@Param("memberSeq") int memberSeq, @Param("helpSeq") int helpSeq);
	

}
