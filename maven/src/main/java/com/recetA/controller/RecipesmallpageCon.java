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

public class RecipesmallpageCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("[RecipesmallpageCon]");

		// 0. post방식 인코딩
		request.setCharacterEncoding("UTF-8");

		// 1. 파라미터 수집
		// 1-1. 대분류 파라미터 수집 : name값으로 b_code값을 넣어 그걸 받아온다.
		// 값을 가지고 Con으로 보낼 때 a태그 사용법
		// <a href="보낼컨트롤러페이지?파라미터변수명=가져갈변수값">
		// <a href="pageCon?b_ctype=korean">
		String b_ctype = request.getParameter("b_ctype");

		// 제이쿼리에서 한글을 쓰려면 따로 처리해야 하는게 있어서? 영어로 받아서 변환해줌
		switch (b_ctype) {
		case "korean": b_ctype = "한식"; break;
		case "chinese": b_ctype = "중식"; break;
		case "japanese": b_ctype = "일식"; break;
		case "western": b_ctype = "양식"; break;
		case "asia": b_ctype = "동남아시아"; break;
		case "fusion": b_ctype = "퓨전"; break;
		}
		
		// 함수 호출
		BasicDAO dao = new BasicDAO();
		
		// 소분류 처리
		// 실험
		// String[] b_ftype = {"밥"};
