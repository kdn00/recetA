package com.recetA.domain;

public class Basicamount {

	// 대분류
	private String b_ctype;
	// n인분
	private String b_amount;
	// 페이징 시작 페이지
	private int start_page;
	// 페이징 끝 페이지
	private int end_page;
	
	public Basicamount(String b_ctype, String b_amount) {
		super();
		this.b_ctype = b_ctype;
		this.b_amount = b_amount;
	}

	public Basicamount(String b_ctype, String b_amount, int start_page, int end_page) {
		super();
		this.b_ctype = b_ctype;
		this.b_amount = b_amount;
		this.start_page = start_page;
		this.end_page = end_page;
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

	public int getStart_page() {
		return start_page;
	}

	public void setStart_page(int start_page) {
		this.start_page = start_page;
	}

	public int getEnd_page() {
		return end_page;
	}

	public void setEnd_page(int end_page) {
		this.end_page = end_page;
	}
	
	
	
	

}
