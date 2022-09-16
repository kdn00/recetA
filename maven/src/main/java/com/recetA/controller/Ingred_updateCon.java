package com.recetA.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.RefriDAO;
import com.recetA.domain.RefriMember;

public class Ingred_updateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("들어왔어요");
		HttpSession session = request.getSession();
		RefriMember refri = (RefriMember)session.getAttribute("refri");
		
		String s_name = request.getParameter("s_name");
		int k_volume =  Integer.parseInt(request.getParameter("k_volume"));
		String k_unit = request.getParameter("k_unit");
		Date k_edate = request.getParameter("k_edate");
		System.out.println(k_edate);
		int m_key = refri.getM_key();
		
		
		// 2. 수집된 데이터를 Member 객체에 담기
		RefriMember RefriMember = new RefriMember(m_key, s_name, k_volume, k_unit, k_edate);
		
		
		// 3. Mapper.xml에서 SQL문 만들고 오기
		
		
		// 4. DAO에 가서 메소드 만들고 오기
				
				
		// 5. DAO 객체 생성, 메소드 호출
		
		RefriDAO dao = new RefriDAO();
		int cnt = dao.ingred_update(RefriMember);
		
		if(cnt>0) {
			System.out.println("개수 수정 성공");
			// 회원정보를 다시 세션에 저장
			// 같은 세션의 이름에 덮어쓰기 하기
			session.setAttribute("ingred_update", RefriMember);
			
		}else {
			System.out.println("개수 수정 실패");
		}

		response.sendRedirect("blank.jsp");		
		
		
	}

}
