package com.web.root.auction.service;
 
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

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
	
	
	// 경매 : 삭제
	@Override
	public int deleteAuction(Map<String, Object> map) {
		int res = 0;
		try {
			res = auctionMapper.deleteAuction(Integer.parseInt(map.get("aucSeq").toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	// 경매 조회 
	public AuctionDTO getAuction(int aucSeq) {
		return auctionMapper.getAuction(aucSeq);
	}
	
	
	
	
	
	
	
	
	// 경매 카운트 다운 (어디에 집어 넣어야 하는가??)
	public void timeOver() {
		
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {	
				
				AuctionDTO auctionDTO = new AuctionDTO();
				
				// 현재 시간
				LocalDateTime now = LocalDateTime.now();

				// 경매 종료 시간 (년, 월, 일, 시, 분, 초)
				LocalDateTime endTime = LocalDateTime.of(2023, 6, 11, 11, 00, 00);
				
				System.out.println(endTime);
				
				// now시간부터 endTime시간까지 시간차이(초단위)를 count에 담기
				long count = now.until(endTime, ChronoUnit.SECONDS);
				
				if(count > 0) {
					System.out.println(count);
				} else if(count == 0){
					// 제일 높은 auc_price 가진 회원 데이터 넘기고
					auctionMapper.getSuccessfulBid(auctionDTO.getAucPrice());
					// 나머지 회원들 데이터 삭제
					auctionMapper.deleteParticipant(auctionDTO.getAucPrice());
					timer.cancel();
				} else {
					// 제일 높은 auc_price 가진 회원 데이터 넘기고
					auctionMapper.getSuccessfulBid(auctionDTO.getAucPrice());
					// 나머지 회원들 데이터 삭제
					auctionMapper.deleteParticipant(auctionDTO.getAucPrice());
					timer.cancel();
				}
			}
		};	
		// now.getTime()='현재시간'부터 1초간격으로 run() 실행 
		timer.schedule(timerTask, new Date(), 1000);
	}
	
	
	
	
	
}
