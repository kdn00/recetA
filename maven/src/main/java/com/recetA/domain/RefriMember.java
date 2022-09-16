package com.recetA.domain;

import java.sql.Date;

public class RefriMember {
	private int m_key;
	private String s_name;
	private int k_volume;
	private String k_unit;
	private String k_edate;

	// 냉장고 보유재료 객체
	public RefriMember(int m_key) {
			this.m_key = m_key;
		}

	public RefriMember(int m_key, String s_name, int k_volume, String k_unit, String k_edate) {
		super();
		this.m_key = m_key;
		this.s_name = s_name;
		this.k_volume = k_volume;
		this.k_unit = k_unit;
		this.k_edate = k_edate;
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

	public String getK_edate() {
		return k_edate;
	}

	public void setK_edate(String k_edate) {
		this.k_edate = k_edate;
	}

	@Override
	public String toString() {
		return "RefriMember [m_key=" + m_key + ", s_name=" + s_name + ", k_volume=" + k_volume + ", k_unit=" + k_unit
				+ ", k_edate=" + k_edate + "]";
	}
	
	
	
}
