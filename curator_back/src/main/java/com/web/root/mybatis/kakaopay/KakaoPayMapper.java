package com.web.root.mybatis.kakaopay;

import com.web.root.payment.dto.KakaoPaymentApproveDTO;

public interface KakaoPayMapper {

	public int ApproveResponse(KakaoPaymentApproveDTO kakaoPaymentApproveDTO);
	
	public KakaoPaymentApproveDTO paymentInfo(int memberSeq);
	
	public void cancelResponse(int memberSeq);
}
