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

public class PagingsmallCon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 소분류 페이징 시작
		System.out.println("[PagingsmallCon]");
		
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
		// 현재 페이지 번호
		int get_page = Integer.parseInt(request.getParameter("page"));
		// 첫 페이지 번호
		int start_page = 1 + (get_page*10);
		// 마지막 페이지 번호
		int end_page = 10 * (get_page+1);
		// 대분류값
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
		int cnt = 0;
		// 3. sql문 작성
		
		// 4. dao 작성
		
		// 5. dao 객체 생성 및 불러오기
		BasicDAO dao = new BasicDAO();
		PagingDAO dao2 = new PagingDAO();

		// 음식 분류
		if (request.getParameterValues("b_ftype") != null) {
			String[] b_ftype = request.getParameterValues("b_ftype");
			
			// 게시글 수
			Basic b_ftypesmall = new Basic(b_ctype, b_ftype[0]);
			// 10개씩 나눌 게시글
			Basic pageb_ftype = new Basic(b_ctype, b_ftype[0], start_page, end_page);
			
			// 5. dao 객체 생성 및 불러오기
			// 5-1. 게시글 전체 개수
			dao = new BasicDAO();
			List<Basic> selectbFtype = dao.selectbFtype(b_ftypesmall);
			
			// 5-2. 게시글 페이징
			dao2 = new PagingDAO();
			// Mapper랑 함수 만들어 와야함
			List<Basic> b_ftypepage = dao2.pagingbFtype(pageb_ftype);

			// 6. 명령 후 처리
			if (b_ftypepage != null) {
				// 세션에 저장
				// 게시글 갯수
				session.setAttribute("selectbFtype", selectbFtype);
				// 게시글을 페이지별로 분리해서 게시
				session.setAttribute("b_ftypepage", b_ftypepage);
				// 현재 페이지 값을 세션값으로 저장
				session.setAttribute("nowpage", get_page);
			} else {
			}
		} // 음식 분류 끝

		// 재료 유형 null값 검사 시작
		if (request.getParameterValues("b_itype") != null) {
			String[] b_itype = request.getParameterValues("b_itype");
			
			// 게시글 수
			Basicitype b_itypesmall = new Basicitype(b_ctype, b_itype[0]);
			// 10개씩 나눌 게시글
			Basicitype pageb_itype = new Basicitype(b_ctype, b_itype[0], start_page, end_page);
			
			// 5. dao 객체 생성 및 불러오기
			// 5-1. 게시글 전체 개수
			dao = new BasicDAO();
			List<Basic> selectbItype = dao.selectbItype(b_itypesmall);
			
			// 5-2. 게시글 페이징
			dao2 = new PagingDAO();
			// Mapper랑 함수 만들어 와야함
			List<Basic> b_itypepage = dao2.pagingbItype(pageb_itype);

			// 6. 명령 후 처리
			if (b_itypepage != null) {
				// 세션에 저장
				// 게시글 갯수
				session.setAttribute("selectbItype", selectbItype);
				// 게시글을 페이지별로 분리해서 게시
				session.setAttribute("b_itypepage", b_itypepage);
				// 현재 페이지 값을 세션값으로 저장
				session.setAttribute("nowpage", get_page);
			} else {
			}
		} // 재료 분류 끝

		// 조리 시간 null값 검사 시작
		if (request.getParameterValues("b_time") != null) {
			String[] b_time = request.getParameterValues("b_time");

			// 수집된 데이터를 객체에 담기
			// 게시글 수
			Basictime b_timesmall = new Basictime(b_ctype, b_time[0]);
			// 10개씩 나눌 게시글
			Basictime pageb_time = new Basictime(b_ctype, b_time[0], start_page, end_page);

			// BasicDAO에서 생성한 메소드 호출하기
			dao = new BasicDAO();
			List<Basic> selectbTime = dao.selectbTime(b_timesmall);
			
			// 게시글 페이징 dao
			dao2 = new PagingDAO();
			List<Basic> b_timepage = dao2.pagingbTime(pageb_time);
			
			// 6. 명령 후 처리
			if (b_timepage != null) {
				// 세션에 저장
				session.setAttribute("selectbTime", selectbTime);
				// 게시글을 페이지별로 분리해서 게시
				session.setAttribute("b_timepage", b_timepage);
				// 현재 페이지 값을 세션값으로 저장
				session.setAttribute("nowpage", get_page);
			} else {
			}
		} // 조리 시간 끝

		// n인분
		if (request.getParameterValues("b_amount") != null) {
			String[] b_amount = request.getParameterValues("b_amount");

			// 게시글 수
			Basicamount b_amountsmall = new Basicamount(b_ctype, b_amount[0]);
			// 10개씩 나눌 게시글
			Basicamount pageb_amount = new Basicamount(b_ctype, b_amount[0], start_page, end_page);
			
			// 5. dao 객체 생성 및 불러오기
			// 5-1. 게시글 전체 개수
			dao = new BasicDAO();
			List<Basic> selectbAmount = dao.selectbAmount(b_amountsmall);
			// 5-2. 게시글 페이징
			dao2 = new PagingDAO();
			// Mapper랑 함수 만들어 와야함
			List<Basic> b_amountpepage = dao2.pagingbAmount(pageb_amount);
		
			// 6. 명령 후 처리
			if (b_amountpepage != null) {
				// 세션에 저장
				session.setAttribute("selectbAmount", selectbAmount);
				// 게시글을 페이지별로 분리해서 게시
				session.setAttribute("b_amountpepage", b_amountpepage);
				// 현재 페이지 값을 세션값으로 저장
				session.setAttribute("nowpage", get_page);
			} else {
			}
		} // n인분 끝

		// 난이도 null값 검사 시작
		if (request.getParameterValues("b_difficulte") != null) {
			String[] b_difficulte = request.getParameterValues("b_difficulte");
			
			// 2. 수집된 데이터를 Basic 객체에 담기
			Basicdifficulte b_difficultesmall = new Basicdifficulte(b_ctype, b_difficulte[0]);
			// 10개씩 나눌 게시글
			Basicdifficulte pageb_difficulte = new Basicdifficulte(b_ctype, b_difficulte[0], start_page, end_page);

			dao = new BasicDAO();
			List<Basic> selectbDifficulte = dao.selectbDifficulte(b_difficultesmall);

			dao2 = new PagingDAO();
			List<Basic> b_difficultepage = dao2.pagingbDifficulte(pageb_difficulte);
			
			// 6. 명령 후 처리
			if (b_difficultepage != null) {
				// 세션에 저장
				session.setAttribute("selectbDifficulte", selectbDifficulte);
				// 게시글을 페이지별로 분리해서 게시
				session.setAttribute("b_difficultepage", b_difficultepage);
				// 현재 페이지 값을 세션값으로 저장
				session.setAttribute("nowpage", get_page);
			} else {
			}
		} // 난이도 끝
		
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
