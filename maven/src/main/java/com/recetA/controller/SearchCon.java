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
import com.recetA.domain.PagingDAO;
import com.recetA.domain.SearchVO;

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
		// 1-1. 페이징 처리를 위해 수집
		int get_page = 0;
		if(request.getParameter("page")!=null) {
			get_page = Integer.parseInt(request.getParameter("page"));
		}
		int start_page = 1 + (get_page*10);
		int end_page = 10 * (get_page+1);
		// 1-2. 검색 값 수집
		String search = request.getParameter("search");
		System.out.println(search);

		// 2. 수집된 데이터를 SearchVO 객체에 담기
		SearchVO searchvo = new SearchVO(search, start_page, end_page);

		// 3. Mapper.xml에서 SQL문 만들어 오기

		// 4. BasicDAO에 메소드 생성하기

		// 5. DAO에서 생성한 메소드 호출하기
		BasicDAO dao = new BasicDAO();
		List<Basic> selectsearch = dao.selectsearch(search);
		System.out.println(selectsearch);
		System.out.println("데이터 수집 완료");
		try {
			PagingDAO dao2 = new PagingDAO();
			List<Basic> pagesearch = dao2.pagingsearch(searchvo);
					// 1. 세션 객체 생성
					// 2. 세션에 저장
				session.setAttribute("selectsearch", selectsearch);
				session.setAttribute("pagesearch", pagesearch);
				session.setAttribute("search", search);
				session.setAttribute("nowpage", get_page);
				response.sendRedirect("search.jsp");

				
		} catch (Exception e) {
			System.out.println("Con 작동 실패");
		response.sendRedirect("main.jsp");
		}
		
		
		
		// 6. 명령 후 처리
		

		
	}
}
