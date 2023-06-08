package com.web.root.mybatis.post;

import java.util.List;

import com.web.root.auction.dto.AuctionDTO;
import com.web.root.cart.dto.CartDTO;
import com.web.root.post.dto.PostAuctionDTO;
import com.web.root.post.dto.PostDTO;
import com.web.root.post.dto.PostExhibitionDTO;

public interface PostMapper {
	
	public PostDTO postView(int postSeq);
	
	public List<PostDTO> postList();
	
	public int postWrite(PostDTO postDTO);

	public int postCart(CartDTO cartDTO);
	
	public int postDelete(int postSeq);
	
	public int postUpdate(PostDTO postDTO);
	
	public List<PostExhibitionDTO> postExhibition1(int postExhibition);
	
	public List<PostExhibitionDTO> viewExhibition(int postExibition);

	public List<PostAuctionDTO> postAuction(int postAuction);
	
	public AuctionDTO auctionSelect(int postSeq);
	
	public List<PostAuctionDTO> viewAuction(int postAuction);

}
