package com.web.root.member.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.member.service.MemberRegisterMail;
import com.web.root.member.service.MemberService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRegisterMail memberRegisterMail;
	
	// 로그인 토큰 반환으로 변경예정
	@PostMapping(value="login", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> login(@RequestBody Map<String, String> map) {

		Map<String, Object> tokenJwt = new HashMap<String, Object>();
		
		if(memberService.loginCheck(map) != null) {
			String accessToken = memberService.getAccessToken(map);
			String refreshToken = memberService.getRefreshToken(map);
			
			tokenJwt.put("accessToken", accessToken);
			tokenJwt.put("refreshToken", refreshToken);
			
			return tokenJwt;	
		}
		return tokenJwt; 
		
	}
	
	//refreshToken
	@PostMapping(value = "silentRefresh", produces = "application/json; charset=utf8")
    @ResponseBody
    public Map<String, Object> silentRefresh(@CookieValue(value = "refreshToken") Cookie refreshCookie) throws ParseException {
    	
    	String refreshToken = refreshCookie.getValue().toString();
    	System.out.println(refreshToken);
    	
    	String token[] = refreshToken.split("\\.");
    	System.out.println(token);
    	Base64.Decoder decoder = Base64.getUrlDecoder();

        System.out.println(new String(decoder.decode(token[1])));
		String decodeToken = new String(decoder.decode(token[1]));
		
		JSONParser jsonParser = new JSONParser();
		JSONObject decodeJSON = (JSONObject)jsonParser.parse(decodeToken);
		
		String decodeValue = decodeJSON.get("email").toString();
		System.out.println(decodeValue);
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", decodeValue);
    	
    	if (refreshToken != null) {
    		String accessToken = memberService.getAccessToken(map);
    		Map<String, Object> tokenJwt = new HashMap<String, Object>();
    		tokenJwt.put("accessToken", accessToken);
    		
    		return tokenJwt;
		}
    	
    	return null;
    	
    }
	
	// 인증코드 발송
	@GetMapping(value="registerCode", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String registerCode(@RequestParam("insertEmail") String memberEmail) throws Exception {
		System.out.println(memberEmail);
		return memberRegisterMail.registerCode(memberEmail);
	}
	
	// 인증코드 확인
	@PostMapping(value="registerCodeResult", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int registerCodeResult(@RequestBody Map<String, Object> map) {
		return memberService.registerCodeResult(map);
	}
	
	// 이메일 중복확인
	@GetMapping(value="emailCheck", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int emailCheck(@RequestParam("insertEmail") String InsertEmail) throws Exception {
		try {
			if(memberService.emailCheck(InsertEmail) == 0) {
				return 0;
			} else return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	// 회원가입
	@PostMapping(value="register", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int register(@RequestBody Map<String, Object> map) {
		return memberService.register(map);
	}

}
















