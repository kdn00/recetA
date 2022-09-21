package com.recetA.domain;

public class Basic {
	
	// 레시피 코드
	private int b_code;
	// 레시피 이름
	private String b_name;
	// 레시피 설명
	private String b_short;
	// 음식 유형
	private String b_ftype;
	// 대분류
	private String b_ctype;
	// 재료 유형
	private String b_itype;
	// 조리 시간
	private String b_time;
	// n인분
	private String b_amount;
	// 난이도
	private String b_difficulte;
	// 대표 이미지
	private String b_url;
	// 페이징 시작 페이지
	private int start_page;
	// 페이징 끝 페이지
	private int end_page;
	
	
	// 전체 데이터를 담는 객체
	public Basic(int b_code, String b_name, String b_short, String b_ftype, String b_ctype, String b_itype,
			String b_time, String b_amount, String b_difficulte, String b_url) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.b_short = b_short;
		this.b_ftype = b_ftype;
		this.b_ctype = b_ctype;
		this.b_itype = b_itype;
		this.b_time = b_time;
		this.b_amount = b_amount;
		this.b_difficulte = b_difficulte;
		this.b_url = b_url;
	}
	
	// 대분류, 소분류를 전부 담은 객체
	public Basic(String b_ftype, String b_ctype, String b_itype, String b_time, String b_amount, String b_difficulte) {
		super();
		this.b_ftype = b_ftype;
		this.b_ctype = b_ctype;
		this.b_itype = b_itype;
		this.b_time = b_time;
		this.b_amount = b_amount;
		this.b_difficulte = b_difficulte;
	}


	// 소분류만 담은 객체
	public Basic(String b_ftype, String b_itype, String b_time, String b_amount, String b_difficulte) {
		super();
		this.b_ftype = b_ftype;
		this.b_itype = b_itype;
		this.b_time = b_time;
		this.b_amount = b_amount;
		this.b_difficulte = b_difficulte;
	}
	
	// 음식분류
	public Basic(String b_ctype, String b_ftype) {
		super();
		this.b_ctype = b_ctype;
		this.b_ftype = b_ftype;
	}
	
	// 대분류 페이징
	public Basic(String b_ctype, int start_page, int end_page) {
		super();
		this.b_ctype = b_ctype;
		this.start_page = start_page;
		this.end_page = end_page;
	}
	
	// 음식분류 페이징
	public Basic(String b_ctype, String b_ftype,int start_page, int end_page) {
		super();
		this.b_ctype = b_ctype;
		this.b_ftype = b_ftype;
		this.start_page = start_page;
		this.end_page = end_page;
	}
	
	// 대분류, 소분류 게시글 띄우기
	public Basic(int b_code, String b_name, String b_url) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.b_url = b_url;
	}
	
	// 페이징 정보 담기
	public Basic(int b_code, String b_name, String b_url, int start_page, int end_page) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.b_url = b_url;
		this.start_page = start_page;
		this.end_page = end_page;
	}

	// 오류 방지용 빈 객체
	public Basic() {
		super();
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

	public String getB_short() {
		return b_short;
	}

	public void setB_short(String b_short) {
		this.b_short = b_short;
	}

	public String getB_ftype() {
		return b_ftype;
	}

	public void setB_ftype(String b_ftype) {
		this.b_ftype = b_ftype;
	}

	public String getB_ctype() {
		return b_ctype;
	}

	public void setB_ctype(String b_ctype) {
		this.b_ctype = b_ctype;
	}

	public String getB_itype() {
		return b_itype;
	}

	public void setB_itype(String b_itype) {
		this.b_itype = b_itype;
	}

	public String getB_time() {
		return b_time;
	}

	public void setB_time(String b_time) {
		this.b_time = b_time;
	}

	public String getB_amount() {
		return b_amount;
	}

	public void setB_amount(String b_amount) {
		this.b_amount = b_amount;
	}

	public String getB_difficulte() {
		return b_difficulte;
	}

	public void setB_difficulte(String b_difficulte) {
		this.b_difficulte = b_difficulte;
	}

	public String getB_url() {
		return b_url;
	}

	public void setB_url(String b_url) {
		this.b_url = b_url;
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

	@Override
	public String toString() {
		return "Basic [b_code=" + b_code + ", b_name=" + b_name + ", b_short=" + b_short + ", b_ftype=" + b_ftype
				+ ", b_ctype=" + b_ctype + ", b_itype=" + b_itype + ", b_time=" + b_time + ", b_amount=" + b_amount
				+ ", b_difficulte=" + b_difficulte + ", b_url=" + b_url + ", start_page=" + start_page + ", end_page="
				+ end_page + "]";
	}

}
