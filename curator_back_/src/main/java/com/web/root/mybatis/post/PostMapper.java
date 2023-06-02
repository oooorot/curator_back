package com.web.root.mybatis.post;




import com.web.root.artist.dto.ArtistDTO;
import com.web.root.cart.dto.CartDTO;
import com.web.root.post.dto.PostDTO;

public interface PostMapper {
	
	public PostDTO PostView(int postSeq);
	
	public int postWrite(PostDTO dto);
	
	public int postCart(CartDTO dto);
	
	public int postDelete(int postSeq);
	
	public int postUpdate(PostDTO dto);

}
