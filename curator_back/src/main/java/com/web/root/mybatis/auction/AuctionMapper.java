package com.web.root.mybatis.auction;

import java.util.List;
import java.util.Map;

import com.web.root.auction.dto.AuctionDTO;

public interface AuctionMapper {

	// 경매 : 현황
	public List<AuctionDTO> auctionView(Map<String, Object> map);
	
	// 경매 : 입찰	
	public int auctionBid(Map<String, Object> map);
	
}
