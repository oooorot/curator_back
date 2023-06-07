package com.web.root.auction.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.root.auction.dto.AuctionDTO;
import com.web.root.auction.service.AuctionService;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class AuctionController {
	
	@Autowired
	public AuctionService auctionService;
	
	// 경매 : 현황
	@GetMapping(value="auctionView", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<AuctionDTO> auctionView(@RequestBody Map<String, Object> map){
		return auctionService.auctionView(map);
	}
	
	// 경매 : 입찰
	@PostMapping(value="auctionBid", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int auctionBid(@RequestBody Map<String, Object> map) {
		return auctionService.auctionBid(map);
	}
	
	// 이 달의 경매
}






