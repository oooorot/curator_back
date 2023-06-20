package com.web.root.mybatis.kakaopay;

import org.apache.ibatis.annotations.Param;

import com.web.root.payment.dto.KakaoPaymentApproveDTO;
import com.web.root.payment.dto.successDTO;

public interface KakaoPayMapper {

	public int ApproveResponse(KakaoPaymentApproveDTO kakaoPaymentApproveDTO);
	
	public void cartDelect(int postSeq);
	
	public KakaoPaymentApproveDTO paymentInfo(int memberSeq);
	
	public KakaoPaymentApproveDTO paymentMemberInfo(String tid);
	
	public void cancelResponse(String tid);
	
	public void setInfo(@Param("tid") String tid, @Param("memberSeq") int memberSeq, @Param("postSeq") int postSeq);
	
	public void delInfo();
	
	public successDTO selInfo();
}
