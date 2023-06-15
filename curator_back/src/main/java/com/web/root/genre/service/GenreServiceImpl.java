


package com.web.root.genre.service;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	        List<PostDTO> list = genreMapper.genreView(genreSeq);
	        for(int i = 0; i < list.size(); i++) {
	        	PostDTO postDTO = list.get(i);
	            String ImageName = postDTO.getPostImageName();
	            byte[] photoEncode = Files.readAllBytes(new File("C:\\Users\\Administrator\\Pictures\\image\\bg_image" + File.separator + ImageName).toPath());
	            String photoEncodeName = "data:application/octet-stream;base64, " + Base64.getEncoder().encodeToString(photoEncode);
	            postDTO.setPostImageName(photoEncodeName);
	        }
	        return list;      
	     } catch (Exception e) {
	        e.printStackTrace();
	     }
	     return null;
	}

}
