


package com.web.root.exhibition.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.exhibition.dto.ExhibitionDTO;
import com.web.root.mybatis.exhibition.ExhibitionMapper;

@Service
public class ExhibitionServiceImpl implements ExhibitionService {
	
	@Autowired
	private ExhibitionMapper mapper;
	
	@Override
	public List<ExhibitionDTO> ExhibitionList() {
		List<ExhibitionDTO> list = mapper.ExhibitionList();
		return list;
	}

}
