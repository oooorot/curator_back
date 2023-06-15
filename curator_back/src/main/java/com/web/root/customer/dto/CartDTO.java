


package com.web.root.customer.dto;

public class CartDTO {
	
   private int cartSeq;
   private int postSeq;
   private int memberSeq;
   private int exhibitionSeq;
   
   public CartDTO() {}
   
   public CartDTO(int memberSeq, int postSeq) {
	   super();
	   this.memberSeq = memberSeq;
	   this.postSeq = postSeq;
   }

   public CartDTO(int cartSeq, int postSeq, int memberSeq, int exhibitionSeq) {
	super();
	this.cartSeq = cartSeq;
	this.postSeq = postSeq;
	this.memberSeq = memberSeq;
	this.exhibitionSeq = exhibitionSeq;
}


public int getCartSeq() {
      return cartSeq;
   }

   public void setCartSeq(int cartSeq) {
      this.cartSeq = cartSeq;
   }

   public int getPostSeq() {
      return postSeq;
   }

   public void setPostSeq(int postSeq) {
      this.postSeq = postSeq;
   }

   public int getMemberSeq() {
      return memberSeq;
   }

   public void setMemberSeq(int memberSeq) {
      this.memberSeq = memberSeq;
   }

	public int getExhibitionSeq() {
		return exhibitionSeq;
	}

	public void setExhibitionSeq(int exhibitionSeq) {
		this.exhibitionSeq = exhibitionSeq;
	}

	   
	   
}
