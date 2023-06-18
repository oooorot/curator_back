package com.web.root.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.customer.dto.BookmarkDTO;
import com.web.root.customer.dto.CartDTO;
import com.web.root.customer.dto.CustomerHelpReplyDTO;
import com.web.root.customer.dto.ParcelDTO;
import com.web.root.customer.dto.PurchaseDTO;
import com.web.root.customer.service.CustomerService;
import com.web.root.member.dto.MemberDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;

	// 회원정보
	@PostMapping(value="memberInfo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public MemberDTO memberInfo(@RequestBody Map<String, Object> map) {
		return customerService.memberInfo(map);
	}
	
	// 회원정보 수정
	@PutMapping(value="memberUpdate", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int memberUpdate(@RequestBody Map<String, Object> map) {
		return customerService.memberUpdate(map);
	}
	
	// 회원 탈퇴
	@DeleteMapping(value="memberDelete", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int memberDelete(@RequestParam("MemberSeq") int MemberSeq) {
		return customerService.memberDelete(MemberSeq);
	}
	
	// 장바구니
	@GetMapping(value="cartList", produces = "application/json; charset=utf8")
    @ResponseBody
    public List<CartDTO> cartList(@RequestParam("memberSeq") int memberSeq) {
       return customerService.cartList(memberSeq);
    }
	
	// 장바구니 삭제
	@DeleteMapping(value="cartDelect", produces = "application/json; charset=utf8")
	@ResponseBody
	public int cartDelect(@RequestParam("cartSeq") int cartSeq) {
		return customerService.cartDelect(cartSeq);
	}
	
	// 구매내역
	@GetMapping(value="purchaseProduct", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<PurchaseDTO> purchaseProduct(@RequestBody Map<String, Object> map) {
		return customerService.purchaseProduct(map); 
	}
	
	// 배송조회
	@GetMapping(value="parcelSelect", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ParcelDTO parcelSelect(@RequestParam("purSeq") int purSeq) {
		return customerService.parcelSelect(purSeq);
	}
	
	// 즐겨찾기(북마크 등록한 작가)
	@GetMapping(value="bookmarkArtistList", produces = "application/json; charset=utf-8")
	@ResponseBody 
	public List<BookmarkDTO> bookmarkArtistList(@RequestParam("memberSeq") int memberSeq){
		return customerService.bookmarkArtistList(memberSeq);
	}
	
	// 나의문의 및 답변
	@GetMapping(value="customerHelpReplyList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<CustomerHelpReplyDTO> customerHelpReplyList(@RequestBody Map<String, Object> map){
		return customerService.customerHelpReplyList(map);
	}
	
}
