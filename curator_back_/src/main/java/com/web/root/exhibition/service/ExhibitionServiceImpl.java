


package com.web.root.exhibition.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.exhibition.dto.ExhibitionDTO;
import com.web.root.mybatis.exhibition.ExhibitionMapper;
import com.web.root.post.dto.PostDTO;

@Service
public class ExhibitionServiceImpl implements ExhibitionService {
	
	@Autowired
	private ExhibitionMapper mapper;
	
	@Override
	public List<ExhibitionDTO> ExhibitionList() {
		List<ExhibitionDTO> list = mapper.ExhibitionList();
		return list;
	}
	
	@Override
	public ExhibitionDTO ExhibitionView(int exhibitionSeq) {
		ExhibitionDTO dto = mapper.ExhibitionView(exhibitionSeq);
		return dto;
	}
	
//	@Override
//	public int exhibitionWrite(ExhibitionDTO dto, MultipartFile multipartFile) {
//			if (multipartFile.getSize() != 0) {
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
//				Calendar calendar = Calendar.getInstance();
//				String sysFileName = sdf.format(calendar.getTime());
//				sysFileName += multipartFile.getOriginalFilename();
//				
//				dto.setExhibitionBanner(sysFileName);
//						
//				File saveFile = new File("/Users/orot/workbench/00_project/project_storage" + File.separator + sysFileName);
//				
//				try {
//					multipartFile.transferTo(saveFile);
//				} catch (Exception e) {
//					e.printStackTrace();			
//				}
//		}
//		
//		int res = mapper.exhibitionWrite(dto);
//		return res;
//	}

}
