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
	        for (int i = 0; i < 10; i++) {
	            if(n[i] == index)
	                return true;
	        }
	        return false;
	    }
		
	
//	public int getNonCode(NonmemberDTO nonmemberDTO) {
//		int res = 0;
//		String revCode = RandomStringUtils.randomNumeric(1);
//		nonmemberDTO.setNonCode(revCode);
//		res = nonmemberMapper.getNonCode(nonmemberDTO);
//		return res;
//	}
		
	
	// 비회원 구매시 정보 입력
	@Override
	public int nonmemberInform(Map<String, Object> map) {
		

		NonmemberDTO nonmemberDTO = new NonmemberDTO();
		
	    String revCode = RandomStringUtils.randomNumeric(1);
	    nonmemberDTO.setNonCode(revCode);
	    int count = nonmemberMapper.getNonCode(nonmemberDTO);
	    if(count == 0) {
    		nonmemberDTO.setNonCode(revCode);
    		nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
    		nonmemberDTO.setNonName(map.get("nonName").toString());
    		nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
    		nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
    		nonmemberDTO.setNonCompany(map.get("nonCompany").toString());
    		nonmemberDTO.setNonDscode(map.get("nonDscode").toString());
    	} else {
    		revCode = RandomStringUtils.randomNumeric(1);
    		count = nonmemberMapper.getNonCode(nonmemberDTO);
    	}
	    
	    return nonmemberMapper.nonmemberInform(nonmemberDTO);
	}
		

//		int count = jdbcTemplate.queryForObject(sql, Integer.class, randomValue);
//"SELECT COUNT(*) FROM your_table WHERE your_column = ?"
//		if (count > 0) {
//		    // Value is duplicated, generate a new random value or handle the duplication case
//		    // You can repeat steps 3 and 4 until a unique value is obtained
//		} else {
//		    // Value is unique, proceed with inserting it into the database
//		    // Write your insert logic here, using the generated randomValue
//		}
		
		
//		int res = 0;
//		NonmemberDTO nonmemberDTO = new NonmemberDTO();
//		Set<String> set = new HashSet<String>();
//		Set<String> getNonCode = new HashSet<String>();
//		getNonCode = nonmemberMapper.getNonCode();
//		while(set.size() < 10) {
//			String revCode = RandomStringUtils.randomNumeric(1);
//			set.add(revCode);
//			System.out.println(set);
//			System.out.println(getNonCode);
//			for(String s : set) {
//				System.out.println(s);
//				for(String g : getNonCode)
//					if(s.equals(g.toString()))
//						System.out.println(g);
//						nonmemberDTO.setNonCode(revCode);
//						System.out.println("2");
//						break;
//			}	
//		}
//		System.out.println("3");
//		nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
//		nonmemberDTO.setNonName(map.get("nonName").toString());
//		nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
//		nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
//		nonmemberDTO.setNonCompany(map.get("nonCompany").toString());
//		nonmemberDTO.setNonDscode(map.get("nonDscode").toString());
//		res = nonmemberMapper.nonmemberInform(nonmemberDTO);
//		

//		try {
//			nonmemberDTO.setNonCode(revCode);
//			nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
//			nonmemberDTO.setNonName(map.get("nonName").toString());
//			nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
//			nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
//			nonmemberDTO.setNonCompany(map.get("nonCompany").toString());
//			nonmemberDTO.setNonDscode(map.get("nonDscode").toString());
//			res = nonmemberMapper.nonmemberInform(nonmemberDTO);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}

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
//				if(revCode == RandomStringUtils.randomNumeric(1)){				
//					nonmemberDTO.setNonCode(revCode);
//					nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
//					nonmemberDTO.setNonName(map.get("nonName").toString());
//					nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
//					nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
//					nonmemberDTO.setNonCompany(map.get("nonCompany").toString());
//					nonmemberDTO.setNonDscode(map.get("nonDscode").toString());
//					res = nonmemberMapper.nonmemberInform(nonmemberDTO);
//					break;
//				} 
//				else{				
//					nonmemberDTO.setNonCode(newRevCode);
//					nonmemberDTO.setNonEmail(map.get("nonEmail").toString());
//					nonmemberDTO.setNonName(map.get("nonName").toString());
//					nonmemberDTO.setNonPhone(map.get("nonPhone").toString());
//					nonmemberDTO.setNonAddr(map.get("nonAddr").toString());
//					nonmemberDTO.setNonCompany(map.get("nonCompany").toString());
//					nonmemberDTO.setNonDscode(map.get("nonDscode").toString());
//					res = nonmemberMapper.nonmemberInform(nonmemberDTO);
//					break;	
//				}
//			}								
//		} catch (Exception e){
//			e.printStackTrace();
//		}

}
