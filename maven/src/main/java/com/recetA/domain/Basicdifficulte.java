package com.recetA.domain;

public class Basicdifficulte {
	
	// 대분류
	private String b_ctype;
	// 난이도
	private String b_difficulte;
	// 페이징 시작 페이지
	private int start_page;
	// 페이징 끝 페이지
	private int end_page;
	
	public Basicdifficulte(String b_ctype, String b_difficulte) {
		super();
		this.b_ctype = b_ctype;
		this.b_difficulte = b_difficulte;
	}
	
	public Basicdifficulte(String b_ctype, String b_difficulte, int start_page, int end_page) {
		super();
		this.b_ctype = b_ctype;
		this.b_difficulte = b_difficulte;
		this.start_page = start_page;
		this.end_page = end_page;
	}



	public Basicdifficulte() {
		super();
	}

	public String getB_ctype() {
		return b_ctype;
	}

	public void setB_ctype(String b_ctype) {
		this.b_ctype = b_ctype;
	}

	public String getB_difficulte() {
		return b_difficulte;
	}

	public void setB_difficulte(String b_difficulte) {
		this.b_difficulte = b_difficulte;
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