//		 String[] b_itype = {"곡류"};

		// null인지 아닌지 각각 확인하고 하나씩 처리한 후, Union 걸어보기

		// 음식 분류
		// 실험용 b_ftype != null
		
		if (request.getParameterValues("b_ftype") != null) {

			// 1. 파라미터 수집
			// 만약 여러개 값을 처리하려면 반복문을 넣어서 처리 --> dao까지 함께 묶어서 하나씩 처리해야 함
			String[] b_ftype = request.getParameterValues("b_ftype");

			// 2. 수집된 데이터를 Basic 객체에 담기
			Basic b_ftypesmall = new Basic(b_ctype, b_ftype[0]);

			// 3. Mapper.xml에서 SQL문 만들어 오기
			// 음식 분류 검색

			// 4. BasicDAO에 메소드 생성하기
			// 4-1. 음식 분류 함수 : List<Basic> selectbFtype(String[] b_ftype)

			// 5. BasicDAO에서 생성한 메소드 호출하기
			dao = new BasicDAO();
			List<Basic> selectbFtype = dao.selectbFtype(b_ftypesmall);

			// 6. 명령 후 처리
			if (selectbFtype != null) {
				// 정보 유지를 위해 세션에 로그인 정보 저장
				// 1. 세션 객체 생성
				HttpSession session = request.getSession();

				// 2. 세션에 저장
				session.setAttribute("selectbFtype", selectbFtype);
				for (int i = 0; i < selectbFtype.size(); i++) {
					System.out.println(selectbFtype.get(i).getB_code());
					System.out.println(selectbFtype.get(i).getB_name());
					System.out.println(selectbFtype.get(i).getB_url());
				}

			} else {
			}
		} // 음식 분류 끝

		// 재료 유형 null값 검사 시작
		// request.getParameterValues("b_itype") != null
		// 실험 : b_itype != null
		if (request.getParameterValues("b_itype") != null) {
			// 1. 파라미터 수집
			// 만약 여러개 값을 처리하려면 반복문을 넣어서 처리 --> dao까지 함께 묶어서 하나씩 처리해야 함
			String[] b_itype = request.getParameterValues("b_itype");

			// 2. 수집된 데이터를 Basic 객체에 담기
			Basicitype b_itypesmall = new Basicitype(b_ctype, b_itype[0]);

			// 3. Mapper.xml에서 SQL문 만들어 오기
			// 음식 분류 검색

			// 4. BasicDAO에 메소드 생성하기
			// 4-1. 음식 분류 함수 : List<Basic> selectbFtype(String[] b_ftype)

			// 5. BasicDAO에서 생성한 메소드 호출하기
			dao = new BasicDAO();
			List<Basic> selectbItype = dao.selectbItype(b_itypesmall);

			// 6. 명령 후 처리
			if (selectbItype != null) {
				// 정보 유지를 위해 세션에 로그인 정보 저장
				// 1. 세션 객체 생성
				HttpSession session = request.getSession();

				// 2. 세션에 저장
				session.setAttribute("selectbItype", selectbItype);
				for (int i = 0; i < selectbItype.size(); i++) {
					System.out.println(selectbItype.get(i).getB_code());
					System.out.println(selectbItype.get(i).getB_name());
					System.out.println(selectbItype.get(i).getB_url());
				}
			} else {
			}
		} // 재료 분류 끝

		// 조리 시간 null값 검사 시작
		// request.getParameterValues("b_time") != null
		// 실험 : b_time != null
		if (request.getParameterValues("b_time") != null) {
			// 1. 파라미터 수집
			// 만약 여러개 값을 처리하려면 반복문을 넣어서 처리 --> dao까지 함께 묶어서 하나씩 처리해야 함
			String[] b_time = request.getParameterValues("b_time");

			// 2. 수집된 데이터를 Basic 객체에 담기
			Basictime b_timesmall = new Basictime(b_ctype, b_time[0]);

			// 3. Mapper.xml에서 SQL문 만들어 오기
			// 음식 분류 검색

			// 4. BasicDAO에 메소드 생성하기
			// 4-1. 음식 분류 함수 : List<Basic> selectbFtype(String[] b_ftype)

			// 5. BasicDAO에서 생성한 메소드 호출하기
			dao = new BasicDAO();
			List<Basic> selectbTime = dao.selectbTime(b_timesmall);

			// 6. 명령 후 처리
			if (selectbTime != null) {
				// 정보 유지를 위해 세션에 로그인 정보 저장
				// 1. 세션 객체 생성
				HttpSession session = request.getSession();

				// 2. 세션에 저장
				session.setAttribute("selectbTime", selectbTime);
				for (int i = 0; i < selectbTime.size(); i++) {
					System.out.println(selectbTime.get(i).getB_code());
					System.out.println(selectbTime.get(i).getB_name());
					System.out.println(selectbTime.get(i).getB_url());
				}
			} else {
			}
		} // 조리 시간 끝

		// n인분 null값 검사 시작
		// request.getParameterValues("b_amount") != null
		// 실험 : b_amount != null
		if (request.getParameterValues("b_amount") != null) {
			// 1. 파라미터 수집
			// 만약 여러개 값을 처리하려면 반복문을 넣어서 처리 --> dao까지 함께 묶어서 하나씩 처리해야 함
			String[] b_amount = request.getParameterValues("b_amount");

			// 2. 수집된 데이터를 Basic 객체에 담기
			Basicamount b_amountsmall = new Basicamount(b_ctype, b_amount[0]);

			// 3. Mapper.xml에서 SQL문 만들어 오기
			// 음식 분류 검색

			// 4. BasicDAO에 메소드 생성하기
			// 4-1. 음식 분류 함수 : List<Basic> selectbFtype(String[] b_ftype)

			// 5. BasicDAO에서 생성한 메소드 호출하기
			dao = new BasicDAO();
			List<Basic> selectbAmount = dao.selectbAmount(b_amountsmall);

			// 6. 명령 후 처리
			if (selectbAmount != null) {
				// 정보 유지를 위해 세션에 로그인 정보 저장
				// 1. 세션 객체 생성
				HttpSession session = request.getSession();

				// 2. 세션에 저장
				session.setAttribute("selectbAmount", selectbAmount);
				for (int i = 0; i < selectbAmount.size(); i++) {
					System.out.println(selectbAmount.get(i).getB_code());
					System.out.println(selectbAmount.get(i).getB_name());
					System.out.println(selectbAmount.get(i).getB_url());
				}
			} else {
			}
		} // n인분 끝

		// 난이도 null값 검사 시작
		// request.getParameterValues("b_difficulte") != null
		// 실험 : b_difficulte != null
		if (request.getParameterValues("b_difficulte") != null) {
			// 1. 파라미터 수집
			// 만약 여러개 값을 처리하려면 반복문을 넣어서 처리 --> dao까지 함께 묶어서 하나씩 처리해야 함
			String[] b_difficulte = request.getParameterValues("b_difficulte");

			// 2. 수집된 데이터를 Basic 객체에 담기
			Basicdifficulte b_difficultesmall = new Basicdifficulte(b_ctype, b_difficulte[0]);

			// 3. Mapper.xml에서 SQL문 만들어 오기
			// 음식 분류 검색

			// 4. BasicDAO에 메소드 생성하기
			// 4-1. 음식 분류 함수 : List<Basic> selectbFtype(String[] b_ftype)

			// 5. BasicDAO에서 생성한 메소드 호출하기
			dao = new BasicDAO();
			List<Basic> selectbDifficulte = dao.selectbDifficulte(b_difficultesmall);

			// 6. 명령 후 처리
			if (selectbDifficulte != null) {
				// 정보 유지를 위해 세션에 로그인 정보 저장
				// 1. 세션 객체 생성
				HttpSession session = request.getSession();

				// 2. 세션에 저장
				session.setAttribute("selectbDifficulte", selectbDifficulte);
				for (int i = 0; i < selectbDifficulte.size(); i++) {
					System.out.println(selectbDifficulte.get(i).getB_code());
					System.out.println(selectbDifficulte.get(i).getB_name());
					System.out.println(selectbDifficulte.get(i).getB_url());
				}
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
