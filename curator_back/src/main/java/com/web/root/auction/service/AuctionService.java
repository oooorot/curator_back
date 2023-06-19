package com.web.root.auction.service;

import java.util.List;
import java.util.Map;

import com.web.root.auction.dto.AuctionDTO;

public interface AuctionService {

	// 경매 : 현황
	public List<AuctionDTO> auctionView(int postSeq);
	
	// 경매 : 입찰
	public int auctionBid(Map<String, Object> map);
	
	// 경매 : 삭제
	public int deleteAuction(Map<String, Object> map);
	
	// 경매 : 조회
	public AuctionDTO getAuction(int aucSeq);

	

	
}
