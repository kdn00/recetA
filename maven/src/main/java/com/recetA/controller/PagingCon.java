package com.recetA.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.Basic;
import com.recetA.domain.BasicDAO;

public class PagingCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[PagingCon]");
		
		request.setCharacterEncoding("UTF-8");

		// itemsInAPage : 한 페이지에 출력 할 게시물 수
		// totalCount : 전체 게시물 수 --> db 등에서 전체 게시물 카운트해서 값 가져오기.
		// totalPage : 출력 할 전체 페이지 수
		int page = 1; // 시작 페이지

		int itemsInAPage = 6;
		int totalCount = 382;
		int totalPage = (int) Math.ceil(totalCount / (double) itemsInAPage);


		// pageCount : 한번에 출력될 페이징 버튼 수
		// startPage : 페이징 버튼 시작 값
		// endPage : 페이징 버튼 종료 값
		int pageCount = 5;
		int startPage = ((page - 1) / pageCount) * pageCount + 1;
		int endPage = startPage + pageCount - 1;

		// 추가로 조건 설정
		if(totalPage < page) {
		page = totalPage;
		}

		if (endPage > totalPage) {
		endPage = totalPage;
		}
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("page", page);

		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
	}

}
