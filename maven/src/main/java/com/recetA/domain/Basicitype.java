package com.recetA.domain;

public class Basicitype {

	// 대분류
	private String b_ctype;
	// 재료 유형
	private String b_itype;
	// 페이징 시작 페이지
	private int start_page;
	// 페이징 끝 페이지
	private int end_page;
	
	public Basicitype(String b_ctype, String b_itype) {
		super();
		this.b_ctype = b_ctype;
		this.b_itype = b_itype;
	}

	public Basicitype(String b_ctype, String b_itype, int start_page, int end_page) {
		super();
		this.b_ctype = b_ctype;
		this.b_itype = b_itype;
		this.start_page = start_page;
		this.end_page = end_page;
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
