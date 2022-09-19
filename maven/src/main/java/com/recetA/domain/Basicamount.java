package com.recetA.domain;

public class Basicamount {

	// 대분류
	private String b_ctype;
	// n인분
	private String b_amount;
	
	public Basicamount(String b_ctype, String b_amount) {
		super();
		this.b_ctype = b_ctype;
		this.b_amount = b_amount;
	}

	public Basicamount() {
		super();
	}

	public String getB_ctype() {
		return b_ctype;
	}

	public void setB_ctype(String b_ctype) {
		this.b_ctype = b_ctype;
	}

	public String getB_amount() {
		return b_amount;
	}

	public void setB_amount(String b_amount) {
		this.b_amount = b_amount;
	}
	
	

}
