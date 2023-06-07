package com.web.root.mybatis.post;






import java.util.List;
import java.util.Map;

import com.web.root.auction.dto.AuctionDTO;
import com.web.root.cart.dto.CartDTO;
import com.web.root.post.dto.PostDTO;
import com.web.root.postExhibition.dto.PostExhibitionDTO;
import com.web.root.postauction.dto.PostAuctionDTO;

public interface PostMapper {
	
	public PostDTO PostView(int postSeq);
	
	public List<PostDTO> postList();
	
	public int postWrite(PostDTO dto);

	public int postCart(CartDTO dto);
	
	public int postDelete(int postSeq);
	
	public int postUpdate(PostDTO dto);
	
	public List<PostExhibitionDTO> postExhibition1(int postExhibition);
	
	public List<PostExhibitionDTO> ViewExhibition(int postExibition);

	public List<PostAuctionDTO> postAuction(int postAuction);
	
	public AuctionDTO auctionSelect(int postSeq);
	
	public List<PostAuctionDTO> ViewAuction(int postAuction);

}
