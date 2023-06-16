package com.web.root.member.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.member.MemberMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	public MemberMapper memberMapper;
	
	//secret key
	private final String ACCESS_SECRET = "keyactivatetoken";
	private final String REFRESH_SECRET = "keyrefreshtoken";
	
	// 로그인 체크
	@Override
	public String loginCheck(Map<String, String> map) {
		try {			
			MemberDTO dto = memberMapper.loginCheck(map);
			if(dto.getMemberEmail() != null) {
				System.out.println(dto.getMemberEmail());
				return dto.getMemberEmail();
			}
			return "success";
		} catch (NullPointerException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 로그인
	@Override
	public String getAccessToken(Map<String, String> map) {
		//가져온 로그인 정보 변수 저장
		String email = map.get("memberEmail");
		String pwd = map.get("memberPw");
		
		System.out.println(email);
		
		// email을 통해 나머지 정보 select
		MemberDTO dto = memberMapper.checkEmail(email);
		System.out.println(dto.getMemberEmail());
    	String nickname = dto.getMemberNickname();
    	int seq = dto.getMemberSeq();
    	int grade = dto.getMemberGrade();
    	
        //JWT Header 작성
        Map<String, Object> jwtHeader = new HashMap<>();
        jwtHeader.put("typ", "JWT");
        jwtHeader.put("alg", "HS256");
        jwtHeader.put("regDate", System.currentTimeMillis());

        //JWT Payloder 작성
        Map<String, Object> claim = new HashMap<>();
        claim.put("email", email);
        claim.put("nickname", nickname);
        claim.put("seq", seq);
        claim.put("grade", grade);
        claim.put("username", "curator");

        String token = Jwts.builder()
                .setSubject(email)
                .setHeader(jwtHeader)
                .setClaims(claim)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 600000 * 1000))
                .signWith(SignatureAlgorithm.HS256, ACCESS_SECRET)
                .compact();
        
		return token;
	}
	
	//refreshToken
	@Override
	public String getRefreshToken(Map<String, String> map) {
		//가져온 로그인 정보 변수 저장
		String email = map.get("memberEmail");
    	
        //JWT Header 작성
        Map<String, Object> jwtHeader = new HashMap<>();
        jwtHeader.put("typ", "JWT");
        jwtHeader.put("alg", "HS256");
        jwtHeader.put("regDate", System.currentTimeMillis());

        //JWT Payloder 작성
        Map<String, Object> claim = new HashMap<>();
        claim.put("email", email);
        claim.put("username", "curator");

        String token = Jwts.builder()
                .setSubject(email)
                .setHeader(jwtHeader)
                .setClaims(claim)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200 * 1000))
                .signWith(SignatureAlgorithm.HS256, REFRESH_SECRET)
                .compact();
        
		return token;
	}
	
	
	// 인증코드 확인
	@Override
	public int registerCodeResult(Map<String, Object> map) {
		String insertCode = map.get("token").toString(); 
		String registerCode = memberMapper.codeSelect();
		if(insertCode.equals(registerCode)) {
			memberMapper.codeDelete();
			return 1;
		} else return 0;
	}
	
	// 이메일 중복 확인
	@Override
	public int emailCheck(String insertEmail) throws Exception {
		try {
			if(memberMapper.emailCheck(insertEmail) == null) {
				System.out.println(memberMapper.emailCheck(insertEmail));
				return 0;
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
		return 1;
	}

	// 회원가입
	@Override
	public int register(Map<String, Object> map) {
		try {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setMemberEmail(map.get("memberEmail").toString());
			memberDTO.setMemberPw(map.get("memberPw").toString());
			memberDTO.setMemberNickname(map.get("memberNickname").toString());
			memberDTO.setMemberName(map.get("memberName").toString());
			memberDTO.setMemberPhone(map.get("memberPhone").toString());
			memberDTO.setMemberAddr(map.get("memberAddr").toString());
			memberDTO.setMemberGrade(Integer.parseInt(map.get("memberGrade").toString()));
			return memberMapper.register(memberDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}	
	
	// 이름 얻어오기
	public String getName(int seq) {
		return memberMapper.getName(seq);
	}
	
	
	
	
}
