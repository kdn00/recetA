package com.recetA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recetA.domain.RefriDAO;
import com.recetA.domain.RefriMember;


public class Ingred_delCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				String s_name = request.getParameter("s_name");
				
				// 2. MemberMapper.xml에서 SQL문 만들기
				
				// 3. MemberDAO에서 회원삭제 메소드 만들기
				
				// 4. 메소드 호출(email값 매개변수로 넣어주기)
				RefriDAO dao = new RefriDAO();
				int cnt = dao.Ingred_del(s_name);
				// 5. 성공 여부에 따른 명령 후 처리
				if(cnt>0) {
					System.out.println("재료 삭제 성공");
				}else {
					System.out.println("재료 삭제 실패");
				}
				// 6. select.jsp로 이동
				response.sendRedirect("RefriCon");
				
			}

		
	

}
