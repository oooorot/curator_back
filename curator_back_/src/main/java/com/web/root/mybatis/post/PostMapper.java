package com.web.root.mybatis.post;




import com.web.root.artist.dto.ArtistDTO;
import com.web.root.post.dto.PostDTO;

public interface PostMapper {
	
	public PostDTO PostView(int postSeq);
	
	public int postWrite(PostDTO dto);

}
