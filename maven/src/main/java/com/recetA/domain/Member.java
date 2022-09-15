package com.recetA.domain;

public class Member {
	private int m_key;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_tel;
	
	// 회원 가입 객체
	public Member(int m_key, String m_id, String m_pw, String m_name, String m_tel) {
		this.m_key = m_key;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_tel = m_tel;
	}
	
	// 회원 수정 객체 --> 수정해야할 것같긴 함
	public Member(String m_id, String m_pw, String m_name, String m_tel) {
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_tel = m_tel;
	}
	
	// 로그인, 마이페이지 확인 객체
	public Member(String m_id, String m_pw) {
		this.m_id = m_id;
		this.m_pw = m_pw;
	}
	// 냉장고 키 값 검색 조건
	public Member(String m_id) {
		this.m_id = m_id;
	}
	// 냉장고 키 값 입력
	public Member(int m_key) {
		super();
		this.m_key = m_key;
	}
	//회원수정 객체-->이쪽이 진짜
	public Member(String m_id, String m_pw, String m_tel) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_tel = m_tel;
	}

	// 오류 방지용 빈 객체
	public Member() {
		super();
	}

	public int getM_key() {
		return m_key;
	}

	public void setM_key(int m_key) {
		this.m_key = m_key;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	
	
	
	
	


}
