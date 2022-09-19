package com.recetA.controller;

import java.io.IOException;
import java.util.ArrayList;
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

public class RecipepageCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// !!!!! 대분류 있는 레시피 분류 페이지 !!!!!!
		System.out.println("[RecipepageCon]");

		// 0. post방식 인코딩
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		session.removeAttribute("selectbFtype");
		session.removeAttribute("selectbItype");
		session.removeAttribute("selectbTime");
		session.removeAttribute("selectbAmount");
		session.removeAttribute("selectbDifficulte");

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

		// 실험 중
//		String b_ctype = "서양";

		// 2. 수집된 데이터를 Basic 객체에 담기
		// 2-1. 대분류 : b_ctype 하나만 담을거기 때문에 객체 사용 x

		// 3. Mapper.xml에서 SQL문 만들어 오기
		// 대분류 검색

		// 4. BasicDAO에 메소드 생성하기
		// 4-1. 대분류 처리 함수 : ArrayList<Basic> selectbCtype(String b_ctype)
		// 4-2. 가져와서 쌓아야하니까...? ArrayList 사용..?

		// 5. BasicDAO에서 생성한 메소드 호출하기
		// 5-1. 대분류 처리 함수 : ArrayList<Basic> selectbCtype(String b_ctype)
		BasicDAO dao = new BasicDAO();
		List<Basic> bigbasic = dao.selectbCtype(b_ctype);

		// 6. 명령 후 처리
		if (bigbasic != null) {
			// 정보 유지를 위해 세션에 로그인 정보 저장
			// 1. 세션 객체 생성
			session = request.getSession();

			// 2. 세션에 저장
			session.setAttribute("bigbasic", bigbasic);
			
			// 가져온 값 확인
//			for (int i = 0; i < bigbasic.size(); i++) {
//				System.out.println(bigbasic.get(i).getB_name());
//			}
			// 레시피 분류 페이지로 이동
			switch (b_ctype) {
			case "한식": response.sendRedirect("korean.jsp"); break;
			case "중식": response.sendRedirect("chinese.jsp"); break;
			case "일식": response.sendRedirect("japanese.jsp"); break;
			case "양식": response.sendRedirect("western.jsp"); break;
			case "동남아시아": response.sendRedirect("asia.jsp"); break;
			case "퓨전": response.sendRedirect("fusion.jsp"); break;
			}
		} else {
			System.out.println("Con 작동 실패");
		}
	}
}
