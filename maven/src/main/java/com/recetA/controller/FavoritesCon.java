package com.recetA.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recetA.domain.FavoritesDAO;
import com.recetA.domain.FavoritesMember;
import com.recetA.domain.Member;
import com.recetA.domain.RefriDAO;
import com.recetA.domain.RefriMember;

import oracle.net.ns.SessionAtts;

public class FavoritesCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println("즐찾들어왔어요");
		Member loginMember = (Member)session.getAttribute("loginMember");
		int m_key = loginMember.getM_key();
		System.out.println(m_key);
		FavoritesMember Favorites_Data = (FavoritesMember)session.getAttribute("Favorites_Data");

		int b_code = (int)Favorites_Data.getB_code();
		System.out.println(b_code);
		String b_name = Favorites_Data.getB_name();
		System.out.println(b_name);
		String b_url = Favorites_Data.getB_url();
		System.out.println(b_url);

		FavoritesMember vo = new FavoritesMember(m_key, b_code, b_name, b_url);
		

		// 3. Mapper.xml에서 SQL문 만들고 오기

		// 4. DAO에 가서 메소드 만들고 오기

		// 5. DAO 객체 생성, 메소드 호출
		FavoritesDAO dao = new FavoritesDAO();
		int cnt = dao.Favorites_insert(vo);
		
		if(cnt>0) {
			System.out.println("즐겨찾기 추가 성공");
		}else {
			System.out.println("즐겨찾기 추가 실패");
		}
		response.sendRedirect("Favorites_LoadCon");

	}
		
	

}
