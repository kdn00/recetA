package com.recetA.controller;

import java.io.IOException;
import java.util.List;

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

public class Favorites_LoadCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		int m_key = loginMember.getM_key();
		
		FavoritesDAO dao = new FavoritesDAO();
		
		List<FavoritesMember> FavoritesMember = dao.FavoritesMember(m_key);
		// 6. 명령 후 처리
		if (FavoritesMember != null) {
			session.setAttribute("FavoritesMember", FavoritesMember);
			for (int i = 0; i < FavoritesMember.size(); i++) {
				System.out.println(FavoritesMember.get(i).toString());
			}
		} else {
			System.out.println("불러오기 실패");
		}
		response.sendRedirect("bookmark.jsp");
	}

}
