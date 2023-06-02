


package com.web.root.post.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.mybatis.post.PostMapper;
import com.web.root.post.dto.PostDTO;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostMapper mapper;
	

	@Override
	public PostDTO PostView(int postSeq) {
		PostDTO dto = mapper.PostView(postSeq);
		return dto;
	}
	
	@Override
	public int postWrite(PostDTO dto, MultipartFile multipartFile) {
			if (multipartFile.getSize() != 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
				Calendar calendar = Calendar.getInstance();
				String sysFileName = sdf.format(calendar.getTime());
				sysFileName += multipartFile.getOriginalFilename();
				
				dto.setPostImageName(sysFileName);
						
				File saveFile = new File("/Users/orot/workbench/00_project/project_storage" + File.separator + sysFileName);
				
				try {
					multipartFile.transferTo(saveFile);
				} catch (Exception e) {
					e.printStackTrace();			
				}
		}
		
		int res = mapper.postWrite(dto);
		return res;
	}

	
	
	

}
