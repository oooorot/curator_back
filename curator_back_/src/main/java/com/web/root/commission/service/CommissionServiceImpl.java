package com.web.root.commission.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.commission.dto.CommissionDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.commission.CommissionMapper;

@Service
public class CommissionServiceImpl implements CommissionService{

	@Autowired
	private CommissionMapper mapper;
	
	private MemberDTO memDTO;
	private ArtistDTO artDTO;
	private CommissionDTO comDTO;
	
	@Override
	public List<CommissionDTO> commAllList() {
		List<CommissionDTO> list = mapper.commAllList();
		return list;
	}

	@Override
	public int commissionWrite(Map<String, Object> map, MultipartFile multipartFile) {
			
		artDTO.setArtistSeq(Integer.parseInt(map.get("artistSeq").toString()));
		memDTO.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
		comDTO.setCommTitle(map.get("commTitle").toString());
		comDTO.setCommContent(map.get("commContent").toString());
		
		if (multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			
			comDTO.setCommImage(sysFileName);
			
			File saveFile = new File("C://testImage" + File.separator + sysFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();			
			}
		}
	//	comDTO.setCommImage(map.get("commImage").toString());

		int res = mapper.commissionWrite(comDTO);
		return res;
	}
	
	

	@Override
	public void commissionUpdate(Map<String, Object> map) {
		
		artDTO.setArtistSeq(Integer.parseInt(map.get("artistSeq").toString()));
		memDTO.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
		comDTO.setCommTitle(map.get("commTitle").toString());
		comDTO.setCommContent(map.get("commContent").toString());
		
		
	}

//	@Override
//	public String saveImageFile(CommissionDTO dto, MultipartFile multipartFile) {
//		if (multipartFile.getSize() != 0) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
//			Calendar calendar = Calendar.getInstance();
//			String sysFileName = sdf.format(calendar.getTime());
//			sysFileName += multipartFile.getOriginalFilename();
//			
//			dto.setCommImage(sysFileName);
//			
//			File saveFile = new File("C://testImage" + File.separator + sysFileName);
//			
//			try {
//				multipartFile.transferTo(saveFile);
//			} catch (Exception e) {
//				e.printStackTrace();			
//			}
//			mapper.saveImageFile(dto);
//		
//		}
//		return "success";
//
//	}
	
}
