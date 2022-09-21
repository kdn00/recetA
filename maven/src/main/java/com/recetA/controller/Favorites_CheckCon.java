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

public class Favorites_CheckCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		FavoritesMember Favorites_Data = (FavoritesMember) session.getAttribute("Favorites_Data");
		Member loginMember = (Member) session.getAttribute("loginMember");
		System.out.println("체크콘왔어요");
		int m_key = (int) loginMember.getM_key();
		System.out.println(m_key);
		String b_name = Favorites_Data.getB_name();
		System.out.println(b_name);

		FavoritesMember vo = new FavoritesMember(m_key, b_name);

		// 3. Mapper.xml에서 SQL문 만들고 오기

		// 4. DAO에 가서 메소드 만들고 오기

		// 5. DAO 객체 생성, 메소드 호출
		FavoritesDAO dao = new FavoritesDAO();
		FavoritesMember cnt = dao.Favorites_Check(vo);

		if (cnt == null) {
			System.out.println("즐겨찾기 추가로");
			response.sendRedirect("FavoritesCon");

		} else {
			System.out.println("즐겨찾기 삭제로");
			response.sendRedirect("Favorites_DelCon");

		}

	}

}
