package com.web.root.mybatis;

import java.util.List;

import com.web.root.dto.TestDTO;

public interface TestMapper {
	
	public List<TestDTO> getListTest();
	
	public TestDTO getTest(int value1);
		
	public int saveTest(TestDTO dto);
	
	public int updateTest(TestDTO dto);
	
	public int deleteTest(int seq);
	
	public int saveData(TestDTO dto);
	

}
