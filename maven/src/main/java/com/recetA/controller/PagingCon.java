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
import com.recetA.domain.Basicamount;
import com.recetA.domain.Basicdifficulte;
import com.recetA.domain.Basicitype;
import com.recetA.domain.Basictime;
import com.recetA.domain.PagingDAO;

public class PagingCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 대분류 페이징 시작
		System.out.println("[PagingCon]");
		
		// 0. post 인코딩
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		// 전에 검색한 세션들 삭제
		session.removeAttribute("bigpage");
		session.removeAttribute("b_ftypepage");
		session.removeAttribute("b_itypepage");
		session.removeAttribute("b_timepage");
		session.removeAttribute("b_amountpage");
		session.removeAttribute("b_difficultepage");
		
		// 1. 파라미터 수집
		int get_page = Integer.parseInt(request.getParameter("page"));
		int start_page = 1 + (get_page*10);
		int end_page = 10 * (get_page+1);
		String b_ctype = request.getParameter("b_ctype");
		
		// 값 받아오는지 확인하기
		System.out.println(get_page + " " + start_page+ " " + end_page);

		switch (b_ctype) {
		case "korean": b_ctype = "한식"; break;
		case "chinese": b_ctype = "중식"; break;
		case "japanese": b_ctype = "일식"; break;
		case "western": b_ctype = "양식"; break;
		case "asia": b_ctype = "동남아시아"; break;
		case "fusion": b_ctype = "퓨전"; break;
		}

		
		// 2. 수집한 데이터 객체에 담기
		Basic page = new Basic(b_ctype, start_page, end_page);
		
		// 3. sql문 작성
		
		// 4. dao 작성
		
		// 5. dao 객체 생성 및 불러오기
		BasicDAO dao = new BasicDAO();
		List<Basic> bigbasic = dao.selectbCtype(b_ctype);
		int cnt = bigbasic.size();
		
		PagingDAO dao2 = new PagingDAO();
		List<Basic> bigpage = dao2.pagingbCtype(page);

		// 6. 명령 후 처리
		if (bigpage != null) {
			// 정보 유지를 위해 세션에 로그인 정보 저장
			// 1. 세션 객체 생성
			session = request.getSession();

			// 2. 세션에 저장
			// 게시글 갯수
			session.setAttribute("bigbasic", cnt);
			// 게시글을 페이지별로 분리해서 게시
			session.setAttribute("bigpage", bigpage);
			// 현재 페이지 값을 세션값으로 저장
			session.setAttribute("nowpage", get_page);
			
		} else {
			System.out.println("Con 작동 실패");
		}
		// 레시피 분류 페이지로 이동
		switch (b_ctype) {
		case "한식": response.sendRedirect("korean.jsp"); break;
		case "중식": response.sendRedirect("chinese.jsp"); break;
		case "일식": response.sendRedirect("japanese.jsp"); break;
		case "양식": response.sendRedirect("western.jsp"); break;
		case "동남아시아": response.sendRedirect("asia.jsp"); break;
		case "퓨전": response.sendRedirect("fusion.jsp"); break;
		}
	}

}
