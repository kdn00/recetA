package com.recetA.domain;

public class FavoritesMember {
	
	private int m_key;
	private int b_code;
	private String b_name;
	private String b_url;
	
	
	public FavoritesMember(int m_key, int b_code, String b_name, String b_url) {
		this.m_key = m_key;
		this.b_code = b_code;
		this.b_name = b_name;
		this.b_url = b_url;
	}
	
	
	public FavoritesMember() {
		super();
	}



	public int getM_key() {
		return m_key;
	}
	public void setM_key(int m_key) {
		this.m_key = m_key;
	}
	public int getB_code() {
		return b_code;
	}
	public void setB_code(int b_code) {
		this.b_code = b_code;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_url() {
		return b_url;
	}
	public void setB_url(String b_url) {
		this.b_url = b_url;
	}
	@Override
	public String toString() {
		return "FavoritesMember [m_key=" + m_key + ", b_code=" + b_code + ", b_name=" + b_name + ", b_url=" + b_url
				+ "]";
	}
	
	
}
