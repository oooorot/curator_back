package com.web.root.payment.service;


import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.web.root.payment.dto.KakaoPaymentApproveDTO;

public interface KakaoPayService {

	public String readyKakaoRequest(int memberSeq, int artistSeq, String postTitle, int postPrice, HttpSession session);

	public int ApproveResponse(String pgToken, HttpSession session);
	
	public KakaoPaymentApproveDTO paymentInfo(int memberSeq);
	
	public ResponseEntity<String> cancelResponse(int memberSeq);
}
