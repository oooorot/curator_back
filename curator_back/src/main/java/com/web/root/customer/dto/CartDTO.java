


package com.web.root.customer.dto;

public class CartDTO {
	
	private int cartSeq;
	   private int postSeq;
	   private int memberSeq;
	   
	   public CartDTO() {
	      super();
	   }

	   public CartDTO(int cartSeq, int postSeq, int memberSeq) {
	      super();
	      this.cartSeq = cartSeq;
	      this.postSeq = postSeq;
	      this.memberSeq = memberSeq;
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

}
