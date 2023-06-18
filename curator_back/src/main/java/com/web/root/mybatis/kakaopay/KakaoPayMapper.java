package com.web.root.mybatis.kakaopay;

import com.web.root.payment.dto.KakaoPaymentApproveDTO;

public interface KakaoPayMapper {

	public int ApproveResponse(KakaoPaymentApproveDTO kakaoPaymentApproveDTO);
	
	public void cartDelect(int postSeq);
	
	public KakaoPaymentApproveDTO paymentInfo(int memberSeq);
	
	public KakaoPaymentApproveDTO paymentMemberInfo(String tid);
	
	public void cancelResponse(String tid);
}
