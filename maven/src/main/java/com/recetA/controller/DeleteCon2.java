package com.recetA.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.Member;
import com.recetA.domain.MemberDAO;

public class DeleteCon2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String m_key = (String) session.getAttribute("m_key");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.deleteFridge(m_key);
		if (cnt > 0) {
			System.out.println("회원삭제 완료");
		} else {
			
			System.out.println("회원삭제 실패");
		}
		MemberDAO dao2 = new MemberDAO();
		int cnt1 = dao2.deleteMember1(m_key);
		if (cnt > 0) {
			System.out.println("회원삭제 완료");
		} else {
			
			System.out.println("회원삭제 실패");
		}
		MemberDAO dao3 = new MemberDAO();
		int cnt2 = dao3.deleteMember(m_key);
		if (cnt > 0) {
			System.out.println("회원삭제 완료");
		} else {
			System.out.println("회원삭제 실패");
		}
		response.sendRedirect("main.jsp");
	}
}
