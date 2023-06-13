package com.web.root.nonmember.service;

import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.mybatis.nonmember.NonmemberMapper;
import com.web.root.nonmember.dto.NonmemberDTO;

@Service
public class NonmemberServiceImpl implements NonmemberService{

	@Autowired
	private NonmemberMapper nonmemberMapper;
	
	

	// 비회원 정보 가져오기
	@Override
	public NonmemberDTO getNonmember(int nonSeq) {
		NonmemberDTO nonmemberDTO = new NonmemberDTO();
		try {
			nonmemberDTO = nonmemberMapper.getNonmember(nonSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nonmemberDTO;
	}
	
	
	
	// 중복 코드 제거 함수
		private static boolean exists(int n[], int index) {
	        for (int i = 0; i < n.length; i++) {
	            if(n[i] == index)
	                return true;
	        }
	        return false;
	    }
		

	
	// 비회원 구매시 정보 입력
	@Override
	public int nonmemberInform(Map<String, Object> map) {
		int res = 0;
//		List<String> list = new ArrayList<String>();
//		list = nonmemberMapper.randomValue();
//		Iterator<String> iter = list.iterator();
		NonmemberDTO nonmemberDTO = new NonmemberDTO();
		String revCode = RandomStringUtils.random(8, false, true);
		
		try {
			nonmemberDTO.setNonCode(revCode);
			nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
			nonmemberDTO.setNonName(map.get("nonName").toString());
			nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
			nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
			nonmemberDTO.setNonCompany(map.get("nonCompany").toString());
			nonmemberDTO.setNonDscode(map.get("nonDscode").toString());
			res = nonmemberMapper.nonmemberInform(nonmemberDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

//		while (iter.hasNext()) {
//			boolean revCode = iter.hasNext();
//			if(RandomStringUtils.random(1, false, true).equals(list)) {
//				nonmemberDTO.setNonCode(revCode);
//				break;
//			}
//			nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
//			nonmemberDTO.setNonName(map.get("nonName").toString());
//			nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
//			nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
//			res = nonmemberMapper.nonmemberInform(nonmemberDTO);	
//		}		
//	}
//		
//			
//		try {			
//			while(true){
//				int n[] = new int[2];
//				int index = 0;	
//				for(int i=0; i<n.length; i++) {
//					do {
//						index = Integer.parseInt(RandomStringUtils.random(1, false, true));
//					} while(exists(n, index));
//					n[i] = index;
//				}	
//				
//				revCode = String.valueOf(n[0]);
//				newRevCode = String.valueOf(n[1]);
//				
//				if(RandomStringUtils.random(1, false, true).equals(list)){				
//					nonmemberDTO.setNonCode(revCode);
//					nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
//					nonmemberDTO.setNonName(map.get("nonName").toString());
//					nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
//					nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
//					res = nonmemberMapper.nonmemberInform(nonmemberDTO);
//					break;
//				} 
//				else{				
//					nonmemberDTO.setNonCode(newRevCode);
//					nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
//					nonmemberDTO.setNonName(map.get("nonName").toString());
//					nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
//					nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
//					res = nonmemberMapper.nonmemberInform(nonmemberDTO);
//					break;	
//				}
//			}								
//		} catch (Exception e){
//			e.printStackTrace();
//		}
//		return res;
//	}
	
	
	
	
}
