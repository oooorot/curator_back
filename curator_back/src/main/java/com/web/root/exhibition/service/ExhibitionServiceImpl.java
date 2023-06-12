


package com.web.root.exhibition.service;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

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
	
	 // 작품내역(DB값)
	 @Override
	 public List<ExhibitionDTO> exhibitionBannerList(int exhibitionSeq) {
	    List<ExhibitionDTO> list = exhibitionMapper.exhibitionBannerList(exhibitionSeq);
	    return list;
	 }

	 // 작품내역(이미지)
	 @Override
	   public ResponseEntity<byte[]> exhibitionimage(String exhibitionBanner) {
	      File file = new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image" + exhibitionBanner);
	      ResponseEntity<byte[]> result = null;
	      try {
	         HttpHeaders header = new HttpHeaders();
	         header.add("Content-type", Files.probeContentType(file.toPath()));
	         result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return result;
	   }

	   // 작품등록
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
	   
	   // 작품수정
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
	   
	   // 작품수정 중 기존 이미지파일 삭제
	   public void exhibitionDelete(String exhibitionDelete) {
	      System.out.println("C:\\Users\\Administrator\\Pictures\\image\\bg_image\\" + exhibitionDelete);
	      File file = new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image\\" + exhibitionDelete);
	      file.delete();
	   }
	   
	   // 작품수정 중 새 이미지파일 업로드
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
