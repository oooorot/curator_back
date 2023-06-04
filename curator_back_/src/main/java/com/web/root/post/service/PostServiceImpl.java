


package com.web.root.post.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.cart.dto.CartDTO;
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
	
	@Override
	public int postCart(Map<String, Object> map) {
		int res = 0;
	      try {
	         CartDTO dto = new CartDTO();
	         dto.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
	         dto.setPostSeq(Integer.parseInt(map.get("postSeq").toString()));
	         res = mapper.postCart(dto);      
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		
		return res;
	}
	
	@Override
	public int postDelete(int postSeq) {
		try {
			return mapper.postDelete(postSeq);
		} catch (Exception e) {
			return 0;
		}
	
	}
	
	@Override
	public int postUpdate(PostDTO dto, MultipartFile multipartFile) {
		
		if(multipartFile.getSize() != 0) {
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
	         Calendar calendar = Calendar.getInstance();
	         String sysFileName = sdf.format(calendar.getTime());
	         sysFileName += multipartFile.getOriginalFilename();
	         deleteImage(sysFileName);
	         dto.setPostImageName(sysFileName);
	         
	         File saveFile = new File("/Users/orot/workbench/00_project/project_storage" + File.separator + sysFileName);
	         
	         try {
	            multipartFile.transferTo(saveFile);
	         } catch (Exception e) {
	            e.printStackTrace();         
	         }
	      }
	      int res = mapper.postUpdate(dto);
	      return res;
	   }
	
	@Override
	   public void deleteImage(String originalFileName) {
	      File deleteFile = new File("C://PleaseImage" + File.separator + originalFileName);
	      deleteFile.delete();
	   }

	
	
	

}
