package com.recetA.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recetA.domain.Member;
import com.recetA.domain.MemberDAO;


public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[JoinCon]");

		// 0. post방식 인코딩
		request.setCharacterEncoding("UTF-8");

		// 1. 파라미터 수집
		String m_id = request.getParameter("id");
		String m_pw = request.getParameter("pw");
		String m_name = request.getParameter("name");
		String m_tel = request.getParameter("tel");

		// 2. 수집된 데이터를 Member 객체에 담기
		Member vo = new Member(5, m_id, m_pw, m_name, m_tel);
		System.out.println(m_id + " " + m_pw + " " + m_name + " " + m_tel);

		// 3. MemberMapper.xml SQL문 만들고 오기

		// 4. MemberDAO 가서 메소드 만들고 오기

		// 5. MemberDAO 객체 생성, 메소드 호출
		MemberDAO dao = new MemberDAO();
		int cnt = dao.insertMember(vo);

		// 6. 명령 후 처리
		if (cnt > 0) {
			System.out.println("회원가입 성공");
			// 회원가입 정보를 유지한채로~~
			// login으로 이동!
			// 정보를 유지할 필요가 없으면 sendRedirect()이동
			// response.sendRedirect("login.jsp");
			// 정보를 유지해야 한다면 forward방식 이동
			// --> request 영역에 정보를 저장

			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			request.setAttribute("joinInfo", vo);
			rd.forward(request, response);

		} else {
			System.out.println("회원가입 실패");
			response.sendRedirect("signup.html");
		}
	}

}
