package com.web.root.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.web.root.dto.TestDTO;

public interface TestService {
	
	public List<TestDTO> getListTest(HttpServletResponse response);
	
	public TestDTO getTest(Map<String, Object> map);
	
	public String saveTest(Map<String, Object> map);
	
	public String updateTest(Map<String, Object> map);
	
	public String deleteTest(Map<String, Object> map);
	
	public String fileProcess(TestDTO dto, MultipartFile multipartFile);

}
