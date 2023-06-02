package com.web.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.dto.TestDTO;
import com.web.root.mybatis.TestMapper;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper mapper;
	
	@Override
	public List<TestDTO> getListTest(HttpServletResponse response) {
		List<TestDTO> list = mapper.getListTest();
		return list;
	}
	
	@Override
	public TestDTO getTest(Map<String, Object> map) {
		TestDTO dto = mapper.getTest(Integer.parseInt(map.get("value1").toString()));
		System.out.println(Integer.parseInt(map.get("value1").toString()));
		return dto;
	}
	
	@Override
	public String saveTest(Map<String, Object> map) {
		TestDTO dto = new TestDTO();
		dto.setValue2(map.get("value2").toString());
		dto.setValue3(map.get("value3").toString());
		dto.setValue4(map.get("value4").toString());
		dto.setValue5(map.get("value5").toString());
		dto.setValue6(map.get("value6").toString());
		dto.setValue7(map.get("value7").toString());
		dto.setValue8(map.get("value8").toString());
		dto.setValue9(map.get("value9").toString());
		int res = mapper.saveTest(dto);
		String msg = "등록에 실패하였습니다.";
		if(res != 0) {
			msg = "등록에 성공하였습니다.";
		}
		return msg;
	}
	
	@Override
	public String updateTest(Map<String, Object> map) {
		TestDTO dto = new TestDTO();
		dto.setValue1(Integer.parseInt(map.get("value1").toString()));
		dto.setValue2(map.get("value2").toString());
		dto.setValue3(map.get("value3").toString());
		dto.setValue4(map.get("value4").toString());
		dto.setValue5(map.get("value5").toString());
		dto.setValue6(map.get("value6").toString());
		dto.setValue7(map.get("value7").toString());
		dto.setValue8(map.get("value8").toString());
		dto.setValue9(map.get("value9").toString());
		int res = mapper.updateTest(dto);
		String msg = "수정에 실패하였습니다.";
		if(res != 0) {
			msg = "수정에 성공하였습니다.";
		}
		return msg;
	}
	
	@Override
	public String deleteTest(Map<String, Object> map) {
		int res = mapper.deleteTest(Integer.parseInt(map.get("value1").toString()));
		String msg = "삭제에 실패하였습니다.";
		if(res != 0) {
			msg = "삭제에 성공하였습니다.";
		}
		return msg;
	}
	
	@Override
	public String fileProcess(TestDTO dto, MultipartFile multipartFile) {
		if (multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			
			dto.setValue9(sysFileName);
			
			File saveFile = new File("/Users/orot/workbench/00_project/project_storage" + File.separator + sysFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();			
			}
			 
		
			mapper.saveData(dto);
		
		}
		return "success";

	}
}
