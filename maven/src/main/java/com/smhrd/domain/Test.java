package com.smhrd.domain;

// 테이블 이름과 VO객체 이름 일치 시키기

public class Test {

	// 접근제한자
	private String id;
	private String pw;

	public Test(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
