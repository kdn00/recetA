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

public class SearchCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 검색 기능
		System.out.println("[SearchCon]");
		
		// 0. post방식 인코딩
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.removeAttribute("selectsearch");

		// 1. 파라미터 수집
		String search = request.getParameter("search");
		System.out.println(search);

		// 2. 수집된 데이터를 Basic 객체에 담기

		// 3. Mapper.xml에서 SQL문 만들어 오기

		// 4. BasicDAO에 메소드 생성하기

		// 5. DAO에서 생성한 메소드 호출하기
		BasicDAO dao = new BasicDAO();
		List<Basic> selectsearch = dao.selectsearch(search);


		// 6. 명령 후 처리
		if (selectsearch != null) {
			// 1. 세션 객체 생성

			// 2. 세션에 저장
			session.setAttribute("selectsearch", selectsearch);
			session.setAttribute("search", search);
			response.sendRedirect("search.jsp");

		} else {
			System.out.println("Con 작동 실패");
		}

		
	}
}
