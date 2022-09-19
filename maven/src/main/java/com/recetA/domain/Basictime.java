package com.recetA.domain;

public class Basictime {
	
	// 대분류
	private String b_ctype;
	// 조리 시간
	private String b_time;
	
	
	public Basictime(String b_ctype, String b_time) {
		super();
		this.b_ctype = b_ctype;
		this.b_time = b_time;
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

	
	
	
}
