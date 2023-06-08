


package com.web.root.post.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cart.dto.CartDTO;
import com.web.root.mybatis.post.PostMapper;
import com.web.root.post.dto.PostAuctionDTO;
import com.web.root.post.dto.PostDTO;
import com.web.root.post.dto.PostExhibitionDTO;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostMapper postMapper;
	

	@Override
	public PostDTO postView(int postSeq) {
		try {
			PostDTO postDTO = new PostDTO();
			postDTO = postMapper.postView(postSeq);
			return postDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PostDTO> postList() {
		try {
			List<PostDTO> postDTO = postMapper.postList();
			return postDTO;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 전시회 유무
	@Override
	public List<PostExhibitionDTO> postExhibition(int postExhibition) {
		List<PostExhibitionDTO> list = null;
		switch(postExhibition) {
		case 1 : 
			list = postMapper.postExhibition1(postExhibition);
			return list;
		case 2 :
			list = postMapper.viewExhibition(postExhibition);
			return list;
			
		default : return null;	
		}
	}
	
	// 경매 유무
	@Override
	public List<PostAuctionDTO> postAuction(int postAuction) {
		
		List<PostAuctionDTO> list = null;
		switch(postAuction) {
		case 1:
			list = postMapper.postAuction(postAuction);
			return list;
		case 2:
			list = postMapper.viewAuction(postAuction);
			return list;
			
		default : return null;
		}
	}
	
	@Override
	public int postWrite(PostDTO postDTO, MultipartFile multipartFile) {
			if (multipartFile.getSize() != 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
				Calendar calendar = Calendar.getInstance();
				String sysFileName = sdf.format(calendar.getTime());
				sysFileName += multipartFile.getOriginalFilename();
				
				postDTO.setPostImageName(sysFileName);
						
				File saveFile = new File("/Users/orot/workbench/00_project/project_storage" + File.separator + sysFileName);
				
				try {
					multipartFile.transferTo(saveFile);
				} catch (Exception e) {
					e.printStackTrace();			
				}
		}
		
		int res = postMapper.postWrite(postDTO);
		return res;
	}
	
	@Override
	public int postCart(Map<String, Object> map) {
		int res = 0;
	      try {
	         CartDTO cartDTO = new CartDTO();
	         cartDTO.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
	         cartDTO.setPostSeq(Integer.parseInt(map.get("postSeq").toString()));   
	         res = postMapper.postCart(cartDTO);      
	      } catch (Exception e) {
	         e.printStackTrace();
	      }	
	      
		return res;
	}
	
	@Override
	public int postDelete(int postSeq) {
		try {
			return postMapper.postDelete(postSeq);
		} catch (Exception e) {
			return 0;
		}
	
	}
	
	@Override
	public int postUpdate(PostDTO postDTO, MultipartFile multipartFile) {
		
		if(multipartFile.getSize() != 0) {
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
	         Calendar calendar = Calendar.getInstance();
	         String sysFileName = sdf.format(calendar.getTime());
	         sysFileName += multipartFile.getOriginalFilename();
	         deleteImage(sysFileName);
	         postDTO.setPostImageName(sysFileName);
	         
	         File saveFile = new File("/Users/orot/workbench/00_project/project_storage" + File.separator + sysFileName);
	         
	         try {
	            multipartFile.transferTo(saveFile);
	         } catch (Exception e) {
	            e.printStackTrace();         
	         }
	      }
	      int res = postMapper.postUpdate(postDTO);
	      return res;
	   }
	
	@Override
	   public void deleteImage(String originalFileName) {
	      File deleteFile = new File("C://PleaseImage" + File.separator + originalFileName);
	      deleteFile.delete();
	   }

	
}
