


package com.web.root.exhibition.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.exhibition.dto.ExhibitionDTO;
import com.web.root.mybatis.exhibition.ExhibitionMapper;

@Service
public class ExhibitionServiceImpl implements ExhibitionService {
	
		@Autowired
		private ExhibitionMapper exhibitionMapper;
	
		// 전시회 리스트
		@Override
		public List<ExhibitionDTO> exhibitionList() {
		     try {
		         List<ExhibitionDTO> list = exhibitionMapper.exhibitionList();
		         for(int i = 0; i < list.size(); i++) {
		        	 ExhibitionDTO exhibitionDTO = list.get(i);
		        	 String ImageName = exhibitionDTO.getExhibitionBanner();
		             byte[] photoEncode = Files.readAllBytes(new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image" + File.separator + ImageName).toPath());
		             String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
		             exhibitionDTO.setExhibitionBanner(photoEncodeName);
		         }
		         return list;      
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      return null;
		}
		
		// 전시회 조회
		@Override
		public ExhibitionDTO exhibitionView(int exhibitionSeq) throws IOException {
			 ExhibitionDTO exhibitionDTO = exhibitionMapper.exhibitionView(exhibitionSeq);
	       	 String ImageName = exhibitionDTO.getExhibitionBanner();
	         byte[] photoEncode = Files.readAllBytes(new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image" + File.separator + ImageName).toPath());
	         String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
	         exhibitionDTO.setExhibitionBanner(photoEncodeName);
			return exhibitionDTO;
		}
	
	   // 전시회 등록
	   @Override
	   public int exhibitionWrite(ExhibitionDTO exhibitionDTO, MultipartFile multipartFile) {
	      if(multipartFile.getSize() != 0) {
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
	         Calendar calendar = Calendar.getInstance();
	         String sysFileName = sdf.format(calendar.getTime());
	         sysFileName += multipartFile.getOriginalFilename();
	         exhibitionDTO.setExhibitionBanner(sysFileName);
	         File exhibitionBanner = new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image" + File.separator + sysFileName);
	         try {
	            multipartFile.transferTo(exhibitionBanner);
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	      return exhibitionMapper.exhibitionWrite(exhibitionDTO);
	   }
	   
	   // 전시회 수정
	   @Override
	   public int exhibitionUpdate(ExhibitionDTO exhibitionDTO, MultipartFile multipartFile) {
	      int result = 0;
	      if(multipartFile.getSize() != 0) {
	    	  exhibitionDelete(exhibitionDTO.getExhibitionBanner());
	         exhibitionDTO.setExhibitionBanner(onlyExhibitionUpdate(multipartFile));
	      } else {
	    	  exhibitionDTO.setExhibitionBanner(onlyExhibitionUpdate(multipartFile));
	      }
	      try {
	         result = exhibitionMapper.exhibitionUpdate(exhibitionDTO);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return result;
	   }
	   
	   // 전시회 수정 중 기존 이미지파일 삭제
	   public void exhibitionDelete(String exhibitionDelete) {
	      System.out.println("C:\\Users\\Administrator\\Pictures\\image\\bg_image\\" + exhibitionDelete);
	      File file = new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image\\" + exhibitionDelete);
	      file.delete();
	   }
	   
	   // 전시회 수정 중 새 이미지파일 업로드
	   public String onlyExhibitionUpdate(MultipartFile multipartFile) {
		   ExhibitionDTO exhibitionDTO = new ExhibitionDTO();
	      if(multipartFile.getSize() != 0) {
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
	         Calendar calendar = Calendar.getInstance();
	         String sysFileName = sdf.format(calendar.getTime());
	         sysFileName += multipartFile.getOriginalFilename();
	         exhibitionDTO.setExhibitionBanner(sysFileName);
	         File exhibitionUpdateFile = new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image" + File.separator + sysFileName);
	         try {
	            multipartFile.transferTo(exhibitionUpdateFile);
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	      return exhibitionDTO.getExhibitionBanner();
	   }   

}
