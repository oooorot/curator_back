package com.web.root.artistpage.service;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.artist.dto.ArtistDTO;
import com.web.root.commission.dto.CommissionDTO;
import com.web.root.mybatis.artistpage.ArtistPageMapper;
import com.web.root.post.dto.PostDTO;

@Service
public class ArtistPageServiceImpl implements ArtistPageService{

	@Autowired
	public ArtistPageMapper artistPageMapper;
	
	// 작가회원정보
	@Override
	public ArtistDTO artistMemberInfo(Map<String, Object> map) {
		ArtistDTO memberDTO = artistPageMapper.artistMemberInfo(Integer.parseInt(map.get("artistSeq").toString()));
		return memberDTO;  
	}
	
	// 작가회원정보 수정
	@Override
	public int artistMemberUpdate(Map<String, Object> map) {
		try {
			if(map.get("memberPw")!=null&map.get("memberNickname")!=null&map.get("memberName")!=null&map.get("memberPhone")!=null&map.get("memberAddr")!=null) {
				return artistPageMapper.artistMemberUpdate(map);
			} else return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// 작가회원탈퇴
	@Override
	public int artistMemberDelete(int MemberSeq) {
		try {
			return artistPageMapper.artistMemberDelete(MemberSeq);
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	// 작품내역(DB값)
	@Override
	public List<PostDTO> artistPostList(int artistSeq) {
		List<PostDTO> list = artistPageMapper.artistPostList(artistSeq);
		return list;
	}

	// 작품내역(이미지)
	@Override
	public ResponseEntity<byte[]> artistPostImage(String postImageName) {
		File file = new File("" + postImageName);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 작품등록
	@Override
	public int artistPostUpdate(PostDTO postDTO, MultipartFile multipartFile) {
		if(multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			postDTO.setPostImageName(sysFileName);
			File artistPostFile = new File("/Users/orot/workbench/00_project/project_storage" + File.separator + sysFileName);
			try {
				multipartFile.transferTo(artistPostFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return artistPageMapper.artistPostUpdate(postDTO);
	}

	// 의뢰내역
	@Override
	public List<CommissionDTO> PostCommissionList(int artistSeq) {
		return artistPageMapper.PostCommissionList(artistSeq);
	}

}
