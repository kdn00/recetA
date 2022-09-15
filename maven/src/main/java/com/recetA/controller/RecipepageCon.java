package com.recetA.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.Basic;
import com.recetA.domain.BasicDAO;

public class RecipepageCon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// !!!!! 대분류 있는 레시피 분류 페이지 !!!!!!
		System.out.println("[RecipepageCon]");

		// 0. post방식 인코딩
		request.setCharacterEncoding("UTF-8");

		// 1. 파라미터 수집
		// 1-1. 대분류 파라미터 수집 : name값으로 b_code값을 넣어 그걸 받아온다.
//		int b_code = Integer.parseInt(request.getParameter("b_code"));
		String b_ctype = request.getParameter("b_ctype");
		
		// 2. 수집된 데이터를 Basic 객체에 담기
		// 2-1. 대분류 : b_code 하나만 담을거기 때문에 객체 사용 x

		// 3. Mapper.xml에서 SQL문 만들어 오기
		// 대분류 검색

		// 4. BasicDAO에 메소드 생성하기
		// 4-1. 대분류 처리 함수 : ArrayList<Basic> selectbCtype(String b_ctype)
		
		// 5. BasicDAO에서 생성한 메소드 호출하기
		// 5-1. 대분류 처리 함수 : ArrayList<Basic> selectbCtype(String b_ctype)
		BasicDAO dao = new BasicDAO();
		ArrayList<Basic> bigbasic = dao.selectbCtype(b_ctype);
		
		
		// 6. 명령 후 처리
		if (bigbasic != null) {
			// 정보 유지를 위해 세션에 로그인 정보 저장
			// 1. 세션 객체 생성
			HttpSession session = request.getSession();

			// 2. 세션에 저장
			session.setAttribute("bigbasic", bigbasic);

			// 레시피 분류 페이지로 이동
			response.sendRedirect("recipepage.jsp");

		} else {
			// main.jsp로 이동
			response.sendRedirect("main.jsp");
		}
		
		
		// 1. 파라미터 수집
		// 1-2. 소분류 파라미터 수집
		String b_ftype = request.getParameter("b_ftype");
		String b_itype = request.getParameter("b_itype");
		String b_time = request.getParameter("b_time");
		String b_amount = request.getParameter("b_amount");
		String b_difficulte = request.getParameter("b_difficulte");

		// 2. 수집된 데이터를 Basic 객체에 담기
		// 2-2. 소분류 : 기준들을 Basic 객체에 담아 사용
		Basic basic = new Basic(b_ftype, b_ctype, b_itype, b_time, b_amount, b_difficulte);

		// 3. Mapper.xml에서 SQL문 만들어 오기
		// 소분류 검색

		// 4. BasicDAO에 메소드 생성하기
		// 4-2. 소분류 처리 함수 : ArrayList<Basic> selectSmall(Basic basic)

		// 5-2. 소분류 처리 함수 : ArrayList<Basic> selectSmall(Basic basic)
		dao = new BasicDAO();
		ArrayList<Basic> smallbasic = dao.selectSmall(basic);

		// 6. 명령 후 처리
		if (smallbasic != null) {
			// 정보 유지를 위해 세션에 로그인 정보 저장
			// 1. 세션 객체 생성
			HttpSession session = request.getSession();

			// 2. 세션에 저장
			session.setAttribute("smallbasic", smallbasic);

			// 레시피 분류 페이지로 이동
			response.sendRedirect("recipepage.jsp");

		} else {
			// main.jsp로 이동
			response.sendRedirect("main.jsp");
		}
	}

}
