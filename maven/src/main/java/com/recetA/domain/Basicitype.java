package com.recetA.domain;

public class Basicitype {

	// 대분류
	private String b_ctype;
	// 재료 유형
	private String b_itype;
	
	public Basicitype(String b_ctype, String b_itype) {
		super();
		this.b_ctype = b_ctype;
		this.b_itype = b_itype;
	}
	
	public Basicitype() {
		super();
	}
	
	public String getB_ctype() {
		return b_ctype;
	}
	public void setB_ctype(String b_ctype) {
		this.b_ctype = b_ctype;
	}
	public String getB_itype() {
		return b_itype;
	}
	public void setB_itype(String b_itype) {
		this.b_itype = b_itype;
	}
	
	
}
