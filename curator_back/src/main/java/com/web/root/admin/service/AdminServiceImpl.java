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
import com.web.root.auction.service.AuctionServiceImpl;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.admin.AdminMapper;
import com.web.root.mybatis.artistpage.ArtistPageMapper;
import com.web.root.mybatis.customer.CustomerMapper;
import com.web.root.mybatis.help.HelpMapper;
import com.web.root.post.dto.PostDTO;
import com.web.root.session.imagepath.ImagePath;

@Service
public class AdminServiceImpl implements AdminService, ImagePath{
	
	@Autowired
	public AdminMapper adminMapper;
	
	@Autowired
	public CustomerMapper customerMapper;
	
	@Autowired
	public ArtistPageMapper artistPageMapper;
	
	@Autowired
	public HelpMapper serviceMapper;
	
	@Autowired
	public AuctionServiceImpl auctionService;

	// 회원관리
	@Override
	public List<MemberDTO> adminCustomerList() {
		return adminMapper.adminCustomerList();
	}
	
	// 작가등록
	@Override
	public int adminArtistAdd(ArtistDTO artistDTO, MultipartFile multipartFile) {
		if(multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			artistDTO.setArtistImage(sysFileName);
			File artistImageFile = new File(IMAGE_PATH + File.separator + sysFileName);
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
	public int adminPostAuction(PostDTO postDTO) {
		int postSeq = postDTO.getPostSeq();
		int postAuction = postDTO.getPostAuction();
		adminMapper.adminPostAuction(postSeq, postAuction);
		if(postDTO.getPostAuction()==1) {
			auctionService.timeOver();
			return 1;
		} else return 0;
	}

	// 임의 회원 탈퇴
	@Override
	public int adminMemberDelete(Map<String, Object> map) {
		int customerDelete = Integer.parseInt(map.get("memberSeq").toString());
		return customerMapper.memberDelete(customerDelete);
	}
}





