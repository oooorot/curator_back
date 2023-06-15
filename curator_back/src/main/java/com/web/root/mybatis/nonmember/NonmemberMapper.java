package com.web.root.mybatis.nonmember;

import java.util.Set;

import com.web.root.nonmember.dto.NonmemberDTO;

public interface NonmemberMapper {

	public NonmemberDTO getNonmember(int nonSeq);

	public int nonmemberInform(NonmemberDTO nonmemberDTO);
	
	public int getNonCode();
	
	public Integer getNonCode(NonmemberDTO nonmemberDTO);
	
}
