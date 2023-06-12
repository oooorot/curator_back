package com.web.root.mybatis.nonmember;

import java.util.List;

import com.web.root.nonmember.dto.NonmemberDTO;

public interface NonmemberMapper {

	public NonmemberDTO getNonmember(int nonSeq);

	public int nonmemberInform(NonmemberDTO nonmemberDTO);
	
	public List<String> randomValue();
	
}
