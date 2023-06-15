package com.web.root.artist.service;


import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.artist.dto.ArtistProfileDTO;
import com.web.root.customer.dto.BookmarkDTO;
import com.web.root.mybatis.artist.ArtistMapper;

@Service
public class ArtistServiceImpl implements ArtistService{

   @Autowired
   private ArtistMapper artistMapper;


   // 작가 리스트 불러오기
   @Override
   public List<ArtistProfileDTO> artistAllList() {     
     try {
         List<ArtistProfileDTO> list = artistMapper.artistAllList();
         for(int i = 0; i < list.size(); i++) {
        	 ArtistProfileDTO artistProfileDTO = list.get(i);
        	 String ImageName = artistProfileDTO.getArtistImage();
             byte[] photoEncode = Files.readAllBytes(new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image" + File.separator + ImageName).toPath());
             String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
             artistProfileDTO.setArtistImage(photoEncodeName);
         }
         return list;      
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   
   // 작가 조회
   @Override
   public ArtistDTO artistInform(int artistSeq) {

      try {
         ArtistDTO artistDTO = artistMapper.artistInform(artistSeq);      
         return artistDTO;   
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   // 작가 top 불러오기
   @Override
   public List<ArtistDTO> artistTop() {
      try {
         List<ArtistDTO> list = artistMapper.artistTop();
         return list;      
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

// 북마크 등록
   @Override
   public int artistBookmark(Map<String, Object> map) { 
      int res= 0;
      try {
         BookmarkDTO bookmarkDTO = new BookmarkDTO();
         bookmarkDTO.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
         bookmarkDTO.setArtistSeq(Integer.parseInt(map.get("artistSeq").toString()));
         res = artistMapper.artistBookmark(bookmarkDTO);      
         updateHit(bookmarkDTO.getArtistSeq());
      } catch (Exception e) {
         e.printStackTrace();   
      }
      return res;
   }   
   
   
   // 좋아요 증가
   public void updateHit(int artistSeq) {
      artistMapper.updateHit(artistSeq); 
   }

}