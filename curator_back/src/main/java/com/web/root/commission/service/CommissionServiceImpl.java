package com.web.root.commission.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.commission.dto.CommissionDTO;
import com.web.root.mybatis.commission.CommissionMapper;

@Service
public class CommissionServiceImpl implements CommissionService{

	@Autowired
	private CommissionMapper mapper;
	
	@Override
	public List<CommissionDTO> commAllList() {
		List<CommissionDTO> list = mapper.commAllList();
		return list;
	}

	@Override
	public int commissionWrite(Map<String, Object> map) {
		
		String sql = "SELECT member_name FROM member m"
				   + "inner join commission c"
				   + "ON m.merber_seq = c.member_seq";
		
		CommissionDTO dto = new CommissionDTO();
		dto.setCommTitle(map.get("commTitle").toString());
		dto.setCommContent(map.get("commContent").toString());
		dto.setCommImage(map.get("commImage").toString());
		
		
		int res = mapper.commissionWrite(dto);
		return res;
	}

	@Override
	public String saveImageFile(CommissionDTO dto, MultipartFile multipartFile) {
		if (multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			
			dto.setCommImage(sysFileName);
			
			File saveFile = new File("C://testImage" + File.separator + sysFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();			
			}
			mapper.saveImageFile(dto);
		
		}
		return "success";

	}
	
}
