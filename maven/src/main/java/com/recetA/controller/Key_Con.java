package com.recetA.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.RefriDAO;
import com.recetA.domain.Member;
import com.recetA.domain.MemberDAO;
public class Key_Con extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("들어왔어요");
		HttpSession session = request.getSession();
        Member loginMember = (Member) session.getAttribute("loginMember");
		String m_id = loginMember.getM_id();
		
		RefriDAO dao = new RefriDAO();
		
		int r_key = dao.m_key_search(m_id);
		
		// 6. 명령 후 처리
		if(r_key>0) {
			System.out.println("키값 가져오기 성공");
			session.setAttribute("r_key", r_key);
			
		}else {
			System.out.println("키값 가져오기 실패");
		}
		response.sendRedirect("RefriCon");
	}

}
