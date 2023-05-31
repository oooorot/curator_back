package com.web.root.member.service;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MemberRegisterMailImpl implements MemberRegisterMail{
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	// MimeMessagePreparator를 사용해서 메일 전송
	@Override
	public String registerCode(String memberEmail) throws Exception{
//		Random randomCode = new Random();
//		StringBuffer buffer = new StringBuffer();
//		for(int i = 0; i < 6; i++) {
//			if(randomCode.nextBoolean()) {
//				buffer.append((char)((int)(randomCode.nextInt(26))+97));
//			}else {
//				buffer.append(randomCode.nextInt(10));
//			}
//		}
		boolean useLetters = true;
		boolean useNumbers = true;
		String randomCode = RandomStringUtils.random(5, useLetters, useNumbers);
		String subject = "큐레이터 사이트 인증메일";
		String content = "안녕하세요 인증 메일입니다\n" + randomCode;
		String from = "ljuho93@gmail.com";
		String to = memberEmail;
		        
        try {
            final MimeMessagePreparator preparator = new MimeMessagePreparator() {
                
                public void prepare(MimeMessage mimeMessage) throws Exception{
                    final MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    
                    mailHelper.setFrom(from);
                    mailHelper.setTo(to);
                    mailHelper.setSubject(subject);
                    mailHelper.setText(content, true);
                    
                    FileSystemResource file = new FileSystemResource(new File("/Users/Administrator/Desktop/0531.txt")); 
                    mailHelper.addAttachment("0531.txt", file);
                }
                
            };
            
            mailSender.send(preparator);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return randomCode.toString();
    }
}

