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
	
	@Override
	public String registerCode(String memberEmail) throws Exception{
		boolean useLetters = true;
		boolean useNumbers = true;
		String randomCode = RandomStringUtils.random(8, useLetters, useNumbers);
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
//                    mailHelper.addAttachment("0531.txt", file);
                }
            };
            mailSender.send(preparator);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return randomCode.toString();
    }
}

