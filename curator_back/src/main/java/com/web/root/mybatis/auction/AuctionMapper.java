package com.web.root.mybatis.auction;

import java.util.List;
import java.util.Map;

import com.web.root.auction.dto.AuctionDTO;

public interface AuctionMapper {

	// 경매 : 현황
	public List<AuctionDTO> auctionView(int postSeq);
	
	// 경매 : 입찰	
	public int auctionBid(Map<String, Object> map);
	
	// 경매 : 글 삭제
	public int deleteAuction(int aucSeq);
	
	// 경매 : 내역조회
	public AuctionDTO getAuction(int aucSeq);
	
	// 경매 : 낙찰
	public AuctionDTO getSuccessfulBid(Map<String, Object> map);
	
	// 경매 : 낙찰자 제외 참여자 삭제
	public int deleteParticipant();

	
}
