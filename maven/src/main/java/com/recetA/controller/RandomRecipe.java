package com.recetA.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.Basic;
import com.recetA.domain.BasicDAO;


public class RandomRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 랜덤 메뉴 추천 1개
		System.out.println("[RandomRecipe]");

		// 0. post방식 인코딩
		request.setCharacterEncoding("UTF-8");

		// 1. 파라미터 수집
		// 1-1. 랜덤 추천은 파라미터 수집x
		Random rand = new Random();
		int b_code = rand.nextInt(500);
		
		
		// 2. 수집된 데이터를 객체에 담기
		// 2-1. 수집한게 없어서 안 담음

		// 3. Mapper.xml에서 SQL문 만들어 오기
		// 레시피명, 레시피 url 검색

		// 4. BasicDAO에 메소드 생성하기
		// 4-1. 랜덤 레시피 출력 함수 : ArrayList<Basic> selectRandom()
		
		// 5. BasicDAO에서 생성한 메소드 호출하기
		// 5-1. 랜덤 레시피 분류 출력 함수 : ArrayList<Basic> selectRandom()
		BasicDAO dao = new BasicDAO();
		Basic randomrecipe = dao.selectRandom(b_code);
		
		// 6. 명령 후 처리
		if (randomrecipe != null) {
			// 정보 유지를 위해 세션에 로그인 정보 저장
			// 1. 세션 객체 생성
			HttpSession session = request.getSession();

			// 2. 세션에 저장
			session.setAttribute("randomrecipe", randomrecipe);
			

			// index.html로 이동
//			response.sendRedirect("main.jsp");

		} else {
			System.out.println("랜덤 레시피 실패");
		}
	}

}
