package com.web.root.payment.service;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.artist.ArtistMapper;
import com.web.root.mybatis.customer.CustomerMapper;
import com.web.root.mybatis.kakaopay.KakaoPayMapper;
import com.web.root.mybatis.post.PostMapper;
import com.web.root.payment.dto.Amount;
import com.web.root.payment.dto.KakaoPaymentApproveDTO;
import com.web.root.payment.dto.successDTO;

@Service
public class KakaoPayServiceImpl implements KakaoPayService {
	
	static final String readyUrl = "https://kapi.kakao.com/v1/payment/ready";	
	static final String approveUrl = "https://kapi.kakao.com/v1/payment/approve";
	static final String cancelUrl = "https://kapi.kakao.com/v1/payment/cancel";
	static final String serviceAppAdminKey = "933fda817ac44389758a8e24bd0cfb16";	// 우리 애플리케이션의 어드민 키
	static final String cid = "TC0ONETIME";											// 가맹점 테스트 코드
	static final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";
	ObjectMapper objectMapper = new ObjectMapper();
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	KakaoPayMapper kakaoPayMapper;
	
	@Autowired
	ArtistMapper artistMapper;
	
	@Autowired
	PostMapper postMapper;
	
	@Autowired
	CustomerMapper customerMapper;

	
	// 카카오페이 요청
	@Override
	public String readyKakaoRequest(int memberSeq, int artistSeq, String postTitle, int postPrice, int postSeq, HttpSession session) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		HttpHeaders httpHeaders = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		
		kakaoPayMapper.delInfo();
        
		httpHeaders.add("Authorization", "KakaoAK " + serviceAppAdminKey);
		httpHeaders.add("Content-type", CONTENT_TYPE);
		httpHeaders.add("Access-Control-Allow-Origin", "*");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", "mateWith_Partner");
        params.add("partner_user_id", "mateWith_User");
        params.add("item_name", postTitle);
        params.add("quantity", "1");
        params.add("total_amount", Integer.toString(postPrice));
        params.add("vat_amount", Integer.toString(postPrice/10));
        params.add("tax_free_amount", "0");
        params.add("approval_url", "http://localhost:8080/root/success");
        params.add("fail_url", "http://localhost:8080/");
        params.add("cancel_url", "http://localhost:8080/root/fail");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, httpHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(readyUrl, entity, String.class);
        
        String kakaoPayRequestURL = ""; 
        String tid = "";
		try {
			kakaoPayRequestURL = objectMapper.readTree(response.getBody()).get("next_redirect_pc_url").asText();
			tid = objectMapper.readTree(response.getBody()).get("tid").asText();
			
			kakaoPayMapper.setInfo(tid, memberSeq, postSeq);
		} catch (IOException e) {
			e.printStackTrace();
		}
		artistMapper.purchasePoint(artistSeq);
		return kakaoPayRequestURL;
	}
	  
	// 결제 완료 승인    
	@Override    
    public int ApproveResponse(String pgToken, HttpSession session) {
    	
		ObjectMapper objectMapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		successDTO dto = kakaoPayMapper.selInfo();
		String tid = dto.getTid();
		int memberSeq = dto.getPostSeq();
		int postSeq = dto.getPostSeq();
		System.out.println(tid);
		System.out.println(memberSeq);
		System.out.println(postSeq);
		
		httpHeaders.add("Authorization", "KakaoAK " + serviceAppAdminKey);
		httpHeaders.add("Content-type", CONTENT_TYPE);
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", tid);
        params.add("partner_order_id", "mateWith_Partner");
        params.add("partner_user_id", "mateWith_User");
        params.add("pg_token", pgToken);
        
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, httpHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(approveUrl, entity, String.class);
		try {
			JsonNode responseBody = objectMapper.readTree(response.getBody());
			
			String aid = responseBody.get("aid").asText();
			String cid = responseBody.get("cid").asText();
			String partner_order_id = responseBody.get("partner_order_id").asText();
			String partner_user_id = responseBody.get("partner_user_id").asText();
			String payment_method_type = responseBody.get("payment_method_type").asText();
			String amount = responseBody.get("amount").toString();
			String item_name = responseBody.get("item_name").asText();
			String quantity = responseBody.get("quantity").asText();
			String created_at = responseBody.get("created_at").asText();
			String approved_at = responseBody.get("approved_at").asText();
			
			KakaoPaymentApproveDTO kakaoPaymentApproveDTO = new KakaoPaymentApproveDTO(); 
			kakaoPaymentApproveDTO.setAid(aid);
			kakaoPaymentApproveDTO.setTid(tid);
			kakaoPaymentApproveDTO.setCid(cid);
			kakaoPaymentApproveDTO.setPartnerOrderId(partner_order_id);
			kakaoPaymentApproveDTO.setPartnerUserId(partner_user_id);
			kakaoPaymentApproveDTO.setPaymentMethodType(payment_method_type);
			kakaoPaymentApproveDTO.setAmount(amount);
			kakaoPaymentApproveDTO.setItemName(item_name);
			kakaoPaymentApproveDTO.setQuantity(quantity);
			kakaoPaymentApproveDTO.setCreatedAt(created_at);
			kakaoPaymentApproveDTO.setApprovedAt(approved_at);
			kakaoPaymentApproveDTO.setMemberSeq(memberSeq);
			kakaoPayMapper.ApproveResponse(kakaoPaymentApproveDTO);
			
	        MemberDTO memberDTO = customerMapper.memberInfo(memberSeq);
	        String purName = memberDTO.getMemberName();
	        String purPhone = memberDTO.getMemberPhone();
	        String purAddr = memberDTO.getMemberAddr();
	        kakaoPayMapper.purchaseUpdate(memberSeq, postSeq, purName, purPhone, purAddr);

			kakaoPayMapper.cartDelect(postSeq);
			postMapper.postDelete(postSeq);
			
			kakaoPayMapper.delInfo();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1;
	}

	// 결제내역
	@Override
	public KakaoPaymentApproveDTO paymentInfo(int memberSeq) {
		return kakaoPayMapper.paymentInfo(memberSeq);
	}
	    
	// 결제 환불
	@Override
	public ResponseEntity<String> cancelResponse(String tid) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		HttpHeaders httpHeaders = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		
		httpHeaders.add("Authorization", "KakaoAK " + serviceAppAdminKey);
		httpHeaders.add("Content-type", CONTENT_TYPE);
		
		KakaoPaymentApproveDTO kakaoPaymentApproveDTO = kakaoPayMapper.paymentMemberInfo(tid);
		String amountJson = kakaoPaymentApproveDTO.getAmount();
		int total = 0;
		try {
			Amount amount =  objectMapper.readValue(amountJson, Amount.class);
			total = amount.getTotal();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
		params.add("cid", cid);
		params.add("tid", kakaoPaymentApproveDTO.getTid());
		params.add("cancel_amount", total);
		params.add("cancel_tax_free_amount", 0);	
		
		try {
			HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(params, httpHeaders);
			ResponseEntity<String> response = restTemplate.exchange(cancelUrl, HttpMethod.POST, entity, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
            	kakaoPayMapper.cancelResponse(tid);
                return ResponseEntity.ok("Payment cancelled successfully");
            } else {
                return ResponseEntity.badRequest().body("Payment cancellation failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }

	}
	
}
