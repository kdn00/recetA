package com.recetA.domain;

import java.sql.Date;

public class RefriMember {
	private int m_key;
	private String s_name;
	private int k_volume;
	private String k_unit;
	private int r_key;
	
	// 냉장고 보유재료 객체
	public RefriMember(int r_key) {
			this.r_key = r_key;
		}


	public RefriMember(int r_key, String s_name, int k_volume, String k_unit) {
		super();
		this.r_key = r_key;
		this.s_name = s_name;
		this.k_volume = k_volume;
		this.k_unit = k_unit;
	}


	public RefriMember() {
		super();
	}

	public int getM_key() {
		return m_key;
	}



	public void setM_key(int m_key) {
		this.m_key = m_key;
	}



	public int getR_key() {
		return r_key;
	}


	public void setR_key(int r_key) {
		this.r_key = r_key;
	}


	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getK_volume() {
		return k_volume;
	}

	public void setK_volume(int k_volume) {
		this.k_volume = k_volume;
	}

	public String getK_unit() {
		return k_unit;
	}

	public void setK_unit(String k_unit) {
		this.k_unit = k_unit;
	}


	@Override
	public String toString() {
		return "RefriMember [r_key=" + r_key + ", s_name=" + s_name + ", k_volume=" + k_volume + ", k_unit=" + k_unit
				+ "]";
	}
	
	
	
}
