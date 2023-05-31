package com.web.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.mybatis.member.MemberArtistMapper;

@Service
public class MemberArtistServiceImpl implements MemberArtistService{
	
	@Autowired
	public MemberArtistMapper memberArtistMapper;
}
