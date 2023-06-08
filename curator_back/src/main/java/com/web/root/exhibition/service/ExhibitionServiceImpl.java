


package com.web.root.exhibition.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.exhibition.dto.ExhibitionDTO;
import com.web.root.mybatis.exhibition.ExhibitionMapper;

@Service
public class ExhibitionServiceImpl implements ExhibitionService {
	
	@Autowired
	private ExhibitionMapper exhibitionMapper;
	
	@Override
	public List<ExhibitionDTO> exhibitionList() {
		List<ExhibitionDTO> exhibitionList = exhibitionMapper.exhibitionList();
		return exhibitionList;
	}
	
	@Override
	public ExhibitionDTO exhibitionView(int exhibitionSeq) {
		ExhibitionDTO exhibitionDTO = exhibitionMapper.exhibitionView(exhibitionSeq);
		return exhibitionDTO;
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
