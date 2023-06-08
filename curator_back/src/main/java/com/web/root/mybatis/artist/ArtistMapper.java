package com.web.root.mybatis.artist;

import java.util.List;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.bookmark.dto.BookmarkDTO;

public interface ArtistMapper {

   // 작가 리스트 불러오기
   public List<ArtistDTO> artistAllList();
   
   // 작가 조회
   public ArtistDTO artistInform(int artistSeq);

   // 북마크 등록
   public int artistBookmark(BookmarkDTO bookmarkDTO);

   // 조회수 증가
   public void updateHit(int artistSeq);

   
}