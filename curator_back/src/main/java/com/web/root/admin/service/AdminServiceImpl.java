package com.web.root.admin.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.admin.AdminMapper;
import com.web.root.mybatis.artistpage.ArtistPageMapper;
import com.web.root.mybatis.customer.CustomerMapper;
import com.web.root.mybatis.help.HelpMapper;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminMapper adminMapper;
	
	@Autowired
	public CustomerMapper customerMapper;
	
	@Autowired
	public ArtistPageMapper artistPageMapper;
	
	@Autowired
	public HelpMapper serviceMapper;

	// 회원관리
	@Override
	public List<MemberDTO> adminCustomerList() {
		return adminMapper.adminCustomerList();
	}
	
	// 작가등록
	@Override
	public int adminArtistAdd(Map<String, Object> map, MultipartFile multipartFile) {
		ArtistDTO artistDTO = new ArtistDTO();
		artistDTO.setArtistSeq(Integer.parseInt(map.get("artistSeq").toString()));
		artistDTO.setArtistName(map.get("artistName").toString());
		artistDTO.setArtistProfile(map.get("artistProfile").toString());
		artistDTO.setArtistSns(map.get("artistSns").toString());
		if(multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			artistDTO.setArtistImage(sysFileName);
			File artistImageFile = new File("" + File.separator + sysFileName);
			try {
				multipartFile.transferTo(artistImageFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return adminMapper.adminArtistAdd(artistDTO);
	}

	// 작가관리
	@Override
	public List<ArtistDTO> adminArtistList() {
		return adminMapper.adminArtistList();
	}
	
	// 그림 등급 관리
	@Override
	public int adminPostAuction(int postSeq, int postAuction) {
		return adminMapper.adminPostAuction(postSeq, postAuction);
	}

	// 임의 회원 탈퇴
	@Override
	public int adminMemberDelete(Map<String, Object> map) {
		int memberGrade = Integer.parseInt(map.get("memberGrade").toString());
		switch(memberGrade) {
		case 1 : 
			int customerDelete = Integer.parseInt(map.get("memberSeq").toString());
			customerMapper.memberDelete(customerDelete);
			return 1; 
		case 2 : 
			int artistDelete = Integer.parseInt(map.get("artistSeq").toString());
			artistPageMapper.artistMemberDelete(artistDelete); 
			return 1;
		default : return 0;	
		}
	}
}





