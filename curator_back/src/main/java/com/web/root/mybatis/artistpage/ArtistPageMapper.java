package com.web.root.mybatis.artistpage;

import java.util.List;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.commission.dto.CommissionDTO;
import com.web.root.post.dto.PostDTO;

public interface ArtistPageMapper {
	
	// 작가회원정보
	public ArtistDTO artistMemberInfo(int artistSeq);
	
	// 작가회원정보 수정
	public int artistMemberUpdate(ArtistDTO artistDTO);
	
	// 작가회원탈퇴
	public int artistMemberDelete(int artistSeq);
	
	// 작품내역
	public List<PostDTO> artistPostList(int artistSeq);
	
	// 작품등록
	public int artistPostWrite(PostDTO postDTO);
	
	// 경매번호가져오기
//	public int getAuctionPostSeq(int PostSeq);
	
	// 작품수정(artistPostUpdate : DB수정)
	public int artistPostUpdate(PostDTO postDTO);
	
	// 의뢰내역
	public List<CommissionDTO> PostCommissionList(int artistSeq);

//	public int artistPostWrite(int postAuction);

}
