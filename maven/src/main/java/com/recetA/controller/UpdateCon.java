package com.recetA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.Member;
import com.recetA.domain.MemberDAO;


public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
//비밀번호, 전화번호
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("update activate");
		// 0. post 방식 인코딩
		request.setCharacterEncoding("UTF-8");
		// 세션 객체 생성하기
		HttpSession session = request.getSession();
		// 세션 변수에 저장하기
		Member loginMember = (Member) session.getAttribute("loginMember");
		// 1. 파라미터 수집
		String m_id = loginMember.getM_id();
		String m_pw = request.getParameter("pw");
		String m_tel = request.getParameter("tel");
		// 2. 수집한 데이터를 Member객체에 담기
		Member updateMember = new Member(m_id ,m_pw, m_tel);
		// 3. MemberMapper.xml에서 SQL문 만들고 오기

		// 4. MemberDAO에 메소드 만들고 오기

		// 5. 메소드 호출
		MemberDAO dao = new MemberDAO();
		int cnt = dao.updateMember(updateMember);
		
		// 6. 명령 후 처리
		if (cnt > 0) {
			// 회원 수정이 잘 됐으면
			
			// 회원 정보를 다시 세션에 저장해야
			// 메인에서 새로운 정보를 출력할 수 있다.
			// 같은 이름의 세션에 덮어쓰기 하기
			session.setAttribute("loginMember", updateMember);
			response.sendRedirect("information.jsp");
		} else {
			
			response.sendRedirect("information.jsp");
		}
	
	}

}
