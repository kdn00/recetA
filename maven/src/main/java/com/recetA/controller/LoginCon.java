package com.recetA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.Member;
import com.recetA.domain.MemberDAO;


public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[LoginCon]");

		// 0. post방식 인코딩
		request.setCharacterEncoding("UTF-8");

		// 1. 파라미터 수집
		String m_id = request.getParameter("id");
		String m_pw = request.getParameter("pw");
		// 2. 수집된 데이터를 Member 객체에 담기
		Member vo = new Member(m_id, m_pw);

		// 3. MemberMapper.xml에서 SQL문 만들어 오기

		// 4. MemberDAO에 메소드 생성하기

		// 5. MemberDAO에서 생성한 메소드 호출하기
		MemberDAO dao = new MemberDAO();
		Member loginMember = dao.selectMember(vo);

		// 6. 명령 후 처리
		if (loginMember != null) {
			// 정보 유지를 위해 세션에 로그인 정보 저장
			// 1. 세션 객체 생성
			HttpSession session = request.getSession();

			// 2. 세션에 저장
			session.setAttribute("loginMember", loginMember);

			// index.html로 이동
			response.sendRedirect("index.html");

		} else {
			System.out.println("로그인 실패");
			// main.jsp로 이동
		}
	}

}
