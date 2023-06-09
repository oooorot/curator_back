package com.web.root.payment.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.web.root.payment.dto.KakaoPaymentApproveDTO;
import com.web.root.payment.service.KakaoPayService;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class KakaoPayController {
	
	@Autowired
	public KakaoPayService paymentService;
	
   // 결제 요청
   @GetMapping(value="readyKakaoRequest", produces = "application/json; charset=utf-8")
   @ResponseBody
   public String readyKakaoRequest(@RequestParam("memberSeq") int memberSeq, @RequestParam("artistSeq") int artistSeq, @RequestParam("postTitle") String postTitle, @RequestParam("postPrice") int postPrice, @RequestParam("postSeq") int postSeq, HttpSession session) {
      String kakaoPayRequestURL = paymentService.readyKakaoRequest(memberSeq, artistSeq, postTitle, postPrice, postSeq, session);
      RedirectView redirectView = new RedirectView();
      redirectView.setUrl(kakaoPayRequestURL);
      return kakaoPayRequestURL;
   }
	
	// 카카오 페이 결제 승인
	@GetMapping(value="success", produces = "application/json; charset=utf-8")
	@ResponseBody
	public RedirectView ApproveResponse(@RequestParam("pg_token") String pg_token, HttpSession session) {
		paymentService.ApproveResponse(pg_token, session);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost:3000/pay/success");
		return redirectView;
	}
	
	// 결제 내역 확인
	@GetMapping(value="paymentInfo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public KakaoPaymentApproveDTO paymentInfo(@RequestParam("memberSeq") int memberSeq) {
		return paymentService.paymentInfo(memberSeq);
	}
	
	// 환불
	@PostMapping(value="cancel", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> cancelResponse(@RequestParam("tid") String tid) {
		return paymentService.cancelResponse(tid);
	}
	
	// 결제 실패
	@GetMapping(value="fail", produces = "application/json; charset=utf-8")
	@ResponseBody
	public RedirectView fail() {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost:3000/pay/fail");
		return redirectView;
	}
	
	
}
