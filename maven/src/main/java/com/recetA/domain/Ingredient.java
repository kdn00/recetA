package com.recetA.domain;

public class Ingredient {
	// 재료 테이블 기본키
	private int i_key;
	// 참조하는 레시피 코드
	private int b_code;
	// 재료 양
	private String i_volume;
	// 재료 유형
	private String i_type;
	// 재료 이름
	private String i_name;
	
	
	public Ingredient(int i_key, int b_code, String i_volume, String i_type, String i_name) {
		super();
		this.i_key = i_key;
		this.b_code = b_code;
		this.i_volume = i_volume;
		this.i_type = i_type;
		this.i_name = i_name;
	}
	
	public Ingredient(int b_code, String i_volume, String i_name) {
		super();
		this.b_code = b_code;
		this.i_volume = i_volume;
		this.i_name = i_name;
	}

	// 오류 방지용 빈 객체
	public Ingredient() {
		super();
	}

	public int getI_key() {
		return i_key;
	}

	public void setI_key(int i_key) {
		this.i_key = i_key;
	}

	public int getB_code() {
		return b_code;
	}

	public void setB_code(int b_code) {
		this.b_code = b_code;
	}

	public String getI_volume() {
		return i_volume;
	}

	public void setI_volume(String i_volume) {
		this.i_volume = i_volume;
	}

	public String getI_type() {
		return i_type;
	}

	public void setI_type(String i_type) {
		this.i_type = i_type;
	}

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	
	
	
}
