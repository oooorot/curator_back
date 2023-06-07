package com.web.root.auction.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.auction.dto.AuctionDTO;
import com.web.root.mybatis.auction.AuctionMapper;

@Service
public class AuctionServiceImpl implements AuctionService{

	@Autowired
	public AuctionMapper auctionMapper;
	
	// 경매 : 현황
	@Override
	public List<AuctionDTO> auctionView(Map<String, Object> map) {
		return auctionMapper.auctionView(map);
	}

	// 경매 : 입찰	
	@Override
	public int auctionBid(Map<String, Object> map) {
		return auctionMapper.auctionBid(map);
	}
	
	
	
}
