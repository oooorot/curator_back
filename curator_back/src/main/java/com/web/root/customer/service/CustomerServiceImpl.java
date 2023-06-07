package com.web.root.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.cart.dto.CartDTO;
import com.web.root.customer.dto.PurchaseDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.customer.CustomerMapper;
import com.web.root.reply.dto.ReplyDTO;
import com.web.root.service.dto.ServiceDTO;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	public CustomerMapper customerMapper;
	
	// 회원정보
	@Override
	public MemberDTO memberInfo(Map<String, Object> map) {
		try {
			MemberDTO memberDTO = customerMapper.memberInfo(Integer.parseInt(map.get("MemberSeq").toString()));
		return memberDTO; 
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 회원정보 수정
	@Override
	public int memberUpdate(Map<String, Object> map) {
		try {
			if(map.get("memberPw")!=null&map.get("memberNickname")!=null&map.get("memberName")!=null&map.get("memberPhone")!=null&map.get("memberAddr")!=null) {
				return customerMapper.memberUpdate(map);
			} else return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// 회원탈퇴
	@Override
	public int memberDelete(int MemberSeq) {
		try {
			return customerMapper.memberDelete(MemberSeq);
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	//장바구니
	@Override
    public List<CartDTO> cartList(int memberSeq) {
		try {
			return customerMapper.cartList(memberSeq);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
       
    }

	// 장바구니 삭제
	@Override
	public int cartDelect(int carSeq) {	
		try {
			return customerMapper.cartDelect(carSeq);
		}catch (Exception e) {
			return 0;
		}
	}

	// 구매내역
	@Override
	public List<PurchaseDTO> purchaseProduct(Map<String, Object> map) {
		List<PurchaseDTO> purchaseList = customerMapper.purchaseProduct(map);
		return purchaseList;
	}
	
	// 즐겨찾기
	@Override
	public List<BookmarkDTO> bookmarkArtistList(Map<String, Object> map) {
		try {
			int memberSeq = Integer.parseInt(map.get("memberSeq").toString());
			return customerMapper.bookmarkArtistList(memberSeq);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 나의문의
	@Override
	public List<ServiceDTO> customerHelpList(int memberSeq) { 
		try {
			return customerMapper.customerHelpList(memberSeq);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 답변보기
	@Override
	public List<ReplyDTO> customerReply(@RequestBody Map<String, Object> map) {
		try {
			ReplyDTO replyDTO = new ReplyDTO();
			replyDTO.setReplySeq(Integer.parseInt(map.get("replySeq").toString()));
			replyDTO.setHelpSeq(Integer.parseInt(map.get("helpSeq").toString()));
			replyDTO.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
			return customerMapper.customerReply(replyDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}















