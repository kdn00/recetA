package com.recetA.domain;

public class Basictime {
	
	// 대분류
	private String b_ctype;
	// 조리 시간
	private String b_time;
	// 페이징 시작 페이지
	private int start_page;
	// 페이징 끝 페이지
	private int end_page;
	
	
	public Basictime(String b_ctype, String b_time) {
		super();
		this.b_ctype = b_ctype;
		this.b_time = b_time;
	}

	public Basictime(String b_ctype, String b_time, int start_page, int end_page) {
		super();
		this.b_ctype = b_ctype;
		this.b_time = b_time;
		this.start_page = start_page;
		this.end_page = end_page;
	}



	public Basictime() {
		super();
	}


	public String getB_ctype() {
		return b_ctype;
	}


	public void setB_ctype(String b_ctype) {
		this.b_ctype = b_ctype;
	}


	public String getB_time() {
		return b_time;
	}


	public void setB_time(String b_time) {
		this.b_time = b_time;
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
