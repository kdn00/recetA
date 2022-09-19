package com.recetA.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.RefriDAO;
import com.recetA.domain.RefriMember;

public class RefriCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("들어왔어요");
		request.setCharacterEncoding("UTF-8");
		// int id = session.getAttribute("");
		int r_key = 1;

		RefriMember vo = new RefriMember(r_key);

		// 3. MemberMapper.xml에서 SQL문 만들어 오기

		// 4. MemberDAO에 메소드 생성하기

		// 5. MemberDAO에서 생성한 메소드 호출하기
		RefriDAO dao = new RefriDAO();
		List<RefriMember> refri = dao.refri(vo);

		// 6. 명령 후 처리
		if (refri != null) {
			// 정보 유지를 위해 세션에 로그인 정보 저장
			// 1. 세션 객체 생성
			HttpSession session = request.getSession();

			// 2. 세션에 저장
			session.setAttribute("refri", refri);
			for (int i = 0; i < refri.size(); i++) {
				System.out.println(refri.get(i).toString());
			}
			// Mypagejsp.jsp로 이동
			response.sendRedirect("refrigerator.jsp");
		} else {
			System.out.println("불러오기 실패");
			response.sendRedirect("refrigerator.jsp");
		}

	}
}
