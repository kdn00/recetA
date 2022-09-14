package com.recetA.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recetA.domain.Member;
import com.recetA.domain.MemberDAO;


public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PreparedStatement psmt = null;
	ResultSet rs = null;

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
		
		Member vo = new Member(m_id, m_pw, m_name, m_tel);
		

		// 3. MemberMapper.xml SQL문 만들고 오기

		// 4. MemberDAO 가서 메소드 만들고 오기

		// 5. MemberDAO 객체 생성, 메소드 호출
		MemberDAO dao = new MemberDAO();
		int cnt = dao.insertMember(vo);
		if (cnt > 0) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		
		
		dao = new MemberDAO();
		Member SelectKey = dao.insertMember2(m_id);
		if (SelectKey != null)  {
			System.out.println("키 검색 성공");
		} else {
			System.out.println("키 검색 실패");

		}
		
		int key = SelectKey.getM_key();
		dao = new MemberDAO();
		cnt = dao.insertMember3(key);
		if (cnt > 0) {
			System.out.println("냉장고 키 성공");
			response.sendRedirect("login.jsp");
		} else {
			System.out.println("냉장고 키 실패");
			response.sendRedirect("main.jsp");
		}
	}

}
