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
import com.web.root.auction.service.AuctionServiceImpl;
import com.web.root.commission.dto.CommissionDTO;
import com.web.root.mybatis.artistpage.ArtistPageMapper;
import com.web.root.post.dto.PostDTO;

@Service
public class ArtistPageServiceImpl implements ArtistPageService{

	@Autowired
	public ArtistPageMapper artistPageMapper;
	
	@Autowired
	public AuctionServiceImpl auctionService;
	
	// 작가회원정보
	@Override
	public ArtistDTO artistMemberInfo(Map<String, Object> map) {
		ArtistDTO memberDTO = artistPageMapper.artistMemberInfo(Integer.parseInt(map.get("artistSeq").toString()));
		return memberDTO;  
	}
	
	// 작품내역(이미지)
	@Override
	public ResponseEntity<byte[]> artistProfileImage(String artistImageName) {
		File file = new File("" + artistImageName);
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
	
	// 작가회원정보 수정
	@Override
	public int artistMemberUpdate(ArtistDTO artistDTO, MultipartFile multipartFile) {
		int result = 0;
		if(multipartFile.getSize() != 0) {
			exArtistImgDelete(artistDTO.getArtistImage());
			artistDTO.setArtistImage(onlyArtistImgUpdate(multipartFile));
		} else {
			artistDTO.setArtistImage(onlyArtistImgUpdate(multipartFile));
		}
		try {
			result = artistPageMapper.artistMemberUpdate(artistDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 작가회원정보 수정 중 기존 이미지파일 삭제
	public void exArtistImgDelete(String exPostDelete) {
		System.out.println("C:/Web/test/" + exPostDelete);
		File file = new File("C:/Web/test/" + exPostDelete);
		file.delete();
	}
	// 작가회원정보 수정 중 새 이미지파일 업로드
	public String onlyArtistImgUpdate(MultipartFile multipartFile) {
		ArtistDTO artistDTO = new ArtistDTO();
		if(multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			artistDTO.setArtistImage(sysFileName);
			File artistImageFile = new File("C:/Web/test" + File.separator + sysFileName);
			try {
				multipartFile.transferTo(artistImageFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return artistDTO.getArtistImage();
	}
	
	// 작가회원탈퇴
	@Override
	public int artistMemberDelete(int artistSeq) {
		try {
			return artistPageMapper.artistMemberDelete(artistSeq);
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
		File file = new File("C:\\gukbi_lee_jun_sam\\spring_origin\\resource\\image_repo" + postImageName);
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
	public int artistPostWrite(PostDTO postDTO, MultipartFile multipartFile) {
		if(multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			postDTO.setPostImageName(sysFileName);
			File artistPostFile = new File("C:\\gukbi_lee_jun_sam\\spring_origin\\resource\\image_repo" + File.separator + sysFileName);
			try {
				multipartFile.transferTo(artistPostFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(postDTO.getPostAuction()==1) {
			artistPageMapper.artistPostWrite(postDTO);
			//int postSeq = postDTO.getPostSeq();
			//artistPageMapper.getAuctionPostSeq(postSeq);
			System.out.println("실행 1");
			auctionService.timeOver();
			System.out.println("실행 2");
		}
		return 1;
	}
	
	
	// 작품수정
	@Override
	public int artistPostUpdate(PostDTO postDTO, MultipartFile multipartFile) {
		int result = 0;
		if(multipartFile.getSize() != 0) {
			exPostDelete(postDTO.getPostImageName());
			postDTO.setPostImageName(onlyPostUpdate(multipartFile));
		} else {
			postDTO.setPostImageName(onlyPostUpdate(multipartFile));
		}
		try {
			result = artistPageMapper.artistPostUpdate(postDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 작품수정 중 기존 이미지파일 삭제
	public void exPostDelete(String exPostDelete) {
		System.out.println("C:/Web/test/" + exPostDelete);
		File file = new File("C:/Web/test/" + exPostDelete + ".*");
		file.delete();
	}
	// 작품수정 중 새 이미지파일 업로드
	public String onlyPostUpdate(MultipartFile multipartFile) {
		PostDTO postDTO = new PostDTO();
		if(multipartFile.getSize() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = sdf.format(calendar.getTime());
			sysFileName += multipartFile.getOriginalFilename();
			postDTO.setPostImageName(sysFileName);
			File artistPostFile = new File("C:/Web/test" + File.separator + sysFileName);
			try {
				multipartFile.transferTo(artistPostFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return postDTO.getPostImageName();
	}

	// 의뢰내역
	@Override
	public List<CommissionDTO> PostCommissionList(int artistSeq) {
		return artistPageMapper.PostCommissionList(artistSeq);
	}

}
