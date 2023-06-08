package com.web.root.mybatis.nonmember;

import com.web.root.nonmember.dto.NonmemberDTO;

public interface NonmemberMapper {

	public NonmemberDTO getNonmember(int nonSeq);

	public int nonmemberInform(NonmemberDTO dto);
	
}
