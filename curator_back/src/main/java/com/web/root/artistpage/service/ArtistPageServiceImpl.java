package com.web.root.artistpage.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.auction.service.AuctionServiceImpl;
import com.web.root.commission.dto.CommissionDTO;
import com.web.root.mybatis.artistpage.ArtistPageMapper;
import com.web.root.post.dto.PostDTO;
import com.web.root.session.imagepath.ImagePath;

@Service
public class ArtistPageServiceImpl implements ArtistPageService, ImagePath{

	@Autowired
	public ArtistPageMapper artistPageMapper;
	
	@Autowired
	public AuctionServiceImpl auctionService;
	
	// 작가회원정보
	@Override
	public ArtistDTO artistMemberInfo(Map<String, Object> map) throws IOException {
		ArtistDTO artistDTO = artistPageMapper.artistMemberInfo(Integer.parseInt(map.get("artistSeq").toString()));
		String ImageName = artistDTO.getArtistImage();
        byte[] photoEncode = Files.readAllBytes(new File(IMAGE_PATH + File.separator + ImageName).toPath());
        String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
        artistDTO.setArtistImage(photoEncodeName);
		return artistDTO;  
	}
	
	// 작가회원정보 수정
	@Override
	public int artistMemberUpdate(ArtistDTO artistDTO, MultipartFile multipartFile) {
		int result = 0;
		if(multipartFile.getSize() != 0) {
			exArtistImgDelete(artistDTO.getArtistImage());
			artistDTO.setArtistImage(onlyArtistImgUpdate(multipartFile));
		} else {
			artistDTO.setArtistImage(onlyArtistImgUpdate(multipartFile));
		}
		try {
			result = artistPageMapper.artistMemberUpdate(artistDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 작가회원정보 수정 중 기존 이미지파일 삭제
	public void exArtistImgDelete(String exPostDelete) {
		System.out.println("/Users/orot/workbench/00_project/project_storage" + exPostDelete);
		File file = new File("/Users/orot/workbench/00_project/project_storage" + exPostDelete);
		file.delete();
	}
	// 작가회원정보 수정 중 새 이미지파일 업로드
	public String onlyArtistImgUpdate(MultipartFile multipartFile) {
		ArtistDTO artistDTO = new ArtistDTO();
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
		return artistDTO.getArtistImage();
	}
	
	// 작가회원탈퇴
	@Override
	public int artistMemberDelete(Map<String, String> map) {
		try {
			int artistSeq = Integer.parseInt(map.get("artistSeq"));
			return artistPageMapper.artistMemberDelete(artistSeq);
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	// 작품내역
	@Override
	public List<PostDTO> artistPostList(int artistSeq) {
	     try {
	         List<PostDTO> list = artistPageMapper.artistPostList(artistSeq);
	         for(int i = 0; i < list.size(); i++) {
	        	 PostDTO postDTO = list.get(i);
	        	 String ImageName = postDTO.getPostImageName();
	             byte[] photoEncode = Files.readAllBytes(new File(IMAGE_PATH + File.separator + ImageName).toPath());
	             String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
	             postDTO.setPostImageName(photoEncodeName);
	         }
	         return list;      
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return null;
	}

	// 작품등록
	   @Override
	   public int artistPostWrite(PostDTO postDTO, MultipartFile multipartFile) {
	      
	      if(multipartFile.getSize() != 0) {
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
	         Calendar calendar = Calendar.getInstance();
	         String sysFileName = sdf.format(calendar.getTime());
	         sysFileName += multipartFile.getOriginalFilename();
	         postDTO.setPostImageName(sysFileName);
	         File artistPostFile = new File(IMAGE_PATH + File.separator + sysFileName);
	         try {
	            multipartFile.transferTo(artistPostFile);
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	      if(postDTO.getPostAuction()==1) {
	         artistPageMapper.artistPostWrite(postDTO);
	         auctionService.timeOver();
	         return 1;
	      } 
	      if(postDTO.getPostAuction()==2) {
	         artistPageMapper.artistPostWrite(postDTO);
	         return 1;
	      }
	      return 0;
	   }
	
	
	// 작품수정
	@Override
	public int artistPostUpdate(PostDTO postDTO, MultipartFile multipartFile) {
		int result = 0;
		if(multipartFile.getSize() != 0) {
			exPostDelete(postDTO.getPostImageName());
			postDTO.setPostImageName(onlyPostUpdate(multipartFile));
		} else {
			postDTO.setPostImageName(onlyPostUpdate(multipartFile));
		}
		try {
			result = artistPageMapper.artistPostUpdate(postDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 작품수정 중 기존 이미지파일 삭제
	public void exPostDelete(String exPostDelete) {
		System.out.println(IMAGE_PATH + exPostDelete);
		File file = new File(IMAGE_PATH + exPostDelete);
		file.delete();
	}
	// 작품수정 중 새 이미지파일 업로드
	public String onlyPostUpdate(MultipartFile multipartFile) {
		PostDTO postDTO = new PostDTO();
		if(multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			postDTO.setPostImageName(sysFileName);
			File artistPostFile = new File(IMAGE_PATH + File.separator + sysFileName);
			try {
				multipartFile.transferTo(artistPostFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return postDTO.getPostImageName();
	}

	// 의뢰내역
	@Override
	public List<CommissionDTO> PostCommissionList(int artistSeq) {
		return artistPageMapper.PostCommissionList(artistSeq);
	}

}
