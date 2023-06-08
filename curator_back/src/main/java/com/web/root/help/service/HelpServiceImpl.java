package com.web.root.help.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.help.dto.HelpDTO;
import com.web.root.mybatis.help.HelpMapper;


@Service
public class HelpServiceImpl implements HelpService{

	@Autowired
	private HelpMapper helpMapper;
	
	
	// 상담 게시글 불러오기
	@Override
	public List<HelpDTO> helpAllList() {
		try {
			List<HelpDTO> list = helpMapper.helpAllList();
			return list;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// 상담 게시글 조회
	@Override
	public HelpDTO helpView(int helpSeq) {
		try {
			HelpDTO helpDTO = helpMapper.helpView(helpSeq);
			return helpDTO;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	// 상담 게시글 등록
	@Override
	public int helpWrite(Map<String, Object> map) {
		int res = 0;
		try {
			HelpDTO helpDTO = new HelpDTO();
			helpDTO.setMemberSeq(Integer.parseInt(map.get("memberSeq").toString()));
			helpDTO.setHelpTitle(map.get("helpTitle").toString());
			helpDTO.setHelpContent(map.get("helpContent").toString());
			res = helpMapper.helpWrite(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	// 수정할 글 불러오기
	@Override
	public HelpDTO updateHelpView(int helpSeq) {
		try {
			HelpDTO helpDTO = helpMapper.updateHelpView(helpSeq);
			return helpDTO;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	// 상담 게시글 수정
	@Override
	public int helpUpdate(Map<String, Object> map) {
		HelpDTO helpDTO = new HelpDTO();
		helpDTO = helpMapper.updateHelpView(Integer.parseInt(map.get("helpSeq").toString()));
		try {
			if(helpDTO.getHelpTitle() !=null && helpDTO.getHelpContent() != null) {
				helpDTO.setHelpTitle(map.get("helpTitle").toString());
				helpDTO.setHelpContent(map.get("helpContent").toString());
				return helpMapper.helpUpdate(map);
			} else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	// 상담 게시글 삭제
	@Override
	public int helpDelete(Map<String, Object> map) {
		try {
			int res = helpMapper.helpDelete(Integer.parseInt(map.get("helpSeq").toString()));
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	
	
}
