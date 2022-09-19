package com.recetA.domain;

public class Basicdifficulte {
	
	// 대분류
	private String b_ctype;
	// 난이도
	private String b_difficulte;
	
	public Basicdifficulte(String b_ctype, String b_difficulte) {
		super();
		this.b_ctype = b_ctype;
		this.b_difficulte = b_difficulte;
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
	
	

}
