package com.recetA.domain;

public class Process {
	private int p_key;
	private int b_code;
	private int p_order;
	private String p_explanation;
	/*전체 조회시 이용할 것*/
	public Process(int p_key, int b_code, int p_order, String p_explanation) {
		super();
		this.p_key = p_key;
		this.b_code = b_code;
		this.p_order = p_order;
		this.p_explanation = p_explanation;
	}
	
	/*순서 정렬*/
	public Process(int p_key, int b_code, int p_order) {
		super();
		this.p_key = p_key;
		this.b_code = b_code;
		this.p_order = p_order;
	}
	/*순서 정렬후 출력시*/
	public Process(int b_code,int p_order, String p_explanation) {
		super();
		this.b_code = b_code;
		this.p_order = p_order;
		this.p_explanation = p_explanation;
	}
	

	public int getP_key() {
		return p_key;
	}

	public void setP_key(int p_key) {
		this.p_key = p_key;
	}

	public int getB_code() {
		return b_code;
	}

	public void setB_code(int b_code) {
		this.b_code = b_code;
	}

	public int getP_order() {
		return p_order;
	}

	public void setP_order(int p_order) {
		this.p_order = p_order;
	}

	public String getP_explanation() {
		return p_explanation;
	}

	public void setP_explanation(String p_explanation) {
		this.p_explanation = p_explanation;
	}
	
}
