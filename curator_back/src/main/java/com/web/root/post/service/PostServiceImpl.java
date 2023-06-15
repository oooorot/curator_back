


package com.web.root.post.service;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.customer.dto.CartDTO;
import com.web.root.mybatis.post.PostMapper;
import com.web.root.post.dto.PostAuctionDTO;
import com.web.root.post.dto.PostDTO;
import com.web.root.post.dto.PostExhibitionDTO;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostMapper postMapper;
	
	// 그림게시판 조회
	@Override
	public PostDTO postView(int postSeq) {
		try {
			PostDTO postDTO = new PostDTO();
			postDTO = postMapper.postView(postSeq);
			String ImageName = postDTO.getPostImageName();
            byte[] photoEncode = Files.readAllBytes(new File("/Users/orot/workbench/00_project/project_storage" + File.separator + ImageName).toPath());
            String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
            postDTO.setPostImageName(photoEncodeName);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//그림게시판 리스트
	@Override
	public List<PostDTO> postList() {
		try {
			List<PostDTO> list = postMapper.postList();
	        for(int i = 0; i < list.size(); i++) {
	        	PostDTO postDTO = list.get(i);
	        	String ImageName = postDTO.getPostImageName();
	            byte[] photoEncode = Files.readAllBytes(new File("/Users/orot/workbench/00_project/project_storage" + File.separator + ImageName).toPath());
	            String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
	            postDTO.setPostImageName(photoEncodeName);
	        }
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
		     try {
		    	 list = postMapper.viewAuction(postAuction);
		         for(int i = 0; i < list.size(); i++) {
		        	 PostAuctionDTO postAuctionDTO = list.get(i);
		        	 String ImageName = postAuctionDTO.getPostImageName();
		             byte[] photoEncode = Files.readAllBytes(new File("/Users/orot/workbench/00_project/project_storage" + File.separator + ImageName).toPath());
		             String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
		             postAuctionDTO.setPostImageName(photoEncodeName);
		         }
		         return list;      
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		default : return null;
		}
	}
	
	// 전시회 유무
	@Override
	public List<PostExhibitionDTO> postExhibition(int postExhibition) {
		List<PostExhibitionDTO> list = null;
		List<PostDTO> postlist = null;
		switch(postExhibition) {
		case 1 : 
			try {
				list = postMapper.postExhibition1(postExhibition);
		        for(int i = 0; i < list.size(); i++) {
		        	PostExhibitionDTO postExhibitionDTO = list.get(i);
		        	String ImageName = postExhibitionDTO.getPostImageName();
		            byte[] photoEncode = Files.readAllBytes(new File("/Users/orot/workbench/00_project/project_storage" + File.separator + ImageName).toPath());
		            String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
		            postExhibitionDTO.setPostImageName(photoEncodeName);
		            
		            String bannerName = postExhibitionDTO.getExhibitionBanner();
		            byte[] bannerEncode = Files.readAllBytes(new File("/Users/orot/workbench/00_project/project_storage" + File.separator + bannerName).toPath());
		            String bannerEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(bannerEncode);
		            postExhibitionDTO.setExhibitionBanner(bannerEncodeName);
		        }
		        return list;      
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
			return list;
		case 2 :
			try {
				postlist = postMapper.viewExhibition(postExhibition);
		        for(int i = 0; i < postlist.size(); i++) {
		        	PostDTO postDTO = postlist.get(i);
		        	String ImageName = postDTO.getPostImageName();
		            byte[] photoEncode = Files.readAllBytes(new File("/Users/orot/workbench/00_project/project_storage" + File.separator + ImageName).toPath());
		            String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
		            postDTO.setPostImageName(photoEncodeName);
		        }
		        return list;      
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		default : return null;	
		}
	}
 		
	// 그림 장바구니
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
	
	// 그림 삭제
	@Override
	public int postDelete(int postSeq) {
		try {
			return postMapper.postDelete(postSeq);
		} catch (Exception e) {
			return 0;
		}
	}
	
	// 그림 수정
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
	   File deleteFile = new File("/Users/orot/workbench/00_project/project_storage" + File.separator + originalFileName);
	   deleteFile.delete();
	}

}
