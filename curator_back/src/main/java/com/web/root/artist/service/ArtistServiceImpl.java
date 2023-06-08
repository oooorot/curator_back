package com.web.root.artist.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;
import com.web.root.mybatis.artist.ArtistMapper;

@Service
public class ArtistServiceImpl implements ArtistService{

   @Autowired
   private ArtistMapper artistMapper;


<<<<<<< HEAD
   // 작가 리스트 불러오기
   @Override
   public List<ArtistDTO> artistAllList() {
      try {
         List<ArtistDTO> list = artistMapper.artistAllList();
         return list;      
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
=======
	// 작가 리스트 불러오기
	@Override
	public List<ArtistDTO> artistAllList() {
		try {
			List<ArtistDTO> list = artistMapper.artistAllList();
			return list;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
>>>>>>> branch 'main' of https://github.com/LeeBumS/curator_back.git

<<<<<<< HEAD
   
   // 작가 조회
   @Override
   public ArtistDTO artistInform(int artistSeq) {
=======
	
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
>>>>>>> branch 'main' of https://github.com/LeeBumS/curator_back.git

<<<<<<< HEAD
      try {
         ArtistDTO artistDTO = artistMapper.artistInform(artistSeq);      
         return artistDTO;   
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
=======
	
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
	
	
	// 조회수 증가
	public void updateHit(int artistSeq) {
		artistMapper.updateHit(artistSeq); 
	}
	
>>>>>>> branch 'main' of https://github.com/LeeBumS/curator_back.git

   
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
   
   
   // 조회수 증가
   public void updateHit(int artistSeq) {
      artistMapper.updateHit(artistSeq); 
   }
   

   
}
