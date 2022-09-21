package com.recetA.domain;

public class SearchVO {
	
	// 검색어
	private String search;
	// 페이징 시작 페이지
	private int start_page;
	// 페이징 끝 페이지
	private int end_page;
	
	public SearchVO(String search, int start_page, int end_page) {
		super();
		this.search = search;
		this.start_page = start_page;
		this.end_page = end_page;
	}

	public SearchVO() {
		super();
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
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
	
	
	
}
