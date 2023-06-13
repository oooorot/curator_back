


package com.web.root.genre.service;

import java.io.File;
import java.nio.file.Files;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.web.root.genre.dto.GenreDTO;
import com.web.root.mybatis.genre.GenreMapper;
import com.web.root.post.dto.PostDTO;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private GenreMapper genreMapper;
	
	@Override
	public List<GenreDTO> genreList() {
		try {
			List<GenreDTO> list = genreMapper.genreList();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PostDTO> genreView(int genreSeq) {
		try {
			List<PostDTO> dto = genreMapper.genreView(genreSeq);
			return dto;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	 // 작품내역(이미지)
	 @Override
	   public ResponseEntity<byte[]> genrePostImageName(String postImageName) {
	      File file = new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image" + postImageName);
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

}
