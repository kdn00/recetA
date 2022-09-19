package com.recetA.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.Member;
import com.recetA.domain.RefriDAO;
import com.recetA.domain.RefriMember;

public class Ingred_plusCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("들어왔어요");
		
		HttpSession session = request.getSession();
		
		int r_key = (int) session.getAttribute("r_key");
		
		System.out.println(r_key);
		String s_name = request.getParameter("s_name");
		System.out.println(s_name);

		int s_volume = Integer.parseInt(request.getParameter("k_volume2"));
		System.out.println(s_volume);

		String s_unit = request.getParameter("k_unit2");
		System.out.println(s_unit);

		
		// 2. 수집된 데이터를 Member 객체에 담기
		RefriMember vo = new RefriMember(r_key, s_name, s_volume, s_unit);

		// 3. Mapper.xml에서 SQL문 만들고 오기

		// 4. DAO에 가서 메소드 만들고 오기

		// 5. DAO 객체 생성, 메소드 호출

		RefriDAO dao = new RefriDAO();
		int cnt = dao.Ingred_plus(vo);
		
		if(cnt>0) {
			System.out.println("재료 추가 성공");
		}else {
			System.out.println("재료 추가 실패");
		}
		response.sendRedirect("RefriCon");

	}
		
		
		
	

}
