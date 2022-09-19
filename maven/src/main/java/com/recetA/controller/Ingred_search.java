package com.recetA.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.RefriDAO;
import com.recetA.domain.RefriMember;

public class Ingred_search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String s_name = request.getParameter("s_name");
		
		// 3. MemberMapper.xml에서 SQL문 만들고 오기
		
				// 4. MemberDAO에 가서 메소드 만들고 오기
				
				
				// 5. MemberDAO 객체 생성, 메소드 호출
				RefriDAO dao = new RefriDAO();
				List<RefriMember> Ingred_search = dao.Ingred_search(s_name);
				
				
				// 6. 명령 후 처리
				
				if(Ingred_search!=null) {
					System.out.println("서치 성공");
					// 세션에 로그인 정보 저장
					// 1. 세션 객체 생성
					HttpSession session = request.getSession();
					// 2. 세션에 저장
					session.setAttribute("Ingred_search", Ingred_search);
					
				}else {
					System.out.println("서치 실패");
				}
				// 페이지 이동
				response.sendRedirect("refrigerator.jsp");
				
				
			}
		
		
		
		
		
	}
