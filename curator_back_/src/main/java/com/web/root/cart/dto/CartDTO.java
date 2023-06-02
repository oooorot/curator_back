package com.web.root.cart.dto;

public class CartDTO {

	private int cartSeq;
   	private int postSeq;
    private int memberSeq;
   
    public CartDTO() {}

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
